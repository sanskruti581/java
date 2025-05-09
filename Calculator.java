import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Calculator {
    public static void main(String[] args) {
        // Create JFrame
        JFrame f = new JFrame("Calculator");
        f.setSize(400, 400);
        f.setLayout(null);
        f.getContentPane().setBackground(new Color(240, 240, 240));  // Light gray background
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create TextFields for inputs
        JTextField t1 = new JTextField();
        t1.setBounds(50, 50, 300, 40);
        t1.setFont(new Font("Arial", Font.PLAIN, 20));
        t1.setBackground(new Color(255, 255, 255));  // White background
        t1.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        JTextField t2 = new JTextField();
        t2.setBounds(50, 100, 300, 40);
        t2.setFont(new Font("Arial", Font.PLAIN, 20));
        t2.setBackground(new Color(255, 255, 255));  // White background
        t2.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        // Create Result Label
        JLabel result = new JLabel("Result: ");
        result.setBounds(50, 220, 300, 30);
        result.setFont(new Font("Arial", Font.BOLD, 18));
        result.setForeground(Color.BLUE);

        // Create Buttons for operations
        JButton addBtn = new JButton("+");
        addBtn.setBounds(50, 150, 60, 40);
        addBtn.setBackground(new Color(0, 123, 255));  // Blue background
        addBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        addBtn.setForeground(Color.WHITE);
        addBtn.setFocusPainted(false);

        JButton subBtn = new JButton("-");
        subBtn.setBounds(120, 150, 60, 40);
        subBtn.setBackground(new Color(0, 123, 255));  // Blue background
        subBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        subBtn.setForeground(Color.WHITE);
        subBtn.setFocusPainted(false);

        JButton mulBtn = new JButton("*");
        mulBtn.setBounds(190, 150, 60, 40);
        mulBtn.setBackground(new Color(0, 123, 255));  // Blue background
        mulBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        mulBtn.setForeground(Color.WHITE);
        mulBtn.setFocusPainted(false);

        JButton divBtn = new JButton("/");
        divBtn.setBounds(260, 150, 60, 40);
        divBtn.setBackground(new Color(0, 123, 255));  // Blue background
        divBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        divBtn.setForeground(Color.WHITE);
        divBtn.setFocusPainted(false);

        // Action Listeners for each button
        addBtn.addActionListener(e -> {
            try {
                double num1 = Double.parseDouble(t1.getText());
                double num2 = Double.parseDouble(t2.getText());
                double sum = num1 + num2;
                result.setText("Result: " + sum);
            } catch (Exception ex) {
                result.setText("Enter valid numbers!");
            }
        });

        subBtn.addActionListener(e -> {
            try {
                double num1 = Double.parseDouble(t1.getText());
                double num2 = Double.parseDouble(t2.getText());
                double difference = num1 - num2;
                result.setText("Result: " + difference);
            } catch (Exception ex) {
                result.setText("Enter valid numbers!");
            }
        });

        mulBtn.addActionListener(e -> {
            try {
                double num1 = Double.parseDouble(t1.getText());
                double num2 = Double.parseDouble(t2.getText());
                double product = num1 * num2;
                result.setText("Result: " + product);
            } catch (Exception ex) {
                result.setText("Enter valid numbers!");
            }
        });

        divBtn.addActionListener(e -> {
            try {
                double num1 = Double.parseDouble(t1.getText());
                double num2 = Double.parseDouble(t2.getText());
                if (num2 != 0) {
                    double quotient = num1 / num2;
                    result.setText("Result: " + quotient);
                } else {
                    result.setText("Cannot divide by zero!");
                }
            } catch (Exception ex) {
                result.setText("Enter valid numbers!");
            }
        });

        // Add components to frame
        f.add(t1);
        f.add(t2);
        f.add(result);
        f.add(addBtn);
        f.add(subBtn);
        f.add(mulBtn);
        f.add(divBtn);

        // Make frame visible
        f.setVisible(true);
    }
}
