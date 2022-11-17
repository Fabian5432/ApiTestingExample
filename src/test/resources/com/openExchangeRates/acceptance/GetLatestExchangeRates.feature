Feature: Get latest exchange rates

  Background:
    Given a client is using the OpenExchangeRates service

@ignore
# Changing Base Currency is currently available for clients on the Developer, Enterprise and Unlimited plans.
Scenario Outline: set and retrieve latest exchange rates for a given base currency
  When a request is made to get all rates available with a specific "<baseCurrency>"
  Then all available rates are returned correctly for the base currency set

  Examples:
    | baseCurrency    |
    | EUR             |
    | GBP             |

  Scenario Outline: get latest exchange rates for given currency symbols
    When a request is made to get all rates available for "<currencySymbols>"
    Then all available rates are returned correctly

    Examples:
      | currencySymbols          |
      | EUR,GBP                  |
      | EUR,GBP,PLN              |
      | EUR,GBP,PLN,AED          |

  Scenario: cannot get all latest exchange rates with invalid access key
    When a request is made to get all rates available using an invalid app id
    Then all available rates are not returned

