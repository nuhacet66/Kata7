import model.Currency;
import presenter.MainPresenter;
import view.SwingMainView;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        SwingMainView view = new SwingMainView();
        MainPresenter presenter = new MainPresenter(view, Arrays.asList(
                new Currency("USD", "US Dollar", "$"),
                new Currency("EUR", "Euro", "€"),
                new Currency("JPY", "Japanese Yen", "¥"),
                new Currency("GBP", "British Pound", "£"),
                new Currency("AUD", "Australian Dollar", "$"),
                new Currency("CAD", "Canadian Dollar", "$"),
                new Currency("CHF", "Swiss Franc", "Fr"),
                new Currency("CNY", "Chinese Yuan", "¥"),
                new Currency("SEK", "Swedish Krona", "kr"),
                new Currency("NZD", "New Zealand Dollar", "$"),
                new Currency("KRW", "South Korean Won", "₩"),
                new Currency("SGD", "Singapore Dollar", "$")

        ));

        view.setVisible(true);
    }
}
