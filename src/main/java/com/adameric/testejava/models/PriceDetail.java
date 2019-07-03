package com.adameric.testejava.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PriceDetail {

   private Double pricePerDayAdult;
   private Double pricePerDayChild;

}
