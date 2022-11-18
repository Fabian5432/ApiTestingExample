package com.openExchangeRates.api.pojo;

public class Rate {
    private String rateName;
    private double  rateValue;

    public Rate(String rateName, double rateValue) {
        this.rateName = rateName;
        this.rateValue = rateValue;
    }
}
