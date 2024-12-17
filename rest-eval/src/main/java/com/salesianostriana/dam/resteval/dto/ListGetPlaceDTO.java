package com.salesianostriana.dam.resteval.dto;


import com.salesianostriana.dam.resteval.model.Place;

import java.util.List;
import java.util.function.Function;

public record ListGetPlaceDTO(
        long count,
        List<PlaceDTO> items
) {

    public static ListGetPlaceDTO of(List<Place> list){
        return new ListGetPlaceDTO(
          list.size(),
          list.stream()//Se puede poner con referencia a metodo o con el metodo aplly, ambas se pueden utilizar
                  .map(PlaceDTO::of)
                  /*.map(new Function<Place, PlaceDTO>() {
                      @Override
                      public PlaceDTO apply(Place place) {
                          return PlaceDTO.of(place);
                      }
                  })*/
                  .toList()
        );
    }
}
