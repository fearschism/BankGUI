import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JRootPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import Client.*;
import javax.swing.JPanel;

public class AddClient {

	private JFrame frmAddClient;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public AddClient() {
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
			public void actionPerformed(ActionEvent e) {
				panel.setBackground(Color.green);
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
		frmAddClient.setBounds(100, 100, 450, 300);
		frmAddClient.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
}
