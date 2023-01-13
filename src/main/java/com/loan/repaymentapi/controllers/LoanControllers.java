package com.loan.repaymentapi.controllers;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/")
@OpenAPIDefinition(info = @Info(title = "Loan Repayment API", version = "1.0", description = "Loan Repayment Information"))
public class LoanControllers {


}
