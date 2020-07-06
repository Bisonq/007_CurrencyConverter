package converter;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

class CurrencyRequest {

    private final HttpClient httpClient;

    protected CurrencyRequest() {
        this.httpClient = HttpClient.newBuilder().build();
    }

    protected HttpResponse<String> sendRequest(CurrencySymbol currencySymbol) {
        try {
            String currency = currencySymbol.toString();
            return this.httpClient.send(HttpRequest.newBuilder()
                    .uri(URI.create("http://api.nbp.pl/api/exchangerates/rates/a/" + currency))
                    .GET()
                    .build(), HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}