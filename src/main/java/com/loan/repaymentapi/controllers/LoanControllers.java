package com.loan.repaymentapi.controllers;

import com.loan.repaymentapi.VO.LoanApplicationRequest;
import com.loan.repaymentapi.VO.LoanApplicationResponse;
import com.loan.repaymentapi.services.LoanService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/")
@OpenAPIDefinition(info = @Info(title = "Loan Repayment API", version = "1.0", description = "Loan Repayment Information"))
public class LoanControllers {

    @Autowired
    private LoanService loanService;

    @PostMapping(value = "request_loan")
    @Operation(summary = "configure number of floors ", tags = {"Loan Application",},
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "Returns all number of floors",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = LoanApplicationResponse.class)))
            })
    private ResponseEntity<LoanApplicationResponse> makeLoanApplication(@RequestBody LoanApplicationRequest loanApplicationRequest) {
        return new ResponseEntity<>(loanService.makeLoanApplication(loanApplicationRequest), HttpStatus.OK);
    }


}
