import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import Client.*;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.JTable;
import java.awt.Toolkit;
import java.awt.Button;

public class DashBoard extends DataHolder{
	public JFrame frmBankV;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashBoard window = new DashBoard();
					window.frmBankV.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DashBoard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBankV = new JFrame();
		frmBankV.setTitle("Bank V0.1B");
		frmBankV.setBounds(100, 100, 450, 300);
		frmBankV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBankV.getContentPane().setLayout(null);
		frmBankV.setVisible(true);
		frmBankV.setResizable(false);
		frmBankV.setIconImage(new ImageIcon(this.getClass().getResource("/usd-crypto-cryptocurrency-cryptocurrencies-cash-money-bank-payment_95103.png")).getImage());
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 444, 271);
		frmBankV.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Add Client");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBankV.dispose();
				new AddClient();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(10, 61, 136, 49);
		btnNewButton.setFocusable(false);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Bank System V0.1B");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(146, 11, 177, 27);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Remove Client");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBankV.dispose();
				new Deposit();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(288, 61, 136, 49);
		btnNewButton_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Manage Balance");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBankV.dispose();
				new DepositReal();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(10, 133, 136, 49);
		btnNewButton_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Created by: SaadAlageel");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(288, 246, 136, 14);
		panel.add(lblNewLabel_1);
		
		JButton btnDisplayClient = new JButton("Display Clients");
		btnDisplayClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBankV.dispose();
				new DisplayC();
			}
		});
		btnDisplayClient.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDisplayClient.setFocusable(false);
		btnDisplayClient.setBackground(Color.WHITE);
		btnDisplayClient.setBounds(151, 184, 136, 49);
		btnDisplayClient.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(btnDisplayClient);
		
		JButton btnTransfer = new JButton("Transfers");
		btnTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBankV.dispose();
				new Transfer();
			}
		});
		btnTransfer.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTransfer.setFocusable(false);
		btnTransfer.setBackground(Color.WHITE);
		btnTransfer.setBounds(288, 132, 136, 49);
		btnTransfer.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(btnTransfer);
		
		JButton btnNewButton_3 = new JButton("Empty File");
		btnNewButton_3.setFocusable(false);
		btnNewButton_3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrintWriter writer;
				try {
					writer = new PrintWriter(f);
					writer.print("");
					writer.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"file is now empty","DONE",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setBounds(167, 110, 102, 23);
		panel.add(btnNewButton_3);
	}
}
