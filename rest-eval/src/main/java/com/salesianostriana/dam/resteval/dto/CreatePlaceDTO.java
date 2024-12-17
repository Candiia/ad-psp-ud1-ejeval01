package com.salesianostriana.dam.resteval.dto;

import com.salesianostriana.dam.resteval.model.Place;

public record CreatePlaceDTO(String name,
                             String address,
                             String desc,
                             String coords,
                             String image) {

   /* public static Place of(CreatePlaceDTO dto){
        return Place.builder()
                .name(dto.name)
                .address(dto.address)
                .desc(dto.desc)
                .coords(dto.coords)
                .image(dto.image)
                .build();
    }*/

    public Place toPlace(){
        return Place.builder()
                .name(this.name)
                .address(this.address)
                .desc(this.desc)
                .coords(this.coords)
                .image(this.image)
                .build();
    }
}
