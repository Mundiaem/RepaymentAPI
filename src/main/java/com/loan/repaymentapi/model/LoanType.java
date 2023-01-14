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
public class LoanType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long loan_type_id;
    private String loan_name;
    private String loan_description;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "loan", joinColumns = {@JoinColumn(name = "loan_type_id")}, inverseJoinColumns = {@JoinColumn(name = "loan_id")})
    private List<Loan> loans = new ArrayList<Loan>();


}
