package com.spring.aftas.repositories;

import com.spring.aftas.entities.Hunting;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HuntingRepository extends JpaRepository<Hunting,Long> {

   boolean existsHuntingByCompetition_CodeAndMember_NumAndFish_Name(String code,long num,String name);
}
