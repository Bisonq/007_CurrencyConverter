package converter;

import converter.response.CurrencyResponseBuilder;

import java.net.http.HttpResponse;

public class Converter {

    private static final Converter converter = new Converter();
    private CurrencyRequest request;

    private Converter() {
        this.request = new CurrencyRequest();
    }

    public static Converter getInstance() {
        return converter;
    }

    public String getTheResultInPLN(double amount, CurrencySymbol symbol) {
        this.request = new CurrencyRequest();
        HttpResponse<String> response = request.sendRequest(symbol);
        if (response.statusCode() == 404)
            return "No Data Found";
        else if (response.statusCode() / 100 != 2)
            throw new ResponseException(response.statusCode());
        CurrencyResponseBuilder currencyResponseBuilder = new CurrencyResponseBuilder(response);
        return amount + " " + symbol.toString() + " = " + currencyResponseBuilder.getRate() * amount + " PLN";
    }

    public String getTheResultInGivenCurrencySymbol(double amount, CurrencySymbol symbol) {
        this.request = new CurrencyRequest();
        HttpResponse<String> response = request.sendRequest(symbol);
        if (response.statusCode() == 404)
            return "No Data Found";
        else if (response.statusCode() / 100 != 2)
            throw new ResponseException(response.statusCode());
        CurrencyResponseBuilder currencyResponseBuilder = new CurrencyResponseBuilder(response);
        return amount + " " + "PLN" + " = " + amount / currencyResponseBuilder.getRate() + " " + symbol.toString();
    }

    public double getActualRate(CurrencySymbol symbol) {
        this.request = new CurrencyRequest();
        HttpResponse<String> response = request.sendRequest(symbol);
        if (response.statusCode() == 404)
            return -1;
        else if (response.statusCode() / 100 != 2)
            throw new ResponseException(response.statusCode());
        CurrencyResponseBuilder currencyResponseBuilder = new CurrencyResponseBuilder(response);
        return currencyResponseBuilder.getRate();
    }

    public String getCurrencyCountry(CurrencySymbol symbol) {
        this.request = new CurrencyRequest();
        HttpResponse<String> response = request.sendRequest(symbol);
        if (response.statusCode() == 404)
            return "No Data Found";
        else if (response.statusCode() / 100 != 2)
            throw new ResponseException(response.statusCode());
        CurrencyResponseBuilder currencyResponseBuilder = new CurrencyResponseBuilder(response);
        return currencyResponseBuilder.getCurrencyName();
    }

    public String getDateOfRatePublication(CurrencySymbol symbol) {
        this.request = new CurrencyRequest();
        HttpResponse<String> response = request.sendRequest(symbol);
        if (response.statusCode() == 404)
            return "No Data Found";
        else if (response.statusCode() / 100 != 2)
            throw new ResponseException(response.statusCode());
        CurrencyResponseBuilder currencyResponseBuilder = new CurrencyResponseBuilder(response);
        return currencyResponseBuilder.getDateOfPublication();
    }
}
