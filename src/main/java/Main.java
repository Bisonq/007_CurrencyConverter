import converter.Converter;
import converter.CurrencySymbol;

public class Main {
    public static void main(String[] args) {
        Converter converter = Converter.getInstance();
        System.out.println("Currency (country): " + converter.getCurrencyCountry(CurrencySymbol.JPY));
        System.out.println("Date of rate publication: " + converter.getDateOfRatePublication(CurrencySymbol.JPY));
        System.out.println("Rate: " + converter.getActualRate(CurrencySymbol.JPY));
        System.out.println(converter.getTheResultInPLN(100, CurrencySymbol.JPY));
        System.out.println(converter.getTheResultInGivenCurrencySymbol(100, CurrencySymbol.JPY));
    }
}
