package com.loan.repaymentapi.repository;

import com.loan.repaymentapi.model.LoanType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanTypeRepository extends JpaRepository<LoanType, Long> {


}
