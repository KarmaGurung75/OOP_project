package billing_system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;

public class billing_system implements ActionListener{

	private JFrame frame;
	private JTextField txt_name;
	private JTextField txt_contact;
	private JTextField txt_email;
	private JTextField txt_address;
	private JTextField product_id;
	private JTextField Product_name;
	private JTextField Rate;
	private JTextField Quantity;
	private JTextField Description;
	private final JSeparator separator_3 = new JSeparator();
	private JTable table;
	private JTextField Total_txt;
	private JTextField Pamount_txt;
	private JTextField Ramount_txt;
     JButton btnsave;
	private int final_Total =0;
	
//	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					billing_system window = new billing_system();
					window.frame.setVisible(true);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public billing_system() {
		initialize();
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1175, 607);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel billing_icon = new JLabel("icon");
		billing_icon.setBounds(10, 10, 61, 45);
		frame.getContentPane().add(billing_icon);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDate.setBounds(893, 10, 61, 25);
		frame.getContentPane().add(lblDate);
		
		JLabel dateShow = new JLabel("Dateshow");
		dateShow.setFont(new Font("Tahoma", Font.BOLD, 16));
		dateShow.setBounds(980, 10, 118, 25);
		SimpleDateFormat dFormat = new SimpleDateFormat("dd-mm-yyyy");
		Date date = new Date();
		dateShow.setText(dFormat.format(date));
		frame.getContentPane().add(dateShow);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTime.setBounds(893, 45, 61, 25);
		frame.getContentPane().add(lblTime);
		
		JLabel time_show = new JLabel("Time_show");
		time_show.setFont(new Font("Tahoma", Font.BOLD, 16));
		time_show.setBounds(980, 45, 89, 25);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm:ss");
		LocalDateTime now = LocalDateTime.now();
	    time_show.setText(dtf.format(now));
		frame.getContentPane().add(time_show);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(0, 104, 1162, 10);
		frame.getContentPane().add(separator);
		
		JLabel lblByer_detail = new JLabel("Buyer Details:");
		lblByer_detail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblByer_detail.setBounds(10, 108, 132, 35);
		frame.getContentPane().add(lblByer_detail);
		
		JLabel lblName = new JLabel("Name\r\n");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(10, 165, 61, 25);
		frame.getContentPane().add(lblName);
		
		txt_name = new JTextField();
		txt_name.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		txt_name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_name.setBounds(81, 165, 146, 25);
		frame.getContentPane().add(txt_name);
		txt_name.setColumns(10);
		
		JLabel lblContact = new JLabel("Contact No");
		lblContact.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContact.setBounds(266, 167, 124, 21);
		frame.getContentPane().add(lblContact);
		
		txt_contact = new JTextField();
		txt_contact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
			}
		});
		txt_contact.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_contact.setBounds(368, 165, 160, 25);
		frame.getContentPane().add(txt_contact);
		txt_contact.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(593, 167, 89, 21);
		frame.getContentPane().add(lblEmail);
		
		txt_email = new JTextField();
		txt_email.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		txt_email.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_email.setBounds(666, 165, 141, 25);
		frame.getContentPane().add(txt_email);
		txt_email.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddress.setBounds(856, 166, 82, 22);
		frame.getContentPane().add(lblAddress);
		
		txt_address = new JTextField();
		txt_address.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_address.setBounds(960, 165, 170, 25);
		frame.getContentPane().add(txt_address);
		txt_address.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 239, 683, -17);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(-15, 213, 1174, 10);
		frame.getContentPane().add(separator_2);
		
		JLabel LblProduct_Detail = new JLabel("Product Details:");
		LblProduct_Detail.setFont(new Font("Tahoma", Font.BOLD, 16));
		LblProduct_Detail.setBounds(10, 224, 160, 38);
		frame.getContentPane().add(LblProduct_Detail);
		
		JLabel lblProductID = new JLabel("Product ID");
		lblProductID.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProductID.setBounds(10, 272, 101, 21);
		frame.getContentPane().add(lblProductID);
		
		product_id = new JTextField();
		product_id.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
			}
		});
		product_id.setFont(new Font("Tahoma", Font.PLAIN, 14));
		product_id.setBounds(92, 270, 61, 25);
		frame.getContentPane().add(product_id);
		product_id.setColumns(10);
		
		JLabel lblPName = new JLabel("Product Name");
		lblPName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPName.setBounds(177, 274, 124, 17);
		frame.getContentPane().add(lblPName);
		
		Product_name = new JTextField();
		Product_name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Product_name.setBounds(303, 270, 141, 25);
		frame.getContentPane().add(Product_name);
		Product_name.setColumns(10);
		
		JLabel lblRate = new JLabel("Rate");
		lblRate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRate.setBounds(487, 274, 72, 17);
		frame.getContentPane().add(lblRate);
		
		Rate = new JTextField();
		Rate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Rate.setBounds(553, 270, 89, 25);
		frame.getContentPane().add(Rate);
		Rate.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuantity.setBounds(697, 274, 72, 17);
		frame.getContentPane().add(lblQuantity);
		
		Quantity = new JTextField();
		Quantity.setBounds(774, 272, 72, 25);
		frame.getContentPane().add(Quantity);
		Quantity.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDescription.setBounds(856, 274, 87, 17);
		frame.getContentPane().add(lblDescription);
		
		Description = new JTextField();
		Description.setBounds(960, 272, 170, 25);
		frame.getContentPane().add(Description);
		Description.setColumns(10);
		
		////////ADD
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int price = Integer.parseInt(Rate.getText());
				int quantity = Integer.parseInt(Quantity.getText());
				int total = price*quantity;
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				model.addRow(new Object [] {Product_name.getText(),product_id.getText(), Description.getText(),price,quantity,total});
				final_Total = final_Total + total;
				String finalTotal1=String.valueOf(final_Total);
				Total_txt.setText(finalTotal1);
				
				
				
			}
		});
		btnAdd.setIcon(new ImageIcon("C:\\java_folder\\OOP_project\\src\\billing_system\\add.png"));
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdd.setBounds(1012, 304, 118, 41);
		
		separator_3.setBackground(Color.BLACK);
		separator_3.setBounds(0, 351, 1162, 10);
		frame.getContentPane().add(separator_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 362, 533, 201);
		frame.getContentPane().add(scrollPane);
		
		///////// table
		
		JLabel lblCalculation = new JLabel("Calculation Details:");
		lblCalculation.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCalculation.setBounds(553, 361, 167, 25);
		frame.getContentPane().add(lblCalculation);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotal.setBounds(553, 398, 80, 35);
		frame.getContentPane().add(lblTotal);
		
		Total_txt = new JTextField();
		Total_txt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Total_txt.setBounds(682, 403, 302, 30);
		frame.getContentPane().add(Total_txt);
		Total_txt.setColumns(10);
		
		JLabel lblPAmount = new JLabel("Paid Amount");
		lblPAmount.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPAmount.setBounds(553, 447, 96, 35);
		frame.getContentPane().add(lblPAmount);
		
		
		//// paid amount
		
		
		Pamount_txt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Pamount_txt.setBounds(682, 450, 302, 30);
		frame.getContentPane().add(Pamount_txt);
		Pamount_txt.setColumns(10);
		
		JLabel lblRamount = new JLabel("Return Amount");
		lblRamount.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRamount.setBounds(553, 502, 111, 35);
		frame.getContentPane().add(lblRamount);
		
		Ramount_txt = new JTextField();
		Ramount_txt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Ramount_txt.setBounds(682, 505, 302, 30);
		frame.getContentPane().add(Ramount_txt);
		Ramount_txt.setColumns(10);
		
		
		////// btn clear

		
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opt=JOptionPane.showConfirmDialog(null,"Are you sure to Exit?","Exit",JOptionPane.YES_NO_OPTION);
				//YES_NO_CANCEL_OPTION;
				if (opt==0) {
					dispose_frame();
				}
			}

			private void dispose_frame() {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});
		
		
		/// exit
		JButton btnsave = new JButton("Save");
		btnsave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		btnsave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnsave.setIcon(new ImageIcon("C:\\java_folder\\OOP_project\\src\\billing_system\\save.png"));
		btnsave.setBounds(1012, 382, 118, 45);
		frame.add(btnsave);
		
		JLabel lblTitle = new JLabel("Billing System");
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 63));
		lblTitle.setBounds(67, 6, 436, 84);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblBackground = new JLabel("New label");
		lblBackground.setIcon(new ImageIcon("C:\\java_folder\\OOP_project\\src\\billing_system\\bg2.png"));
		lblBackground.setBounds(4, 0, 1158, 611);
		frame.getContentPane().add(lblBackground);
	}

	protected void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			
	}
}
