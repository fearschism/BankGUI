import java.awt.EventQueue;
import Client.*;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JRootPane;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import Client.*;
import javax.swing.JPanel;

public class AddClient extends DataHolder {
	int ID;
	int Bal;
	String x;
	int count = 1;
	public   JFrame frmAddClient;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */
	public AddClient(){
		initialize();
		//ReadFile();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		bnk.ReadF(f);
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
		btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {;//credits to: Harry Joy/stackoverflow
				boolean okB = true;
				boolean okN = true;
				boolean okID = true;
				x = textField.getText();
				try {
					Bal = Integer.parseInt(textField_1.getText());
				} catch (NumberFormatException w) {
					okB = false;
					lblNewLabel_3.setForeground(Color.red);
					lblNewLabel_3.setText("Must be a number");
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
				}
				if(okID) {
					lblNewLabel_4.setForeground(Color.green);
					lblNewLabel_4.setText("OK");
				}
				if(x.equals("")) {
					okN = false;
					lblNewLabel_1.setText("Name is required");
					lblNewLabel_1.setForeground(Color.red);
				}
				else {
					okN = true;
					lblNewLabel_1.setText("OK");
					lblNewLabel_1.setForeground(Color.green);
				}
				
				if(okB && okID && okN) {
					 cl = new Client(x,Bal,ID);
					// System.out.println(bnk.C.get(0).getID());
					 System.out.println(bnk.searchList(ID));
					 if( (bnk.searchList(ID) == -1)||(bnk.searchList(ID) == -2)) {
						 bnk.AddC(cl);
						 panel.setBackground(new Color(105, 230, 9));
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						 lblNewLabel_5.setText("Added " + count++);
						 bnk.WriteF(f);
						System.out.println(bnk.searchList(ID));
					 }
					 else if((bnk.searchList(ID) >= 0)) {
						 lblNewLabel_5.setText("ID Already entered");
						 panel.setBackground(Color.red);
						 System.out.println(bnk.searchList(ID));
					 }
					 else {
						 lblNewLabel_5.setText("Not Added");
						 bnk.WriteF(f);
						 panel.setBackground(Color.red);
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
		btnNewButton_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
		lblNewLabel_5.setBounds(152, 175, 135, 26);
		frmAddClient.getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Created by: SaadAlageel");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_6.setBounds(298, 187, 136, 14);
		frmAddClient.getContentPane().add(lblNewLabel_6);
		frmAddClient.setBounds(100, 100, 450, 300);
		frmAddClient.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
}
