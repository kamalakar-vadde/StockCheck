package com.stock.StockCheck.service;

import com.stock.StockCheck.Exception.ProductNotfoundException;
import com.stock.StockCheck.model.Product;
import com.stock.StockCheck.model.StockCheckAudit;
import com.stock.StockCheck.repository.ProductRepository;
import com.stock.StockCheck.repository.StockCheckAuditRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final StockCheckAuditRepo stockCheckAuditRepo;

    @Autowired
    public ProductService(final ProductRepository productRepository,final StockCheckAuditRepo stockCheckAuditRepo) {
        this.productRepository = productRepository;
        this.stockCheckAuditRepo = stockCheckAuditRepo;
    }

    public StockCheckAudit stockCheck(Long id){
        StockCheckAudit responseObj;
      Optional<Product> product=  productRepository.findById(id);
      String response;
      if(product.isPresent()){
          Product prodct = product.get();
             if(prodct.isBlocked())  {
                 response = "This Product is Blocked currently";
             }  else{
                    if(prodct.getCurrentStockLevel()>prodct.getMinStockLevel()  )  {
                           response = "This Product has the expected min stock levels";
                    }   else{
                          response = "This Product doesn't have the expected min stock levels";
                    }

          }
          StockCheckAudit stockCheckAudit= new StockCheckAudit(product.get().getId(),product.get().getName(),response, Instant.now());

          responseObj= stockCheckAuditRepo.save(stockCheckAudit);

      }   else{
                      throw new ProductNotfoundException();
      }

      return responseObj;
    }

    public List<StockCheckAudit> getHistory(){
        return stockCheckAuditRepo.findAll();
    }

}
