package com.loan.repaymentapi.services;

import com.loan.repaymentapi.VO.*;
import com.loan.repaymentapi.model.*;
import com.loan.repaymentapi.repository.LoanApplicationRepository;
import com.loan.repaymentapi.repository.LoanRepository;
import com.loan.repaymentapi.repository.LoanTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {


    @Autowired
    private LoanApplicationRepository loanApplicationRepository;
    @Autowired
    private LoanTypeRepository loanTypeRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private LoanRepository loanRepository;

    public LoanApplicationResponse makeLoanApplication(LoanApplicationRequest request) {
        LoanApplication loanApplication1 = new LoanApplication();
        loanApplication1.setLoan_amount(request.getLoan_amount());
        loanApplication1.setLoan_status(LoanStatus.ACCEPTED);
        loanApplication1.setLoan_duration(request.getDuration());

        Customers cus = new Customers();
        cus.setUsername(request.getCustomer_name());
        cus.setPhone_number(request.getPhone_number());
        customerService.saveCustomer(cus);
        loanApplication1.setCustomer(cus);

        LoanApplication application = loanApplicationRepository.save(loanApplication1);
        LoanApplicationResponse response = new LoanApplicationResponse();
        response.setLoan_application_id(application.getLoan_application_id());
        response.setDate(application.getDate());
        response.setLoan_duration(application.getLoan_duration());
        response.setLoan_status(application.getLoan_status());
        response.setLoan_amount(application.getLoan_amount());


        return response;

    }

    public List<LoanApplication> getLoanApplications() {
        return loanApplicationRepository.findAll();
    }

    public LoanTypeResponse makeLoanType(LoanTypeRequest loanTypeRequest) {
        LoanType loanType = new LoanType();
        loanType.setLoan_name(loanTypeRequest.getLoan_name());
        loanType.setLoan_description(loanTypeRequest.getLoan_description());
        LoanType results = loanTypeRepository.save(loanType);
        LoanTypeResponse response = new LoanTypeResponse();
        response.setLoan_type_id(results.getLoan_type_id());
        response.setLoan_name(results.getLoan_name());
        response.setLoan_description(results.getLoan_description());
        return response;
    }

    public Loan approveLoan(Long loan_application_id) {
        Optional<LoanApplication> application = loanApplicationRepository.findById(loan_application_id);
        if (application.isPresent()) {
            Loan loan = new Loan();
            loan.setCustomer(application.get().getCustomer());
            loan.setAmount(application.get().getLoan_amount());
            loan.setDuration(application.get().getLoan_duration());
            loan.setLoan_payment_status(LoanStatus.ACTIVE);
            Optional<LoanType> loanType;
            if (application.get().getLoan_duration() > 12) {
                loanType = loanTypeRepository.findById((long) 1);
            } else {
                loanType = loanTypeRepository.findById((long) 2);
            }
            loan.setLoan_type(loanType.get());
            loan.setPrinciple_amount(application.get().getLoan_amount());
            loan.setInterest(9);

            return loan;


        } else {
            return null;
        }
    }

    public List<Loan> getActiveLoans(String phone_number) {
        return loanRepository.findCustomerLoansPaymentStatus(phone_number, LoanStatus.ACTIVE);


    }

    public PaymentResponse makePayments(MakeLoanPaymentRequest request) {
        PaymentResponse response = new PaymentResponse();
        return response;
    }




}
