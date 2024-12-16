package com.salesianostriana.dam.resteval.dto;

import com.salesianostriana.dam.resteval.model.Place;

public record CreatePlaceDTO(String name,
                             String address,
                             String desc,
                             String coords,
                             String image) {

    public static CreatePlaceDTO of(Place place){
        return new CreatePlaceDTO(
          place.getName(),
                place.getAddress(),
                place.getDesc(),
                place.getCoords(),
                place.getImage()
        );
    }
}
