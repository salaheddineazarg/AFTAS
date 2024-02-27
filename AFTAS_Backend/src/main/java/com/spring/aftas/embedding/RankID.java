package com.spring.aftas.embedding;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@Embeddable
public class RankID implements Serializable {


    @Column(nullable = false)
    public UUID user_num;

    @Column(nullable = false)
    public String competition_code;
}
