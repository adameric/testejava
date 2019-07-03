package com.adameric.testejava.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Comissao {

    private Long id;
    private String cityName;
    private List<ComissaoQuarto> rooms;

}
