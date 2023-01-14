package com.loan.repaymentapi.services;

import com.loan.repaymentapi.VO.LoanApplicationRequest;
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

    public LoanApplication makeLoanApplication(LoanApplicationRequest loanApplication) {
        LoanApplication loanApplication1= new LoanApplication();
        loanApplication1.setLoan_amount(loanApplication.getLoan_amount());
        loanApplication1.setLoan_status(LoanStatus.ACCEPTED);

        return loanApplicationRepository.save(loanApplication1);

    }

}
