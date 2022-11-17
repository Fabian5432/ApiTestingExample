package org.openExchangeRates.api.example;

import org.openExchangeRates.api.example.pojo.ExchangeRate;

public interface IOpenExchangeRatesService {
    ExchangeRate getAllRatesForSpecificCurrencySymbols(String currencySymbols);
}
