import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DisplayC extends DataHolder{

	private JFrame frmDisplayClients;
	int count = 0;
	int start = 1;
	JButton backward;
	JLabel lblNewLabel_3;
	JTextPane textPane_1;
	JTextPane textPane_1_1;
	JTextPane textPane;
	JButton editname;
	JButton editid;
	JButton editbal;
	JButton forward;
	int bal;
	int id;
	boolean okname;
	boolean okbal;
	boolean okID;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public DisplayC() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		bnk.ReadF(f);
		frmDisplayClients = new JFrame();
		frmDisplayClients.setTitle("Display Clients");
		frmDisplayClients.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmDisplayClients.setBackground(Color.LIGHT_GRAY);
		frmDisplayClients.setVisible(true);
		frmDisplayClients.setBounds(100, 100, 450, 300);
		frmDisplayClients.setResizable(false);
		frmDisplayClients.setIconImage(new ImageIcon(this.getClass().getResource("/usd-crypto-cryptocurrency-cryptocurrencies-cash-money-bank-payment_95103.png")).getImage());
		frmDisplayClients.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDisplayClients.getContentPane().setLayout(null);
		
		textPane = new JTextPane();
		textPane_1 = new JTextPane();
		textPane_1_1 = new JTextPane();
		editname = new JButton("Edit");
		editid = new JButton("Edit");
		editbal = new JButton("Edit");
		forward = new JButton(">");
		backward = new JButton("<");
		forward.setCursor(new Cursor(Cursor.HAND_CURSOR));
		backward.setCursor(new Cursor(Cursor.HAND_CURSOR));
		editbal.setCursor(new Cursor(Cursor.HAND_CURSOR));
		editname.setCursor(new Cursor(Cursor.HAND_CURSOR));
		editid.setCursor(new Cursor(Cursor.HAND_CURSOR));
		if(bnk.C.size() ==0) {
			textPane.setText("Empty");
			textPane_1.setText("Empty");
			textPane_1_1.setText("Empty");
			forward.setEnabled(false);
			forward.setBackground(Color.GRAY);
			backward.setEnabled(false);
			editbal.setEnabled(false);
			editid.setEnabled(false);
			editname.setEnabled(false);
		}
		if(bnk.C.size() == 1) {
			forward.setEnabled(false);
			forward.setBackground(Color.GRAY);
		}
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(71, 51, 46, 14);
		frmDisplayClients.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Balance:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(71, 89, 59, 14);
		frmDisplayClients.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(85, 127, 32, 14);
		frmDisplayClients.getContentPane().add(lblNewLabel_2);
		
		textPane.setEditable(false);
		textPane.setBounds(140, 51, 228, 27);
		if(bnk.C.size() == 0) {
			textPane.setText("empty");
		}
		else
		textPane.setText(bnk.C.get(0).getCname());
		frmDisplayClients.getContentPane().add(textPane);
		
		textPane_1.setEditable(false);
		textPane_1.setBounds(140, 89, 228, 27);
		if(bnk.C.size() == 0) {
			textPane_1.setText("empty");
		}
		else
		textPane_1.setText(bnk.C.get(0).getCBalance()+"");
		frmDisplayClients.getContentPane().add(textPane_1);
		
		textPane_1_1.setEditable(false);
		textPane_1_1.setBounds(140, 127, 228, 27);
		if(bnk.C.size() == 0) {
			textPane_1_1.setText("empty");
		}
		else
		textPane_1_1.setText(bnk.C.get(0).getID()+"");
		frmDisplayClients.getContentPane().add(textPane_1_1);
		
		editname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				okname = true;
				String name = JOptionPane.showInputDialog("Enter new name: ");
				if(name.equals("")) {
					okname = false;
					JOptionPane.showMessageDialog(null,"Must enter name","Error",JOptionPane.ERROR_MESSAGE);
				}
				else if(okname) {
				bnk.C.get(count).setCname(name);
				textPane.setText(bnk.C.get(count).getCname());
				bnk.WriteF(f);
				}
			}
		});
		editname.setFont(new Font("Tahoma", Font.PLAIN, 10));
		editname.setBackground(Color.WHITE);
		editname.setBounds(378, 51, 54, 27);
		editname.setFocusable(false);
		frmDisplayClients.getContentPane().add(editname);
		
		editbal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				okbal = true;
				try {
					bal =Integer.parseInt(JOptionPane.showInputDialog("Enter new balance: "));
				} catch (NumberFormatException w) {
					okbal = false;
					JOptionPane.showMessageDialog(null,"must be a number","Error",JOptionPane.ERROR_MESSAGE);
				}
				
				if(bal < 0) {
					okbal = false;
					JOptionPane.showMessageDialog(null,"cannot be negative","Error",JOptionPane.ERROR_MESSAGE);
				}
				else if(okbal) {
					bnk.C.get(count).setCBalance(bal);
					textPane_1.setText(bnk.C.get(count).getCBalance()+"");
					bnk.WriteF(f);
				}	
			}
		});
		editbal.setFont(new Font("Tahoma", Font.PLAIN, 10));
		editbal.setBackground(Color.WHITE);
		editbal.setBounds(378, 89, 54, 27);
		editbal.setFocusable(false);
		frmDisplayClients.getContentPane().add(editbal);
		
		editid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				okID = true;
				try {
					id =Integer.parseInt(JOptionPane.showInputDialog("Enter new ID: "));
				} catch (NumberFormatException w) {
					okID = false;
					JOptionPane.showMessageDialog(null,"must be a number","Error",JOptionPane.ERROR_MESSAGE);
				}
				
				if(id < 0) {
					okID = false;
					JOptionPane.showMessageDialog(null,"cannot be negative","Error",JOptionPane.ERROR_MESSAGE);
				}
				else if(bnk.searchList(id)>=0 && id != bnk.C.get(count).getID()) {
					JOptionPane.showMessageDialog(null,"ID already exists","Error",JOptionPane.ERROR_MESSAGE);
					okID = false;
				}
				else if(id == bnk.C.get(count).getID()) {
					JOptionPane.showMessageDialog(null,"Same ID","Error",JOptionPane.ERROR_MESSAGE);
					okID = false;
				}
				else if(okID) {
					bnk.C.get(count).setID(id);
					textPane_1_1.setText(bnk.C.get(count).getID()+"");
					bnk.WriteF(f);
				}
			}
		});
		editid.setFont(new Font("Tahoma", Font.PLAIN, 10));
		editid.setBackground(Color.WHITE);
		editid.setBounds(378, 127, 54, 27);
		editid.setFocusable(false);
		frmDisplayClients.getContentPane().add(editid);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDisplayClients.dispose();
				new DashBoard();
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(34, 197, 89, 52);
		frmDisplayClients.getContentPane().add(btnNewButton_1);
		

		forward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				textPane.setText(bnk.C.get(count).getCname());
				textPane_1.setText(bnk.C.get(count).getCBalance()+"");
				textPane_1_1.setText(bnk.C.get(count).getID()+"");
				backward.setEnabled(true);
				backward.setBackground(Color.white);
				lblNewLabel_3.setText("Client " + (count+1));
				if(count == bnk.C.indexOf(bnk.C.getLast())) {
					forward.setEnabled(false);
					forward.setBackground(Color.gray);
				}
			}
		});
		forward.setBackground(Color.WHITE);
		forward.setBounds(322, 165, 46, 23);
		forward.setFocusable(false);
		frmDisplayClients.getContentPane().add(forward);
		

		backward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count--;
				textPane.setText(bnk.C.get(count).getCname());
				textPane_1.setText(bnk.C.get(count).getCBalance()+"");
				textPane_1_1.setText(bnk.C.get(count).getID()+"");
				lblNewLabel_3.setText("Client " + (count+1));
				forward.setEnabled(true);
				forward.setBackground(Color.white);
				if(count == bnk.C.indexOf(bnk.C.getFirst())) {
					backward.setEnabled(false);
					backward.setBackground(Color.GRAY);
				}
			}
		});
		backward.setEnabled(false);
		backward.setBackground(Color.GRAY);
		backward.setBounds(266, 165, 46, 23);
		backward.setFocusable(false);
		frmDisplayClients.getContentPane().add(backward);
		
		lblNewLabel_3 = new JLabel("Client 1");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(212, 11, 89, 29);
		frmDisplayClients.getContentPane().add(lblNewLabel_3);
	}
}
