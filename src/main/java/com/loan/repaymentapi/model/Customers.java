package com.loan.repaymentapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
@Builder
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private long customer_id;
    @Column(nullable = false, unique = true)
    private String email;
    private String first_name;
    private String second_name;
    @Column(nullable = false, unique = true)
    private String username;
    private String password;
    @Column(nullable = false, unique = true)
    private String phone_number;
    private Date date_joined;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "notifications", joinColumns = {@JoinColumn(name = "customer_id")}, inverseJoinColumns = {@JoinColumn(name = "notification_id")})
    private List<Notification> elevators = new ArrayList<Notification>();
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "loan", joinColumns = {@JoinColumn(name = "customer_id")}, inverseJoinColumns = {@JoinColumn(name = "loan_id")})
    private List<Loan> loan = new ArrayList<Loan>();
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "loan_applications", joinColumns = {@JoinColumn(name = "customer_id")}, inverseJoinColumns = {@JoinColumn(name = "loan_application_id")})
    private List<LoanApplication> loan_applications = new ArrayList<LoanApplication>();

}
