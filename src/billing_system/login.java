package billing_system;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField User_txt;
    private JPasswordField password_txt;
    private JButton login_btn;
    private JLabel label;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                   login frame = new login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 80, 450, 350);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(204, 221, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Login");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        lblNewLabel.setBounds(210, 30, 273, 93);
        contentPane.add(lblNewLabel);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBackground(Color.BLACK);
        lblUsername.setForeground(Color.BLACK);
        lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblUsername.setBounds(50, 100, 193, 52);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setBackground(Color.CYAN);
        lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblPassword.setBounds(50, 150, 193, 52);
        contentPane.add(lblPassword);
        
        User_txt = new JTextField();
        User_txt.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        User_txt.setBounds(150, 110, 200, 35);
        contentPane.add(User_txt);
        User_txt.setColumns(10);

        password_txt = new JPasswordField();
        password_txt.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        password_txt.setBounds(150, 155, 200, 35);
        contentPane.add(password_txt);

        login_btn = new JButton("Login");
        login_btn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        login_btn.setBounds(200, 200, 95, 40);
        login_btn.setBackground(new Color(179, 255, 102));
        contentPane.add(login_btn);
        login_btn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String userName = "Karma";
                String password =  "Gurung";
                
                  
                if(  User_txt.getText().equals("Karma") && password_txt.getText().equals("Gurung")) {
                	
                        JOptionPane.showMessageDialog(login_btn, "You have successfully logged in");
                        
                    } else {
                        JOptionPane.showMessageDialog(login_btn, "Wrong Username & Password");
                    }
            }
        });

       

        
    }
}
