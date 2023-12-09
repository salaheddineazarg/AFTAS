package com.spring.aftas.services.Impl;


import com.spring.aftas.dto.competition.CompetitionDTO;
import com.spring.aftas.dto.competition.CompetitionResponseDTO;
import com.spring.aftas.repositories.CompetitionRepository;
import com.spring.aftas.services.interfaces.ICompetitionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class CompetitionService implements ICompetitionService {


    private final ModelMapper modelMapper;
    private final CompetitionRepository competitionRepository;

    @Autowired
    public CompetitionService(ModelMapper modelMapper,CompetitionRepository competitionRepository){
        this.competitionRepository = competitionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Pageable getCompetitionsByPagination(Pageable pageable) {
        return null;
    }

    @Override
    public List<CompetitionResponseDTO> getAllService() {
        return null;
    }

    @Override
    public Optional<CompetitionResponseDTO> saveService(CompetitionDTO competitionDTO) {
        return Optional.empty();
    }

    @Override
    public boolean deleteService(String Id) {
        return false;
    }

    @Override
    public Optional<CompetitionResponseDTO> updateService(CompetitionDTO competitionDTO, String Id) {
        return Optional.empty();
    }

    @Override
    public Optional<CompetitionResponseDTO> findByIdService(String Id) {
        return Optional.empty();
    }
}
