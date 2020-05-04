package alpha.vantage.utils;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import alpha.vantage.dto.CurrencyExchangeDTO;
import alpha.vantage.dto.GlobalQuoteDTO;
import gherkin.deps.com.google.gson.JsonSyntaxException;

public class Parser {
    static final DateTimeFormatter DATE_WITH_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    static final DateTimeFormatter SIMPLE_DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static CurrencyExchangeDTO getCurrencyExchangeDataFromJsonString(String jsonString) {
        JsonObject rootObject = JsonParser.parseString(jsonString).getAsJsonObject();
        Type dataType = new TypeToken<Map<String, Map<String, String>>>() {
        }.getType();
        Map<String, Map<String, String>> data = new Gson().fromJson(rootObject, dataType);
        return createCurrencyExchangeData(data.values().stream().findFirst().orElse(Collections.emptyMap()));
    }

    private static CurrencyExchangeDTO createCurrencyExchangeData(Map<String, String> values)
        throws JsonSyntaxException {
        return new CurrencyExchangeDTO(
            values.get("1. From_Currency Code"),
            values.get("2. From_Currency Name"),
            values.get("3. To_Currency Code"),
            values.get("4. To_Currency Name"),
            Float.parseFloat(values.get("5. Exchange Rate")),
            LocalDateTime.parse(values.get("6. Last Refreshed"), DATE_WITH_TIME_FORMAT),
            values.get("7. Time Zone")
        );
    }

    public static GlobalQuoteDTO getGlobalQuoteDataFromJsonString(String jsonString) {
        JsonObject rootObject = JsonParser.parseString(jsonString).getAsJsonObject();
        Type dataType = new TypeToken<Map<String, Map<String, String>>>() {
        }.getType();
        Map<String, Map<String, String>> data = new Gson().fromJson(rootObject, dataType);
        return createGlobalQuoteDTP(data.values().stream().findFirst().orElse(Collections.emptyMap()));
    }

    private static GlobalQuoteDTO createGlobalQuoteDTP(Map<String, String> values) throws JsonSyntaxException {
        return new GlobalQuoteDTO(
            values.get("01. symbol"),
            Double.parseDouble(values.get("02. open")),
            Double.parseDouble(values.get("03. high")),
            Double.parseDouble(values.get("04. low")),
            Double.parseDouble(values.get("05. price")),
            Long.parseLong(values.get("06. volume")),
            LocalDate.parse(values.get("07. latest trading day"), SIMPLE_DATE_FORMAT),
            Double.parseDouble(values.get("08. previous close")),
            Double.parseDouble(values.get("09. change")),
            Double.parseDouble(values.get("10. change percent").replace("%", ""))
        );
    }

}
