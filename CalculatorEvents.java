import javax.swing.*;
import java.awt.event.*;

public class CalculatorEvents implements ActionListener {
    //Defines objects and fields for the class
    private JButton[] numberButtons;
    private JButton[] functionalButtons;
    private JTextField textfield;
    private double num1;
    private double num2;
    private double result;
    private char operator;


    public CalculatorEvents(JButton[] numberButtons, JButton[] functionalButtons, JTextField textfield, double num1, double num2,double result, char operator) {
        //Sets objects and fields passed when CalculatorEvents object is instantiated
        this.numberButtons = numberButtons;
        this.functionalButtons = functionalButtons;
        this.textfield = textfield;
        this.num1 = num1;
        this.num2 = num2;
        this.result = result;
        this.operator = operator;
    }
    @Override
    //actionPeformed implimentation from ActionListener Interface
    public void actionPerformed(ActionEvent e) {

        //If you click the button, it will add the number to the text field
        for(int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        //Adds a decimal place to a number and in the text field
        if (e.getSource() == functionalButtons[4]) {
            textfield.setText(textfield.getText().concat("."));
        }
        //Sets operator to add and clears the textField
        if (e.getSource() == functionalButtons[0]) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        //Sets operator to subtract and clears the textField
        if (e.getSource() == functionalButtons[1]) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        //Sets operator to multiply and clears the textField
        if (e.getSource() == functionalButtons[2]) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        //Sets operator to divide and clears the textField
        if (e.getSource() == functionalButtons[3]) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }
        //Performs specified operation if you click the equals sign and returns the result
        if (e.getSource() == functionalButtons[5]) {
            num2 = Double.parseDouble(textfield.getText());
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
                    result = num1 / num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1 = result;
        }
        //Clears the textField when you press the clear button
        if (e.getSource() == functionalButtons[7]) {
            textfield.setText("");
        }
        //Clears the last character in the text field. It does this by copying the string, clearing the whole textField,
        //and rebuilding it without the last character
        if (e.getSource() == functionalButtons[6]) {
            String string = textfield.getText();
            textfield.setText("");
            for (int i = 0; i < string.length() -1; i++) {
                textfield.setText(textfield.getText() + string.charAt(i));
            }
        }
        //Changes the positive or negative character to numbers
        if (e.getSource() == functionalButtons[8]) {
            double temp = Double.parseDouble(textfield.getText());
            temp *= -1;
            textfield.setText(String.valueOf(temp));
        }
    }
}
