package com.ayesa.spring6restmvc.controller;

import com.ayesa.spring6restmvc.model.Beer;
import com.ayesa.spring6restmvc.services.BeerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

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
@Controller
@RequiredArgsConstructor
@Slf4j
public class BeerController {

    private final BeerService beerService;

    public Beer getBeerById(UUID beerId) {

        log.info("BeerController.getBeerById() - beerId: {} (in controller) was called!", beerId);

        return beerService.getBeerById(beerId);
    }

}
