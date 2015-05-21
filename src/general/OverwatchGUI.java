package general;

import high_low.HighLowBotFunctions;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JProgressBar;

import slots.SlotsBotFunctions;
import keno.KenoBotFunctions;
import keno.KenoWindowGUI;

/**
 * @author Tony
 * @version 1.0
 */
public class OverwatchGUI extends JFrame implements ActionListener {

	static JLabel lblTokensLeft;
	static JLabel lblTokensUsed;

	/**
	 * 
	 */
	private static final long serialVersionUID = -2943557883627117665L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					OverwatchGUI frame = new OverwatchGUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public OverwatchGUI() {
		
		if(KenoWindowGUI.getOnTop()==true) {
			setAlwaysOnTop(true);
		}

		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 190);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextArea txtrTheBotWill = new JTextArea();
		txtrTheBotWill.setBackground(getBackground());
		txtrTheBotWill.setEditable(false);
		txtrTheBotWill
				.setText("The bot will now waste your money\nIf you want it to end before it has\nfinished press \"Stop\" (duh)");
		txtrTheBotWill.setBounds(10, 11, 284, 64);
		contentPane.add(txtrTheBotWill);

		lblTokensLeft = new JLabel("Tokens left: " + KenoBotFunctions.getToken_left());
		lblTokensLeft.setBounds(155, 86, 98, 14);
		contentPane.add(lblTokensLeft);

		lblTokensUsed = new JLabel("Tokens used: 0");
		lblTokensUsed.setBounds(59, 86, 98, 14);
		contentPane.add(lblTokensUsed);

		JButton btnStop = new JButton("Stop!");
		btnStop.setBounds(105, 111, 89, 23);
		btnStop.addActionListener(this);
		contentPane.add(btnStop);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String game = SelectGameGUI.getGame();
		this.dispose();
		
		switch (game) {
		case "Slots":
			SlotsBotFunctions.killDriver();
			JOptionPane.showMessageDialog(null, "Successfully stopped the Bot.\nTokens used: " +SlotsBotFunctions.getToken_used() +"\nTokens left: " +SlotsBotFunctions.getToken_left());
			break;
		case "Keno":
			KenoBotFunctions.killDriver();
			JOptionPane.showMessageDialog(null, "Successfully stopped the Bot.\nTokens used: " +KenoBotFunctions.getToken_used() +"\nTokens left: " +KenoBotFunctions.getToken_left());
			break;
		case "High/Low":
			HighLowBotFunctions.killDriver();
			JOptionPane.showMessageDialog(null, "Successfully stopped the Bot.\nTokens used: " +HighLowBotFunctions.getToken_used() +"\nTokens left: " +HighLowBotFunctions.getToken_left());
			break;
		default:
			SlotsBotFunctions.killDriver();
			KenoBotFunctions.killDriver();
			HighLowBotFunctions.killDriver();
			JOptionPane.showMessageDialog(null, "Successfully stopped the Bot.");
			break;
		}
		
		System.exit(NORMAL);
	}

	public void updateCount(int used, int left) {
		lblTokensUsed.setText("Tokens left: " + left);
		lblTokensLeft.setText("Tokens used: " + used);
	}
}
