package com.salesianostriana.dam.resteval.controller;

import com.salesianostriana.dam.resteval.dto.CreatePlaceDTO;
import com.salesianostriana.dam.resteval.dto.ListGetPlaceDTO;
import com.salesianostriana.dam.resteval.repository.PlaceRepository;
import com.salesianostriana.dam.resteval.model.Place;
import com.salesianostriana.dam.resteval.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/place")
public class PlaceController {

    private final PlaceService placeService;

    @GetMapping()
    public ListGetPlaceDTO getAll(){
        return ListGetPlaceDTO.of(placeService.getAll());
    }

    @GetMapping("/{id}")
    public Place getPlaceId(@PathVariable Long id){
        return placeService.getById(id);
    }


    @PostMapping()
    public ResponseEntity<Place> create(@RequestBody CreatePlaceDTO place){
       return ResponseEntity.status(201)
               .body(
                       placeService.create(place.toPlace())
               );
    }

    @PutMapping("/{id}")
    public Place edit(@RequestBody CreatePlaceDTO place, @PathVariable Long id){
       return placeService.edit(id, place.toPlace());

    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        placeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
