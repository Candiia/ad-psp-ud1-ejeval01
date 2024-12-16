package com.salesianostriana.dam.resteval.dto;

import com.salesianostriana.dam.resteval.model.Place;

public record PlaceDTO(Long id,
                       String name,
                       String coords,
                       String image) {

    public static PlaceDTO of(Place place){
        return new PlaceDTO(
                place.getId(),
                place.getName(),
                place.getCoords(),
                place.getImage()
        );

    }
}
