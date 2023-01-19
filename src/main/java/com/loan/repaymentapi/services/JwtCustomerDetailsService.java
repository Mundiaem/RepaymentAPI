package com.loan.repaymentapi.services;


import com.loan.repaymentapi.VO.RegisterTemplate;
import com.loan.repaymentapi.model.Customers;
import com.loan.repaymentapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtCustomerDetailsService implements UserDetailsService {
    @Autowired
    private CustomerRepository customerRepository;
//    @Qualifier("bCryptPasswordEncoder")
    @Autowired
    private PasswordEncoder bcryptEncoder;



    public Customers save(RegisterTemplate customer) {
        Customers newCustomer = new Customers();
        newCustomer.setUsername(customer.getUsername());
        newCustomer.setPassword(bcryptEncoder.encode(customer.getPassword()));
        return customerRepository.save(newCustomer);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customers customer = customerRepository.findByUsername(username);
        if (customer == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new User(customer.getUsername(), customer.getPassword(),
                new ArrayList<>());    }
}
