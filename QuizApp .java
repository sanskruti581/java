import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuizApp {

    private static int score = 0; // Variable to store score

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Quiz App");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Question 1
        JLabel question1 = new JLabel("Question 1: What is the capital of France?");
        JRadioButton option1 = new JRadioButton("Berlin");
        JRadioButton option2 = new JRadioButton("Madrid");
        JRadioButton option3 = new JRadioButton("Paris");
        JRadioButton option4 = new JRadioButton("Rome");

        // Group radio buttons for question 1
        ButtonGroup group1 = new ButtonGroup();
        group1.add(option1);
        group1.add(option2);
        group1.add(option3);
        group1.add(option4);

        // Question 2
        JLabel question2 = new JLabel("Question 2: What is 2 + 2?");
        JRadioButton option5 = new JRadioButton("3");
        JRadioButton option6 = new JRadioButton("4");
        JRadioButton option7 = new JRadioButton("5");
        JRadioButton option8 = new JRadioButton("6");

        // Group radio buttons for question 2
        ButtonGroup group2 = new ButtonGroup();
        group2.add(option5);
        group2.add(option6);
        group2.add(option7);
        group2.add(option8);

        // Question 3
        JLabel question3 = new JLabel("Question 3: Who wrote 'Hamlet'?");
        JRadioButton option9 = new JRadioButton("Charles Dickens");
        JRadioButton option10 = new JRadioButton("William Shakespeare");
        JRadioButton option11 = new JRadioButton("George Orwell");
        JRadioButton option12 = new JRadioButton("Jane Austen");

        // Group radio buttons for question 3
        ButtonGroup group3 = new ButtonGroup();
        group3.add(option9);
        group3.add(option10);
        group3.add(option11);
        group3.add(option12);

        // Question 4
        JLabel question4 = new JLabel("Question 4: What is the chemical symbol for water?");
        JRadioButton option13 = new JRadioButton("O2");
        JRadioButton option14 = new JRadioButton("H2O");
        JRadioButton option15 = new JRadioButton("CO2");
        JRadioButton option16 = new JRadioButton("HO2");

        // Group radio buttons for question 4
        ButtonGroup group4 = new ButtonGroup();
        group4.add(option13);
        group4.add(option14);
        group4.add(option15);
        group4.add(option16);

        // Question 5
        JLabel question5 = new JLabel("Question 5: What is the largest planet in our solar system?");
        JRadioButton option17 = new JRadioButton("Earth");
        JRadioButton option18 = new JRadioButton("Jupiter");
        JRadioButton option19 = new JRadioButton("Saturn");
        JRadioButton option20 = new JRadioButton("Mars");

        // Group radio buttons for question 5
        ButtonGroup group5 = new ButtonGroup();
        group5.add(option17);
        group5.add(option18);
        group5.add(option19);
        group5.add(option20);

        // Submit Button
        JButton submitButton = new JButton("Submit");
        JLabel resultLabel = new JLabel("Your score will be shown here.");

        // Action listener for submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                score = 0; // Reset score before checking answers

                // Check answers for question 1
                if (option3.isSelected()) {
                    score++; // Correct answer for question 1
                }

                // Check answers for question 2
                if (option6.isSelected()) {
                    score++; // Correct answer for question 2
                }

                // Check answers for question 3
                if (option10.isSelected()) {
                    score++; // Correct answer for question 3
                }

                // Check answers for question 4
                if (option14.isSelected()) {
                    score++; // Correct answer for question 4
                }

                // Check answers for question 5
                if (option18.isSelected()) {
                    score++; // Correct answer for question 5
                }

                // Display score
                resultLabel.setText("Your score: " + score + " out of 5");
            }
        });

        // Add components to the frame
        frame.add(question1);
        frame.add(option1);
        frame.add(option2);
        frame.add(option3);
        frame.add(option4);
        frame.add(question2);
        frame.add(option5);
        frame.add(option6);
        frame.add(option7);
        frame.add(option8);
        frame.add(question3);
        frame.add(option9);
        frame.add(option10);
        frame.add(option11);
        frame.add(option12);
        frame.add(question4);
        frame.add(option13);
        frame.add(option14);
        frame.add(option15);
        frame.add(option16);
        frame.add(question5);
        frame.add(option17);
        frame.add(option18);
        frame.add(option19);
        frame.add(option20);
        frame.add(submitButton);
        frame.add(resultLabel);

        frame.setVisible(true);
    }
}
