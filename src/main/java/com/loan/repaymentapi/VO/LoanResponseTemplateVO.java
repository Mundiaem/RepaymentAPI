package com.loan.repaymentapi.VO;

import com.loan.repaymentapi.model.LoanApplication;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanResponseTemplateVO {
    public String message;
    public boolean successful;
    public LoanApplication loanApplication;

}
