package com.spring.aftas.repositories;

import com.spring.aftas.embedding.RankID;
import com.spring.aftas.entities.Rank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RankRepository extends JpaRepository<Rank, RankID> {
}
