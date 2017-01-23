package calc;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;

public class Calculator {
	
	private JFrame frmCalculator;
	private JTextField textField;

	double firstNum;
	double secondNum;
	double result;
	String operation;
	String answer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frmCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() {
		initialize();
	}

	/**
	 * Contents of the frame (initialize).
	 */
	private void initialize() {

		// Frame & Layout =======================
		frmCalculator = new JFrame();
		frmCalculator.setAutoRequestFocus(false);

		frmCalculator.setTitle("Calculator");
		frmCalculator.getContentPane().setBackground(new Color(173, 216, 230));
		frmCalculator.setBounds(100, 100, 472, 385);
		frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frmCalculator.setMinimumSize(new Dimension(440, 385));
		frmCalculator.setMaximumSize(new Dimension(600, 600));
		frmCalculator.setPreferredSize(new Dimension(600, 600));
		frmCalculator.setSize(431, 385);

		frmCalculator.setLocationRelativeTo(null);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 81, 82, 80, 20, 50, 24, 43, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 23, 49, 49, 49, 49, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		frmCalculator.getContentPane().setLayout(gridBagLayout);

		// Label & TextField ============================
		JLabel label = new JLabel("Calculator");
		label.setBackground(new Color(51, 255, 153));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.gridwidth = 7;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		frmCalculator.getContentPane().add(label, gbc_label);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridwidth = 4;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 1;
		frmCalculator.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);

		// Erase Button ==============================
		JButton btnErase = new JButton("<<");
		btnErase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String erase = null;

				if (textField.getText().length() > 0) {
					StringBuilder str = new StringBuilder(textField.getText());
					str.deleteCharAt(textField.getText().length() - 1);
					erase = str.toString();
					textField.setText(erase);
				}

			}
		});

		btnErase.setForeground(Color.BLACK);
		btnErase.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnErase.setBackground(new Color(255, 165, 0));
		GridBagConstraints gbc_btnErase = new GridBagConstraints();
		gbc_btnErase.fill = GridBagConstraints.BOTH;
		gbc_btnErase.insets = new Insets(0, 0, 5, 5);
		gbc_btnErase.gridwidth = 2;
		gbc_btnErase.gridx = 4;
		gbc_btnErase.gridy = 1;
		frmCalculator.getContentPane().add(btnErase, gbc_btnErase);

		// Percentage Button ===========================
		JButton btnPro = new JButton("%");
		btnPro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String answer;
				secondNum = Double.parseDouble(textField.getText());

				if (operation == "+") {
					result = (firstNum + secondNum) / secondNum * 100;
					answer = String.format(Locale.US, "%.2f", result);
					textField.setText(answer);
					label.setText(
							"Percentage of the sum of " + firstNum + " and " + secondNum + " against " + secondNum);
				}

				else if (operation == "-") {
					result = (firstNum - secondNum) / secondNum * 100;
					answer = String.format(Locale.US, "%.2f", result);
					textField.setText(answer);
					label.setText(firstNum + " is an increase of what % from " + secondNum + "?");
				}

				else if (operation == "*") {
					result = (firstNum * secondNum) / 100;
					answer = String.format(Locale.US, "%.2f", result);
					textField.setText(answer);
					label.setText(secondNum + "% of " + firstNum);
				}

				else if (operation == "/") {
					result = (firstNum / secondNum) * 100;
					answer = String.format(Locale.US, "%.2f", result);
					textField.setText(answer);
					label.setText("Percentage of " + firstNum + " against " + secondNum);
				}

			}
		});

		btnPro.setForeground(Color.BLACK);
		btnPro.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPro.setBackground(new Color(255, 165, 0));
		GridBagConstraints gbc_btnPro = new GridBagConstraints();
		gbc_btnPro.fill = GridBagConstraints.BOTH;
		gbc_btnPro.insets = new Insets(0, 0, 5, 0);
		gbc_btnPro.gridwidth = 2;
		gbc_btnPro.gridx = 5;
		gbc_btnPro.gridy = 3;
		frmCalculator.getContentPane().add(btnPro, gbc_btnPro);

		// '9' Button ==========================
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String enterNumber = textField.getText() + btn9.getText();
				textField.setText(enterNumber);

			}
		});

		btn9.setForeground(Color.BLACK);
		btn9.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn9.setBackground(SystemColor.textHighlight);
		GridBagConstraints gbc_btn9 = new GridBagConstraints();
		gbc_btn9.fill = GridBagConstraints.BOTH;
		gbc_btn9.insets = new Insets(0, 0, 5, 5);
		gbc_btn9.gridx = 2;
		gbc_btn9.gridy = 2;
		frmCalculator.getContentPane().add(btn9, gbc_btn9);

		// '8' Button ==========================
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String enterNumber = textField.getText() + btn8.getText();
				textField.setText(enterNumber);

			}
		});

		btn8.setForeground(Color.BLACK);
		btn8.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn8.setBackground(SystemColor.textHighlight);
		GridBagConstraints gbc_btn8 = new GridBagConstraints();
		gbc_btn8.fill = GridBagConstraints.BOTH;
		gbc_btn8.insets = new Insets(0, 0, 5, 5);
		gbc_btn8.gridx = 1;
		gbc_btn8.gridy = 2;
		frmCalculator.getContentPane().add(btn8, gbc_btn8);

		// '7' Button ==========================
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String enterNumber = textField.getText() + btn7.getText();
				textField.setText(enterNumber);

			}
		});

		btn7.setForeground(Color.BLACK);
		btn7.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn7.setBackground(SystemColor.textHighlight);
		GridBagConstraints gbc_btn7 = new GridBagConstraints();
		gbc_btn7.fill = GridBagConstraints.BOTH;
		gbc_btn7.insets = new Insets(0, 0, 5, 5);
		gbc_btn7.gridx = 0;
		gbc_btn7.gridy = 2;
		frmCalculator.getContentPane().add(btn7, gbc_btn7);

		// '6' Button ==========================
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String enterNumber = textField.getText() + btn6.getText();
				textField.setText(enterNumber);

			}
		});

		btn6.setForeground(Color.BLACK);
		btn6.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn6.setBackground(SystemColor.textHighlight);
		GridBagConstraints gbc_btn6 = new GridBagConstraints();
		gbc_btn6.fill = GridBagConstraints.BOTH;
		gbc_btn6.insets = new Insets(0, 0, 5, 5);
		gbc_btn6.gridx = 2;
		gbc_btn6.gridy = 3;
		frmCalculator.getContentPane().add(btn6, gbc_btn6);

		// '5' Button ==========================
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String enterNumber = textField.getText() + btn5.getText();
				textField.setText(enterNumber);

			}
		});

		btn5.setForeground(Color.BLACK);
		btn5.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn5.setBackground(SystemColor.textHighlight);
		GridBagConstraints gbc_btn5 = new GridBagConstraints();
		gbc_btn5.fill = GridBagConstraints.BOTH;
		gbc_btn5.insets = new Insets(0, 0, 5, 5);
		gbc_btn5.gridx = 1;
		gbc_btn5.gridy = 3;
		frmCalculator.getContentPane().add(btn5, gbc_btn5);

		// '4' Button ==========================
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String enterNumber = textField.getText() + btn4.getText();
				textField.setText(enterNumber);

			}
		});

		btn4.setForeground(Color.BLACK);
		btn4.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn4.setBackground(SystemColor.textHighlight);
		GridBagConstraints gbc_btn4 = new GridBagConstraints();
		gbc_btn4.fill = GridBagConstraints.BOTH;
		gbc_btn4.insets = new Insets(0, 0, 5, 5);
		gbc_btn4.gridx = 0;
		gbc_btn4.gridy = 3;
		frmCalculator.getContentPane().add(btn4, gbc_btn4);

		// '3' Button ==========================
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String enterNumber = textField.getText() + btn3.getText();
				textField.setText(enterNumber);

			}
		});

		btn3.setForeground(Color.BLACK);
		btn3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn3.setBackground(SystemColor.textHighlight);
		GridBagConstraints gbc_btn3 = new GridBagConstraints();
		gbc_btn3.fill = GridBagConstraints.BOTH;
		gbc_btn3.insets = new Insets(0, 0, 5, 5);
		gbc_btn3.gridx = 2;
		gbc_btn3.gridy = 4;
		frmCalculator.getContentPane().add(btn3, gbc_btn3);

		// '2' Button ===========================
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String enterNumber = textField.getText() + btn2.getText();
				textField.setText(enterNumber);

			}
		});

		btn2.setForeground(Color.BLACK);
		btn2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn2.setBackground(SystemColor.textHighlight);
		GridBagConstraints gbc_btn2 = new GridBagConstraints();
		gbc_btn2.fill = GridBagConstraints.BOTH;
		gbc_btn2.insets = new Insets(0, 0, 5, 5);
		gbc_btn2.gridx = 1;
		gbc_btn2.gridy = 4;
		frmCalculator.getContentPane().add(btn2, gbc_btn2);

		// '1' Button ===========================
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String enterNumber = textField.getText() + btn1.getText();
				textField.setText(enterNumber);

			}
		});

		btn1.setForeground(Color.BLACK);
		btn1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn1.setBackground(SystemColor.textHighlight);
		GridBagConstraints gbc_btn1 = new GridBagConstraints();
		gbc_btn1.fill = GridBagConstraints.BOTH;
		gbc_btn1.insets = new Insets(0, 0, 5, 5);
		gbc_btn1.gridx = 0;
		gbc_btn1.gridy = 4;
		frmCalculator.getContentPane().add(btn1, gbc_btn1);

		// '0' Button ===========================
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String enterNumber = textField.getText() + btn0.getText();
				textField.setText(enterNumber);

			}
		});

		btn0.setForeground(Color.BLACK);
		btn0.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn0.setBackground(SystemColor.textHighlight);
		GridBagConstraints gbc_btn0 = new GridBagConstraints();
		gbc_btn0.fill = GridBagConstraints.BOTH;
		gbc_btn0.insets = new Insets(0, 0, 0, 5);
		gbc_btn0.gridx = 0;
		gbc_btn0.gridy = 5;
		frmCalculator.getContentPane().add(btn0, gbc_btn0);

		// Divide Button ============================
		JButton btnDivide = new JButton("/");
		btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				firstNum = Double.parseDouble(textField.getText());
				operation = "/";
				textField.setText("");
				label.setText(firstNum + "/");

			}
		});

		btnDivide.setForeground(Color.BLACK);
		btnDivide.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDivide.setBackground(new Color(255, 165, 0));
		GridBagConstraints gbc_btnDivide = new GridBagConstraints();
		gbc_btnDivide.fill = GridBagConstraints.BOTH;
		gbc_btnDivide.insets = new Insets(0, 0, 5, 5);
		gbc_btnDivide.gridwidth = 2;
		gbc_btnDivide.gridx = 3;
		gbc_btnDivide.gridy = 2;
		frmCalculator.getContentPane().add(btnDivide, gbc_btnDivide);

		// Multiplication Button=====================
		JButton btnMulti = new JButton("*");
		btnMulti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				firstNum = Double.parseDouble(textField.getText());
				operation = "*";
				textField.setText("");
				label.setText(firstNum + "*");

			}
		});

		btnMulti.setForeground(Color.BLACK);
		btnMulti.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnMulti.setBackground(new Color(255, 165, 0));
		GridBagConstraints gbc_btnMulti = new GridBagConstraints();
		gbc_btnMulti.fill = GridBagConstraints.BOTH;
		gbc_btnMulti.insets = new Insets(0, 0, 5, 5);
		gbc_btnMulti.gridwidth = 2;
		gbc_btnMulti.gridx = 3;
		gbc_btnMulti.gridy = 3;
		frmCalculator.getContentPane().add(btnMulti, gbc_btnMulti);

		// Minus Button ===========================
		JButton btnMin = new JButton("-");
		btnMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				firstNum = Double.parseDouble(textField.getText());
				operation = "-";
				textField.setText("");
				label.setText(firstNum + "-");

			}
		});

		btnMin.setForeground(Color.BLACK);
		btnMin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnMin.setBackground(new Color(255, 165, 0));
		GridBagConstraints gbc_btnMin = new GridBagConstraints();
		gbc_btnMin.fill = GridBagConstraints.BOTH;
		gbc_btnMin.insets = new Insets(0, 0, 5, 5);
		gbc_btnMin.gridwidth = 2;
		gbc_btnMin.gridx = 3;
		gbc_btnMin.gridy = 4;
		frmCalculator.getContentPane().add(btnMin, gbc_btnMin);

		// Dot Button ============================
		JButton btnDot = new JButton(".");
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String enterNumber = textField.getText() + btnDot.getText();
				textField.setText(enterNumber);
			}
		});

		btnDot.setForeground(Color.BLACK);
		btnDot.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDot.setBackground(new Color(102, 153, 255));
		GridBagConstraints gbc_btnDot = new GridBagConstraints();
		gbc_btnDot.fill = GridBagConstraints.BOTH;
		gbc_btnDot.insets = new Insets(0, 0, 0, 5);
		gbc_btnDot.gridx = 1;
		gbc_btnDot.gridy = 5;
		frmCalculator.getContentPane().add(btnDot, gbc_btnDot);

		// Plus Button ============================
		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				firstNum = Double.parseDouble(textField.getText());
				operation = "+";
				textField.setText("");
				label.setText(firstNum + "+");
			}
		});

		btnPlus.setForeground(Color.BLACK);
		btnPlus.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPlus.setBackground(new Color(255, 165, 0));
		GridBagConstraints gbc_btnPlus = new GridBagConstraints();
		gbc_btnPlus.fill = GridBagConstraints.BOTH;
		gbc_btnPlus.insets = new Insets(0, 0, 0, 5);
		gbc_btnPlus.gridwidth = 2;
		gbc_btnPlus.gridx = 3;
		gbc_btnPlus.gridy = 5;
		frmCalculator.getContentPane().add(btnPlus, gbc_btnPlus);

		// +/- Button ==================================
		JButton btnPluMin = new JButton("+/-");
		btnPluMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				double oposite = Double.parseDouble(String.valueOf(textField.getText()));
				oposite = oposite * (-1);
				textField.setText(String.valueOf(oposite));
			}
		});

		btnPluMin.setForeground(Color.BLACK);
		btnPluMin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPluMin.setBackground(new Color(102, 153, 255));
		GridBagConstraints gbc_btnPluMin = new GridBagConstraints();
		gbc_btnPluMin.fill = GridBagConstraints.BOTH;
		gbc_btnPluMin.insets = new Insets(0, 0, 0, 5);
		gbc_btnPluMin.gridx = 2;
		gbc_btnPluMin.gridy = 5;
		frmCalculator.getContentPane().add(btnPluMin, gbc_btnPluMin);

		// Sqrt Button =============================
		JButton btnEquals = new JButton("="); // Declared before ActionListener
												// so it can be disabled

		JButton btnSqrt = new JButton("sqrt");
		btnSqrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				firstNum = Double.parseDouble(textField.getText());
				operation = "sqrt";

				if (firstNum > 0) {

					result = Math.sqrt(firstNum);
					answer = String.format(Locale.US, "%.2f", result);
					textField.setText(answer);
					label.setText("sqrt of " + firstNum + " = " + answer);

				} else if (firstNum < 0) {
					textField.setText("Error");
					label.setText(firstNum + " Negative Number!");
					btn0.setEnabled(false);
					btn1.setEnabled(false);
					btn2.setEnabled(false);
					btn3.setEnabled(false);
					btn4.setEnabled(false);
					btn5.setEnabled(false);
					btn6.setEnabled(false);
					btn7.setEnabled(false);
					btn8.setEnabled(false);
					btn9.setEnabled(false);
					btnMin.setEnabled(false);
					btnDivide.setEnabled(false);
					btnMulti.setEnabled(false);
					btnEquals.setEnabled(false);
					btnPlus.setEnabled(false);
					btnDot.setEnabled(false);
					btnPluMin.setEnabled(false);
					btnSqrt.setEnabled(false);
					btnPro.setEnabled(false);
					btnErase.setEnabled(false);
					textField.setEnabled(false);
				}
			}
		});

		btnSqrt.setForeground(Color.BLACK);
		btnSqrt.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSqrt.setBackground(new Color(255, 165, 0));
		GridBagConstraints gbc_btnSqrt = new GridBagConstraints();
		gbc_btnSqrt.fill = GridBagConstraints.BOTH;
		gbc_btnSqrt.insets = new Insets(0, 0, 5, 0);
		gbc_btnSqrt.gridwidth = 2;
		gbc_btnSqrt.gridx = 5;
		gbc_btnSqrt.gridy = 2;
		frmCalculator.getContentPane().add(btnSqrt, gbc_btnSqrt);

		// Equals Button ==========================================
		btnEquals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String answer;
				secondNum = Double.parseDouble(textField.getText());

				if (operation == "+") {
					result = firstNum + secondNum;
					answer = String.format(Locale.US, "%.2f", result);
					textField.setText(answer);
					label.setText(firstNum + "+" + secondNum + "=");
				}

				else if (operation == "-") {
					result = firstNum - secondNum;
					answer = String.format(Locale.US, "%.2f", result);
					textField.setText(answer);
					label.setText(firstNum + "-" + secondNum + "=");
				}

				else if (operation == "*") {
					result = firstNum * secondNum;
					answer = String.format(Locale.US, "%.2f", result);
					textField.setText(answer);
					label.setText(firstNum + "*" + secondNum + "=");
				}

				else if (operation == "/") {

					if (secondNum == 0) {
						textField.setText("Error");
						label.setText(firstNum + "/" + secondNum + " = Don't divide by 0!");
						btn0.setEnabled(false);
						btn1.setEnabled(false);
						btn2.setEnabled(false);
						btn3.setEnabled(false);
						btn4.setEnabled(false);
						btn5.setEnabled(false);
						btn6.setEnabled(false);
						btn7.setEnabled(false);
						btn8.setEnabled(false);
						btn9.setEnabled(false);
						btnMin.setEnabled(false);
						btnDivide.setEnabled(false);
						btnMulti.setEnabled(false);
						btnEquals.setEnabled(false);
						btnPlus.setEnabled(false);
						btnDot.setEnabled(false);
						btnPluMin.setEnabled(false);
						btnSqrt.setEnabled(false);
						btnPro.setEnabled(false);
						btnErase.setEnabled(false);
						textField.setEnabled(false);

					} else {

						result = firstNum / secondNum;
						answer = String.format(Locale.US, "%.2f", result);
						textField.setText(answer);
						label.setText(firstNum + "/" + secondNum + "=");
					}
				}
			}
		});

		btnEquals.setForeground(Color.BLACK);
		btnEquals.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEquals.setBackground(new Color(255, 165, 0));
		GridBagConstraints gbc_btnEquals = new GridBagConstraints();
		gbc_btnEquals.fill = GridBagConstraints.BOTH;
		gbc_btnEquals.gridheight = 2;
		gbc_btnEquals.gridwidth = 2;
		gbc_btnEquals.gridx = 5;
		gbc_btnEquals.gridy = 4;
		frmCalculator.getContentPane().add(btnEquals, gbc_btnEquals);

		// Clear Button =========================
		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textField.setText(null);
				label.setText("Calculator");
				btn0.setEnabled(true);
				btn1.setEnabled(true);
				btn2.setEnabled(true);
				btn3.setEnabled(true);
				btn4.setEnabled(true);
				btn5.setEnabled(true);
				btn6.setEnabled(true);
				btn7.setEnabled(true);
				btn8.setEnabled(true);
				btn9.setEnabled(true);
				btnMin.setEnabled(true);
				btnDivide.setEnabled(true);
				btnMulti.setEnabled(true);
				btnEquals.setEnabled(true);
				btnPlus.setEnabled(true);
				btnDot.setEnabled(true);
				btnPluMin.setEnabled(true);
				btnSqrt.setEnabled(true);
				btnPro.setEnabled(true);
				btnErase.setEnabled(true);
				textField.setEnabled(true);

			}
		});

		btnC.setBackground(new Color(255, 165, 0));
		btnC.setForeground(SystemColor.desktop);
		btnC.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_btnC = new GridBagConstraints();
		gbc_btnC.fill = GridBagConstraints.BOTH;
		gbc_btnC.insets = new Insets(0, 0, 5, 0);
		gbc_btnC.gridx = 6;
		gbc_btnC.gridy = 1;
		frmCalculator.getContentPane().add(btnC, gbc_btnC);
	}
}
