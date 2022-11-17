package com.openExchangeRates.acceptance;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.jupiter.api.Assumptions;

public class Hooks {
    @Before("@ignore")
    public void skip_scenario(Scenario scenario){
        System.out.println("SKIP SCENARIO: " + scenario.getName());
        Assumptions.assumeTrue(false);
    }
}
