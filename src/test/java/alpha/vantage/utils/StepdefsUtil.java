package alpha.vantage.utils;

import java.util.List;
import java.util.Map;

import cucumber.api.DataTable;

public class StepdefsUtil {

    public static String getParameterByName(DataTable dataTable, String parameterName) {
        List<Map<String, String>> requestParameters = dataTable.asMaps(String.class, String.class);
        return requestParameters.get(0).get(parameterName);
    }
}
