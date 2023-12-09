package com.spring.aftas.repositories;

import com.spring.aftas.entities.Competition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetitionRepository extends JpaRepository<Competition,String> {
}
