package calculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorWindow {

	JFrame frame;
	JPanel panel;
	JLabel calculatorLabel, numberOneLabel, numberTwoLabel, operationLabel, resultLabel;
	JTextField numberOneTextField, numberTwoTextField, resultTextField;
	JComboBox comboBox;
	JButton calculateButton;
	Operation operation = new Operation();

	public CalculatorWindow() {

	}

	public void calculator() {

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(350, 450);
		frame.setResizable(false);
		frame.setLayout(null);

		panel = new JPanel();
		panel.setSize(450, 550);
		panel.setBackground(Color.gray);
		panel.setLayout(null);

		calculatorLabel = new JLabel(); // Calculator label
		calculatorLabel.setText("Calculator");
		calculatorLabel.setBounds(95, 0, 150, 150);
		calculatorLabel.setFont(new Font("Calibri", Font.BOLD, 30));// sets the font and the size of the label text
		calculatorLabel.setForeground(Color.orange); // sets the color of the label text

		numberOneLabel = new JLabel(); // First number label
		numberOneLabel.setText("First number");
		numberOneLabel.setForeground(Color.black);
		numberOneLabel.setBounds(20, 50, 100, 150);

		numberTwoLabel = new JLabel();// Second number label
		numberTwoLabel.setText("Second number");
		numberTwoLabel.setBounds(20, 100, 100, 150);
		numberTwoLabel.setForeground(Color.black);

		numberOneTextField = new JTextField();// first number TextField
		numberOneTextField.setBounds(130, 120, 80, 25);

		numberTwoTextField = new JTextField();// second number TextField
		numberTwoTextField.setBounds(130, 170, 80, 25);

		operationLabel = new JLabel();// Operation label
		operationLabel.setText("Operation");
		operationLabel.setForeground(Color.black);
		operationLabel.setBounds(20, 150, 100, 150);

		String[] operations = { "Addition", "Substraction", "Multiply", "Divide" };
		comboBox = new JComboBox(operations);
		comboBox.setBounds(130, 220, 100, 35);

		resultLabel = new JLabel(); // Result label
		resultLabel.setText("Result");
		resultLabel.setForeground(Color.black);
		resultLabel.setBounds(20, 250, 100, 150);

		resultTextField = new JTextField(); // result TextField
		resultTextField.setBounds(130, 310, 80, 25);

		calculateButton = new JButton("Calculate"); // Calculate Button
		calculateButton.setBounds(130, 370, 100, 35);
		calculateButton.setFocusable(false);
		calculateButton.setBackground(Color.orange);// sets the colour of the button
		calculateButton.setForeground(Color.black);// sets the colour of the button text

		frame.add(panel); // add the panel to the frame
		panel.add(calculatorLabel); // add all the components to the panel
		panel.add(numberOneLabel);
		panel.add(numberTwoLabel);
		panel.add(numberOneTextField);
		panel.add(numberTwoTextField);
		panel.add(operationLabel);
		panel.add(comboBox);
		panel.add(resultLabel);
		panel.add(resultTextField);
		panel.add(calculateButton);
		frame.setVisible(true);

		calculateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String number1 = "";
				String number2 = "";
				try {

					number1 = numberOneTextField.getText(); // take the value introduced in the numberOneTextField
					double nr1 = Double.parseDouble(number1);// convert it to double
					operation.setNumber1(nr1);

					number2 = numberTwoTextField.getText();// take the value introduced in the numberTwoTextField
					double nr2 = Double.parseDouble(number2);// convert it to double
					operation.setNumber2(nr2);
					if (e.getSource() == calculateButton) {

						if (comboBox.getSelectedIndex() == 0) { // addition
							double addition = operation.addition(operation.getNumber1(), operation.getNumber2());
							String add = Double.toString(addition);
							resultTextField.setText(add);// in the resultTextField we put the addition of the 2 numbers
						} else if (comboBox.getSelectedIndex() == 1) {// substraction
							double substraction = operation.substraction(operation.getNumber1(),
									operation.getNumber2());
							String subs = Double.toString(substraction);
							resultTextField.setText(subs);
						} else if (comboBox.getSelectedIndex() == 2) {// multiply
							double multiply = operation.multiply(operation.getNumber1(), operation.getNumber2());
							String mult = Double.toString(multiply);
							resultTextField.setText(mult);
						} else if (comboBox.getSelectedIndex() == 3) {// divide

							if (nr2 == 0) {
								JOptionPane.showMessageDialog(null, "Can't divide by zero! Enter another number.",
										"Message", JOptionPane.INFORMATION_MESSAGE);
							} else {
								double divide = operation.divide(operation.getNumber1(), operation.getNumber2());
								String div = Double.toString(divide);
								resultTextField.setText(div);

							}

						}
					}
				} catch (Exception exception) {

					JOptionPane.showMessageDialog(null, "Input a number!", "Message", JOptionPane.INFORMATION_MESSAGE);
				}

			}

		});
	}
}
