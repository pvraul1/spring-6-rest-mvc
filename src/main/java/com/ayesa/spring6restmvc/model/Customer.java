package com.ayesa.spring6restmvc.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Represents a Customer entity.
 * <p>
 * This class encapsulates the properties of a customer, including their name,
 * unique identifier (ID), version, creation date, and the date of the last update.
 * It uses Lombok annotations for automatic generation of getters, setters,
 * equals, hashCode, and toString methods, as well as a builder pattern for object creation.
 *
 * <p>
 * Created by IntelliJ, Spring Framework Guru.
 *
 * @author architecture - pvraul
 * @version 08/12/2024 - 10:20
 * @since 1.17
 */
@Data
@Builder
public class Customer {

    /**
     * The name of the customer.
     * <p>
     * This field represents the full name of the customer.
     */
    private String name;

    /**
     * The unique identifier (UUID) of the customer.
     * <p>
     * This field uniquely identifies each customer.
     */
    private UUID id;

    /**
     * The version number of the customer entity.
     * <p>
     * This field helps to manage optimistic locking in case of concurrent updates.
     */
    private Integer version;

    /**
     * The date and time when the customer entity was created.
     * <p>
     * This field represents the timestamp when the customer record was created.
     */
    private LocalDateTime createdDate;

    /**
     * The date and time when the customer entity was last updated.
     * <p>
     * This field represents the timestamp of the most recent update to the customer record.
     */
    private LocalDateTime updateDate;

}
