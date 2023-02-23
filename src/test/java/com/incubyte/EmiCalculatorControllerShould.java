package com.incubyte;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EmiCalculatorControllerShould {
    EmiCalculatorController emiCalculator;
    EmiService emiservice;

    @BeforeEach
    public void init() {
        emiservice = Mockito.mock(EmiService.class);
        emiCalculator = new EmiCalculatorController(emiservice);

    }

    @Test
    @DisplayName("calculate emi")
    void calculate_emi() {

        int amount = 200000;
        double interestRate = 3.5;
        int durationYear = 30;
        int monthlyIncome=100;

        emiCalculator.calculate(durationYear,amount, interestRate,monthlyIncome);

        Mockito.verify(emiservice).calculate(amount, interestRate, durationYear,monthlyIncome);

    }

}

