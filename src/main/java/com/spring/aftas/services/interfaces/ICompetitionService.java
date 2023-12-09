package com.spring.aftas.services.interfaces;

import com.spring.aftas.dto.competition.CompetitionDTO;
import com.spring.aftas.dto.competition.CompetitionResponseDTO;

import java.awt.print.Pageable;


public interface ICompetitionService extends IData<CompetitionResponseDTO, CompetitionDTO,String> {


    Pageable getCompetitionsByPagination(Pageable pageable);
}
