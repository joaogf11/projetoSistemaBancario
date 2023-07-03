package br.com.bcb.models.scope;

import java.time.Instant;
import java.util.Date;

public class Transactionals {
    private double transactionValue;
    private Date transactionDate;
    private Instant transactionDateUnixTime;
    private String userPaid;
    private String userRecieved;
    private String userPaidBank;
    private String getUserRecievedBank;
    private String UUID;

    public double getTransactionValue() {
        return transactionValue;
    }

    public void setTransactionValue(double transactionValue) {
        this.transactionValue = transactionValue;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
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

    public String getGetUserRecievedBank() {
        return getUserRecievedBank;
    }

    public void setGetUserRecievedBank(String getUserRecievedBank) {
        this.getUserRecievedBank = getUserRecievedBank;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }
}
