package com.loan.repaymentapi.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterTemplate {
    private String email;
    private String first_name;
    private String second_name;
    private String username;
    private String password;
    private String phone_number;
}
