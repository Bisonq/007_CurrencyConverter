package converter;

public enum CurrencySymbol {
    EUR("Euro"),
    GBP("British Pound"),
    USD("U.S. Dollar"),
    CHF("Swiss Franc"),
    JPY("Japanese Yen"),
    AUD("Australian Dollar");

    private final String currencyName;

    CurrencySymbol(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencyName() {
        return currencyName;
    }
}
