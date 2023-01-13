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
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transaction_id;
    private PaymentStatus payment_status;
    private Date transaction_date;
    private float payment_amount;
    @ManyToOne
    @JoinColumn(name = "loan_transaction_id")
    private Transaction transaction;


}
