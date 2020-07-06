package converter.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.http.HttpResponse;

public class CurrencyResponseBuilder {

    private final HttpResponse<String> response;
    private CurrencyResponse currencyResponse;

    public CurrencyResponseBuilder(HttpResponse<String> response) {
        this.response = response;
        build();
    }

    public double getRate() {
        return this.currencyResponse.getRates()[0].getMid();
    }

    public String getCurrencyName() {
        return this.currencyResponse.getCurrency();
    }

    public String getDateOfPublication() {
        return this.currencyResponse.getRates()[0].getEffectiveDate();
    }

    protected void build() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            this.currencyResponse = mapper.readValue(response.body(), CurrencyResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
