package com.incubyte;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.MutableHttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import jakarta.inject.Inject;


public class EmiService {



    EmiControllerClient emiControllerClient;
    @Inject
    HttpClient httpClient;

    public EmiService(EmiControllerClient emiControllerClient) {

        this.emiControllerClient = emiControllerClient;
    }

    public Emi calculate(int loanAmount, double interestRate, int durationYears, int monthlyIncome) {
        MutableHttpRequest<Object> request = HttpRequest.GET("45b77711-0aa6-44d8-b35b-975b4de0654d");

        final Emi retrieve = emiControllerClient.fetch(loanAmount,interestRate,durationYears);
        retrieve.setApproval(retrieve.getMonthlyPayment() < monthlyIncome/2);
        return retrieve;
    }
}
