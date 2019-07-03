package com.adameric.testejava.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ComissaoParams {

    private Long idCidade;
    private String nomeCidade;
    private List<Hotel> hotels;
    private String checkIn;
    private String checkOut;
    private Integer qtdeCriancas;
    private Integer qtdeAdultos;

}
