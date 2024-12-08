package com.ayesa.spring6restmvc.controller;

import com.ayesa.spring6restmvc.model.Beer;
import com.ayesa.spring6restmvc.services.BeerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
/**
 * BeerController
 * <p>
 * Created by IntelliJ, Spring Framework Guru.
 *
 * @author architecture - pvraul
 * @version 07/12/2024 - 16:58
 * @since 1.17
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1")
public class BeerController {

    private final BeerService beerService;

    @RequestMapping(value = "/beer", method = RequestMethod.GET)
    public List<Beer> listBeers() {

        log.info("BeerController.listBeers() (in controller) was called!");

        return beerService.listBeers();
    }

    @RequestMapping(value = "/beer/{beerId}", method = RequestMethod.GET)
    public Beer getBeerById(@PathVariable("beerId") final UUID beerId) {

        log.info("BeerController.getBeerById() - beerId: {} (in controller) was called!", beerId);

        return beerService.getBeerById(beerId);
    }

}
