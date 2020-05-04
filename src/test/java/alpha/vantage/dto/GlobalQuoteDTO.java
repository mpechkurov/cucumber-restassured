package alpha.vantage.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class GlobalQuoteDTO {
    private final String symbol;
    private final Double open;
    private final Double high;
    private final Double low;
    private final Double price;
    private final Long volume;
    private final LocalDate latestTradingDay;
    private final Double previousClose;
    private final Double change;
    private final Double changePercent;

    public GlobalQuoteDTO(String symbol,
                          Double open,
                          Double high,
                          Double low,
                          Double price,
                          Long volume,
                          LocalDate latestTradingDay,
                          Double previousClose,
                          Double change,
                          Double changePercent) {
        this.symbol = symbol;
        this.open = open;
        this.high = high;
        this.low = low;
        this.price = price;
        this.volume = volume;
        this.latestTradingDay = latestTradingDay;
        this.previousClose = previousClose;
        this.change = change;
        this.changePercent = changePercent;
    }

    public String getSymbol() {
        return symbol;
    }

    public Double getOpen() {
        return open;
    }

    public Double getHigh() {
        return high;
    }

    public Double getLow() {
        return low;
    }

    public Double getPrice() {
        return price;
    }

    public Long getVolume() {
        return volume;
    }

    public LocalDate getLatestTradingDay() {
        return latestTradingDay;
    }

    public Double getPreviousClose() {
        return previousClose;
    }

    public Double getChange() {
        return change;
    }

    public Double getChangePercent() {
        return changePercent;
    }
}
