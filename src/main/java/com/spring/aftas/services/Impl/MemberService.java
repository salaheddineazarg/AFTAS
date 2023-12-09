package com.spring.aftas.services.Impl;

import com.spring.aftas.dto.member.MemberDTO;
import com.spring.aftas.dto.member.MemberResponseDTO;
import com.spring.aftas.repositories.MemberRepository;
import com.spring.aftas.services.interfaces.IMemberService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MemberService implements IMemberService {


    private final ModelMapper modelMapper;
    private final MemberRepository memberRepository;


    @Autowired
    public MemberService(ModelMapper modelMapper, MemberRepository memberRepository) {
        this.modelMapper = modelMapper;
        this.memberRepository = memberRepository;
    }


    @Override
    public List<MemberResponseDTO> getAllService() {
        return null;
    }

    @Override
    public Optional<MemberResponseDTO> saveService(MemberDTO memberDTO) {
        return Optional.empty();
    }

    @Override
    public boolean deleteService(Long Id) {
        return false;
    }

    @Override
    public Optional<MemberResponseDTO> updateService(MemberDTO memberDTO, Long Id) {
        return Optional.empty();
    }

    @Override
    public Optional<MemberResponseDTO> findByIdService(Long Id) {
        return Optional.empty();
    }

    @Override
    public List<MemberResponseDTO> findByName(String name) {
        return null;
    }

    @Override
    public List<MemberResponseDTO> findByFamilyName(String familyName) {
        return null;
    }
}
