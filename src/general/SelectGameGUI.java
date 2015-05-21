package general;

import high_low.HLWindowGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;

import keno.KenoWindowGUI;
import slots.SlotsWindowGUI;

public class SelectGameGUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private static String game;
	private static String browser;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectGameGUI frame = new SelectGameGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SelectGameGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 220, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrPleaseChooseThe = new JTextArea();
		txtrPleaseChooseThe.setEditable(false);
		txtrPleaseChooseThe.setBackground(getBackground());
		txtrPleaseChooseThe.setText("Please choose the game,\nthat you want the \nbot to play for you");
		txtrPleaseChooseThe.setBounds(10, 9, 198, 80);
		contentPane.add(txtrPleaseChooseThe);
		
		JButton btnSlots = new JButton("Slots");
		btnSlots.setBounds(55, 100, 89, 23);
		btnSlots.addActionListener(this);
		contentPane.add(btnSlots);
		
		JButton btnKeno = new JButton("Keno");
		btnKeno.setBounds(55, 150, 89, 23);
		btnKeno.addActionListener(this);
		contentPane.add(btnKeno);
		
		JButton btnHighlow = new JButton("High/Low");
		btnHighlow.setBounds(55, 200, 89, 23);
		btnHighlow.addActionListener(this);
		contentPane.add(btnHighlow);
		
		String[] options = {"Firefox","Chrome"};
		comboBox = new JComboBox(options);
		comboBox.setBounds(55, 250, 89, 20);
		contentPane.add(comboBox);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton game = (JButton) e.getSource();
		this.game = game.getText();
		
		browser = comboBox.getSelectedItem().toString();

		if (!browser.equals("")) {
			this.dispose();
			
			//@debug
			//System.out.println(browser);
			
			switch(SelectGameGUI.getGame()) {
			case "Keno":
				KenoWindowGUI kgui = new KenoWindowGUI();	
				startWindowGUI(kgui);
				kgui.setSize(400, 470);
				//JOptionPane.showMessageDialog(null, "Keno is not available at the moment sorry.\n ¯\\_(ツ)_/¯");
				break;
			case "High/Low":
				HLWindowGUI hlgui = new HLWindowGUI();	
				startWindowGUI(hlgui);
				hlgui.setSize(400, 410);
				//JOptionPane.showMessageDialog(null, "High/Low is not available at the moment sorry.\n ¯\\_(ツ)_/¯");
				break;
			default:
				SlotsWindowGUI sgui = new SlotsWindowGUI();
				startWindowGUI(sgui);
				//JOptionPane.showMessageDialog(null, "Slots is not available at the moment sorry.\n ¯\\_(ツ)_/¯");
				break;
			}
		}
	}
	
	private static void startWindowGUI(JFrame gui) {
		gui.setSize(370, 380);
		gui.setResizable(false);
		gui.setVisible(true);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static String getGame() {
		return game;
	}
	
	public static String getBrowser() {
		return browser;
	}
}
