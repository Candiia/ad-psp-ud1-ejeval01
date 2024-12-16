package com.salesianostriana.dam.resteval.controller;

import com.salesianostriana.dam.resteval.PlaceRepository;
import com.salesianostriana.dam.resteval.model.Place;
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

    private final PlaceRepository placeRepository;

    @GetMapping()
    public ResponseEntity<List<Place>> getAll(){
        List<Place> result = placeRepository.getAll();
        if(result.isEmpty()){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Place> getPlaceId(@RequestParam Long id){
        Optional<Place> result = placeRepository.get(id);
        if(result.isEmpty()){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.of(result);
    }

    @PostMapping()
    public ResponseEntity<Place> create(@RequestBody Place place){
       return ResponseEntity.status(201).body(place);
    }

    /*@PutMapping("/{id}")
    public ResponseEntity<Place> edit(@RequestBody Place place, Long id){
        Optional<Place> result = placeRepository.get(id);

    }*/

    @DeleteMapping("/{id}")
    public void delete(@RequestParam Long id){
        placeRepository.delete(id);
        ResponseEntity.noContent().build();
    }
}
