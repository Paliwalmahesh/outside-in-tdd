package com.incubyte;

import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.json.tree.JsonObject;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@MicronautTest
public class CurrencyCalculatorTest {
    @Client("/")
    @Inject
    HttpClient httpClient;

    @Test
    @DisplayName("EMI Should be calculated")
    void emi_should_be_calculated() {
        //Given
        int loanAmount = 20000;
        double interestRate = 3.5;
        int durationYears = 30;
        //when
        int monthlyIncome=100;
        Emi emi = httpClient.toBlocking().retrieve("emi-calculator/30?loanAmount="
                + loanAmount + "&interestRate=" + interestRate + "&monthlyIncome=" + monthlyIncome, Emi.class);
        int interestPaid = emi.getInterestPaid();
        //then
        int monthlyAmount = emi.getMonthlyPayment();
        Assertions.assertThat(interestPaid).isEqualTo(123312);
        Assertions.assertThat(monthlyAmount).isEqualTo(898);


    }
    @Test
    @DisplayName("should approve if monthly income is twice the monthly payment  ")
    void should_approve_if_monthly_income_is_twice_the_monthly_payment() {
        //Given
        int loanAmount = 20000;
        double interestRate = 3.5;
        int durationYears = 30;
        //when
        int monthlyIncome=100;
        Emi emi = httpClient.toBlocking().retrieve("emi-calculator/30?loanAmount="
                + loanAmount + "&interestRate=" + interestRate + "&monthlyIncome=" + monthlyIncome, Emi.class);
      boolean approval = emi.getApproval();
      Assertions.assertThat(approval).isFalse();

        }
}



