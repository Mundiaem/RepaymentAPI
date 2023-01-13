package com.loan.repaymentapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customer_id;
    private String phone_number;
    private String customer_name;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "notifications", joinColumns = {@JoinColumn(name = "customer_id")}, inverseJoinColumns = {@JoinColumn(name = "notification_id")})
    private List<Notification> elevators = new ArrayList<Notification>();
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "loan", joinColumns = {@JoinColumn(name = "customer_id")}, inverseJoinColumns = {@JoinColumn(name = "loan_id")})
    private List<Loan> loan = new ArrayList<Loan>();
    @OneToOne(mappedBy = "customer")
    private LoanApplication loanApplication;
}
