package com.stock.StockCheck.controller;

import com.stock.StockCheck.model.StockCheckAudit;
import com.stock.StockCheck.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(final ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public StockCheckAudit getProduct(@PathVariable Long id) {
        return productService.stockCheck(id);
    }
    @GetMapping("/history")
    public List<StockCheckAudit> getProductsHistory() {
        return productService.getHistory();
    }
}
