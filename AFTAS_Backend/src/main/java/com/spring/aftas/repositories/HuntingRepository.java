package com.spring.aftas.repositories;

import com.spring.aftas.entities.Hunting;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface HuntingRepository extends JpaRepository<Hunting,Long> {

   Optional<Hunting> findHuntingByCompetition_CodeAndUser_NumAndFish_Name(String code, UUID num, String name);
}
