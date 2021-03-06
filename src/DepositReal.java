import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class DepositReal extends DataHolder{

	private JFrame frmManageBalance;
	private JTextField textField;
	boolean okA;
	boolean okNE;
	int amount;
	JLabel lblNewLabel_2;
	JPanel panel;
	JLabel lblNewLabel_3;
	ButtonGroup group;
	JRadioButton rdDeposit;
	JRadioButton rdWithdraw;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public DepositReal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		bnk.ReadF(f);
		frmManageBalance = new JFrame();
		frmManageBalance.setTitle("Manage Balance");
		frmManageBalance.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmManageBalance.getContentPane().setLayout(null);
		frmManageBalance.setVisible(true);
		frmManageBalance.setResizable(false);
		frmManageBalance.setIconImage(new ImageIcon(this.getClass().getResource("/usd-crypto-cryptocurrency-cryptocurrencies-cash-money-bank-payment_95103.png")).getImage());
		
		JLabel lblNewLabel_1 = new JLabel("Created by: SaadAlageel");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(288, 236, 136, 14);
		frmManageBalance.getContentPane().add(lblNewLabel_1);
		String[] n = bnk.getCNames();
		JComboBox comboBox = new JComboBox(n);
		comboBox.setMaximumRowCount(10);
		comboBox.enable(true);
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(158, 49, 251, 30);
		comboBox.setFocusable(false);
		if(n.length == 0) {
			comboBox.addItem("empty");
			comboBox.enable(false);
		}
		frmManageBalance.getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Client:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(53, 55, 75, 24);
		frmManageBalance.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setBounds(158, 114, 251, 24);
		frmManageBalance.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAmount.setBounds(53, 114, 95, 24);
		frmManageBalance.getContentPane().add(lblAmount);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				okA = true;
				okNE = true;
				try {
					amount = Integer.parseInt(textField.getText());
				} catch (NumberFormatException w) {
					okA = false;
					lblNewLabel_3.setText("Must be a number");
					lblNewLabel_3.setForeground(Color.red);
				}
				if(amount < 0) {
					okA = false;
					lblNewLabel_3.setText("Cannot be negative");
					lblNewLabel_3.setForeground(Color.red);
				}
				else {
					okA = true;
					lblNewLabel_3.setText("OK");
					lblNewLabel_3.setForeground(Color.green);
				}
				if(bnk.C.size() ==0) {
					okNE = false;
					lblNewLabel_2.setText("No Clients avaliable");
					lblNewLabel_2.setForeground(Color.red);
					panel.setBackground(Color.red);
				}
				else {
					okNE = true;
					lblNewLabel_2.setText("OK");
					lblNewLabel_2.setForeground(Color.green);
				}
				if(bnk.C.get(comboBox.getSelectedIndex()).getCBalance() < amount && rdWithdraw.isSelected()) {
					okNE = false;
					lblNewLabel_2.setText("insufficient funds");
					lblNewLabel_2.setForeground(Color.red);
					panel.setBackground(Color.red);
				}
				else {
					okNE = true;
					lblNewLabel_2.setText("OK");
					lblNewLabel_2.setForeground(Color.green);
				}
				
				if(okA && okNE && rdDeposit.isSelected()) {
					System.out.print(amount);
					int i =comboBox.getSelectedIndex();
					bnk.C.get(i).setCBalance(bnk.C.get(i).getCBalance() + amount);
					bnk.WriteF(f);
					panel.setBackground(Color.green);
					textField.setText("");
				}
				if(okA && okNE && rdWithdraw.isSelected()) {
					System.out.print(amount);
					int i =comboBox.getSelectedIndex();
					bnk.C.get(i).setCBalance(bnk.C.get(i).getCBalance() - amount);
					bnk.WriteF(f);
					panel.setBackground(Color.green);
					textField.setText("");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setFocusable(false);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(304, 187, 105, 38);
		btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frmManageBalance.getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmManageBalance.dispose();
				new DashBoard();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setFocusable(false);
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(181, 187, 105, 38);
		btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frmManageBalance.getContentPane().add(btnBack);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(168, 89, 153, 14);
		frmManageBalance.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(168, 149, 163, 14);
		frmManageBalance.getContentPane().add(lblNewLabel_3);
		
		 panel = new JPanel();
		panel.setBounds(118, 187, 53, 38);
		frmManageBalance.getContentPane().add(panel);
		
		rdDeposit = new JRadioButton("Deposit");
		rdDeposit.setSelected(true);
		rdDeposit.setBackground(Color.LIGHT_GRAY);
		rdDeposit.setBounds(254, 7, 109, 23);
		rdDeposit.setFocusable(false);
		frmManageBalance.getContentPane().add(rdDeposit);
		
		rdWithdraw = new JRadioButton("Withdraw");
		rdWithdraw.setBackground(Color.LIGHT_GRAY);
		rdWithdraw.setBounds(158, 7, 95, 23);
		rdWithdraw.setFocusable(false);
		group = new ButtonGroup();
		group.add(rdWithdraw);
		group.add(rdDeposit);
		if(bnk.C.size() == 0) {
			textField.setEnabled(false);
			btnNewButton.setEnabled(false);
		}
		frmManageBalance.getContentPane().add(rdWithdraw);
		frmManageBalance.setBounds(100, 100, 450, 300);
		frmManageBalance.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
}
