import converter.CurrencyRequest;
import converter.CurrencySymbol;

import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) {
        CurrencyRequest currencyRequest = new CurrencyRequest(CurrencySymbol.JPY);
        HttpResponse<String> response = currencyRequest.sendRequest();
        System.out.println(currencyRequest.getResultCode(response));
        System.out.println(currencyRequest.getResultMessage(response));

    }
}
