package com.incubyte;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;

@Client("https://mocki.io/v1/")
public interface EmiControllerClient {
@Get("45b77711-0aa6-44d8-b35b-975b4de0654d")
    Emi fetch(int loanAmount, double interestRate, int durationYears);
}
