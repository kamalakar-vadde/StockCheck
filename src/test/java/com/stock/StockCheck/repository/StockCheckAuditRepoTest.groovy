package com.stock.StockCheck.repository


import com.stock.StockCheck.model.StockCheckAudit
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Issue
import spock.lang.Specification

import java.time.Instant

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StockCheckAuditRepoTest extends Specification {
    @Autowired
    StockCheckAuditRepo stockCheckAuditRepo
    @Issue("test StockCheckAudit Repository")
    def "test StockCheckAudit Repository"(){
        given: "StockCheckAudit repo"
        when:"when a row is saved"

        StockCheckAudit stockCheckAudit= new StockCheckAudit(1L,"kamal","sample save", Instant.now())
        stockCheckAuditRepo.save(stockCheckAudit)
        then:"We should see the data saved to repository"
        stockCheckAuditRepo.findAll().size()==1
    }
}
