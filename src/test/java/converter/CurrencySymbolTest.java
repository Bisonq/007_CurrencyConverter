package converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CurrencySymbolTest {

    @Test
    @DisplayName("EUR symbol should have Euro name")
    void test1() {
        //given
        CurrencySymbol currencySymbol = CurrencySymbol.EUR;

        //when
        String currencyName = currencySymbol.getCurrencyName();

        //then
        assertEquals("Euro", currencyName);
    }

    @Test
    @DisplayName("GBP symbol should have British Pound name")
    void test2() {
        //given
        CurrencySymbol currencySymbol = CurrencySymbol.GBP;

        //when
        String currencyName = currencySymbol.getCurrencyName();

        //then
        assertEquals("British Pound", currencyName);
    }

    @Test
    @DisplayName("USD symbol should have U.S. Dollar name")
    void test3() {
        //given
        CurrencySymbol currencySymbol = CurrencySymbol.USD;

        //when
        String currencyName = currencySymbol.getCurrencyName();

        //then
        assertEquals("U.S. Dollar", currencyName);
    }

    @Test
    @DisplayName("CHF symbol should have Swiss Franc name")
    void test4() {
        //given
        CurrencySymbol currencySymbol = CurrencySymbol.CHF;

        //when
        String currencyName = currencySymbol.getCurrencyName();

        //then
        assertEquals("Swiss Franc", currencyName);
    }

    @Test
    @DisplayName("JPY symbol should have Japanese Yen name")
    void test5() {
        //given
        CurrencySymbol currencySymbol = CurrencySymbol.JPY;

        //when
        String currencyName = currencySymbol.getCurrencyName();

        //then
        assertEquals("Japanese Yen", currencyName);
    }

    @Test
    @DisplayName("AUD symbol should have Australian Dollar name")
    void test6() {
        //given
        CurrencySymbol currencySymbol = CurrencySymbol.AUD;

        //when
        String currencyName = currencySymbol.getCurrencyName();

        //then
        assertEquals("Australian Dollar", currencyName);
    }

}