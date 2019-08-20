package com.stock.StockCheck.service


import com.stock.StockCheck.Exception.ProductNotfoundException

import com.stock.StockCheck.model.StockCheckAudit
import com.stock.StockCheck.repository.ProductRepository
import com.stock.StockCheck.repository.StockCheckAuditRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceTest extends Specification {
    @Autowired
    StockCheckAuditRepo stockCheckAuditRepo

    @Autowired
    ProductRepository productRepository


    ProductService productService
    def setup(){
        productService =new ProductService(productRepository,stockCheckAuditRepo)
    }

    def "StockCheck for blocked Product"() {
        given: "productService and product repo with a blocked product saved product 'b'"
        when:"when product status is requested"
        StockCheckAudit stockCheckAuditresponse=productService.stockCheck(2L)
        then:
        stockCheckAuditresponse.response == 'This Product is Blocked currently'

    }

    def "StockCheck for Product having stock with in limits "() {
        given: "productService and product repo with product saved having sufficient stock product 'a'"
        when:"when product status is requested"
        StockCheckAudit stockCheckAuditresponse=productService.stockCheck(1L)
        then:
        stockCheckAuditresponse.response == 'This Product has the expected min stock levels'

    }

    def "StockCheck for Product having stock not with in expected limits "() {
        given: "productService and product repo with product saved having insufficient stock product 'c'"
         when:"when product status is requested"
        StockCheckAudit stockCheckAuditresponse=productService.stockCheck(3L)
        then:
        stockCheckAuditresponse.response == "This Product doesn't have the expected min stock levels"

    }
    def "StockCheck for invalid product "() {
        given: "productService and product repo "
        when:"when product status is requested"
        StockCheckAudit stockCheckAuditresponse=productService.stockCheck(111111L)
        then:
        thrown ProductNotfoundException

    }
}
