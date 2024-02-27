package com.spring.aftas.dto.level;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LevelDTO {

    private UUID code;
    private String description;
    private int points;
}
