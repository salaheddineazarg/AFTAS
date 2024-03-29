package com.spring.aftas.dto.rank;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RankDTO {

    private int rank;
    private int score;
    private String competition_code;
    private UUID user_num;
}
