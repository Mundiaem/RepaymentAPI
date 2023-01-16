package com.loan.repaymentapi.VO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class MakeLoanPaymentRequest {
    private int  load_id;
    private float amount;
    private String phone_number;
}
