package com.ayesa.spring6restmvc.services;

import com.ayesa.spring6restmvc.model.Beer;

import java.util.List;
import java.util.UUID;

public interface BeerService {

    List<Beer> listBeers();

    Beer getBeerById(UUID beerId);

    Beer saveBeer(Beer beer);

    void updateById(UUID beerId, Beer beer);

    void deleteById(UUID beerId);

    void updateBeerPatchById(UUID beerId, Beer beer);
}
