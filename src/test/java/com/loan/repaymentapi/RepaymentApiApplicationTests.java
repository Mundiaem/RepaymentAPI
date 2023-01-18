package com.loan.repaymentapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loan.repaymentapi.services.LoanService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;




@ExtendWith(MockitoExtension.class)
class RepaymentApiApplicationTests {


    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private LoanService loanService;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getAllLoanApplications() throws Exception {

        verify(loanService).getLoanApplications();

    }


}
