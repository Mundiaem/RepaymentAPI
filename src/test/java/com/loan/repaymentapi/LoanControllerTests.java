package com.loan.repaymentapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loan.repaymentapi.VO.LoanApplicationRequest;
import com.loan.repaymentapi.model.LoanApplication;
import com.loan.repaymentapi.model.LoanStatus;
import com.loan.repaymentapi.services.LoanService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
public class LoanControllerTests {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private LoanService loanService;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        this.loanService
                = new LoanService();
    }

    @Test
    public void testCreateLoanApplication() throws Exception {

        LoanApplication application = LoanApplication.builder()
                .loan_amount(200000)
                .loan_status(LoanStatus.ACCEPTED)
                .loan_duration(12)
                .date(LocalDateTime.now())
                .build();
        LoanApplicationRequest request = LoanApplicationRequest.builder()
                .phone_number("+254 7633380155").customer_name("Dominic Mundia").duration(12).loan_amount(200000).build();

        given(loanService.makeLoanApplication(any(LoanApplicationRequest.class)))
                .willAnswer((invocation) -> invocation.getArgument(0));

        // when - action or behaviour that we are going test
        ResultActions response = mockMvc.perform(post("/v1/api/request_loan")
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON));

        // then - verify the result or output using assert statements
        response.andDo(print()).
                andExpect(status().isCreated())
                .andExpect(jsonPath("$.loan_amount",
                        is(application.getLoan_amount())))
                .andExpect(jsonPath("$.loan_duration",
                        is(application.getLoan_duration())))
                .andExpect(jsonPath("$.loan_status",
                        is(application.getLoan_status()))).
                andExpect(jsonPath("$.date",
                        is(application.getDate())));
    }

}
