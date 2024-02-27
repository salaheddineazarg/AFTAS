package com.spring.aftas.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Hunting {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Min(value = 1, message = "Number of fish must be at least 1")
    @Positive(message = "Number of fish must be a positive number")
    @Column(nullable = false)
    private int numberOfFish =1;

    @NotNull(message = "Fish must be provided")
    @ManyToOne(cascade = CascadeType.ALL)
    private Fish fish;

    @NotNull(message = "Competition must be provided")
    @ManyToOne(cascade = CascadeType.ALL)
    private Competition competition;

    @NotNull(message = "Member must be provided")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private User user;


}
