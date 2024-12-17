package com.salesianostriana.dam.resteval.service;

import com.salesianostriana.dam.resteval.dto.CreatePlaceDTO;
import com.salesianostriana.dam.resteval.error.PlaceNotFoundException;
import com.salesianostriana.dam.resteval.model.Place;
import com.salesianostriana.dam.resteval.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;

    public List<Place> getAll(){
        List<Place> result = placeRepository.getAll();
        if(result.isEmpty())
            throw new PlaceNotFoundException("No hay restraurantes");
        return result;
    }

    public Place getById(Long id){
        return placeRepository.get(id).orElseThrow(
                () -> new PlaceNotFoundException("No se ha podido encontrar el lugar con ese ID: %d" .formatted(id)));
    }

    public Place create(Place place){
        return placeRepository.add(place);
   }

    public Place edit (Long id, Place place){
        return placeRepository.edit(id, place)
                .orElseThrow(() -> new PlaceNotFoundException("No se puede editar")
                );
    }

   public void delete(Long id){
        placeRepository.delete(id);
   }
}
