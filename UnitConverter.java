import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnitConverter {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Unit Converter");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Labels
        JLabel label1 = new JLabel("Enter Value:");
        label1.setBounds(50, 30, 100, 25);
        JLabel label2 = new JLabel("From Unit:");
        label2.setBounds(50, 70, 100, 25);
        JLabel label3 = new JLabel("To Unit:");
        label3.setBounds(50, 110, 100, 25);
        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setBounds(50, 190, 100, 25);

        // Text Field for input value
        JTextField inputField = new JTextField();
        inputField.setBounds(150, 30, 150, 25);

        // Dropdown for From Unit selection
        JComboBox<String> fromUnitComboBox = new JComboBox<>();
        fromUnitComboBox.setBounds(150, 70, 150, 25);
        fromUnitComboBox.addItem("Meters");
        fromUnitComboBox.addItem("Kilometers");
        fromUnitComboBox.addItem("Centimeters");
        fromUnitComboBox.addItem("Inches");
        fromUnitComboBox.addItem("Feet");

        // Dropdown for To Unit selection
        JComboBox<String> toUnitComboBox = new JComboBox<>();
        toUnitComboBox.setBounds(150, 110, 150, 25);
        toUnitComboBox.addItem("Meters");
        toUnitComboBox.addItem("Kilometers");
        toUnitComboBox.addItem("Centimeters");
        toUnitComboBox.addItem("Inches");
        toUnitComboBox.addItem("Feet");

        // Button to perform conversion
        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(150, 150, 100, 30);

        // Result Label to display the conversion result
        JLabel resultValueLabel = new JLabel("");
        resultValueLabel.setBounds(150, 190, 150, 25);

        // Action listener for the convert button
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double value = Double.parseDouble(inputField.getText());
                    String fromUnit = (String) fromUnitComboBox.getSelectedItem();
                    String toUnit = (String) toUnitComboBox.getSelectedItem();
                    double result = convertUnits(value, fromUnit, toUnit);
                    resultValueLabel.setText(String.valueOf(result));
                } catch (NumberFormatException ex) {
                    resultValueLabel.setText("Invalid Input");
                }
            }
        });

        // Adding components to frame
        frame.add(label1);
        frame.add(inputField);
        frame.add(label2);
        frame.add(fromUnitComboBox);
        frame.add(label3);
        frame.add(toUnitComboBox);
        frame.add(convertButton);
        frame.add(resultLabel);
        frame.add(resultValueLabel);

        frame.setVisible(true);
    }

    // Method to convert units
    public static double convertUnits(double value, String fromUnit, String toUnit) {
        double result = 0.0;

        // Convert the value to meters first
        if (fromUnit.equals("Kilometers")) {
            value = value * 1000; // Convert kilometers to meters
        } else if (fromUnit.equals("Centimeters")) {
            value = value / 100; // Convert centimeters to meters
        } else if (fromUnit.equals("Inches")) {
            value = value * 0.0254; // Convert inches to meters
        } else if (fromUnit.equals("Feet")) {
            value = value * 0.3048; // Convert feet to meters
        }

        // Now convert the value to the desired unit
        if (toUnit.equals("Kilometers")) {
            result = value / 1000; // Convert meters to kilometers
        } else if (toUnit.equals("Centimeters")) {
            result = value * 100; // Convert meters to centimeters
        } else if (toUnit.equals("Inches")) {
            result = value / 0.0254; // Convert meters to inches
        } else if (toUnit.equals("Feet")) {
            result = value / 0.3048; // Convert meters to feet
        } else {
            result = value; // No conversion needed (same unit)
        }

        return result;
    }
}
