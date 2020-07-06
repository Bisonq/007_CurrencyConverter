package converter.response;

import com.fasterxml.jackson.annotation.JsonProperty;

class CurrencyResponse {
    @JsonProperty("table")
    private String table;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("code")
    private String code;
    @JsonProperty("rates")
    private CurrencyRates[] rates;

    public String getTable() {
        return table;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCode() {
        return code;
    }

    public CurrencyRates[] getRates() {
        return rates;
    }
}
