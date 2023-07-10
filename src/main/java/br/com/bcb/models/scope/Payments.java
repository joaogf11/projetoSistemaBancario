package br.com.bcb.models.scope;

import java.time.Instant;

public class Payments {
    private double transactionValue;
    private String transactionDate;
    private Instant transactionDateUnixTime;
    private String userPaid;
    private String userRecieved;
    private String userPaidBank;
    private String UserRecievedBank;
    private String UUID;
    private String paymentMethod;
    public String getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public double getTransactionValue() {
        return transactionValue;
    }

    public void setTransactionValue(double transactionValue) {
        this.transactionValue = transactionValue;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Instant getTransactionDateUnixTime() {
        return transactionDateUnixTime;
    }

    public void setTransactionDateUnixTime(Instant transactionDateUnixTime) {
        this.transactionDateUnixTime = transactionDateUnixTime;
    }

    public String getUserPaid() {
        return userPaid;
    }

    public void setUserPaid(String userPaid) {
        this.userPaid = userPaid;
    }

    public String getUserRecieved() {
        return userRecieved;
    }

    public void setUserRecieved(String userRecieved) {
        this.userRecieved = userRecieved;
    }

    public String getUserPaidBank() {
        return userPaidBank;
    }

    public void setUserPaidBank(String userPaidBank) {
        this.userPaidBank = userPaidBank;
    }

    public String getUserRecievedBank() {
        return UserRecievedBank;
    }

    public void setUserRecievedBank(String userRecievedBank) {
        this.UserRecievedBank = userRecievedBank;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }
}
