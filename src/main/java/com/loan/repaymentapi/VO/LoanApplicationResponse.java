package com.loan.repaymentapi.VO;

import com.loan.repaymentapi.model.LoanStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanApplicationResponse {
    private long loan_application_id;
    private float loan_amount;
    private int loan_duration;
    private Date date;
    private LoanStatus loan_status;

}
