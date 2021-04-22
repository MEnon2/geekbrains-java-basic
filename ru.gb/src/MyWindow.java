import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {

    public MyWindow() {
        setTitle("Калькулятор");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 500);

        setLayout(new BorderLayout());

        JTextField field = new JTextField();
        add(field, BorderLayout.NORTH);


        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(4, 0));
        add(bottomPanel, BorderLayout.CENTER);

        JButton[] buttons = new JButton[10];

        for (int i = 0; i < 10; i++) {
            String str = String.valueOf((i + 1) % 10);
            buttons[i] = new JButton(str);
            buttons[i].setBounds(20, 60 + i * 60, 50, 32);
            MyListenerAction buttonAction = new MyListenerAction(str, field);
            buttons[i].addActionListener(buttonAction);
            bottomPanel.add(buttons[i]);
        }

        JPanel bottomPanelAction = new JPanel();
        bottomPanelAction.setLayout(new GridLayout(2, 0));
        add(bottomPanelAction, BorderLayout.SOUTH);

        JButton buttonPlus = new JButton("+");
        buttonPlus.addActionListener(new MyListenerAction("+", field));
        bottomPanelAction.add(buttonPlus);

        JButton buttonMinus = new JButton("-");
        buttonMinus.addActionListener(new MyListenerAction("-", field));
        bottomPanelAction.add(buttonMinus);

        JButton buttonMultiply = new JButton("*");
        buttonMultiply.addActionListener(new MyListenerAction("*", field));
        bottomPanelAction.add(buttonMultiply);

        JButton buttonDivide = new JButton("/");
        buttonDivide.addActionListener(new MyListenerAction("/", field));
        bottomPanelAction.add(buttonDivide);

        JButton buttonResult = new JButton("=");
        buttonResult.addActionListener(new MyListenerAction("result", field));
        bottomPanelAction.add(buttonResult);

        JButton buttonClear = new JButton("C");
        buttonClear.addActionListener(new MyListenerAction("clear", field));
        bottomPanelAction.add(buttonClear);

        JButton buttonSquareRoot = new JButton("√");
        buttonSquareRoot.addActionListener(new MyListenerAction("squareRoot", field));
        bottomPanelAction.add(buttonSquareRoot);

        setVisible(true);
    }

    private class MyListenerAction implements ActionListener {

        private String str;
        private JTextField field = new JTextField();

        public MyListenerAction(String str, JTextField field) {
            this.str = str;
            this.field = field;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (this.str == "clear") {
                this.field.setText("");
            } else if (this.str == "result") {
                int ResultExpression = сalculateResultExpression(this.field.getText());
                this.field.setText(String.valueOf(ResultExpression));
            } else if (this.str == "squareRoot") {
                double ResultExpression = Math.sqrt(Integer.parseInt(this.field.getText().trim()));
                this.field.setText(String.valueOf(ResultExpression));
            } else {
                this.field.setText(this.field.getText() + String.valueOf(this.str));
            }
        }

    }

    public static int сalculateResultExpression(String expression) {
        String text = "";
        String[] splittedValues, splittedValuesPlus, splittedValuesMinus;
        int result = 0;

        expression = "(" + expression + ")";

        if (expression.contains("+")) {
            splittedValues = expression.split("\\+");

            for (int i = 0; i < splittedValues.length - 1; i++) {
                text = text + splittedValues[i] + ")+(";
            }
            expression = text + splittedValues[splittedValues.length - 1];
        }

        text = "";
        if (expression.contains("-")) {
            splittedValues = expression.split("-");

            for (int i = 0; i < splittedValues.length - 1; i++) {
                text = text + splittedValues[i] + ")-(";
            }
            expression = text + splittedValues[splittedValues.length - 1];
        }

        int bInd, eInd;
        while (expression.contains("(")) {

            bInd = expression.indexOf("(");
            eInd = expression.indexOf(")");

            text = expression.substring(bInd + 1, eInd);

            if (text.contains("*")) {
                splittedValues = text.split("\\*");
                result = Integer.parseInt(splittedValues[0].trim());
                for (int i = 1; i < splittedValues.length; i++) {
                    result = result * Integer.parseInt(splittedValues[i]);
                }
                text = String.valueOf(result);
            }

            if (text.contains("/")) {
                splittedValues = text.split("/");
                result = Integer.parseInt(splittedValues[0].trim());
                for (int i = 1; i < splittedValues.length; i++) {
                    result = result / Integer.parseInt(splittedValues[i]);
                }
                text = String.valueOf(result);
            }

            expression = expression.substring(0, bInd) + text + expression.substring(eInd + 1, expression.length());
        }

        int sum = 0;
        splittedValuesPlus = expression.split("\\+");
        for (int i = 0; i < splittedValuesPlus.length; i++) {
            if (splittedValuesPlus[i].contains("-")) {
                splittedValuesMinus = splittedValuesPlus[i].split("-");
                result = Integer.parseInt(splittedValuesMinus[0].trim());
                for (int j = 1; j < splittedValuesMinus.length; j++) {
                    result = result - Integer.parseInt(splittedValuesMinus[j].trim());
                }
            } else {
                result = Integer.parseInt(splittedValuesPlus[i].trim());
            }
            sum = sum + result;
        }

        return sum;
    }

    public static void main(String[] args) {

        MyWindow myForm = new MyWindow();

    }
}
