package com.loan.repaymentapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loan.repaymentapi.VO.LoanApplicationRequest;
import com.loan.repaymentapi.VO.LoanApplicationResponse;
import com.loan.repaymentapi.model.LoanApplication;
import com.loan.repaymentapi.model.LoanStatus;
import com.loan.repaymentapi.repository.LoanApplicationRepository;
import com.loan.repaymentapi.services.LoanService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class RepaymentApiApplicationTests {


    @Mock
    LoanApplicationRepository loanApplicationRepository;
    @Autowired
    private MockMvc mockMvc;
    @InjectMocks
    private LoanService loanService;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getAllLoanApplications() throws Exception {
        LoanApplication application = LoanApplication.builder()
                .loan_amount(200000)
                .loan_status(LoanStatus.ACCEPTED)
                .loan_duration(12)
                .date(LocalDateTime.now())
                .build();
        LoanApplicationResponse response = new LoanApplicationResponse();
        response.setLoan_application_id(application.getLoan_application_id());
        response.setDate(application.getDate());
        response.setLoan_duration(application.getLoan_duration());
        response.setLoan_status(application.getLoan_status());
        response.setLoan_amount(application.getLoan_amount());
        LoanApplicationRequest request = LoanApplicationRequest.builder()
                .phone_number("+254 7633380155").customer_name("Dominic Mundia").duration(12).loan_amount(200000).build();
        when(loanService.makeLoanApplication(ArgumentMatchers.any(LoanApplicationRequest.class))).thenReturn(response);
        LoanApplicationResponse created = loanService.makeLoanApplication(request);
        assertThat(created.getLoan_amount()).isSameAs(created.getLoan_amount());
        verify(loanService).makeLoanApplication(request);

    }


}
