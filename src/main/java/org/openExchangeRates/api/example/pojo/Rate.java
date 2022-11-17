package org.openExchangeRates.api.example.pojo;

public class Rate {
    private String rateName;
    private double  rateValue;

    public Rate(String rateName, double rateValue) {
        this.rateName = rateName;
        this.rateValue = rateValue;
    }
}
