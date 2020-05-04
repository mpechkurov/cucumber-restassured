Feature: Forex currency exchange rate endpoint
  As a user
  I want to get real time exchange rate from currency to currency
  So I can get real time data currency rate

  Scenario: Get exchange rate for correct request
    When user send currency exchange rate with parameters
      | function               | from_currency | to_currency |
      | CURRENCY_EXCHANGE_RATE | USD           | JPY         |
    Then user get response with exchange rate for current date
      | USD | United States Dollar | JPY | Japanese Yen | UTC |

  Scenario Outline: Get exchange rate with wrong parameter
    When user send currency exchange rate with parameters
      | function         | from_currency         | to_currency         |
      | <function_value> | <from_currency_value> | <to_currency_value> |
    Then user get response with error message "<error_message>"
    Examples:
      | function_value         | from_currency_value | to_currency_value | error_message                                                                                                                      |
      | WRONG_VALUE            | USD                 | JPY               | This API function (WRONG_VALUE) does not exist.                                                                                    |
      | CURRENCY_EXCHANGE_RATE | WRONG_VALUE         | JPY               | Invalid API call. Please retry or visit the documentation (https://www.alphavantage.co/documentation/) for CURRENCY_EXCHANGE_RATE. |
      | CURRENCY_EXCHANGE_RATE | USD                 | WRONG_VALUE       | Invalid API call. Please retry or visit the documentation (https://www.alphavantage.co/documentation/) for CURRENCY_EXCHANGE_RATE. |
