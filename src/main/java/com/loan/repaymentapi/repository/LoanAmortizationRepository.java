package com.loan.repaymentapi.repository;

import com.loan.repaymentapi.model.LoanAmortization;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface LoanAmortizationRepository extends CrudRepository<LoanAmortization, Long> {


    @Query("select l from LoanAmortization l where  l.loan.loan_id =: loan_id")
    LoanAmortization findTopByOrderByDateDesc(@Param("loan_id") Long loan_id);
}
