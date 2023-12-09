package com.spring.aftas.repositories;

import com.spring.aftas.entities.Level;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LevelRepository extends JpaRepository<Level,Long> {

}
