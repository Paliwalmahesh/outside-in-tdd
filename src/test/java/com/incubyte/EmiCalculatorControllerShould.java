package com.incubyte;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EmiCalculatorControllerShould {
    EmiCalculatorController emicalculator;
    EmiService emiservice;

    @BeforeEach
    public void init() {
        emiservice = Mockito.mock(EmiService.class);
        emicalculator = new EmiCalculatorController(emiservice);

    }

    @Test
    @DisplayName("calculate emi")
    void calculate_emi() {

        int amount = 200000;
        double interestRate = 3.5;
        int durationYear = 30;
        int monthlyIncome=100;

        emicalculator.calculate(durationYear,amount, interestRate,monthlyIncome);

        Mockito.verify(emiservice).calculate(amount, interestRate, durationYear,monthlyIncome);

    }
@Test
@DisplayName("return false if monthly income is half then emi")
void return_false_if_monthly_income_is_half_then_emi() {
    int amount = 200000;
    double interestRate = 3.5;
    int durationYear = 30;
    int monthlyIncome=100;



    }
}

