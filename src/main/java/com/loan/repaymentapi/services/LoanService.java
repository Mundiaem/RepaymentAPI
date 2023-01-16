package com.loan.repaymentapi.services;

import com.loan.repaymentapi.VO.LoanApplicationRequest;
import com.loan.repaymentapi.VO.LoanApplicationResponse;
import com.loan.repaymentapi.VO.LoanTypeRequest;
import com.loan.repaymentapi.VO.LoanTypeResponse;
import com.loan.repaymentapi.model.Customers;
import com.loan.repaymentapi.model.LoanApplication;
import com.loan.repaymentapi.model.LoanStatus;
import com.loan.repaymentapi.model.LoanType;
import com.loan.repaymentapi.repository.LoanApplicationRepository;
import com.loan.repaymentapi.repository.LoanTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {


    @Autowired
    private LoanApplicationRepository loanApplicationRepository;
    @Autowired
    private LoanTypeRepository loanTypeRepository;

    @Autowired
    private CustomerService customerService;

    public LoanApplicationResponse makeLoanApplication(LoanApplicationRequest request) {
        LoanApplication loanApplication1 = new LoanApplication();
        loanApplication1.setLoan_amount(request.getLoan_amount());
        loanApplication1.setLoan_status(LoanStatus.ACCEPTED);
        loanApplication1.setLoan_duration(request.getDuration());
        Customers cus = new Customers();
        cus.setCustomer_name(request.getCustomer_name());
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
        LoanTypeResponse response= new LoanTypeResponse();
        response.setLoan_type_id(results.getLoan_type_id());
        response.setLoan_name(results.getLoan_name());
        response.setLoan_description(results.getLoan_description());
        return response;
    }



}
