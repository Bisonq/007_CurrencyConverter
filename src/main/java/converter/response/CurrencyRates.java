package converter.response;

import com.fasterxml.jackson.annotation.JsonProperty;

class CurrencyRates {
    @JsonProperty("no")
    private String no;
    @JsonProperty("effectiveDate")
    private String effectiveDate;
    @JsonProperty("mid")
    private Double mid;

    public String getNo() {
        return no;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public Double getMid() {
        return mid;
    }
}
