package com.spring.aftas.repositories;

import com.spring.aftas.embedding.RankID;
import com.spring.aftas.entities.Rank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RankRepository extends JpaRepository<Rank, RankID> {

    long countByRankID(RankID rankID);
    List<Rank> findRankByCompetition_Code(String code);
}
