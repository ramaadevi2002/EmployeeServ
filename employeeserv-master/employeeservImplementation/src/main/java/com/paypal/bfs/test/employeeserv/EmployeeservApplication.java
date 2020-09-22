package com.paypal.bfs.test.employeeserv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.paypal.bfs.test.employeeserv.api.model")
@SpringBootApplication
public class EmployeeservApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmployeeservApplication.class, args);
    }
}