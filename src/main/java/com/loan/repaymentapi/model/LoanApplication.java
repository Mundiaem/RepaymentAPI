package com.loan.repaymentapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long loan_application_id;
    private float loan_amount;
    private int loan_duration;
    private Date date;
    private LoanStatus loan_status;
    @ManyToOne
    @JoinColumn(name = "loan_application_customer_id")
    private Customers customer;
}
