package slots;

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

import other.Tooltip;

/**
 * @author Tony
 * @version 1.0
 */
public class SlotsWindowGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = -8849249081274390947L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextArea textArea_1;
	private JButton btnStart;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	private JCheckBox KeepWatchdogOnTop;
	
	public static String name;
	public static String pw;
	public static int tokens;
	public static String bet;
	public static String browser;
	private static boolean onTop;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SlotsWindowGUI() {
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);
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
		lblLogin.setBounds(20, 86, 46, 14);
		contentPane.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(20, 111, 61, 14);
		contentPane.add(lblPassword);
		
		JLabel lblTokensLeft = new JLabel("Tokens left:");
		lblTokensLeft.setToolTipText(Tooltip.tokens);
		lblTokensLeft.setBounds(20, 136, 90, 14);
		contentPane.add(lblTokensLeft);
		
		textField = new JTextField();
		textField.setBounds(120, 83, 223, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(120, 108, 223, 20);
		contentPane.add(passwordField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(120, 133, 223, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textArea_1 = new JTextArea("*Please note that this won't be able to "
				+ "\nsolve the captcha (afterall that what it \nis there for) and that you should have solved"
				+ "\nit by hand in the last few minutes.");
		textArea_1.setEditable(false);
		textArea_1.setBackground(getBackground());
		textArea_1.setBounds(10, 265, 364, 85);
		contentPane.add(textArea_1);
		
		btnStart = new JButton("Start!");
		btnStart.setBounds(148, 231, 89, 23);
		btnStart.addActionListener(this);
		contentPane.add(btnStart);
		
		JLabel lblMoneyToBet = new JLabel("Money to bet:");
		lblMoneyToBet.setBounds(20, 161, 90, 14);
		contentPane.add(lblMoneyToBet);
		
		
		String[] options = {"10","100","1K","10K","100K","1M","10M"};
		comboBox = new JComboBox(options);
		comboBox.setBounds(120, 158, 223, 20);
		contentPane.add(comboBox);
		
		KeepWatchdogOnTop = new JCheckBox("Keep Watchdog always on top");
		KeepWatchdogOnTop.setToolTipText(Tooltip.keepWdOnTop);
		KeepWatchdogOnTop.setBounds(20, 195, 223, 23);
		contentPane.add(KeepWatchdogOnTop);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		name = textField.getText();
		pw = passwordField.getText();
		browser = SelectGameGUI.getBrowser();
		bet = (String)comboBox.getSelectedItem();
		onTop = KeepWatchdogOnTop.isSelected();
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
		
		if (tokens != 0) {
			if (!name.equals("")) {
				if (!pw.equals("")) {
					// System.out.println("test:" +name +"|" +pw +"|" +tokens);
					this.dispose();
					Thread t = new Thread() {
						@Override
						public void run() {
							SlotsBotFunctions.startBot(browser, SlotsWindowGUI.name,SlotsWindowGUI.pw, tokens, SlotsWindowGUI.bet);
						}
					};
					t.start();
				} else {
					JOptionPane.showMessageDialog(null,"Please enter something in the \"Password\" field!");
				}
			} else {
				JOptionPane.showMessageDialog(null,
						"Please enter something in the \"Login\" field!");
			}
		}
	}	
	
	public static boolean getOnTop() {
		return onTop;
	}
}
