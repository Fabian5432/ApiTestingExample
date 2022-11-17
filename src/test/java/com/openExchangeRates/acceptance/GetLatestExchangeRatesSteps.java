package com.openExchangeRates.acceptance;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openExchangeRates.api.example.OpenExchangeRatesService;
import org.openExchangeRates.api.example.pojo.ExchangeRate;

import static org.junit.jupiter.api.Assertions.*;

public class GetLatestExchangeRatesSteps {
    private OpenExchangeRatesService currencyLayerService;
    private ExchangeRate actualExchangeRateResponse;
    private String currencies;

    @Given("a client is using the OpenExchangeRates service")
    public void aUserIsUsingTheOpenCurrencyApi() {

        currencyLayerService = new OpenExchangeRatesService("1de86dfd996b4c9da20c0b3fa6eefaa4");
    }

    @When("^a request is made to get all rates available for \\\"([^\\\"]*)\\\"")
    public void aRequestIsMadeToGetAllQuotesAvailable(String currencies) {

       this.currencies = currencies;
       actualExchangeRateResponse = currencyLayerService.getAllRatesForSpecificCurrencySymbols(currencies);
    }

    @Then("all available rates are returned correctly")
    public void allAvailableQuotesAreReturned() {
        var expectedCurrencies = currencies.split(",");
        assertNotNull(actualExchangeRateResponse, "Actual rates should not be null");
        assertFalse(actualExchangeRateResponse.getRates().stream().findAny().isEmpty(), "Actual rates should not be empty");
        assertEquals(expectedCurrencies.length, actualExchangeRateResponse.getRates().size(), "Actual rates size should be as expected");
    }

    @When("a request is made to get all rates available using an invalid app id")
    public void aRequestIsMadeToGetAllQuotesAvailableUsingAnInvalidAccessKey() {

        currencyLayerService = new OpenExchangeRatesService(null);
    }

    @Then("all available rates are not returned")
    public void allAvailableQuotesAreNotReturned() {

        assertNull(actualExchangeRateResponse, "Response should be null");
    }
}
