package com.loan.repaymentapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = RepaymentApiApplication.class)
class RepaymentApiApplicationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeClass
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
    }

    @Test
    public void testGetLoanApplication() throws Exception {
        /*
        *  private String phone_number;
    private String customer_name;
    private float loan_amount;
    private int duration;
        * */
        mockMvc.perform(get("/v1/api/request_loan"))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.phone_number").value(1))
                .andExpect(jsonPath("$.customer_name").value("TechGeekNextUser"))
                .andExpect(jsonPath("$.loan_amount").value(0))
                .andExpect(jsonPath("$.duration").value(12));
    }

}
