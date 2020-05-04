package alpha.vantage.utils;

public enum Parameters {
    FUNCTION("function"),
    FROM_CURRENCY("from_currency"),
    TO_CURRENCY("to_currency"),
    SYMBOL("symbol"),
    KEY("apikey"),
    DATA_TYPE("datatype");


    private String parameterName;

    Parameters(String parameterName) {
        this.parameterName = parameterName;
    }

    public String value() {
        return parameterName;
    }

}
