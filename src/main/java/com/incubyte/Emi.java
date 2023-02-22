package com.incubyte;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Emi {
    private final int interestPaid;
    private final int monthlyPayment;
    private boolean approval;

    public Emi(
            @JsonProperty("total_interest_paid") int interestPaid,
            @JsonProperty("total") int monthlyPayment) {
        this.interestPaid = interestPaid;
        this.monthlyPayment = monthlyPayment;
    }

    public int getInterestPaid() {
        return interestPaid;
    }


    public int getMonthlyPayment() {
        return monthlyPayment;
    }

    public boolean getApproval() {
        return approval;
    }

    public void setApproval(boolean approval) {
        this.approval = approval;
    }
}
