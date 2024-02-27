package com.spring.aftas.services.Impl;

import com.spring.aftas.dto.hunting.HuntingDTO;
import com.spring.aftas.dto.hunting.HuntingResponseDTO;
import com.spring.aftas.entities.Fish;
import com.spring.aftas.entities.Hunting;
import com.spring.aftas.entities.Rank;
import com.spring.aftas.entities.User;
import com.spring.aftas.enumuration.Role;
import com.spring.aftas.repositories.*;
import com.spring.aftas.services.interfaces.IHuntingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class HuntingService implements IHuntingService {



    private final ModelMapper modelMapper;
    private final HuntingRepository huntingRepository;
    private final CompetitionRepository competitionRepository;
    private final UserRepository userRepository;
    private  final FishRepository fishRepository;
    private final RankService rankService;


    public HuntingService(ModelMapper modelMapper,
                          HuntingRepository huntingRepository,
                          CompetitionRepository competitionRepository,
                          UserRepository userRepository,
                          FishRepository fishRepository,
                          RankService rankService
    ){

        this.huntingRepository = huntingRepository;
        this.modelMapper= modelMapper;
        this.competitionRepository =competitionRepository;
        this.userRepository=userRepository;
        this.fishRepository =fishRepository;
        this.rankService = rankService;
    }

    @Override
    public List<HuntingResponseDTO> getAllService() {

        return Arrays.asList(modelMapper.map(this.huntingRepository.findAll(),HuntingResponseDTO[].class));
    }

    @Override
    public Optional<HuntingResponseDTO> saveService(HuntingDTO huntingDTO) {


        Optional<Hunting> huntingOptional = this.huntingRepository
                .findHuntingByCompetition_CodeAndUser_NumAndFish_Name(
                        huntingDTO.getCompetition_code(),
                        huntingDTO.getUser_num(),
                        huntingDTO.getFish_name()
                );
        if (huntingOptional.isPresent()) {
           Hunting hunting = huntingOptional.get();
            hunting.setId(hunting.getId());
            hunting.setNumberOfFish(hunting.getNumberOfFish() + huntingDTO.getNumberOfFish());
            hunting = this.huntingRepository.save(hunting);
            this.rankService.updateScore(huntingDTO.getUser_num(),huntingDTO.getCompetition_code(),huntingDTO.getFish_name(),huntingDTO.getNumberOfFish());
            return Optional.of(modelMapper.map(hunting, HuntingResponseDTO.class));
        }
        else {

            Hunting hunting = modelMapper.map(huntingDTO,Hunting.class);
            if (huntingDTO.getCompetition_code() != null) {
                hunting.setCompetition(
                        this.competitionRepository.findById(huntingDTO.getCompetition_code()).get()
                );
            }
            if (huntingDTO.getUser_num() != null ) {
                User user = userRepository.findById(huntingDTO.getUser_num()).get();
                if (user.getRole() == Role.Member) {
                    hunting.setUser(
                            user
                    );
                }

            }

            if (huntingDTO.getFish_name() != null) {

               hunting.setFish(
                       this.fishRepository.findByName(huntingDTO.getFish_name()).get()
               );
            }

            hunting.setNumberOfFish(huntingDTO.getNumberOfFish());
            hunting = this.huntingRepository.save(hunting);
            this.rankService.updateScore(huntingDTO.getUser_num(),huntingDTO.getCompetition_code(), huntingDTO.getFish_name(),huntingDTO.getNumberOfFish());

                return Optional.of(modelMapper.map(hunting, HuntingResponseDTO.class));

        }

    }




    @Override
    public boolean deleteService(Long Id) {

        if (this.huntingRepository.existsById(Id)){
            this.huntingRepository.deleteById(Id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<HuntingResponseDTO> updateService(HuntingDTO huntingDTO, Long Id) {
        return Optional.empty();
    }

    @Override
    public Optional<HuntingResponseDTO> findByIdService(Long Id) {
        return this.huntingRepository.findById(Id)
                .map(hunting -> modelMapper.map(hunting,HuntingResponseDTO.class));
    }
}
