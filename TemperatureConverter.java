import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TemperatureConverter {
    public static void main(String[] args) {
        // Create JFrame
        JFrame f = new JFrame("Temperature Converter");
        f.setSize(400, 300);
        f.setLayout(null);
        f.getContentPane().setBackground(new Color(240, 240, 240));  // Light gray background
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create labels
        JLabel inputLabel = new JLabel("Enter Temperature:");
        inputLabel.setBounds(50, 50, 150, 25);
        inputLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel fromLabel = new JLabel("From Unit:");
        fromLabel.setBounds(50, 100, 120, 25);
        fromLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel toLabel = new JLabel("To Unit:");
        toLabel.setBounds(50, 150, 120, 25);
        toLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel resultLabel = new JLabel("Converted Temperature: ");
        resultLabel.setBounds(50, 200, 300, 25);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        resultLabel.setForeground(Color.BLUE);

        // Create JTextField for input temperature
        JTextField inputField = new JTextField();
        inputField.setBounds(200, 50, 100, 30);
        inputField.setFont(new Font("Arial", Font.PLAIN, 16));

        // Create JComboBox for temperature units (Celsius, Fahrenheit, Kelvin)
        String[] units = {"Celsius", "Fahrenheit", "Kelvin"};
        JComboBox<String> fromUnitBox = new JComboBox<>(units);
        fromUnitBox.setBounds(200, 100, 150, 30);
        fromUnitBox.setFont(new Font("Arial", Font.PLAIN, 16));

        JComboBox<String> toUnitBox = new JComboBox<>(units);
        toUnitBox.setBounds(200, 150, 150, 30);
        toUnitBox.setFont(new Font("Arial", Font.PLAIN, 16));

        // Create Convert Button
        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(150, 180, 100, 40);
        convertButton.setFont(new Font("Arial", Font.BOLD, 16));
        convertButton.setBackground(new Color(0, 123, 255));  // Blue background
        convertButton.setForeground(Color.WHITE);

        // ActionListener for Convert Button
        convertButton.addActionListener(e -> {
            try {
                // Get input temperature
                double inputTemp = Double.parseDouble(inputField.getText());

                // Get selected units
                String fromUnit = (String) fromUnitBox.getSelectedItem();
                String toUnit = (String) toUnitBox.getSelectedItem();

                // Conversion logic
                double convertedTemp = 0.0;

                // Convert temperature based on selected units
                if (fromUnit.equals("Celsius")) {
                    if (toUnit.equals("Fahrenheit")) {
                        convertedTemp = (inputTemp * 9/5) + 32;  // Celsius to Fahrenheit
                    } else if (toUnit.equals("Kelvin")) {
                        convertedTemp = inputTemp + 273.15;  // Celsius to Kelvin
                    } else {
                        convertedTemp = inputTemp;  // Celsius to Celsius
                    }
                } else if (fromUnit.equals("Fahrenheit")) {
                    if (toUnit.equals("Celsius")) {
                        convertedTemp = (inputTemp - 32) * 5/9;  // Fahrenheit to Celsius
                    } else if (toUnit.equals("Kelvin")) {
                        convertedTemp = (inputTemp - 32) * 5/9 + 273.15;  // Fahrenheit to Kelvin
                    } else {
                        convertedTemp = inputTemp;  // Fahrenheit to Fahrenheit
                    }
                } else if (fromUnit.equals("Kelvin")) {
                    if (toUnit.equals("Celsius")) {
                        convertedTemp = inputTemp - 273.15;  // Kelvin to Celsius
                    } else if (toUnit.equals("Fahrenheit")) {
                        convertedTemp = (inputTemp - 273.15) * 9/5 + 32;  // Kelvin to Fahrenheit
                    } else {
                        convertedTemp = inputTemp;  // Kelvin to Kelvin
                    }
                }

                // Display the result
                resultLabel.setText("Converted Temperature: " + convertedTemp);

            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter a valid temperature.");
            }
        });

        // Add components to frame
        f.add(inputLabel);
        f.add(fromLabel);
        f.add(toLabel);
        f.add(resultLabel);
        f.add(inputField);
        f.add(fromUnitBox);
        f.add(toUnitBox);
        f.add(convertButton);

        // Make frame visible
        f.setVisible(true);
    }
}
