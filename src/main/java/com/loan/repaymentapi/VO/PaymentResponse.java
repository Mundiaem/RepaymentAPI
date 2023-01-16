package com.loan.repaymentapi.VO;

import lombok.*;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class PaymentResponse {
    private LocalDateTime date;
    private float payment_amount;
    private float interest_paid;
    private float principal_amount;
    private float remaining_amount;
}
