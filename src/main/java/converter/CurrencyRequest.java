package converter;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyRequest {

    private final CurrencySymbol currencySymbol;
    private final HttpClient httpClient;

    public CurrencyRequest(CurrencySymbol currencySymbol){
        this.currencySymbol = currencySymbol;
        this.httpClient = HttpClient.newBuilder().build();
    }

    public HttpResponse<String> sendRequest(){
        try {
            String currency = this.currencySymbol.toString();
            return this.httpClient.send(HttpRequest.newBuilder()
                    .uri(URI.create("http://api.nbp.pl/api/exchangerates/rates/a/" + currency))
                    .GET()
                    .build(), HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getResultCode(HttpResponse<String> response){
        return response.statusCode();
    }

    public String getResultMessage(HttpResponse<String> response){
        return response.body();
    }
}