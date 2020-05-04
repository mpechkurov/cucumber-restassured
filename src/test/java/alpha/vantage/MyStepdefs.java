package alpha.vantage;

import java.util.List;

import com.jayway.restassured.response.Response;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import alpha.vantage.dto.CurrencyExchangeDTO;
import alpha.vantage.dto.GlobalQuoteDTO;
import alpha.vantage.temp.AbstractSteps;

import static com.jayway.restassured.RestAssured.given;
import static alpha.vantage.utils.Parameters.DATA_TYPE;
import static alpha.vantage.utils.Parameters.FROM_CURRENCY;
import static alpha.vantage.utils.Parameters.FUNCTION;
import static alpha.vantage.utils.Parameters.KEY;
import static alpha.vantage.utils.Parameters.SYMBOL;
import static alpha.vantage.utils.Parameters.TO_CURRENCY;
import static alpha.vantage.utils.Parser.getCurrencyExchangeDataFromJsonString;
import static alpha.vantage.utils.Parser.getGlobalQuoteDataFromJsonString;
import static alpha.vantage.utils.StepdefsUtil.getParameterByName;
import static alpha.vantage.utils.TestProperties.DEFAULT_API_KEY_VALUE;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;

public class MyStepdefs extends AbstractSteps {

    private static final String X_DOWNLOAD = "application/x-download";
    private static final String EXPECTED_GLOBAL_QUOTE_CSV_FILE = "global_quote.csv";
    private static final String CONTENT_DISPOSITION = "Content-Disposition";

    @When("^user send currency exchange rate with parameters$")
    public void userSendCurrencyExchangeRateWithParameters(DataTable table) {
        Response response = given()
                       .param(FUNCTION.value(), getParameterByName(table, FUNCTION.value()))
                       .param(FROM_CURRENCY.value(), getParameterByName(table, FROM_CURRENCY.value()))
                       .param(TO_CURRENCY.value(), getParameterByName(table, TO_CURRENCY.value()))
                       .param(KEY.value(), DEFAULT_API_KEY_VALUE)
                       .when()
                       .get()
                       .thenReturn();
        testContext().setResponse(response);
    }

    @Then("^user get response with exchange rate for current date$")
    public void userGetResponseWithExchangeRateForCurrentDate(DataTable dataTable) {

        List<String> expectedData = dataTable.asList(String.class);
        CurrencyExchangeDTO actualResponseData = getCurrencyExchangeDataFromJsonString(testContext().getResponse().getBody().asString());

        testContext().getResponse().then().assertThat().statusCode(SC_OK);
        assertEquals(expectedData.get(0), actualResponseData.getFromCurrencyCode());
        assertEquals(expectedData.get(1), actualResponseData.getFromCurrencyName());
        assertEquals(expectedData.get(2), actualResponseData.getToCurrencyCode());
        assertEquals(expectedData.get(3), actualResponseData.getToCurrencyName());
        assertEquals(expectedData.get(4), actualResponseData.getTimezone());
    }

    @Then("^user get response with error message \"([^\"]*)\"$")
    public void userGetResponseWithErrorMessage(String expectedErrorMessage) {
        assertEquals(expectedErrorMessage, testContext().getResponse().getBody().jsonPath().get("'Error Message'"));
    }

    @Then("^user get response with global quote data for \"([^\"]*)\" with correct data format$")
    public void userGetResponseWithGlobalQuoteDataForWithCorrectDataFormat(String expectedSymbol) {
        GlobalQuoteDTO globalQuoteDTO = getGlobalQuoteDataFromJsonString(testContext().getResponse().getBody().asString());
        assertEquals(globalQuoteDTO.getSymbol(), expectedSymbol);
    }

    @When("^user send global quoter request with required parameter$")
    public void userSendGlobalQuoterRequestWithRequiredParameter(DataTable table) {
        Response response = given()
                       .param(FUNCTION.value(), getParameterByName(table, FUNCTION.value()))
                       .param(SYMBOL.value(), getParameterByName(table, SYMBOL.value()))
                       .param(KEY.value(), DEFAULT_API_KEY_VALUE)
                       .when()
                       .get()
                       .thenReturn();
        testContext().setResponse(response);
    }

    @When("^user send global quoter request with all parameter$")
    public void userSendGlobalQuoterRequestWithAllParameter(DataTable table) {
        Response response = given()
                       .param(FUNCTION.value(), getParameterByName(table, FUNCTION.value()))
                       .param(SYMBOL.value(), getParameterByName(table, SYMBOL.value()))
                       .param(KEY.value(), DEFAULT_API_KEY_VALUE)
                       .param(DATA_TYPE.value(), getParameterByName(table, DATA_TYPE.value()))
                       .when()
                       .get()
                       .thenReturn();
        testContext().setResponse(response);
    }

    @Then("^user get response in 'csv' format$")
    public void userGetResponseInCsvFormat() {
        testContext().getResponse().then().assertThat().header(CONTENT_DISPOSITION, containsString(EXPECTED_GLOBAL_QUOTE_CSV_FILE));
        testContext().getResponse().then().assertThat().contentType(X_DOWNLOAD);
    }

}
