package com.spring.aftas.security.auth;



import com.spring.aftas.dto.User.UserDto;
import com.spring.aftas.dto.User.UserDtoResponse;
import com.spring.aftas.entities.Token;
import com.spring.aftas.entities.User;
import com.spring.aftas.enumuration.Role;
import com.spring.aftas.enumuration.TokenType;
import com.spring.aftas.repositories.TokenRepository;
import com.spring.aftas.repositories.UserRepository;
import com.spring.aftas.security.jwt.JwtService;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final ModelMapper modelMapper;

    public UserDtoResponse register(UserDto request) {
        var user = User.builder()
                .name(request.getName())
                .familyName(request.getFamilyName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .identityDocumentType(request.getIdentityDocumentType())
                .identityNumber(request.getIdentityNumber())
                .nationality(request.getNationality())
                .accessionDate(request.getAccessionDate())
                .status(false)
                .role(request.getRole())
                .build();
        var savedUser = repository.save(user);
        return modelMapper.map(savedUser,UserDtoResponse.class);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);

        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .user(modelMapper.map(user, UserDtoResponse.class))
                .build();
    }

    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getNum());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    public List<UserDtoResponse> findMembers(){

        return Arrays.asList(modelMapper.map(repository.findUsersByRole(Role.Member),UserDtoResponse[].class));
    }


}