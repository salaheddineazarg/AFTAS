package com.spring.aftas.services.Impl;

import com.spring.aftas.dto.hunting.HuntingDTO;
import com.spring.aftas.dto.hunting.HuntingResponseDTO;
import com.spring.aftas.repositories.HuntingRepository;
import com.spring.aftas.services.interfaces.IHuntingService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HuntingService implements IHuntingService {



    private final ModelMapper modelMapper;
    private final HuntingRepository huntingRepository;


    public HuntingService(ModelMapper modelMapper,HuntingRepository huntingRepository){
        this.huntingRepository = huntingRepository;
        this.modelMapper= modelMapper;
    }

    @Override
    public List<HuntingResponseDTO> getAllService() {
        return null;
    }

    @Override
    public Optional<HuntingResponseDTO> saveService(HuntingDTO huntingDTO) {
        return Optional.empty();
    }

    @Override
    public boolean deleteService(Long Id) {
        return false;
    }

    @Override
    public Optional<HuntingResponseDTO> updateService(HuntingDTO huntingDTO, Long Id) {
        return Optional.empty();
    }

    @Override
    public Optional<HuntingResponseDTO> findByIdService(Long Id) {
        return Optional.empty();
    }
}
