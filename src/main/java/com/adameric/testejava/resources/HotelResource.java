package com.adameric.testejava.resources;

import com.adameric.testejava.models.Comissao;
import com.adameric.testejava.models.ComissaoParams;
import com.adameric.testejava.models.Hotel;
import com.adameric.testejava.services.BrokerService;
import com.adameric.testejava.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/hotel")
public class HotelResource {

    @Autowired
    BrokerService brokerService;

    @Autowired
    HotelService hotelService;

    @GetMapping("/calcular-valor-total-comissao")
    public ResponseEntity<Comissao> calcularValorTotalPorCidade(@RequestParam Long cityCode,
                                                                @RequestParam String checkin,
                                                                @RequestParam String checkout,
                                                                @RequestParam Integer qtdeAdultos,
                                                                @RequestParam Integer qtdeCriancas){
        List<Hotel> hotels = brokerService.listarHotelsPorIdCity(cityCode);
        return ResponseEntity.ok(hotelService.listarComissao(
                ComissaoParams.builder()
                        .hotels(hotels)
                        .checkIn(checkin)
                        .checkOut(checkout)
                        .qtdeAdultos(qtdeAdultos)
                        .qtdeCriancas(qtdeCriancas)
                        .idCidade(cityCode)
                        .nomeCidade(hotels.get(0).getCityName())
                        .build()
        ));
    }

    @GetMapping("/calcular-valor-total-comissao-hotel")
    public ResponseEntity<Comissao> calcularValorTotalPorHotel(@RequestParam Long idHotel,
                                                               @RequestParam String checkin,
                                                               @RequestParam String checkout,
                                                               @RequestParam Integer qtdeAdultos,
                                                               @RequestParam Integer qtdeCriancas){
        Hotel hotel = brokerService.obterHotelPorId(idHotel);
        return ResponseEntity.ok(hotelService.listarComissao(
                ComissaoParams.builder()
                        .hotels(Arrays.asList(hotel))
                        .checkIn(checkin)
                        .checkOut(checkout)
                        .qtdeAdultos(qtdeAdultos)
                        .qtdeCriancas(qtdeCriancas)
                        .idCidade(hotel.getCityCode())
                        .nomeCidade(hotel.getCityName())
                        .build()
        ));
    }

}
