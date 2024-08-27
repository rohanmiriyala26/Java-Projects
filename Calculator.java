import java.awt.*;
import java.awt.event.*;
class Calculator extends Frame implements ActionListener 
{
    private TextField inputField;
    private Button[] numberButtons;
    private Button[] operationButtons;
    private Button equalsButton, clearButton;
    private String operator = "";
    private double num1 = 0, num2 = 0, result = 0;

    public Calculator() 
    {
        setTitle("Calculator");
        setSize(300, 400);
        setLayout(new BorderLayout());
        setVisible(true);
        inputField = new TextField();
        add(inputField, BorderLayout.NORTH);
        numberButtons = new Button[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new Button(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }
        operationButtons = new Button[4];
        String[] operations = {"+", "-", "*", "/"};
        for (int i = 0; i < 4; i++) {
            operationButtons[i] = new Button(operations[i]);
            operationButtons[i].addActionListener(this);
        }
        equalsButton = new Button("=");
        equalsButton.addActionListener(this);
        clearButton = new Button("C");
        clearButton.addActionListener(this);
        Panel buttonPanel = new Panel();
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));
        buttonPanel.add(numberButtons[1]);
        buttonPanel.add(numberButtons[2]);
        buttonPanel.add(numberButtons[3]);
        buttonPanel.add(operationButtons[0]);
        buttonPanel.add(numberButtons[4]);
        buttonPanel.add(numberButtons[5]);
        buttonPanel.add(numberButtons[6]);
        buttonPanel.add(operationButtons[1]);
        buttonPanel.add(numberButtons[7]);
        buttonPanel.add(numberButtons[8]);
        buttonPanel.add(numberButtons[9]);
        buttonPanel.add(operationButtons[2]);
        buttonPanel.add(clearButton);
        buttonPanel.add(numberButtons[0]);
        buttonPanel.add(equalsButton);
        buttonPanel.add(operationButtons[3]);
        add(buttonPanel, BorderLayout.CENTER);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
            inputField.setText(inputField.getText() + command);
        } else if (command.charAt(0) == 'C') {
            inputField.setText("");
            num1 = num2 = result = 0;
            operator = "";
        } else if (command.charAt(0) == '=') {
            num2 = Double.parseDouble(inputField.getText());
            switch (operator) {
                case "+": result = num1 + num2; break;
                case "-": result = num1 - num2; break;
                case "*": result = num1 * num2; break;
                case "/": result = num1 / num2; break;
            }
            inputField.setText(String.valueOf(result));
            operator = "";
        } else {
            if (!operator.isEmpty()) {
                num1 = Double.parseDouble(inputField.getText());
                inputField.setText("");
            }
            operator = command;
        }
    }
    public static void main(String[] args) {
        new Calculator();
    }
}
