package converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class CurrencyRequestTest {

    @Test
    @DisplayName("Request should require Euro currency")
    void test1() {
        //given
        CurrencyRequest currencyRequest = new CurrencyRequest();

        //when
        String requestUri = currencyRequest.sendRequest(CurrencySymbol.EUR).uri().toString();
        String requestSymbol = requestUri.substring(requestUri.lastIndexOf('/') + 1);

        //then
        assertEquals(CurrencySymbol.EUR.toString(), requestSymbol);
    }

    @Test
    @DisplayName("Request should require British Pound currency")
    void test2() {
        //given
        CurrencyRequest currencyRequest = new CurrencyRequest();

        //when
        String requestUri = currencyRequest.sendRequest(CurrencySymbol.GBP).uri().toString();
        String requestSymbol = requestUri.substring(requestUri.lastIndexOf('/') + 1);

        //then
        assertEquals(CurrencySymbol.GBP.toString(), requestSymbol);
    }

    @Test
    @DisplayName("Request should require U.S. Dollar currency")
    void test3() {
        //given
        CurrencyRequest currencyRequest = new CurrencyRequest();

        //when
        String requestUri = currencyRequest.sendRequest(CurrencySymbol.USD).uri().toString();
        String requestSymbol = requestUri.substring(requestUri.lastIndexOf('/') + 1);

        //then
        assertEquals(CurrencySymbol.USD.toString(), requestSymbol);
    }

    @Test
    @DisplayName("Request should require Swiss Franc currency")
    void test4() {
        //given
        CurrencyRequest currencyRequest = new CurrencyRequest();

        //when
        String requestUri = currencyRequest.sendRequest(CurrencySymbol.CHF).uri().toString();
        String requestSymbol = requestUri.substring(requestUri.lastIndexOf('/') + 1);

        //then
        assertEquals(CurrencySymbol.CHF.toString(), requestSymbol);
    }

    @Test
    @DisplayName("Request should require Japanese Yen currency")
    void test5() {
        //given
        CurrencyRequest currencyRequest = new CurrencyRequest();

        //when
        String requestUri = currencyRequest.sendRequest(CurrencySymbol.JPY).uri().toString();
        String requestSymbol = requestUri.substring(requestUri.lastIndexOf('/') + 1);

        //then
        assertEquals(CurrencySymbol.JPY.toString(), requestSymbol);
    }

    @Test
    @DisplayName("Request should require Australian Dollar currency")
    void test6() {
        //given
        CurrencyRequest currencyRequest = new CurrencyRequest();

        //when
        String requestUri = currencyRequest.sendRequest(CurrencySymbol.AUD).uri().toString();
        String requestSymbol = requestUri.substring(requestUri.lastIndexOf('/') + 1);

        //then
        assertEquals(CurrencySymbol.AUD.toString(), requestSymbol);
    }

    @Test
    @DisplayName("Request should use NBP api")
    void test7() {
        //given
        CurrencyRequest currencyRequest = new CurrencyRequest();

        //when
        String apiHost = currencyRequest.sendRequest(CurrencySymbol.EUR).uri().getHost();

        //then
        assertEquals("api.nbp.pl", apiHost);
    }

    @Test
    @DisplayName("Response status code should be between 1__ and 5__")
    void test8() {
        //given
        CurrencyRequest currencyRequest = new CurrencyRequest();

        //when
        int httpCode = currencyRequest.sendRequest(CurrencySymbol.EUR).statusCode() / 100;

        //then
        assertTrue(httpCode >= 1 && httpCode <= 5);
    }

    @Test
    @DisplayName("Request method should return null when there is no internet")
    void test9() throws UnknownHostException {
        //given
        CurrencyRequest currencyRequest = new CurrencyRequest();

        //when
        assumingThat("127.0.0.1".equals(InetAddress.getLocalHost().getHostAddress()),
                () -> assertNull(currencyRequest.sendRequest(CurrencySymbol.EUR)));
    }

    @Test
    @DisplayName("Request should throw IllegalArgumentException when CurrencySymbol is null")
    void test10(){
        //given
        CurrencyRequest currencyRequest = new CurrencyRequest();

        //then
        assertThrows(IllegalArgumentException.class, () -> currencyRequest.sendRequest(null));
    }
}