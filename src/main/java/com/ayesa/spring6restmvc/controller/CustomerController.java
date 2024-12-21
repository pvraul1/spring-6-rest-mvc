package com.ayesa.spring6restmvc.controller;

import com.ayesa.spring6restmvc.model.Customer;
import com.ayesa.spring6restmvc.services.CustomerService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping("/customer/{customerId}")
    public ResponseEntity<Void> updateCustomerPatchById(final @PathVariable("customerId") UUID customerId, @RequestBody final Customer customer) {
        log.info("CustomerController.updateCustomerPatchById() (in controller) was called!");

        customerService.updateCustomerPatchById(customerId, customer);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/customer/{customerId}")
    public ResponseEntity<Void> deleteById(@PathVariable("customerId") final UUID customerId) {
        log.info("CustomerController.deleteById() (in controller) was called!");

        customerService.deleteById(customerId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/customer/{customerId}")
    public ResponseEntity<Void> updateById(@PathVariable("customerId") final UUID customerId, @RequestBody final Customer customer) {
        log.info("CustomerController.updateById() (in controller) was called!");

        customerService.updateById(customerId, customer);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public ResponseEntity<Void> handlePost(@RequestBody final Customer customer) {
        log.info("CustomerController.handlePost() (in controller) was called!");

        final Customer savedCustomer = customerService.saveCustomer(customer);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/api/v1/customer/" + savedCustomer.getId().toString());

        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

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
