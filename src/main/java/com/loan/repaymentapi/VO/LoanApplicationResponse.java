package com.loan.repaymentapi.VO;

import com.loan.repaymentapi.model.LoanStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanApplicationResponse {
    private long loan_application_id;
    private float loan_amount;
    private int loan_duration;
    private LocalDateTime date;
    private LoanStatus loan_status;
    private String message;
    private boolean success;

}
