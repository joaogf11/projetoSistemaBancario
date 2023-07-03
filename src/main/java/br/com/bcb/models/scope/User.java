package br.com.bcb.models.scope;

import java.time.Instant;
import java.util.Date;

public class User {
    private double balance;
    private int accountPassword;
    private String name;
    private Date bornDate;
    private Instant bornDateUnixTime;
    private String cpf;
    private int cardPassword;
    private int atpPassword;
    private String gender;
    private String address;
    private String cellNumber;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(int accountPassword) {
        this.accountPassword = accountPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getCardPassword() {
        return cardPassword;
    }

    public void setCardPassword(int cardPassword) {
        this.cardPassword = cardPassword;
    }

    public int getAtpPassword() {
        return atpPassword;
    }

    public void setAtpPassword(int atpPassword) {
        this.atpPassword = atpPassword;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

    public Instant getBornDateUnixTime() {
        return bornDateUnixTime;
    }

    public void setBornDateUnixTime(Instant bornDateUnixTime) {
        this.bornDateUnixTime = bornDateUnixTime;
    }
}
