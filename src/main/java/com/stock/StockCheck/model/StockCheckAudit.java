package com.stock.StockCheck.model;


import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity
@NoArgsConstructor
public class StockCheckAudit {
    @Id
    @GeneratedValue
    private Long id;
    private Long productId;
    private String productName;
    private String response;
    private Instant requestedOn;

    public StockCheckAudit(Long productId, String productName, String response, Instant requestedOn) {
        this.productId = productId;
        this.productName = productName;
        this.response = response;
        this.requestedOn = requestedOn;
    }

    public Long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getResponse() {
        return response;
    }

    public Instant getRequestedOn() {
        return requestedOn;
    }
}
