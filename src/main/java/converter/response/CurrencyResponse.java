package converter.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

class CurrencyResponse {
    @JsonProperty("table")
    private String table;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("code")
    private String code;
    @JsonProperty("rates")
    private CurrencyRates[] rates;

    @Override
    public String toString() {
        return "CurrencyResponse{" +
                "table='" + table + '\'' +
                ", currency='" + currency + '\'' +
                ", code='" + code + '\'' +
                ", rates=" + Arrays.toString(rates) +
                '}';
    }
}
