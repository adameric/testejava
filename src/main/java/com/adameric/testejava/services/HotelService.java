package com.adameric.testejava.services;

import com.adameric.testejava.constants.ConstantComissao;
import com.adameric.testejava.models.*;
import com.adameric.testejava.utils.DataUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService {

    public Comissao listarComissao(ComissaoParams params){

        List<ComissaoQuarto> listaQuartosComissionados = new ArrayList<ComissaoQuarto>();

        long qtdeDias = DataUtil.obterDiferencaDias(params.getCheckIn(),params.getCheckOut());

        for(Hotel hotel: params.getHotels()){

            for(Room room: hotel.getRooms()){
                Price price = room.getPrice();
                Double valorAdultoPorDia = price.getAdult()*params.getQtdeAdultos()*qtdeDias;
                Double valorCriancaPorDia = price.getChild()*params.getQtdeCriancas()*qtdeDias;
                Double valorComissionadoAdulto = valorAdultoPorDia*ConstantComissao.COMISSAO;
                Double valorComissionadoCrianca = valorAdultoPorDia/ConstantComissao.COMISSAO;
                Double totalPrice = valorAdultoPorDia+valorCriancaPorDia+valorComissionadoAdulto+valorComissionadoCrianca;

                PriceDetail priceDetail = PriceDetail.builder()
                        .pricePerDayAdult(valorAdultoPorDia)
                        .pricePerDayChild(valorCriancaPorDia)
                        .build();

                ComissaoQuarto comissaoQuarto = ComissaoQuarto.builder()
                        .categoryName(room.getCategoryName())
                        .roomID(room.getRoomID())
                        .totalPrice(totalPrice)
                        .priceDetail(priceDetail).build();
                listaQuartosComissionados.add(comissaoQuarto);

            }
        }
        return Comissao.builder()
                    .cityName(params.getNomeCidade())
                    .id(params.getIdCidade())
                    .rooms(listaQuartosComissionados)
                    .build();
    }


}
