package com.loan.repaymentapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder

@Entity
@Table(name = "loan_application")
public class LoanApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long loan_application_id;
    private float loan_amount;
    private int loan_duration;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime date;
    private LoanStatus loan_status;
    @ManyToOne
    @JoinColumn(name = "customer_loan_application_id")
    private Customers customer;
    @OneToOne(mappedBy = "loan_application", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Loan loan;
}
