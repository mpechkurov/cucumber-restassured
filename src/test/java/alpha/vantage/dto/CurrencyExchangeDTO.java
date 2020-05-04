package alpha.vantage.dto;

import java.time.LocalDateTime;

public class CurrencyExchangeDTO {

    private final String fromCurrencyCode;
    private final String fromCurrencyName;
    private final String toCurrencyCode;
    private final String toCurrencyName;
    private final Float exchangeRate;
    private final LocalDateTime time;
    private final String timezone;

    public CurrencyExchangeDTO(String fromCurrencyCode,
                               String fromCurrencyName,
                               String toCurrencyCode,
                               String toCurrencyName,
                               Float exchangeRate,
                               LocalDateTime time,
                               String timezone) {
        this.fromCurrencyCode = fromCurrencyCode;
        this.fromCurrencyName = fromCurrencyName;
        this.toCurrencyCode = toCurrencyCode;
        this.toCurrencyName = toCurrencyName;
        this.exchangeRate = exchangeRate;
        this.time = time;
        this.timezone = timezone;
    }

    public String getFromCurrencyCode() {
        return fromCurrencyCode;
    }

    public String getFromCurrencyName() {
        return fromCurrencyName;
    }

    public String getToCurrencyCode() {
        return toCurrencyCode;
    }

    public String getToCurrencyName() {
        return toCurrencyName;
    }

    public Float getExchangeRate() {
        return exchangeRate;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getTimezone() {
        return timezone;
    }

    @Override
    public String toString() {
        return "CurrencyExchangeData{" +
               "fromCurrencyCode='" + fromCurrencyCode + '\'' +
               ", fromCurrencyName='" + fromCurrencyName + '\'' +
               ", toCurrencyCode='" + toCurrencyCode + '\'' +
               ", toCurrencyName='" + toCurrencyName + '\'' +
               ", exchangeRate=" + exchangeRate +
               ", time=" + time +
               ", timezone='" + timezone + '\'' +
               '}';
    }
}
