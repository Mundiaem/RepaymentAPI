package com.loan.repaymentapi.services;

import com.loan.repaymentapi.model.Customers;
import com.loan.repaymentapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customers saveCustomer(Customers customer){
        return customerRepository.save(customer);

    }
}
