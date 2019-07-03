package com.adameric.testejava.services;

import com.adameric.testejava.constants.ConstantURL;
import com.adameric.testejava.models.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BrokerService {

    @Autowired
    private RestTemplate restTemplate;

    public List<Hotel> listarHotelsPorIdCity(Long idCity) {


        ResponseEntity<List<Hotel>> response = restTemplate.exchange(
                ConstantURL.URL_CITY + idCity,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Hotel>>(){});

        return response.getBody();
    }

    public Hotel obterHotelPorId(Long idHotel) {

        ResponseEntity<List<Hotel>> response = restTemplate.exchange(
                ConstantURL.URL_HOTEL + idHotel,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Hotel>>(){});

        return response.getBody() != null ? response.getBody().get(0) : null;
    }

}
