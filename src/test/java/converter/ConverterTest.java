package converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.text.html.HTML;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {

    @Test
    @DisplayName("Converter should be singleton")
    void test1(){
      //given
      Converter converter1 = Converter.getInstance();
      Converter converter2 = Converter.getInstance();

      //when
      assertSame(converter1, converter2);
    }

    @Test
    @DisplayName("Converter should return correct currency name")
    void test2(){
        //given
        Converter converter = Converter.getInstance();
        CurrencySymbol currencySymbol1 = CurrencySymbol.JPY;
        CurrencySymbol currencySymbol2 = CurrencySymbol.AUD;

        //when
        String country1 = converter.getCurrencyName(currencySymbol1);
        String country2 = converter.getCurrencyName(currencySymbol2);

        //then
        assertEquals("jen (Japonia)", country1);
        assertEquals("dolar australijski", country2);
    }

    @Test
    @DisplayName("Converter should return today's date of rate publication")
    void test3(){
        //given
        Converter converter = Converter.getInstance();
        CurrencySymbol currencySymbol = CurrencySymbol.JPY;
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String actualDate = formatter.format(date);

        //when
        String publicationDate = converter.getDateOfRatePublication(currencySymbol);

        //then
        assertEquals(actualDate, publicationDate);
    }

    @Test
    @DisplayName("Converter should return correct currency convert into PLN")
    void test4 (){
        //given
        Converter converter = Converter.getInstance();
        double amount = 100;
        CurrencySymbol currencySymbol = CurrencySymbol.JPY;
        CurrencyRequest request = new CurrencyRequest();
        String response = request.sendRequest(currencySymbol).body();
        String rates = response.substring(response.indexOf("["), response.lastIndexOf("]"));
        String midRate = rates.substring(rates.lastIndexOf(":")+1, rates.lastIndexOf("}"));
        Double actualRate = Double.parseDouble(midRate);
        Double result = actualRate * amount;

        //when
        String methodResult = converter.getTheResultInPLN(amount, currencySymbol);

        //then
        assertEquals(amount + " " + currencySymbol.toString() + " = " + result + " PLN", methodResult);
    }

    @Test
    @DisplayName("Converter should return correct currency convert into given symbol")
    void test5 (){
        //given
        Converter converter = Converter.getInstance();
        double amount = 100;
        CurrencySymbol currencySymbol = CurrencySymbol.JPY;
        CurrencyRequest request = new CurrencyRequest();
        String response = request.sendRequest(currencySymbol).body();
        String rates = response.substring(response.indexOf("["), response.lastIndexOf("]"));
        String midRate = rates.substring(rates.lastIndexOf(":")+1, rates.lastIndexOf("}"));
        Double actualRate = Double.parseDouble(midRate);
        Double result = amount / actualRate;

        //when
        String methodResult = converter.getTheResultInGivenCurrencySymbol(amount, currencySymbol);

        //then
        assertEquals(amount + " PLN = " + result + " " + currencySymbol.toString(), methodResult);
    }

    @Test
    @DisplayName("Converter should return correct actual rate")
    void test6 (){
        //given
        Converter converter = Converter.getInstance();
        CurrencySymbol currencySymbol = CurrencySymbol.JPY;
        CurrencyRequest request = new CurrencyRequest();
        String response = request.sendRequest(currencySymbol).body();
        String rates = response.substring(response.indexOf("["), response.lastIndexOf("]"));
        String midRate = rates.substring(rates.lastIndexOf(":")+1, rates.lastIndexOf("}"));
        Double actualRate = Double.parseDouble(midRate);

        //when
        double methodRateResult = converter.getActualRate(currencySymbol);

        //then
        assertEquals(actualRate, methodRateResult);
    }

    @Test
    @DisplayName("Converter convert methods should return 0 when amount is 0")
    void test7 (){
        //given
        Converter converter = Converter.getInstance();
        double amount = 0;
        CurrencySymbol currencySymbol = CurrencySymbol.JPY;

        //when
        String methodResult = converter.getTheResultInGivenCurrencySymbol(amount, currencySymbol);

        //then
        assertEquals(amount + " PLN = " + 0.0 + " " + currencySymbol.toString(), methodResult);
    }

    @Test
    @DisplayName("Converter methods should return IllegalArgumentException when null is given")
    void test8 (){
        //given
        Converter converter = Converter.getInstance();;

        //then
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> converter.getActualRate(null)),
                () -> assertThrows(IllegalArgumentException.class, () -> converter.getDateOfRatePublication(null)),
                () -> assertThrows(IllegalArgumentException.class, () -> converter.getCurrencyName(null)),
                () -> assertThrows(IllegalArgumentException.class, () -> converter.getTheResultInGivenCurrencySymbol(0, null)),
                () -> assertThrows(IllegalArgumentException.class, () -> converter.getTheResultInPLN(0, null))
        );
    }
}