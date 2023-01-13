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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "loan_application_id")
    private Customers customer;
    @OneToOne(mappedBy = "loan_application", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Loan loan;
}
