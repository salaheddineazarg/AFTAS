package com.spring.aftas.services.interfaces;


import com.spring.aftas.dto.rank.*;
import com.spring.aftas.embedding.RankID;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IRankService {

    List<RankResponseDTO> getAllService();
    Optional<RankResponseDTO> saveService(RankDTO rankDTO);
    Optional<RankResponseDTO> findByIdService(String code , UUID num);
    boolean deleteService(String code, UUID num);
    Optional<RankResponseDTO> updateService(RankDTO rankDTO,String code,UUID num);

    List<RankResponseDTO> getByCompetition(String code);
    boolean updateScore(UUID num,String code,String name,int numberOfFish);
    List<RankResponseDTO> calRanking(String code);
}
