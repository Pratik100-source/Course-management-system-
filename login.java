package Final_assessment;

import java.awt.EventQueue;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPasswordField txtPassword;
    private JTextArea txtEmail;
    private JTextArea txtName;
    private JComboBox<String> txtMode;

    // Private instance variables to store login credentials
    private String loginEmail;
    private String loginPassword;
    private String loginMode;
    private String loginName;

    // Public setter methods to set login credentials
    public void setLoginEmail(String email) {
        this.loginEmail = email;
    }

    public void setLoginPassword(String password) {
        this.loginPassword = password;
    }

    public void setLoginMode(String mode) {
        this.loginMode = mode;
    }
    public void setLoginName(String name) {
        this.loginName = name;
    }

    // Public getter methods to retrieve login credentials
    public String getLoginEmail() {
        return loginEmail;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public String getLoginMode() {
        return loginMode;
    }
    
    public String getLoginName() {
        return loginName;
    }
    
    

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
        setBounds(100, 100, 369, 452);
        setLocation(600, 100);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/login2.png")));
        contentPane = new JPanel();
        contentPane.setBackground(UIManager.getColor("CheckBox.light"));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        txtEmail = new JTextArea();
        txtEmail.setBackground(UIManager.getColor("Button.highlight"));
        txtEmail.setBounds(85, 240, 146, 20);
        contentPane.add(txtEmail);
        
        txtName = new JTextArea();
        txtName.setBackground(Color.WHITE);
        txtName.setBounds(85, 191, 146, 20);
        contentPane.add(txtName);
        
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Arial", Font.BOLD, 11));
        lblUsername.setBounds(85, 170, 83, 18);
        contentPane.add(lblUsername);

        txtMode = new JComboBox<String>();
        txtMode.setModel(
                new DefaultComboBoxModel<String>(new String[] { "Select User Mode", "Student", "Teacher", "Manager" }));
        txtMode.setSelectedIndex(0);
        txtMode.setToolTipText("");
        txtMode.setFont(new Font("Arial", Font.BOLD, 11));
        txtMode.setBackground(new Color(255, 255, 255));
        txtMode.setBounds(85, 328, 146, 20);
        contentPane.add(txtMode);

        JButton btnLogin = new JButton("login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	
            	String loginName = txtName.getText().toLowerCase();
                String loginEmail = txtEmail.getText();
                String loginPassword = txtPassword.getText();
                int loginModeIndex = txtMode.getSelectedIndex();
                String loginMode = "";

                switch (loginModeIndex) {
                    case 0:
                        JOptionPane.showMessageDialog(btnLogin, "Please, Select a mode");
                        return;
                    case 1:
                        loginMode = "Student";
                        break;
                    case 2:
                        loginMode = "Tutor";
                        break;
                    case 3:
                        loginMode = "Manager";
                        break;
                }

                if (loginEmail.isEmpty()) {
                    JOptionPane.showMessageDialog(btnLogin, "Email is Empty");
                } else if (loginPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(btnLogin, "Please Enter the password");
                } else {
                
                    setLoginEmail(loginEmail);
                    setLoginPassword(loginPassword);
                    setLoginMode(loginMode);
                    setLoginName(loginName);
                    
                    String email = getLoginEmail();
                    String password = getLoginPassword();
                    String mode = getLoginMode();
                    String name = getLoginName();
                   
                    LoginHandler loginHandler = new LoginHandler();
                    
                    if(loginHandler.login(email,password,mode,name)) {
                    	dispose();
                    	
                    }
                
                }
            }
        });
        btnLogin.setFont(new Font("Arial", Font.BOLD, 11));
        btnLogin.setBounds(85, 358, 68, 21);
        contentPane.add(btnLogin);

        JLabel lblEnterEmail = new JLabel(" Enter Email");
        lblEnterEmail.setFont(new Font("Arial", Font.BOLD, 11));
        lblEnterEmail.setBounds(85, 218, 83, 18);
        contentPane.add(lblEnterEmail);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Arial", Font.BOLD, 11));
        lblPassword.setBounds(85, 270, 68, 13);
        contentPane.add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 10));
        txtPassword.setBounds(85, 286, 146, 20);
        contentPane.add(txtPassword);

        JLabel lblNewLabel_1 = new JLabel("Welcome to the Login Panel");
        lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
        lblNewLabel_1.setBounds(71, 31, 210, 13);
        contentPane.add(lblNewLabel_1);

        JLabel lbllogo = new JLabel("");
        lbllogo.setBounds(124, 54, 125, 106);

        Image img = new ImageIcon(this.getClass().getResource("/login2.png")).getImage().getScaledInstance(100, 100,
                Image.SCALE_DEFAULT);
        lbllogo.setIcon(new ImageIcon(img));
        contentPane.add(lbllogo);

        JButton btnNewButton = new JButton("Signup");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                signup su = new signup();
                su.show();
                dispose();
            }
        });
        btnNewButton.setFont(new Font("Arial", Font.BOLD, 11));
        btnNewButton.setBounds(160, 358, 71, 21);
        contentPane.add(btnNewButton);
        
        
    }
}
