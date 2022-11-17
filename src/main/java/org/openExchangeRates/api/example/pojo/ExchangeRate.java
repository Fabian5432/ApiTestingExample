package org.openExchangeRates.api.example.pojo;

import java.util.ArrayList;

public class ExchangeRate {

    private String disclaimer;

    private String license;

    private int timestamp;

    private String base;

    private ArrayList<Rate> Rates;

    public ExchangeRate(String disclaimer, String license, int timestamp, String base, ArrayList<Rate> rates) {
        this.disclaimer = disclaimer;
        this.license = license;
        this.timestamp = timestamp;
        this.base = base;
        Rates = rates;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public String getLicense() {
        return license;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public String getBase() {
        return base;
    }

    public ArrayList<Rate> getRates() {
        return Rates;
    }
}
