package com.incubyte;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EmiServiceShould {
    EmiControllerClient emiControllerClient;
    EmiService emiService;

    @BeforeEach
    public void init() {
        emiControllerClient = Mockito.mock(EmiControllerClient.class);
        emiService = new EmiService(emiControllerClient);
    }

    @Test
    @DisplayName("return false if monthly income is less twice of monthly payment")
    void return_false_if_monthly_income_is_less_twice_of_monthly_payment() {
        int loanAmount = 20000;
        double interestRate = 3.5;
        int durationYears = 30;
        int monthlyIncome = 100;
        Emi emi = new Emi(123312, 898);
        Mockito.when(emiControllerClient.fetch(loanAmount, interestRate, durationYears)).thenReturn(emi);
        final Emi calculateEmi = emiService.calculate(loanAmount, interestRate, durationYears, monthlyIncome);
        Assertions.assertThat(calculateEmi.getApproval()).isFalse();
    }

    @Test
    @DisplayName("return true if monthly income is less twice of monthly payment")
    void return_true_if_monthly_income_is_less_twice_of_monthly_payment() {
        int loanAmount = 20000;
        double interestRate = 3.5;
        int durationYears = 30;
        int monthlyIncome = 100000;
        Emi emi = new Emi(123312, 898);
        Mockito.when(emiControllerClient.fetch(loanAmount, interestRate, durationYears)).thenReturn(emi);
        final Emi calculateEmi = emiService.calculate(loanAmount, interestRate, durationYears, monthlyIncome);
        Assertions.assertThat(calculateEmi.getApproval()).isTrue();
    }
}