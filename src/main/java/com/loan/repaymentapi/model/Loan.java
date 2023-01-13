package com.loan.repaymentapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long loan_id;
    private Date loan_date;
    private float amount;
    private float payment;
    private int duration;
    private int interest;
    private float principle_amount;
    @ManyToOne
    @JoinColumn(name = "loan_customer_id")
    private Customers customer;
    @ManyToOne
    @JoinColumn(name = "loan_loan_type_id")
    private LoanType loan_type;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "transaction", joinColumns = {@JoinColumn(name = "loan_id")}, inverseJoinColumns = {@JoinColumn(name = "transaction_id")})
    private List<Transaction> loan_applications = new ArrayList<Transaction>();



}
