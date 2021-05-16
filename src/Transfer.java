import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class Transfer extends DataHolder {

	private JFrame frmTransfer;
	private JTextField textField;
	boolean okFrom = true;
	boolean okTo = true;
	boolean okA = true;
	int amount;
	JLabel lblNewLabel_3;
	JLabel Error;
	JPanel panel;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public Transfer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		bnk.ReadF(f);
		frmTransfer = new JFrame();
		frmTransfer.setTitle("Transfer");
		frmTransfer.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmTransfer.getContentPane().setLayout(null);
		frmTransfer.setVisible(true);
		frmTransfer.setResizable(false);
		frmTransfer.setIconImage(new ImageIcon(this.getClass().getResource("/usd-crypto-cryptocurrency-cryptocurrencies-cash-money-bank-payment_95103.png")).getImage());
		String[] arr = bnk.getCNames();
		JComboBox comboBox = new JComboBox(arr);
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(127, 39, 270, 33);
		comboBox.setFocusable(false);
		
		JComboBox comboBox_1 = new JComboBox(arr);
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(127, 83, 270, 33);
		comboBox_1.setFocusable(false);
		if(arr.length == 0) {
			comboBox.addItem("empty");
			comboBox.enable(false);
			comboBox_1.addItem("empty");
			comboBox_1.enable(false);
		}
		frmTransfer.getContentPane().add(comboBox);
		frmTransfer.getContentPane().add(comboBox_1);
		
		textField = new JTextField();
		textField.setBounds(127, 151, 270, 33);
		frmTransfer.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Transfer");
		btnNewButton.setFocusable(false);
		btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					amount = Integer.parseInt(textField.getText());
					if(amount < 0) {
						okA = false;
						lblNewLabel_3.setText("Cannot be negative");
						lblNewLabel_3.setForeground(Color.red);
					}
					else if(amount >= 0) {
						okA = true;
						lblNewLabel_3.setText("OK");
						lblNewLabel_3.setForeground(Color.green);
					}
				} catch (NumberFormatException w) {
					okA = false;
					lblNewLabel_3.setText("Must be a number");
					lblNewLabel_3.setForeground(Color.red);
				}
				if(bnk.C.get(comboBox.getSelectedIndex()).getID() == bnk.C.get(comboBox_1.getSelectedIndex()).getID()) {
					okTo = false;
					Error.setText("Cannot transfer to the same account");
					Error.setForeground(Color.red);
					
				}
				else if(bnk.C.get(comboBox.getSelectedIndex()).getCBalance() < amount) {
					okFrom = false;
					Error.setText("insufficient funds");
					Error.setForeground(Color.red);
					panel.setBackground(Color.red);
				}
				
				else {
					okTo = true;
					okFrom = true;
					Error.setText("OK");
					Error.setForeground(Color.green);
				}
				if(okA == false || okTo == false) {
					panel.setBackground(Color.red);
				}
				if(okA && okFrom && okTo) {
					bnk.C.get(comboBox.getSelectedIndex()).setCBalance(bnk.C.get(comboBox.getSelectedIndex()).getCBalance() - amount);
					bnk.C.get(comboBox_1.getSelectedIndex()).setCBalance(bnk.C.get(comboBox_1.getSelectedIndex()).getCBalance() + amount);
					panel.setBackground(Color.green);
					bnk.WriteF(f);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(333, 211, 79, 39);
		frmTransfer.getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFocusable(false);
		btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTransfer.dispose();
				new DashBoard();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(234, 211, 79, 39);
		frmTransfer.getContentPane().add(btnBack);
		
		JLabel lblNewLabel = new JLabel("From:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(55, 46, 41, 14);
		frmTransfer.getContentPane().add(lblNewLabel);
		
		JLabel lblTo = new JLabel("To:");
		lblTo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTo.setBounds(73, 90, 23, 14);
		frmTransfer.getContentPane().add(lblTo);
		
		JLabel lblNewLabel_1 = new JLabel("Amount:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(55, 158, 62, 14);
		frmTransfer.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Created by: SaadAlageel");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1_1.setBounds(298, 14, 136, 14);
		frmTransfer.getContentPane().add(lblNewLabel_1_1);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_3.setBounds(127, 186, 200, 14);
		frmTransfer.getContentPane().add(lblNewLabel_3);
		
		Error = new JLabel("");
		Error.setFont(new Font("Tahoma", Font.BOLD, 10));
		Error.setBounds(127, 126, 270, 14);
		frmTransfer.getContentPane().add(Error);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(163, 211, 62, 26);
		if(bnk.C.size() == 0) {
			textField.setEnabled(false);
		}
		frmTransfer.getContentPane().add(panel);
		frmTransfer.setBounds(100, 100, 450, 300);
		frmTransfer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
