import java.awt.*;
import javax.swing.*;


public class Calculator {
    //JFrame is main body of calculator GUI
    JFrame frame;
    JTextField textfield;
    //Creates JButton arrays with JButton objects for each of the numbers and operations
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    //JPanel is main panel for the buttons, below the text field
    JPanel panel;
    Font myFont = new Font("Ink Free", Font.BOLD, 30);
    //Calculator events object, which is different from the tutorial. This has lot of the objects in fields
    //in this constructor passed through, which is how it can do the cals in the CalculatorEvents class
    CalculatorEvents events;

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    public Calculator() {
        //Defining the main JFrame
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        //Defining the textfield where the numbers and results will appear
        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);

        //Instantiating functional buttons with defining character
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        negButton = new JButton("(-)");

        //Adding functional buttons to array
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        //Setting sizes for negative, delte, and clear buttons
        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);

        //Instantiating CalculatorEvents object and passes in the mentioned objects, arrays and fields
        events = new CalculatorEvents(numberButtons, functionButtons, textfield, num1, num2,result, operator);

        //Adds an actionListener, sets the Front, and removes a borderline from the buttons
        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(events);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        //Instantiates the number buttons, adds an actionListener, set the front, and removes the border
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(events);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        //Instantiates the JPanel object, sets the bounds and the inserted grid layout format
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        //Adds buttons to JPanel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        //Adds Panel, textField, and rest of functional buttons to JFrame
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);

    }
}
