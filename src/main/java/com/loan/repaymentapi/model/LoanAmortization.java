package com.loan.repaymentapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CurrentTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanAmortization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long loan_amortization_id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime date;
    private float payment_amount;
    private float interest_paid;
    private float principal_amount;
    private float remaining_amount;
    @ManyToOne
    @JoinColumn(name = "loan_loan_amortization_id")
    private Transaction transaction;

}
