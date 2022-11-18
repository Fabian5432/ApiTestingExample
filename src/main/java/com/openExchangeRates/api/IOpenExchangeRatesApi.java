package com.openExchangeRates.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IOpenExchangeRatesApi {

    @GET("/api/latest.json")
    Call<ResponseBody> getLatestExchangeRatesWithSpecificSymbols(@Query("app_id") String app_id, @Query("symbols") String symbols);
}
