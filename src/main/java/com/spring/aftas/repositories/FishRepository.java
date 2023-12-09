package com.spring.aftas.repositories;

import com.spring.aftas.entities.Fish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FishRepository extends JpaRepository<Fish,String> {
}
