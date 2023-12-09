package com.spring.aftas.services.Impl;


import com.spring.aftas.dto.rank.RankDTO;
import com.spring.aftas.dto.rank.RankResponseDTO;
import com.spring.aftas.embedding.RankID;
import com.spring.aftas.repositories.RankRepository;
import com.spring.aftas.services.interfaces.IRankService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RankService implements IRankService {


    private final ModelMapper modelMapper;
    private final RankRepository rankRepository;

    private RankService(ModelMapper modelMapper,RankRepository rankRepository){
        this.rankRepository = rankRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<RankResponseDTO> getAllService() {
        return null;
    }

    @Override
    public Optional<RankResponseDTO> saveService(RankDTO rankDTO) {
        return Optional.empty();
    }

    @Override
    public boolean deleteService(RankID Id) {
        return false;
    }

    @Override
    public Optional<RankResponseDTO> updateService(RankDTO rankDTO, RankID Id) {
        return Optional.empty();
    }

    @Override
    public Optional<RankResponseDTO> findByIdService(RankID Id) {
        return Optional.empty();
    }
}
