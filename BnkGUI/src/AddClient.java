import java.awt.EventQueue;
import Client.*;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JRootPane;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import Client.*;
import javax.swing.JPanel;

public class AddClient extends DataHolder{
	int ID;
	int Bal;
	int count = 1;
	private JFrame frmAddClient;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public AddClient(){
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JPanel panel = new JPanel();
		frmAddClient = new JFrame();
		frmAddClient.setTitle("Add Client");
		frmAddClient.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmAddClient.getContentPane().setLayout(null);
		frmAddClient.setVisible(true);
		frmAddClient.setResizable(false);
		JLabel lblNewLabel = new JLabel("Client's name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(20, 49, 106, 26);
		frmAddClient.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField.setBounds(152, 53, 201, 22);
		frmAddClient.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblClientsBalance = new JLabel("Client's Balance:");
		lblClientsBalance.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClientsBalance.setBounds(20, 86, 112, 26);
		frmAddClient.getContentPane().add(lblClientsBalance);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(152, 90, 201, 22);
		frmAddClient.getContentPane().add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("National ID:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(20, 123, 106, 26);
		frmAddClient.getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(152, 127, 201, 22);
		frmAddClient.getContentPane().add(textField_2);
		
		btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {;//credits to: Harry Joy/stackoverflow
				boolean okB = true;
				boolean okN = true;
				boolean okID = true;
				try {
					Bal = Integer.parseInt(textField_1.getText());
				} catch (NumberFormatException w) {
					okB = false;
					lblNewLabel_3.setForeground(Color.red);
					lblNewLabel_3.setText("Must be a number");
					panel.setBackground(Color.red);
				}
				if(okB) {
				lblNewLabel_3.setForeground(Color.green);
				lblNewLabel_3.setText("OK");
				}
				try {
					ID = Integer.parseInt(textField_2.getText());
				} catch (NumberFormatException w) {
					okID = false;
					lblNewLabel_4.setForeground(Color.red);
					lblNewLabel_4.setText("Must be a number");
					panel.setBackground(Color.red);
				}
				if(okID) {
					lblNewLabel_4.setForeground(Color.green);
					lblNewLabel_4.setText("OK");
				}
				if(textField.getText().equals("")) {
					okN = false;
					lblNewLabel_1.setText("Name is required");
					lblNewLabel_1.setForeground(Color.red);
					panel.setBackground(Color.red);
				}
				else {
					okN = true;
					lblNewLabel_1.setText("OK");
					lblNewLabel_1.setForeground(Color.green);
				}
				
				if(okB && okID && okN) {
					panel.setBackground(new Color(105, 230, 9));
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					 cl = new Client(textField.getText(),Bal,ID);
					 bnk.AddC(cl);
					 if(bnk.AddC(cl)) {
						 lblNewLabel_5.setText("Added " +count++);
					 }
					 else {
						 lblNewLabel_5.setText("Full");
					 }
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(319, 212, 105, 38);
		btnNewButton.setFocusable(false);
		frmAddClient.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frmAddClient.dispose();
			new DashBoard();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBackground(SystemColor.text);
		btnNewButton_1.setBounds(197, 212, 112, 38);
		btnNewButton_1.setFocusable(false);
		frmAddClient.getContentPane().add(btnNewButton_1);
		panel.setBackground(Color.WHITE);
		panel.setBounds(116, 224, 58, 26);
		frmAddClient.getContentPane().add(panel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(152, 74, 135, 14);
		frmAddClient.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(152, 111, 135, 14);
		frmAddClient.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_4.setBounds(152, 148, 135, 14);
		frmAddClient.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(331, 187, 82, 14);
		frmAddClient.getContentPane().add(lblNewLabel_5);
		frmAddClient.setBounds(100, 100, 450, 300);
		frmAddClient.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
}
