import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Deposit extends DataHolder  {
	int ID;
	private JFrame frmRemoveClient;
	private JTextField textField;
	JLabel lblNewLabel_3 = new JLabel("");
	JPanel panel = new JPanel();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Deposit() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		bnk.ReadF(f);
		frmRemoveClient = new JFrame();
		frmRemoveClient.setTitle("Remove Client");
		frmRemoveClient.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmRemoveClient.setBounds(100, 100, 450, 300);
		frmRemoveClient.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmRemoveClient.getContentPane().setLayout(null);
		frmRemoveClient.setVisible(true);
		frmRemoveClient.setResizable(false);
		frmRemoveClient.setIconImage(new ImageIcon(this.getClass().getResource("/usd-crypto-cryptocurrency-cryptocurrencies-cash-money-bank-payment_95103.png")).getImage());
		
		JLabel lblNewLabel = new JLabel("Remove Client");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(139, 11, 129, 22);
		frmRemoveClient.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField.setBounds(139, 98, 263, 38);
		frmRemoveClient.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("National ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 96, 114, 38);
		frmRemoveClient.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Remove");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean okID = true;
				try {
					ID = Integer.parseInt(textField.getText().trim());
				} catch (NumberFormatException w) {
					okID = false;
					lblNewLabel_3.setText("Must be a number");
					lblNewLabel_3.setForeground(Color.red);
			}
				if(ID < 0) {
					okID = false;
					lblNewLabel_3.setText("cannot be negative");
					lblNewLabel_3.setForeground(Color.red);
				}
				if(okID) {
					lblNewLabel_3.setText("OK");
					lblNewLabel_3.setForeground(Color.green);
					ID = Integer.parseInt(textField.getText().trim());
					try {
						if(bnk.RemoveV2(f, ID) == 1) {
							panel.setBackground(Color.green);
						}
						else if(bnk.RemoveV2(f, ID) == 0) {
							panel.setBackground(Color.orange);
						}
						else if(bnk.RemoveV2(f, ID) == -1) {
							panel.setBackground(Color.red);
						}
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
		}});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(326, 203, 98, 47);
		btnNewButton.setFocusable(false);
		btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frmRemoveClient.getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(Color.WHITE);
		btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRemoveClient.dispose();
				new DashBoard();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(218, 203, 98, 47);
		btnBack.setFocusable(false);
		frmRemoveClient.getContentPane().add(btnBack);
		
		panel.setBounds(139, 203, 69, 47);
		frmRemoveClient.getContentPane().add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("Red: Not Found");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 221, 98, 14);
		frmRemoveClient.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Green: Removed");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1.setBounds(10, 236, 98, 14);
		frmRemoveClient.getContentPane().add(lblNewLabel_2_1);
		lblNewLabel_3.setBounds(139, 147, 158, 14);
		frmRemoveClient.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_2_2 = new JLabel("Orange: List Empty");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_2.setBounds(10, 203, 114, 14);
		frmRemoveClient.getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Created by: SaadAlageel");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1_1.setBounds(288, 172, 136, 14);
		frmRemoveClient.getContentPane().add(lblNewLabel_1_1);
	}
}
