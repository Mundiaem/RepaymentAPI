package com.loan.repaymentapi.controllers;



import com.loan.repaymentapi.VO.LoanTypeResponse;
import com.loan.repaymentapi.VO.RegisterTemplate;
import com.loan.repaymentapi.model.Customers;
import com.loan.repaymentapi.model.JwtRequest;
import com.loan.repaymentapi.model.JwtResponse;
import com.loan.repaymentapi.model.LoanApplication;
import com.loan.repaymentapi.security.JwtTokenUtil;
import com.loan.repaymentapi.services.JwtCustomerDetailsService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@ComponentScan
@RequestMapping("/v1/api/customer/")
@OpenAPIDefinition(info = @Info(title = "Loan Repayment API", version = "1.0", description = "Authentication"))
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtCustomerDetailsService jwtCustomerDetailsService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "Login Authentication ", tags = {"Authentication",},
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "Customer login",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = JwtResponse.class)))
            })

    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = jwtCustomerDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());


        final String token = jwtTokenUtil.generateToken(userDetails);
        System.out.println("Token: "+token);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "Register customers  ", tags = {"Authentication",},
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "Customer details response ",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = RegisterTemplate.class)))
            })
    public ResponseEntity<?> saveUser(@RequestBody RegisterTemplate registerTemplate) throws Exception {
        return ResponseEntity.ok(jwtCustomerDetailsService.save(registerTemplate));
    }
}
