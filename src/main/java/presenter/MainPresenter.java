package presenter;

import model.Currency;
import service.ExchangeRateService;
import view.MainView;

import java.util.List;

public class MainPresenter {
    private final MainView view;
    private final List<Currency> currencies;
    private final ExchangeRateService exchangeRateService;

    public MainPresenter(MainView view, List<Currency> currencies) {
        this.view = view;
        this.currencies = currencies;
        this.exchangeRateService = new ExchangeRateService();
        this.view.setCurrencies(currencies);
        this.view.onConvertButtonClick(this::convert);
    }

    private void convert() {
        try {
            Currency from = view.getSelectedFromCurrency();
            Currency to = view.getSelectedToCurrency();
            double amount = view.getAmount();

            double rate = exchangeRateService.getExchangeRate(from, to);
            double result = amount * rate;

            view.setConversionResult(String.format("%.2f %s = %.2f %s",
                    amount, from.getCode(), result, to.getCode()));
        } catch (Exception e) {
            view.setConversionResult("Error: " + e.getMessage());
        }
    }
}
