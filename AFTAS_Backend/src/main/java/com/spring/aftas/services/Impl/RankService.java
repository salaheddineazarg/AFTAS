package com.spring.aftas.services.Impl;


import com.spring.aftas.dto.rank.RankDTO;
import com.spring.aftas.dto.rank.RankResponseDTO;
import com.spring.aftas.embedding.RankID;
import com.spring.aftas.entities.Fish;
import com.spring.aftas.entities.Rank;
import com.spring.aftas.entities.User;
import com.spring.aftas.enumuration.Role;
import com.spring.aftas.repositories.*;
import com.spring.aftas.services.interfaces.IRankService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RankService implements IRankService {


    private final ModelMapper modelMapper;
    private final RankRepository rankRepository;
    private final CompetitionRepository competitionRepository;
    private final UserRepository userRepository;
    private final FishRepository fishRepository;

    private RankService(ModelMapper modelMapper,
                        RankRepository rankRepository,
                        CompetitionRepository  competitionRepository,
                        UserRepository userRepository,
                        FishRepository fishRepository


    ){
        this.rankRepository = rankRepository;
        this.modelMapper = modelMapper;
        this.competitionRepository = competitionRepository;
        this.userRepository =userRepository ;
        this.fishRepository = fishRepository;
    }

    @Override
    public List<RankResponseDTO> getAllService() {

        return Arrays.asList(modelMapper.map(this.rankRepository.findAll(), RankResponseDTO[].class));
    }

    @Override
    public Optional<RankResponseDTO> saveService(RankDTO rankDTO) {
        Rank rank = modelMapper.map(rankDTO, Rank.class);
        User user = userRepository.findById(rankDTO.getUser_num()).get();
        if (rankDTO.getCompetition_code() != null) {
            rank.setCompetition(
                    this.competitionRepository.findById(rankDTO.getCompetition_code()).get()
            );
        }

        if (rankDTO.getUser_num() !=null ) {

            if (user.getRole() == Role.Member)
            rank.setUser(
                    this.userRepository.findById(rankDTO.getUser_num()).get()

            );
        }
         RankID rankID = new RankID();
        rankID.setCompetition_code(rankDTO.getCompetition_code());
        rankID.setUser_num(user.getNum());
        rank.setRankID(rankID);
        long count = this.rankRepository.countByCompetition_Code(rankDTO.getCompetition_code());

        if (count < rank.getCompetition().getNumberOfParticipants()) {
            rank = this.rankRepository.save(rank);
            return Optional.ofNullable(modelMapper.map(rank, RankResponseDTO.class));
        }
        return Optional.empty();
    }


    @Override
    public boolean deleteService(String code, UUID num) {
       RankID rankID = new RankID();
       rankID.setCompetition_code(code);
           rankID.setUser_num(num);
        System.out.println(rankID);
       if (this.rankRepository.existsById(rankID)){
           this.rankRepository.deleteById(rankID);
           return  true;
       }
        return false;
    }
    @Override
    public Optional<RankResponseDTO> updateService(RankDTO rankDTO, String code, UUID num) {
        RankID rankID = new RankID();
        rankID.setCompetition_code(code);
        rankID.setUser_num(num);
        if (this.rankRepository.existsById(rankID)){
            Rank rank = modelMapper.map(rankDTO, Rank.class);
            if (rankDTO.getCompetition_code() != null) {
                rank.setCompetition(
                        this.competitionRepository.findById(rankDTO.getCompetition_code()).get()
                );
            }

            if (rankDTO.getUser_num()!= null) {
                rank.setUser(
                        this.userRepository.findById(rankDTO.getUser_num()).get()
                );
            }

            rank.setRankID(rankID);
                rank = this.rankRepository.save(rank);
                return Optional.ofNullable(modelMapper.map(rank, RankResponseDTO.class));
        }
        return Optional.empty();
    }
    @Override
    public Optional<RankResponseDTO> findByIdService(String code,UUID num) {
        RankID rankID = new RankID();
        rankID.setCompetition_code(code);
        rankID.setUser_num(num);
        if (this.rankRepository.existsById(rankID)){

            Optional<Rank> rankOptional =this.rankRepository.findById(rankID);

            return rankOptional.map(rank ->  modelMapper.map(rank,RankResponseDTO.class));
        }
        return Optional.empty();
    }

    @Override
    public List<RankResponseDTO> getByCompetition(String code) {

        return Arrays.asList(modelMapper.map(this.rankRepository.findRankByCompetition_Code(code),RankResponseDTO[].class));
    }




    @Override
    public boolean updateScore(UUID num,String code,String name,int numberOfFish){
        Optional<Fish> fishOptional = this.fishRepository.findByName(name);
        Fish fish = fishOptional.get();
        Optional<Rank> rankOptional = this.rankRepository.findRankByUser_NumAndCompetition_Code(num,code);
        Rank rank = rankOptional.get();

        if (fish != null && rank != null) {
            System.out.println(rank.getRankID());
            rank.setRankID(rank.getRankID());
            rank.setScore(rank.getScore() + fish.getLevel().getPoints() * numberOfFish);
            this.rankRepository.save(rank);
            return  true;
        }
        return false;
    }



    @Override
    public List<RankResponseDTO> calRanking(String code) {
        List<Rank> sortedRankingsByScore = this.rankRepository.findAllByCompetition_CodeOrderByScoreDesc(code);
        for (int i = 0; i < sortedRankingsByScore.size(); i++) {
            sortedRankingsByScore.get(i).setRank(i + 1);
        }
        List<Rank> insertedRankings = this.rankRepository.saveAll(sortedRankingsByScore);
        return insertedRankings.stream()
                .map(ranking -> modelMapper.map(ranking, RankResponseDTO.class))
                .toList();
    }
}
