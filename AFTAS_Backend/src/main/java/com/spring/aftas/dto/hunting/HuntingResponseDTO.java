package com.spring.aftas.dto.hunting;

import com.spring.aftas.dto.competition.CompetitionDTO;
import com.spring.aftas.dto.fish.FishDTO;
import com.spring.aftas.dto.member.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HuntingResponseDTO {

    private long id;
    private int numberOfFish;
    private FishDTO fish;
    private UserDTO user;
    private CompetitionDTO competition;
}
