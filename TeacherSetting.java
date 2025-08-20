package Final_assessment;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import java.sql.*;
import javax.swing.table.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTabbedPane;
import javax.swing.JSlider;
import javax.swing.JPasswordField;
import java.awt.Label;

public class TeacherSetting extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JPasswordField passwordField;
    private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherSetting frame = new TeacherSetting("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
//	 panel = new JPanel();
	/**
	 * Create the frame.
	 */
	public TeacherSetting(String course) {
		setBackground(new Color(255, 255, 255));
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 723);
		setLocation(340, 80);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new LineBorder(new Color(128, 128, 128)));

		setContentPane(contentPane);
		
		JButton btnCourses = new JButton("Courses");
		btnCourses.setBounds(75, 247, 137, 39);
		btnCourses.setBackground(new Color(235, 235, 235));
		btnCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherCourse tcourse = new TeacherCourse(course);
				tcourse.show();
				dispose();
				
			}
		});
		contentPane.setLayout(null);
		btnCourses.setFont(new Font("Arial", Font.BOLD, 15));
		contentPane.add(btnCourses);
		
		JButton btnTutors = new JButton("Tutors");
		btnTutors.setBounds(75, 309, 137, 39);
		btnTutors.setBackground(new Color(235, 235, 235));
		btnTutors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TeacherTeacher tteacher = new TeacherTeacher(course);
				tteacher.show();
				dispose();
			}
		});
		btnTutors.setFont(new Font("Arial", Font.BOLD, 15));
		contentPane.add(btnTutors);
		
		JButton btnStudents = new JButton("Students");
		btnStudents.setBounds(75, 368, 137, 39);
		btnStudents.setBackground(new Color(235, 235, 235));
		btnStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TeacherStudent tstudent = new TeacherStudent(course);
				tstudent.show();
				dispose();
			}
		});
		btnStudents.setFont(new Font("Arial", Font.BOLD, 15));
		contentPane.add(btnStudents);
		
		JButton btnSetting = new JButton("Setting");
		btnSetting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSetting.setBounds(75, 430, 137, 39);
		
		btnSetting.setBackground(new Color(255, 128, 128));
		btnSetting.setFont(new Font("Arial", Font.BOLD, 15));
		contentPane.add(btnSetting);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(75, 491, 137, 39);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login lg = new login();
				lg.show();
				dispose();
			}
		});
		btnLogout.setBackground(new Color(235, 235, 235));
		btnLogout.setFont(new Font("Arial", Font.BOLD, 15));
		contentPane.add(btnLogout);
		
		JButton btnDashboard = new JButton("Dashboard");
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherDashboard tdash = new TeacherDashboard(course);
				tdash.show();
				dispose();
			}
		});
		btnDashboard.setBounds(75, 187, 137, 39);
		btnDashboard.setBackground(new Color(235, 235, 235));
		btnDashboard.setFont(new Font("Arial", Font.BOLD, 15));
		contentPane.add(btnDashboard);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(232, 37, 709, 39);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel = new JLabel("Setting");
		lblNewLabel.setBounds(259, 49, 87, 25);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(lblNewLabel);
		
		JLabel lblHome = new JLabel("");
		lblHome.setBounds(72, 37, 150, 145);
		lblHome.setBackground(new Color(255, 255, 255));
		contentPane.add(lblHome);
		Image img = new ImageIcon(this.getClass().getResource("/home (2).png")).getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);;;
		lblHome.setIcon(new ImageIcon(img));
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(232, 84, 709, 25);
		contentPane.add(separator_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Security and Login");
		lblNewLabel_1.setBounds(259, 131, 165, 25);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(636, 192, 131, 25);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(374, 192, 131, 25);
		contentPane.add(passwordField_1);
		
		JLabel lblOldpassword = new JLabel("Old Password");
		lblOldpassword.setBounds(534, 201, 92, 13);
		lblOldpassword.setFont(new Font("Arial", Font.BOLD, 13));
		contentPane.add(lblOldpassword);
		
		JLabel lblNewpassword = new JLabel("New Password");
		lblNewpassword.setBounds(259, 201, 105, 13);
		lblNewpassword.setFont(new Font("Arial", Font.BOLD, 13));
		contentPane.add(lblNewpassword);
		
		JButton btnNewButton = new JButton("Create Student Report");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherReport treport = new TeacherReport();
				treport.show();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(448, 271, 191, 25);
		contentPane.add(btnNewButton);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Oldpassword = passwordField.getText();
				String Newpassword = passwordField_1.getText();

				
				
                
                String jdbcUrl = "jdbc:mysql://localhost:3306/student";
			    String username = "root";
			    String passkey = "";
			    
                 if(Oldpassword.isEmpty()) {
					
					JOptionPane.showMessageDialog(btnChangePassword,"Please Enter the old password");
				}
                 else if(Newpassword.isEmpty()) {
					
					JOptionPane.showMessageDialog(btnChangePassword,"Please Enter the new password");
				}
			    
                 else {
                	 
                 
			    try {
			    	// Load the JDBC driver
			        Class.forName("com.mysql.cj.jdbc.Driver");

			        // Establish a connection
			        Connection connection = DriverManager.getConnection(jdbcUrl, username, passkey);
			        
					// Create statement/Query
					Statement stmt = connection.createStatement();

			        // Check if the connection is successful
			        if (connection != null) {
			            System.out.println("Database connection is successful!");
			            
			            String s = "UPDATE teachers SET Password = '"+Newpassword+"'WHERE Password='"+Oldpassword+"'";
			            int rows_affected = stmt.executeUpdate(s);
			            if (rows_affected > 0) {
			            	JOptionPane.showMessageDialog(btnChangePassword,"Successfully Changed the password");
			            } else {
			            	JOptionPane.showMessageDialog(btnChangePassword,"Old password doesn't match");
			            }
			        }
			        }
			        catch(ClassNotFoundException | SQLException e1) {
			        	// Handle exceptions
				        e1.printStackTrace();
				        System.out.println("Database connection failed!");
			        }
			}
			}     
		});
		btnChangePassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnChangePassword.setBounds(259, 271, 147, 25);
		contentPane.add(btnChangePassword);
		
		JLabel lblNewLabel_2 = new JLabel("If System misbehaves please report us on:");
		lblNewLabel_2.setBounds(285, 403, 258, 32);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel lblNewLabel_3 = new JLabel("Email: np03cs4a220487@heraldcollege.edu.np");
		lblNewLabel_3.setBounds(285, 444, 248, 13);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JLabel lblNewLabel_3_1 = new JLabel("Contact: 9866969746");
		lblNewLabel_3_1.setBounds(285, 467, 248, 13);
		contentPane.add(lblNewLabel_3_1);
		lblNewLabel_3_1.setFont(new Font("Arial", Font.PLAIN, 12));
		
		Label label = new Label("Help and Services");
		label.setBounds(322, 365, 148, 24);
		contentPane.add(label);
		label.setFont(new Font("Arial", Font.BOLD, 13));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(285, 395, 218, 218);
		contentPane.add(separator);

    }
}
