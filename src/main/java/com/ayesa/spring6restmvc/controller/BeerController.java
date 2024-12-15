package com.ayesa.spring6restmvc.controller;

import com.ayesa.spring6restmvc.model.Beer;
import com.ayesa.spring6restmvc.services.BeerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/beer/{beerId}")
    public ResponseEntity<Void> updateById(@PathVariable("beerId") UUID beerId,@RequestBody final Beer beer) {
        log.info("BeerController.updateById() (in controller) was called!");

        beerService.updateById(beerId, beer);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/beer")
    public ResponseEntity<Void> handlePost(@RequestBody final Beer beer) {
        log.info("BeerController.handlePost() (in controller) was called!");

        final Beer savedBeer = beerService.saveBeer(beer);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/api/v1/beer/" + savedBeer.getId().toString());

        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

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
