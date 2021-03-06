package billing_system;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;


public class UserRegistration implements ActionListener {

   // private static final long serialVersionUID = 1L;
    private JFrame UR;
    private JTextField name_txt;
    private JTextField username_txt;
    private JPasswordField password_txt;
    private JTextField email_txt;
    private JTextField address_txt;
    private JTextField contact_txt;
    private JButton btnRegister;
    
    
////////////////////////////////////////// LAUNCHING THE APPLICATION ////////////////////////////////
    public static void main(String [] args) {
    EventQueue.invokeLater(new Runnable() {
    public void run() {
    try {
    	UserRegistration frame = new UserRegistration();
    frame.setVisible(true);
    } catch (Exception e) {
    e.printStackTrace();
    }
   }
 });
}
///////////////////////////////////////////////////////////////////////////////////////////////////////
	
    
    
///////////////////////////////////////// CREATING THE MAIN FRAME /////////////////////////////////////
    public UserRegistration() {
        UR= new JFrame("User Registration");
        UR.setBackground(new Color(255, 255, 255));
        UR.setBounds(450, 190,500,400);
        UR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UR.getContentPane().setLayout(null);
////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        
        
////////////////////////////////////////// LABELS //////////////////////////////////////////////////////
        
        // REGISTER TITLE
        JLabel lblNewUserRegister = new JLabel("New User Register");
        lblNewUserRegister.setForeground(Color.BLACK);
        lblNewUserRegister.setBackground(new Color(205, 92, 92));
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.BOLD, 22));
        lblNewUserRegister.setBounds(26,57,208, 50);
        UR.getContentPane().add(lblNewUserRegister);
        
        // NAME LABEL
        JLabel lblName = new JLabel("Name");
        lblName.setForeground(new Color(0, 0, 0));
        lblName.setFont(new Font("Times New Roman", Font.BOLD, 18));  
        lblName.setBounds(42,117,90,30);
        UR.getContentPane().add(lblName);

        // USERNAME LABEL
        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblusername.setBounds(42,157, 90,30);
        UR.getContentPane().add(lblusername);
        
        // PASSWORD LABEL
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblpassword.setBounds(42,197,90,30);
        UR.getContentPane().add(lblpassword);
        
        // EMAIL ADDRESS LABEL
        JLabel lblemail = new JLabel("Email ID");
        lblemail.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblemail.setBounds(42, 237, 74, 30);
        UR.getContentPane().add(lblemail);
        
        // CONTACT NUMBER LABEL
        JLabel lblcontact = new JLabel("Contact No");
        lblcontact.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblcontact.setBounds(42,277,100, 30);
        UR.getContentPane().add(lblcontact);
        
        // ADDRESS LABEL
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lbladdress.setBounds(42,316,74, 42);
        UR.getContentPane().add(lbladdress);
///////////////////////////////////////////////////////////////////////////////////////////////////
        
        
        
//////////////////////////////////////// TEXT FIELD ///////////////////////////////////////////////        
        
        //NAME
        name_txt = new JTextField();
        name_txt.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        name_txt.setBounds(187,123,100,20);
        UR.getContentPane().add(name_txt);
        name_txt.setColumns(10);

        // USER NAME
        username_txt = new JTextField();
        username_txt.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        username_txt.setBounds(187,163,100,20);
        UR.getContentPane().add(username_txt);
        username_txt.setColumns(10);

        // PASSWORD
        password_txt = new JPasswordField();
        password_txt.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        password_txt.setBounds(187,203, 100,20);
        UR.getContentPane().add(password_txt);
        password_txt.setColumns(10);

        // EMAIL
        email_txt = new JTextField();
        email_txt.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        email_txt.setBounds(187,243,100,20);
        UR.getContentPane().add(email_txt);
        email_txt.setColumns(10);
        
        // CONTACT
        contact_txt = new JTextField();
        contact_txt.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        contact_txt.setBounds(187,283, 100,20);
        UR.getContentPane().add(contact_txt);
       
        // ADDRESS
        address_txt = new JTextField();
        address_txt.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        address_txt.setBounds(187,328, 100,20);
        UR.getContentPane().add(address_txt);
        address_txt.setColumns(10);
////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        
        
////////////////////////////////////////// BUTTONS ////////////////////////////////////////////////////
        
        // REGISTER BUTTON
        btnRegister = new JButton("Register");
        btnRegister.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
            	String name = name_txt.getText();
                String username = username_txt.getText();
                String password = password_txt.getText();
                String email = email_txt.getText();
                String contact = contact_txt.getText();
                int len = contact.length();
                String address = address_txt.getText();

                // message show with username
                String msg = "" + username ;
                msg += " \n";
                
                if (username_txt.getText().equals("") || password_txt.getText().equals("") ) {        	
                	JOptionPane.showMessageDialog(btnRegister, "Please Enter The Full details");
                }

                else if(e.getSource() == btnRegister ) {
                	database_connector dc= new database_connector();
                	String query = "INSERT INTO tbl_buyer values('" + name + "','" + username + "','" + password + "','" +contact + "','" + email + "','" + address+ "')";
                	
                int val = dc.insert(query);
                
                if (val>0) {
                        JOptionPane.showMessageDialog(btnRegister,

                            "Welcome, " + msg + "Your account is sucessfully created");
                            billing_system bs= new billing_system();
                        	bs.BillingScreen();
                        	dispose_UR();

                    }
                    	
                    }
            }

			private void dispose_UR() {
				// TODO Auto-generated method stub
				UR.dispose();
				
			}
        });
       
        btnRegister.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnRegister.setBounds(82,386,120,30);
        UR.getContentPane().add(btnRegister);
        
        // EXIT BUTTON
        JButton btnback = new JButton("EXIT");
        btnback.setIcon(new ImageIcon("C:\\java_folder\\OOP_project\\src\\billing_system\\exit1.png"));
        btnback.setForeground(Color.BLACK);
        btnback.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnback.setBounds(218, 426, 107, 42);
        UR.getContentPane().add(btnback);
        btnback.addActionListener(new ActionListener() {
  		  public void actionPerformed(ActionEvent e) {
  			  System.exit(0);
  		  }
  		});
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        
        
/////////////////////////////////// BACKGROUND IMAGE ///////////////////////////////////////////////////////////////////////
        JLabel lbl = new JLabel("");
        lbl.setIcon(new ImageIcon("C:\\java_folder\\OOP_project\\src\\billing_system\\background1.png"));
        lbl.setBounds(0, -15, 346, 495);
        UR.getContentPane().add(lbl);
        UR.setSize(335,505);   
        UR.setVisible(true);   
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
