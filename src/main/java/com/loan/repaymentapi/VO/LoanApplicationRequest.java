package com.loan.repaymentapi.VO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class LoanApplicationRequest {
    private String phone_number;
    private String customer_name;
    private float loan_amount;
    private int duration;
    private long loan_type_id;
}
