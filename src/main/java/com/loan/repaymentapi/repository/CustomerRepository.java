package com.loan.repaymentapi.repository;

import com.loan.repaymentapi.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customers, Long> {
    Customers findByUsername(String user_name);
}
