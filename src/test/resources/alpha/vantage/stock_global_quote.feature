Feature: Stock quote endpoint
  As a user
  I want to get latest price and volume information for a security of your choice
  So I can get latest information of the global security of your choice.

  Scenario: Get global quote of choice
    When user send global quoter request with required parameter
      | function     | symbol |
      | GLOBAL_QUOTE | IBM    |
    Then user get response with global quote data for "IBM" with correct data format

  Scenario: Get global quote in csv format
    When user send global quoter request with all parameter
      | function     | symbol | datatype |
      | GLOBAL_QUOTE | IBM    | csv      |
    Then user get response in 'csv' format

  Scenario Outline: Get global quote with wrong parameter
    When user send global quoter request with required parameter
      | function         | symbol         |
      | <function_value> | <symbol_value> |
    Then user get response with error message "<error_message>"
    Examples:
      | function_value | symbol_value | error_message                                                                                                            |
      | WRONG_VALUE    | IBM          | This API function (WRONG_VALUE) does not exist.                                                                          |
      | GLOBAL_QUOTE   | WRONG_VALUE  | Invalid API call. Please retry or visit the documentation (https://www.alphavantage.co/documentation/) for GLOBAL_QUOTE. |
