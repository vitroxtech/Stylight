package squaring.vitrox.stylight.Common;
import java.util.Currency;

public class MoneyHelper {

    public String getshowablePrice(String value, String currency) {
        if (!value.isEmpty() && !currency.isEmpty()) {
            StringBuilder Sb = new StringBuilder();
            Currency mycurrency = Currency.getInstance(currency);
            Sb.append(mycurrency.getSymbol());
            Sb.append(" ");
            Sb.append(value);
            return Sb.toString();
        }
        return null;
    }
}
