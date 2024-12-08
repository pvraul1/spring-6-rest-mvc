package com.ayesa.spring6restmvc.controller;

import com.ayesa.spring6restmvc.model.Customer;
import com.ayesa.spring6restmvc.services.CustomerService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * CustomerController
 * <p>
 * Created by IntelliJ, Spring Framework Guru.
 *
 * @author architecture - pvraul
 * @version 08/12/2024 - 10:44
 * @since 1.17
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public List<Customer> listAllCustomers() {
        log.info("CustomerController.listAllCustomers() (in controller) was called!");

        return customerService.getAllCustomers();
    }

    @RequestMapping(value = "/customer/{customerId}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable("customerId") UUID id) {
        log.info("CustomerController.getCustomerById() - customerId: {} (in controller) was called!", id);

        return customerService.getCustomerById(id);
    }
}
