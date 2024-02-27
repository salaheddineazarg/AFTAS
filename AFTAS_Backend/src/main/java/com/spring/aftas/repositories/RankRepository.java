package com.spring.aftas.repositories;

import com.spring.aftas.embedding.RankID;
import com.spring.aftas.entities.Rank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RankRepository extends JpaRepository<Rank, RankID> {

    long countByCompetition_Code(String code);
    List<Rank> findRankByCompetition_Code(String code);
    Optional<Rank> findRankByUser_NumAndCompetition_Code(UUID num, String code);
    List<Rank> findAllByCompetition_CodeOrderByScoreDesc(String code);

}
