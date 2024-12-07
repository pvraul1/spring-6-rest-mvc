package com.ayesa.spring6restmvc.services;

import com.ayesa.spring6restmvc.model.Beer;

import java.util.UUID;

public interface BeerService {

    Beer getBeerById(UUID beerId);

}
