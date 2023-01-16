package com.loan.repaymentapi.controllers;

import com.loan.repaymentapi.VO.LoanApplicationRequest;
import com.loan.repaymentapi.VO.LoanApplicationResponse;
import com.loan.repaymentapi.VO.LoanTypeRequest;
import com.loan.repaymentapi.VO.LoanTypeResponse;
import com.loan.repaymentapi.model.LoanApplication;
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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/")
@OpenAPIDefinition(info = @Info(title = "Loan Repayment API", version = "1.0", description = "Loan Repayment Information"))
public class LoanControllers {

    @Autowired
    private LoanService loanService;
    @PostMapping(value = "create_loan_type")
    @Operation(summary = "create loan type ", tags = {"Loan Type",},
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "Return loan types",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = LoanTypeResponse.class)))
            })
    /**
     * get loan applications
     * */
    private ResponseEntity<LoanTypeResponse> createLoanType(@RequestBody LoanTypeRequest request) {
        return new ResponseEntity<>(loanService.makeLoanType(request), HttpStatus.OK);
    }
    @PostMapping(value = "request_loan")
    @Operation(summary = "Make loan request ", tags = {"Loan Application",},
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "Return loan application",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = LoanApplicationResponse.class)))
            })
    /**
     * get loan applications
     * */
    private ResponseEntity<LoanApplicationResponse> makeLoanApplication(@RequestBody LoanApplicationRequest loanApplicationRequest) {
        return new ResponseEntity<>(loanService.makeLoanApplication(loanApplicationRequest), HttpStatus.OK);
    }

    @GetMapping(value = "loan_applications")
    @Operation(summary = "Get loan applications  ", tags = {"Loan Applications",},
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "Return all loan applications ",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = LoanApplication.class)))
            })
    private ResponseEntity<List<LoanApplication>> getLoanApplications() {
        return new ResponseEntity<>(loanService.getLoanApplications(), HttpStatus.OK);
    }

    /**
     *
     * */



}
