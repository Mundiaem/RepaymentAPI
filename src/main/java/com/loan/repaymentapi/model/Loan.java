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
    @OneToOne(mappedBy = "loan")
    private LoanType loan_type;
    @OneToOne
    @MapsId
    @JoinColumn(name = "loan_id")
    private LoanApplication loan_application;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "transactions", joinColumns = {@JoinColumn(name = "loan_id")}, inverseJoinColumns = {@JoinColumn(name = "transaction_id")})
    private List<Transaction> transactions = new ArrayList<Transaction>();


}
