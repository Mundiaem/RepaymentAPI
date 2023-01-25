package com.loan.repaymentapi.services;


import com.loan.repaymentapi.VO.RegisterTemplate;
import com.loan.repaymentapi.model.Customers;
import com.loan.repaymentapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
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


    public RegisterTemplate save(RegisterTemplate customer) {
        Customers newCustomer = new Customers();
        newCustomer.setUsername(customer.getUsername());
        newCustomer.setPassword(bcryptEncoder.encode(customer.getPassword()));
        newCustomer.setSecond_name(customer.getSecond_name());
        newCustomer.setEmail(customer.getEmail());
        newCustomer.setFirst_name(customer.getFirst_name());
        newCustomer.setPhone_number(customer.getPhone_number());
        Customers cus = customerRepository.save(newCustomer);


        return new RegisterTemplate(cus.getEmail(), cus.getFirst_name(), cus.getSecond_name()
                , cus.getUsername(), cus.getPassword(), cus.getPhone_number());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customers customer = customerRepository.findByUsername(username);
        if (customer == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new User(customer.getUsername(), customer.getPassword(),
                new ArrayList<>());
    }
}
