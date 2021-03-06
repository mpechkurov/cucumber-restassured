# Description
API testing example for :  
 
API | Description | Auth | HTTPS | CORS |
|---|---|---|---|---|
| [Alpha Vantage](https://www.alphavantage.co/) | Realtime and historical stock data | `apiKey` | Yes | Unknown |

## Endpoint 1
[Exchange Rates](https://www.alphavantage.co/documentation/#currency-exchange)
Request example :
```
https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency=USD&to_currency=JPY&apikey=demo
```
Covered in feature forex_currency_exchange_rate.feature

Scenario list : 
1. Happy path for valid data request
2. Invalid input validation scenario

## Endpoint 2
[Quote Endpoint](https://www.alphavantage.co/documentation/#latestprice)
Request example : 
```
https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=IBM&apikey=demo
```
Covered in feature stock_global_quote.feature

Scenario list : 
1. Happy path for valid data request
2. Happy path for valid optional parameter "datatype"
3. Invalid input validation scenario

## Tools 
- [Java 8](https://www.oracle.com/java/technologies/javase-jre8-downloads.html) - required version of Java.
- [Maven](https://maven.apache.org) - tool to build and run Java projects.
- [Cucumber](https://cucumber.io) - BDD test framework.
- [Rest assured](http://rest-assured.io) - test framework for API testing.
- [gson](https://github.com/google/gson) - library to parse Json format.


## How to run tests 
1. Claim your API Key https://www.alphavantage.co/support/#api-key
2. Update __config.properties__ with your key
3. Run test from project root directory  ```mvn clean test```

# NOTE 
Due limitation from Alpha Vantage API tests executed with 10 seconds pause. 

  > Standard API call frequency is 5 calls per minute and 500 calls per day.
  > Please visit https://www.alphavantage.co/premium/ if you would like to target a higher API call frequency.