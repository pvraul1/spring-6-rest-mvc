package com.ayesa.spring6restmvc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Represents a beer model in the system.
 * <p>
 * This class includes attributes such as ID, name, beer style, UPC,
 * quantity on hand, price, and timestamps for creation and updates.
 * <p>
 * Created using IntelliJ by Spring Framework Guru.
 *
 * <p><b>Details:</b></p>
 * - Unique ID for each beer.<br>
 * - Style defined by {@link BeerStyle}.<br>
 * - UPC as a unique product identifier.<br>
 * - Price and quantity for inventory management.
 * <p>
 * Created by IntelliJ, Spring Framework Guru.
 *
 * @author architecture - pvraul
 * @version 07/12/2024 - 16:21
 * @since 1.17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Beer {

    private UUID id;
    private Integer version;
    private String beerName;
    private BeerStyle beerStyle;
    private String upc;
    private Integer quantityOnHand;
    private BigDecimal price;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;

}
