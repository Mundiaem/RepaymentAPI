package com.loan.repaymentapi.services;

import com.loan.repaymentapi.VO.LoanApplicationRequest;
import com.loan.repaymentapi.VO.LoanApplicationResponse;
import com.loan.repaymentapi.model.LoanApplication;
import com.loan.repaymentapi.model.LoanStatus;
import com.loan.repaymentapi.repository.LoanApplicationRepository;
import com.loan.repaymentapi.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {


    @Autowired
    private LoanApplicationRepository loanApplicationRepository;

    public LoanApplicationResponse makeLoanApplication(LoanApplicationRequest request) {
        LoanApplication loanApplication1= new LoanApplication();
        loanApplication1.setLoan_amount(request.getLoan_amount());
        loanApplication1.setLoan_status(LoanStatus.ACCEPTED);
        loanApplication1.setLoan_duration(request.getDuration());


        LoanApplication application = loanApplicationRepository.save(loanApplication1);
        LoanApplicationResponse response= new LoanApplicationResponse();
        response.setLoan_application_id(application.getLoan_application_id());
        response.setDate(application.getDate());
        response.setLoan_duration(application.getLoan_duration());
        response.setLoan_status(application.getLoan_status());
        response.setLoan_amount(application.getLoan_amount());


        return response;

    }

}
