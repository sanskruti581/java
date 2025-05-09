import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CurrencyConverter {
    public static void main(String[] args) {
        // Create JFrame
        JFrame f = new JFrame("Currency Converter");
        f.setSize(400, 300);
        f.setLayout(null);
        f.getContentPane().setBackground(new Color(240, 240, 240));  // Light gray background
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create labels
        JLabel fromLabel = new JLabel("From Currency:");
        fromLabel.setBounds(50, 50, 120, 25);
        fromLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel toLabel = new JLabel("To Currency:");
        toLabel.setBounds(50, 100, 120, 25);
        toLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(50, 150, 120, 25);
        amountLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel resultLabel = new JLabel("Converted Amount: ");
        resultLabel.setBounds(50, 200, 300, 25);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        resultLabel.setForeground(Color.BLUE);

        // Create TextField for Amount input
        JTextField amountField = new JTextField();
        amountField.setBounds(150, 150, 150, 30);
        amountField.setFont(new Font("Arial", Font.PLAIN, 16));

        // Create JComboBox for currency selection
        String[] currencies = {"USD", "INR", "EUR", "GBP"};
        JComboBox<String> fromCurrencyBox = new JComboBox<>(currencies);
        fromCurrencyBox.setBounds(150, 50, 150, 30);
        fromCurrencyBox.setFont(new Font("Arial", Font.PLAIN, 16));

        JComboBox<String> toCurrencyBox = new JComboBox<>(currencies);
        toCurrencyBox.setBounds(150, 100, 150, 30);
        toCurrencyBox.setFont(new Font("Arial", Font.PLAIN, 16));

        // Create Convert Button
        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(150, 180, 100, 40);
        convertButton.setFont(new Font("Arial", Font.BOLD, 16));
        convertButton.setBackground(new Color(0, 123, 255));  // Blue background
        convertButton.setForeground(Color.WHITE);

        // ActionListener for Convert Button
        convertButton.addActionListener(e -> {
            try {
                // Get input amount
                double amount = Double.parseDouble(amountField.getText());

                // Get selected currencies
                String fromCurrency = (String) fromCurrencyBox.getSelectedItem();
                String toCurrency = (String) toCurrencyBox.getSelectedItem();

                // Conversion logic (dummy rates for example)
                double conversionRate = 1.0;

                // Dummy conversion rates (in reality, you would get this from an API or database)
                if (fromCurrency.equals("USD") && toCurrency.equals("INR")) {
                    conversionRate = 75.0;  // Example: 1 USD = 75 INR
                } else if (fromCurrency.equals("INR") && toCurrency.equals("USD")) {
                    conversionRate = 0.013;  // Example: 1 INR = 0.013 USD
                } else if (fromCurrency.equals("EUR") && toCurrency.equals("INR")) {
                    conversionRate = 85.0;  // Example: 1 EUR = 85 INR
                } else if (fromCurrency.equals("GBP") && toCurrency.equals("INR")) {
                    conversionRate = 95.0;  // Example: 1 GBP = 95 INR
                }

                // Perform the conversion
                double convertedAmount = amount * conversionRate;
                resultLabel.setText("Converted Amount: " + convertedAmount);

            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter a valid number.");
            }
        });

        // Add components to frame
        f.add(fromLabel);
        f.add(toLabel);
        f.add(amountLabel);
        f.add(resultLabel);
        f.add(amountField);
        f.add(fromCurrencyBox);
        f.add(toCurrencyBox);
        f.add(convertButton);

        // Make frame visible
        f.setVisible(true);
    }
}
