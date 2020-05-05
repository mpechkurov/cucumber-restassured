package alpha.vantage.framework.base;

import java.util.concurrent.TimeUnit;

import com.jayway.restassured.RestAssured;

import alpha.vantage.utils.TestProperties;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class GlobalHooks {

    private static final int TIMEOUT_DUE_SERVICE_LIMITATION = 11;

    @Before
    public void beforeAll() {
        RestAssured.baseURI = TestProperties.BASE_URL;
    }

    @After
    public void tearDown() throws InterruptedException {
        TestContext.CONTEXT.reset();
        /**
         * This sleep just due limitation from Alpha Advantage API.
         * Tests should be executed slowly to path this limitation.
         *
         *"Thank you for using Alpha Vantage!
         * Our standard API call frequency is 5 calls per minute and 500 calls per day.
         * Please visit https://www.alphavantage.co/premium/ if you would like to target a higher API call frequency."
         */
        Thread.sleep(TimeUnit.SECONDS.toMillis(TIMEOUT_DUE_SERVICE_LIMITATION));
    }
}
