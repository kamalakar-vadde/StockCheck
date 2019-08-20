package com.stock.StockCheck.repository


import com.stock.StockCheck.model.Product
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Issue
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductRepositoryTest extends Specification {

    @Autowired
    ProductRepository productRepository
    @Issue("test Product Repository")
    def "test Product Repository"(){
        given: "product repo"
        when:"when products are saved using data.sql"
        then:"We should see the data in repository"
        productRepository.findAll().size()==5
    }

}
