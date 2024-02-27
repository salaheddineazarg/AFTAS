package com.spring.aftas.dto.hunting;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HuntingDTO {
    private long id;
    private int numberOfFish;
    private String fish_name;
    private UUID user_num;
    private String competition_code;

}
