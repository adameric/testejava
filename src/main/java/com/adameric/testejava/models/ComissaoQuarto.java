package com.adameric.testejava.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ComissaoQuarto {

    private Long roomID;
    private String categoryName;
    private Double totalPrice;
    private PriceDetail priceDetail;

}
