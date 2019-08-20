package com.stock.StockCheck.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }

    private String name;
    private boolean isBlocked;
    private long minStockLevel;
    private long currentStockLevel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public long getMinStockLevel() {
        return minStockLevel;
    }

    public void setMinStockLevel(long minStockLevel) {
        this.minStockLevel = minStockLevel;
    }

    public long getCurrentStockLevel() {
        return currentStockLevel;
    }

    public void setCurrentStockLevel(long currentStockLevel) {
        this.currentStockLevel = currentStockLevel;
    }

    public Product(String name, boolean isBlocked, long minStockLevel, long currentStockLevel) {
        this.name = name;
        this.isBlocked = isBlocked;
        this.minStockLevel = minStockLevel;
        this.currentStockLevel = currentStockLevel;
    }

    public Product() {
    }
}
