package com.incubyte;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;

@Controller("/")

public class EmiCalculatorController {

    private EmiService emiservice;

    public EmiCalculatorController(EmiService emiservice) {

        this.emiservice = emiservice;
    }


    @Get("emi-calculator/{durationYear}")
    public Emi calculate(@QueryValue int durationYear, int loanAmount, double interestRate, int monthlyIncome) {
        System.out.println(loanAmount);
        return this.emiservice.calculate(loanAmount, interestRate, durationYear, monthlyIncome);

    }
}
