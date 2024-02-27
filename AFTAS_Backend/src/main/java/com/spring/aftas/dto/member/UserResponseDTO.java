package com.spring.aftas.dto.member;

import com.spring.aftas.dto.hunting.HuntingDTO;
import com.spring.aftas.dto.rank.RankDTO;
import com.spring.aftas.enumuration.IdentityDocType;
import com.spring.aftas.enumuration.Role;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {
    private long num;
    private String name;
    private String familyName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    private LocalDate accessionDate;
    private String nationality;
    private IdentityDocType identityDocumentType;
    private String identityNumber;
    private List<HuntingDTO> huntings;
    private List<RankDTO> ranks;

}
