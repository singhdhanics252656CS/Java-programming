/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {

    JTextField display;
    double num1, num2, result;
    char operator;

    JButton[] numberButtons = new JButton[10];
    JButton addButton, subButton, mulButton, divButton;
    JButton equalButton, clearButton, decimalButton;

    Color lightPink = new Color(255, 220, 230);
    Color pink = new Color(255, 182, 193);
    Color darkPink = new Color(255, 105, 150);

    public Calculator() {

        setTitle("Cotteque Calculator");
        setSize(350, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        getContentPane().setBackground(lightPink);

        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 30));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setBackground(Color.WHITE);
        display.setForeground(Color.DARK_GRAY);

        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 5, 5));
        panel.setBackground(lightPink);

        for (int i = 0; i <= 9; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));

            numberButtons[i].setFont(
                    new Font("Arial", Font.BOLD, 20)
            );

            numberButtons[i].setBackground(Color.WHITE);
            numberButtons[i].setForeground(Color.DARK_GRAY);
            numberButtons[i].setFocusPainted(false);

            numberButtons[i].addActionListener(this);
        }

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        equalButton = new JButton("=");
        clearButton = new JButton("C");
        decimalButton = new JButton(".");

        JButton[] operationButtons = {
            addButton, subButton, mulButton, divButton,
            equalButton, clearButton, decimalButton
        };

        for (JButton button : operationButtons) {

            button.setFont(
                    new Font("Arial", Font.BOLD, 20)
            );

            button.setBackground(pink);
            button.setForeground(Color.DARK_GRAY);
            button.setFocusPainted(false);

            button.addActionListener(this);
        }

        equalButton.setBackground(darkPink);
        equalButton.setForeground(Color.WHITE);

        panel.add(clearButton);
        panel.add(divButton);
        panel.add(mulButton);
        panel.add(subButton);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(addButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(equalButton);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(decimalButton);

        panel.add(numberButtons[0]);
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));

        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i <= 9; i++) {

            if (e.getSource() == numberButtons[i]) {

                display.setText(
                        display.getText() + i
                );

                return;
            }
        }

        if (e.getSource() == decimalButton) {

            if (!display.getText().contains(".")) {
                display.setText(
                        display.getText() + "."
                );
            }
        }

        if (e.getSource() == clearButton) {

            display.setText("");

            num1 = 0;
            num2 = 0;
            result = 0;

            return;
        }

        if (e.getSource() == addButton ||
            e.getSource() == subButton ||
            e.getSource() == mulButton ||
            e.getSource() == divButton) {

            if (!display.getText().isEmpty()) {

                num1 = Double.parseDouble(
                        display.getText()
                );

                if (e.getSource() == addButton)
                    operator = '+';

                else if (e.getSource() == subButton)
                    operator = '-';

                else if (e.getSource() == mulButton)
                    operator = '*';

                else if (e.getSource() == divButton)
                    operator = '/';

                display.setText("");
            }
        }

        if (e.getSource() == equalButton) {

            if (!display.getText().isEmpty()) {

                num2 = Double.parseDouble(
                        display.getText()
                );

                switch (operator) {

                    case '+':
                        result = num1 + num2;
                        break;

                    case '-':
                        result = num1 - num2;
                        break;

                    case '*':
                        result = num1 * num2;
                        break;

                    case '/':

                        if (num2 == 0) {

                            JOptionPane.showMessageDialog(
                                    this,
                                    "Cannot divide by zero"
                            );

                            return;
                        }

                        result = num1 / num2;
                        break;
                }

                display.setText(
                        String.valueOf(result)
                );
            }
        }
    }

    public static void main(String[] args) {

        new Calculator();
    }
}