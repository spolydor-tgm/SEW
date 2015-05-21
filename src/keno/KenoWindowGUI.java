package keno;

import general.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

import org.bouncycastle.crypto.tls.AlwaysValidVerifyer;

/**
 * @author Tony
 * @version 1.0
 */
public class KenoWindowGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = -8849249081274390947L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextArea textArea_1;
	private JButton btnStart;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JCheckBox KeepWatchdogOnTop;
	private JCheckBox GenerateRandomNumbers;
	
	public static String name;
	public static String pw;
	public static int tokens;
	public static String bet;
	public static String browser;
	public static boolean onTop;
	public static boolean everyTurn;
	public static String amount;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public KenoWindowGUI() {
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea("Please enter your Information \nand the number of tokens you have left \nso the process can start gambling.*");
		textArea.setBounds(10, 11, 364, 68);
		textArea.setEditable(false);
		textArea.setBackground(getBackground());
		contentPane.add(textArea);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(20, 85, 46, 14);
		contentPane.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(20, 110, 61, 14);
		contentPane.add(lblPassword);
		
		JLabel lblTokensLeft = new JLabel("Tokens left:");
		lblTokensLeft.setToolTipText(StringOutsource.tokens);
		lblTokensLeft.setBounds(20, 135, 90, 14);
		contentPane.add(lblTokensLeft);
		
		textField = new JTextField();
		textField.setBounds(150, 80, 223, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(150, 105, 223, 20);
		contentPane.add(passwordField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(150, 130, 223, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textArea_1 = new JTextArea("*Please note that this won't be able to "
				+ "\nsolve the captcha (afterall that what it \nis there for) and that you should have solved"
				+ "\nit by hand in the last half hour or so.");
		textArea_1.setEditable(false);
		textArea_1.setBackground(getBackground());
		textArea_1.setBounds(10, 345, 364, 85);
		contentPane.add(textArea_1);
		
		btnStart = new JButton("Start!");
		btnStart.setBounds(149, 311, 89, 23);
		btnStart.addActionListener(this);
		contentPane.add(btnStart);
		
		JLabel lblMoneyToBet = new JLabel("Money to bet:");
		lblMoneyToBet.setBounds(20, 160, 90, 14);
		contentPane.add(lblMoneyToBet);
		
		
		String[] options = {"10","100","1K","10K","100K","1M"};
		comboBox = new JComboBox(options);
		comboBox.setBounds(150, 155, 223, 20);
		contentPane.add(comboBox);
		
		KeepWatchdogOnTop = new JCheckBox("Keep Watchdog always on top");
		KeepWatchdogOnTop.setBounds(10, 266, 223, 23);
		KeepWatchdogOnTop.setToolTipText(StringOutsource.keepWdOnTop);
		contentPane.add(KeepWatchdogOnTop);
		
		GenerateRandomNumbers = new JCheckBox("Generate random numbers every turn");
		GenerateRandomNumbers.setBounds(10, 236, 327, 23);
		GenerateRandomNumbers.setToolTipText(StringOutsource.newNbsEveryTurn);
		contentPane.add(GenerateRandomNumbers);
		
		JLabel lblAmountOfNumbers = new JLabel("Amount of numbers");
		lblAmountOfNumbers.setBounds(20, 185, 120, 14);
		lblAmountOfNumbers.setToolTipText(StringOutsource.kenoAmountOfNbs);
		contentPane.add(lblAmountOfNumbers);
		
		String[] amounts = {"10", "9", "8", "7", "6", "5", "4", "3", "2", "1"};
		comboBox_1 = new JComboBox(amounts);
		comboBox_1.setBounds(150, 180, 223, 20);
		contentPane.add(comboBox_1);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		name = textField.getText();
		pw = passwordField.getText();
		browser = SelectGameGUI.getBrowser();
		bet = (String)comboBox.getSelectedItem();
		onTop = KeepWatchdogOnTop.isSelected();
		everyTurn = GenerateRandomNumbers.isSelected();
		amount = (String)comboBox_1.getSelectedItem();
		
		//System.out.println(onTop);
		
		try {
			if (!textField_1.getText().equals("")) {
				tokens = Integer.parseInt(textField_1.getText());
			} else {
				JOptionPane.showMessageDialog(null, "Please enter something in the \"tokens left\" field!");
			}
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Please enter only numbers in the \"tokens left\" field!");
		}
		
		if(!name.equals("")) {
			if(!pw.equals("")) {
				//System.out.println("test:" +name +"|" +pw +"|" +tokens);
				this.dispose();
				Thread t = new Thread() {
					@Override
					public void run() {
						//@debug
						//System.out.println(browser);
						
						keno.KenoBotFunctions.startBot(browser, KenoWindowGUI.name, KenoWindowGUI.pw, tokens, KenoWindowGUI.bet, amount, everyTurn);
					}
				};
				t.start();
				
			} else {
				JOptionPane.showMessageDialog(null, "Please enter something in the \"Password\" field!");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Please enter something in the \"Login\" field!");
		}
	}	
	
	public static boolean getOnTop() {
		return onTop;
	}
}
