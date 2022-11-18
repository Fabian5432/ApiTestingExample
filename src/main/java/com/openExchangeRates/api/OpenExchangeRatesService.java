package com.openExchangeRates.api;

import okhttp3.ResponseBody;
import org.json.JSONObject;
import com.openExchangeRates.api.pojo.ExchangeRate;
import com.openExchangeRates.api.pojo.Rate;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.ArrayList;

public class OpenExchangeRatesService implements IOpenExchangeRatesService{

    private IOpenExchangeRatesApi iOpenExhangeRatesApi;
    private Retrofit retrofit;
    private String accessKey;

    public OpenExchangeRatesService(String accessKey)
    {
        this.accessKey = accessKey;
        this.retrofit = new Retrofit.Builder()
            .baseUrl("https://openexchangerates.org")
            .build();
        this.iOpenExhangeRatesApi = retrofit.create(IOpenExchangeRatesApi.class);
    }

    @Override
    public ExchangeRate getAllRatesForSpecificCurrencySymbols(String currencySymbols) {
        Call<ResponseBody> response = iOpenExhangeRatesApi.getLatestExchangeRatesWithSpecificSymbols(accessKey, currencySymbols);
        return extractExchangeRateFromResponse(response);
    }

    private ExchangeRate extractExchangeRateFromResponse(Call<ResponseBody> response)
    {
        ExchangeRate exchangeRate = null;
        var rates = new ArrayList<Rate>();
        try {
            var responseBody = response.execute().body().string();
            System.out.println(responseBody);
            JSONObject json = new JSONObject(responseBody);
            var ratesJson = json.getJSONObject("rates");

            for (String key : ratesJson.keySet())
            {
                rates.add(new Rate(key, ratesJson.getDouble(key)));
            }

            exchangeRate = new ExchangeRate(json.getString("disclaimer"),
                    json.getString("license"),
                    json.getInt("timestamp"),
                    json.getString("base"),
                    rates);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return  exchangeRate;
    }
}
