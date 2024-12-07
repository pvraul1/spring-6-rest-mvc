package com.ayesa.spring6restmvc.services;

import com.ayesa.spring6restmvc.model.Beer;
import com.ayesa.spring6restmvc.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * BeerServiceImpl
 * <p>
 * Created by IntelliJ, Spring Framework Guru.
 *
 * @author architecture - pvraul
 * @version 07/12/2024 - 16:50
 * @since 1.17
 */
@Service
@Slf4j
public class BeerServiceImpl implements BeerService {

    @Override
    public Beer getBeerById(UUID beerId) {

        log.info("BeerServiceImpl.getBeerById() - beerId: {} (in service) was called!", beerId);

        return Beer.builder()
                .id(beerId)
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("123456")
                .price(new BigDecimal("12.95"))
                .quantityOnHand(122)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

    }

}
