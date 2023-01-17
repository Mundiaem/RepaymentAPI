package com.loan.repaymentapi.repository;

import com.loan.repaymentapi.model.Loan;
import com.loan.repaymentapi.model.LoanAmortization;
import com.loan.repaymentapi.model.LoanStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Long> {

    @Query("select l from Loan l where  l.customer.phone_number=:phone_number and  l.loan_payment_status=:loan_payment_status")
    List<Loan> findCustomerLoansPaymentStatus(@Param("phone_number") String phone_number, @Param("loan_payment_status") LoanStatus loan_payment_status);

    @Query("select l from Loan l where  l.customer.phone_number=:phone_number")
    List<Loan> findCustomerLoans(@Param("phone_number") String phone_number);

    @Query("select l from Loan l where  l.customer.phone_number=:phone_number ")
    List<Loan> findCustomerLoanByLoanAmortizations(@Param("phone_number") String phone_number);




}
