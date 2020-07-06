package converter.response;

import com.fasterxml.jackson.annotation.JsonProperty;

class CurrencyRates {
    @JsonProperty("no")
    private String no;
    @JsonProperty("effectiveDate")
    private String effectiveDate;
    @JsonProperty("mid")
    private Double mid;

    @Override
    public String toString() {
        return "CurrencyRates{" +
                "no='" + no + '\'' +
                ", effectiveDate='" + effectiveDate + '\'' +
                ", mid=" + mid +
                '}';
    }
}
