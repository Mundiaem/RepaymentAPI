package com.loan.repaymentapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
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
    private LocalDateTime loan_date;
    private float amount;
    private float payment;
    private int duration;
    private int interest;
    private float principle_amount;
    private LoanStatus loan_payment_status;
    @ManyToOne
    @JoinColumn(name = "loan_customer_id")
    private Customers customer;
    @ManyToOne
    @JoinColumn(name = "loan_loan_type_id")
    private LoanType loan_type;
    @OneToOne
    @MapsId
    @JoinColumn(name = "loan_id")
    private LoanApplication loan_application;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "loan_amortizations", joinColumns = {@JoinColumn(name = "loan_id")}, inverseJoinColumns = {@JoinColumn(name = "loan_amortization_id")})
    private List<LoanAmortization> loanAmortizations = new ArrayList<LoanAmortization>();
}
