package com.loan.repaymentapi.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanTypeResponse {
    private long loan_type_id;
    private String loan_name;
    private String loan_description;
}
