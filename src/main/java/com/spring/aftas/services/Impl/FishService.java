package com.spring.aftas.services.Impl;


import com.spring.aftas.dto.fish.FishDTO;
import com.spring.aftas.dto.fish.FishResponseDTO;
import com.spring.aftas.repositories.FishRepository;
import com.spring.aftas.services.interfaces.IFishService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FishService implements IFishService {

    private final ModelMapper modelMapper;

    private final FishRepository fishRepository;


    @Autowired
    private FishService(ModelMapper modelMapper,FishRepository fishRepository){
        this.fishRepository = fishRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<FishResponseDTO> getAllService() {
        return null;
    }

    @Override
    public Optional<FishResponseDTO> saveService(FishDTO fishDTO) {
        return Optional.empty();
    }

    @Override
    public boolean deleteService(String Id) {
        return false;
    }

    @Override
    public Optional<FishResponseDTO> updateService(FishDTO fishDTO, String Id) {
        return Optional.empty();
    }

    @Override
    public Optional<FishResponseDTO> findByIdService(String Id) {
        return Optional.empty();
    }
}
