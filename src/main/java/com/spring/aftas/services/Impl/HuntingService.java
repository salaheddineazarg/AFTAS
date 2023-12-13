package com.spring.aftas.services.Impl;

import com.spring.aftas.dto.hunting.HuntingDTO;
import com.spring.aftas.dto.hunting.HuntingResponseDTO;
import com.spring.aftas.entities.Hunting;
import com.spring.aftas.repositories.CompetitionRepository;
import com.spring.aftas.repositories.FishRepository;
import com.spring.aftas.repositories.HuntingRepository;
import com.spring.aftas.repositories.MemberRepository;
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
    private final MemberRepository memberRepository;
    private  final FishRepository fishRepository;


    @Autowired
    public HuntingService(ModelMapper modelMapper,
                          HuntingRepository huntingRepository,
                          CompetitionRepository competitionRepository,
                          MemberRepository memberRepository,
                          FishRepository fishRepository
    ){

        this.huntingRepository = huntingRepository;
        this.modelMapper= modelMapper;
        this.competitionRepository =competitionRepository;
        this.memberRepository=memberRepository;
        this.fishRepository =fishRepository;
    }

    @Override
    public List<HuntingResponseDTO> getAllService() {

        return Arrays.asList(modelMapper.map(this.huntingRepository.findAll(),HuntingResponseDTO[].class));
    }

    @Override
    public Optional<HuntingResponseDTO> saveService(HuntingDTO huntingDTO) {

        Hunting hunting = modelMapper.map(huntingDTO, Hunting.class);
        if (this.huntingRepository.existsHuntingByCompetition_CodeAndMember_NumAndFish_Name(
                huntingDTO.getCompetition_code(),
                huntingDTO.getMember_num(),
                huntingDTO.getFish_name()))
        {
            hunting.setNumberOfFish(hunting.getNumberOfFish()+1);
            hunting.setId(hunting.getId());
            hunting = this.huntingRepository.save(hunting);
            return Optional.of(modelMapper.map(hunting, HuntingResponseDTO.class));
        }else {
            if (huntingDTO.getCompetition_code()!=null){
                hunting.setCompetition(
                        this.competitionRepository.findById(huntingDTO.getCompetition_code()).get()
                );
            }
            if (huntingDTO.getMember_num()>0){
                hunting.setMember(
                        this.memberRepository.findById(huntingDTO.getMember_num()).get()
                );
            }
            if (huntingDTO.getFish_name()!=null){
                this.fishRepository.findByName(huntingDTO.getFish_name()).get();
            }

          hunting = this.huntingRepository.save(hunting);

            return Optional.of(modelMapper.map(hunting,HuntingResponseDTO.class));

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
