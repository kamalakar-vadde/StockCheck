package com.stock.StockCheck.repository;

import com.stock.StockCheck.model.StockCheckAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockCheckAuditRepo extends JpaRepository<StockCheckAudit,Long> {
}
