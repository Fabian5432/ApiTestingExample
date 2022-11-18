package com.openExchangeRates.api;

import com.openExchangeRates.api.pojo.ExchangeRate;

public interface IOpenExchangeRatesService {
    ExchangeRate getAllRatesForSpecificCurrencySymbols(String currencySymbols);
}
