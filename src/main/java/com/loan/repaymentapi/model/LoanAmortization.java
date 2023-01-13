package com.loan.repaymentapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanAmortization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long loan_amortization_id;
    private Date date;
    private float payment_amount;
    private float interest_paid;
    private float principal_amount;
    private float remaining_amount;

}
