package billing_system;


//import required classes and packages 

import javax.swing.*; 

import java.awt.*;
import java.lang.Exception;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class userLogin {
	private JFrame loginframe;
	private JTextField username;
	private JPasswordField password_txt;
	
	/**
	 * * Launch the application.
	 * */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
        try {
        	 userLogin window = new userLogin();
            window.loginframe.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
});
}

/**
* Create the application.
*/

public  userLogin() {
initialize();
}
/**
* Initialize the contents of the frame.
*/

private void initialize() {
loginframe = new JFrame();
loginframe.setForeground(Color.BLACK);
loginframe.setFont(new Font("Arial", Font.BOLD, 16));
loginframe.setBackground(new Color(0, 51, 51));
loginframe.setBounds(200, 100,591,402);
loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
loginframe.getContentPane().setLayout(null);

JLabel textlogin = new JLabel("Please Login");
textlogin.setBounds(10, 88, 170, 41);
textlogin.setForeground(new Color(13, 13, 13));
textlogin.setBackground(Color.PINK);
textlogin.setFont(new Font("Times New Roman", Font.BOLD, 20));
loginframe.getContentPane().add(textlogin);


JLabel lblusername = new JLabel("USERNAME");
lblusername.setBounds(10,139, 96, 22);
loginframe.getContentPane().add(lblusername);
lblusername.setBackground(new Color(51, 0, 51));
lblusername.setHorizontalAlignment(SwingConstants.CENTER);
lblusername.setFont(new Font("Times New Roman", Font.BOLD, 16));


JLabel lblpassword = new JLabel("PASSWORD");
lblpassword.setBounds(10, 206, 96, 26);
loginframe.getContentPane().add(lblpassword);
lblpassword.setFont(new Font("Times New Roman", Font.BOLD, 16));
lblpassword.setHorizontalAlignment(SwingConstants.CENTER);

//
username = new JTextField();
username.setBounds(10,176, 131,20);
loginframe.getContentPane().add(username);
username.setColumns(10);

//
password_txt = new JPasswordField();
password_txt.setBounds(10,235, 131, 20);
loginframe.getContentPane().add(password_txt);
password_txt.setColumns(10);

//
JLabel lblregister = new JLabel("New User? Click here to ");
lblregister.setBounds(4,312,200,25);
loginframe.getContentPane().add(lblregister);
lblregister.setFont(new Font("Times New Roman", Font.BOLD, 14));
JButton btnregister = new JButton("Sign Up");
btnregister.setBounds(168,313,80,25);
btnregister.setFont(new Font("Times New Roman", Font.BOLD, 15));
btnregister.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
    	 //dispose();
         userRegister ur = new userRegister();
         ur.setVisible(true);
         dispose_loginn();
    }

	private void dispose_loginn() {
		// TODO Auto-generated method stub
		setVisible(false);
		loginframe.dispose();
		
	}
});

btnregister.setBackground(Color.WHITE);
btnregister.setFont(new Font("Arial", Font.BOLD, 12));
loginframe.getContentPane().add(btnregister);


    JButton btnlogin = new JButton("Login");
    btnlogin.setBounds(10,276,80, 26);
	btnlogin.addActionListener(new ActionListener() {
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) {
         if (username.getText().equals("") && password_txt.getText().equals("") ) {
             JOptionPane.showMessageDialog( btnlogin, "Please Enter Username and Password");
         }
         else if(e.getSource()== btnlogin) {
        	 String userName = username.getText();
             String password = password_txt.getText();
        	 String query = "Select username, password from tbl_buyer where username= '"+ userName+"' and password= '"+password+"' ";
        	 database_connector dc = new database_connector();

             ResultSet rows = dc.select(query);
             try {
				if (rows.next()) {
				   JOptionPane.showMessageDialog(btnlogin, "You have successfully logged in");
						 billing_system bs= new billing_system();
						 bs.setVisible(false);
						 dispose_loginn();     	        
				 }
				 else {
				     JOptionPane.showMessageDialog(btnlogin, "Wrong Username & Password");
				 }
			} catch (SQLException throwable) {
				// TODO Auto-generated catch block
				throwable.printStackTrace();
			} 
         }
	 }
		private void dispose_loginn() {
			// TODO Auto-generated method stub
			setVisible(true);
			loginframe.dispose();		
		}
 });

btnlogin.setForeground(Color.BLACK);
btnlogin.setBackground(Color.WHITE);
btnlogin.setFont(new Font("Times New Roman", Font.BOLD, 16));
loginframe.getContentPane().add(btnlogin);



JButton btnexit = new JButton("EXIT");
btnexit.setIcon(new ImageIcon("C:\\java_folder\\OOP_project\\src\\billing_system\\exit1.png"));
btnexit.setBounds(220,350, 107, 41);
btnexit.setFont(new Font("Times New Roman", Font.BOLD, 16));
btnexit.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
  	  System.exit(0);        
    }
});
loginframe.getContentPane().add(btnexit);


JLayeredPane layeredPane = new JLayeredPane();
layeredPane.setBounds(32, 183, 172, -65);
loginframe.getContentPane().add(layeredPane);
    
    JLabel lblwelcome = new JLabel("Billing System");
    lblwelcome.setFont(new Font("Times New Roman", Font.BOLD, 40));
    lblwelcome.setBounds(4, 44, 280, 46);
    loginframe.getContentPane().add(lblwelcome);
    
        JLabel lblpicture = new JLabel("");
        lblpicture.setIcon(new ImageIcon("C:\\java_folder\\OOP_project\\src\\billing_system\\background1.png"));
        lblpicture.setBounds(0, 0,343,391);
        loginframe.getContentPane().add(lblpicture);
    loginframe.setSize(341,427);   
    loginframe.setVisible(true);    
}   

/**
        * Initialize the contents of the frame.

        */

        private void main() {
                     loginframe = new JFrame();
                     loginframe.setSize(500,402);
                     loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

			public void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
}