package view;

import model.Currency;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SwingMainView extends JFrame implements view.MainView {
    private JComboBox<Currency> fromCurrency;
    private JComboBox<Currency> toCurrency;
    private JTextField amountField;
    private JLabel resultLabel;
    private JButton convertButton;

    public SwingMainView() {
        setTitle("Money Calculator");
        setLayout(new GridLayout(5, 2));

        add(new JLabel("From:"));
        fromCurrency = new JComboBox<>();
        add(fromCurrency);

        add(new JLabel("To:"));
        toCurrency = new JComboBox<>();
        add(toCurrency);

        add(new JLabel("Amount:"));
        amountField = new JTextField();
        add(amountField);

        convertButton = new JButton("Convert");
        add(convertButton);

        resultLabel = new JLabel("Result: ");
        add(resultLabel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }

    @Override
    public void setCurrencies(List<Currency> currencies) {
        for (Currency currency : currencies) {
            fromCurrency.addItem(currency);
            toCurrency.addItem(currency);
        }
    }

    @Override
    public Currency getSelectedFromCurrency() {
        return (Currency) fromCurrency.getSelectedItem();
    }

    @Override
    public Currency getSelectedToCurrency() {
        return (Currency) toCurrency.getSelectedItem();
    }

    @Override
    public double getAmount() {
        return Double.parseDouble(amountField.getText());
    }

    @Override
    public void setConversionResult(String result) {
        resultLabel.setText(result);
    }

    @Override
    public void onConvertButtonClick(Runnable action) {
        convertButton.addActionListener(e -> action.run());
    }
}