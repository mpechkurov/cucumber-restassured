package alpha.vantage;

import com.jayway.restassured.RestAssured;

import alpha.vantage.utils.TestProperties;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import alpha.vantage.temp.TestContext;

public class GlobalHooks {

    @Before
    public void beforeAll() {
        RestAssured.baseURI = TestProperties.BASE_URL;
    }

    @After
    public void tearDown() {
        TestContext.CONTEXT.reset();
    }
}
