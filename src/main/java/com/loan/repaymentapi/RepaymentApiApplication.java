package com.loan.repaymentapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = {"com.loan.repaymentapi.*", "com.loan.repaymentapi.config"})
@EnableJpaRepositories(basePackages = "com.loan.repaymentapi.repository", entityManagerFactoryRef = "entityManagerFactory")
public class RepaymentApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RepaymentApiApplication.class, args);
    }

}
