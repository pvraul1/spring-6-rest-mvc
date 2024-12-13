package com.ayesa.spring6restmvc.services;

import com.ayesa.spring6restmvc.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    Customer getCustomerById(UUID uuid);

    List<Customer> getAllCustomers();

    Customer saveCustomer(Customer customer);
}
