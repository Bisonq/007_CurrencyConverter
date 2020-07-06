package converter;

import converter.response.CurrencyResponseBuilder;

import java.net.http.HttpResponse;

public class Converter {

    private static final Converter converter = new Converter();

    private Converter(){
    }

    public static Converter getInstance(){
        return converter;
    }

    public String getTheResultInPLN(double amount, CurrencySymbol symbol){
        CurrencyRequest request = new CurrencyRequest();
        HttpResponse<String> response = request.sendRequest(symbol);
        CurrencyResponseBuilder currencyResponseBuilder = new CurrencyResponseBuilder(response);
        return amount + " " + symbol.toString() + " = " + currencyResponseBuilder.getRate() * amount + " PLN";
    }

    public String getTheResultInGivenCurrencySymbol(double amount, CurrencySymbol symbol){
        CurrencyRequest request = new CurrencyRequest();
        HttpResponse<String> response = request.sendRequest(symbol);
        CurrencyResponseBuilder currencyResponseBuilder = new CurrencyResponseBuilder(response);
        return amount + " " + "PLN" + " = " + amount / currencyResponseBuilder.getRate() + " " + symbol.toString();
    }

    public double getActualRate(CurrencySymbol symbol){
        CurrencyRequest request = new CurrencyRequest();
        HttpResponse<String> response = request.sendRequest(symbol);
        CurrencyResponseBuilder currencyResponseBuilder = new CurrencyResponseBuilder(response);
        return currencyResponseBuilder.getRate();
    }

    public String getCurrencyCountry(CurrencySymbol symbol){
        CurrencyRequest request = new CurrencyRequest();
        HttpResponse<String> response = request.sendRequest(symbol);
        CurrencyResponseBuilder currencyResponseBuilder = new CurrencyResponseBuilder(response);
        return currencyResponseBuilder.getCurrencyName();
    }

    public String getDateOfRatePublication(CurrencySymbol symbol){
        CurrencyRequest request = new CurrencyRequest();
        HttpResponse<String> response = request.sendRequest(symbol);
        CurrencyResponseBuilder currencyResponseBuilder = new CurrencyResponseBuilder(response);
        return currencyResponseBuilder.getDateOfPublication();
    }
}
