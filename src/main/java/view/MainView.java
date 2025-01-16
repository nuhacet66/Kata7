package view;

import model.Currency;

import java.util.List;

public interface MainView {
    void setCurrencies(List<Currency> currencies);
    void setConversionResult(String result);
    void onConvertButtonClick(Runnable action);
    Currency getSelectedFromCurrency();
    Currency getSelectedToCurrency();
    double getAmount();
}
