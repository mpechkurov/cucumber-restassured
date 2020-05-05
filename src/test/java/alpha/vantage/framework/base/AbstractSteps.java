package alpha.vantage.framework.base;

import java.util.List;
import java.util.Map;

import cucumber.api.DataTable;

import static alpha.vantage.framework.base.TestContext.CONTEXT;

public abstract class AbstractSteps {
    protected static final String X_DOWNLOAD = "application/x-download";
    protected static final String CONTENT_DISPOSITION = "Content-Disposition";

    public TestContext testContext() {
        return CONTEXT;
    }

    public static String getParameterByName(DataTable dataTable, String parameterName) {
        List<Map<String, String>> requestParameters = dataTable.asMaps(String.class, String.class);
        return requestParameters.get(0).get(parameterName);
    }
}

