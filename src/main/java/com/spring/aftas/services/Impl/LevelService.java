package com.spring.aftas.services.Impl;

import com.spring.aftas.dto.level.LevelDTO;
import com.spring.aftas.repositories.LevelRepository;
import com.spring.aftas.services.interfaces.ILevelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LevelService  implements ILevelService {


    private  final ModelMapper modelMapper;
    private final LevelRepository levelRepository;


    @Autowired
    public LevelService(ModelMapper modelMapper,LevelRepository levelRepository){
        this.levelRepository = levelRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<LevelDTO> getAllService() {
        return null;
    }

    @Override
    public Optional<LevelDTO> saveService(LevelDTO levelDTO) {
        return Optional.empty();
    }

    @Override
    public boolean deleteService(Long Id) {
        return false;
    }

    @Override
    public Optional<LevelDTO> updateService(LevelDTO levelDTO, Long Id) {
        return Optional.empty();
    }

    @Override
    public Optional<LevelDTO> findByIdService(Long Id) {
        return Optional.empty();
    }
}
