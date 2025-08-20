package Final_assessment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class TeacherReport extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtModule;
	private JTextField txtPercentage;
	private JTextField txtId;
	private JTextField txtGpa;
	private JTextField txtLevel;
	private JTextField txtSemester;
	private JTextField txtCourse;
	private JTextField txtSubject;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherReport frame = new TeacherReport();
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
	public TeacherReport() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 320, 480, 645);
		setLocation(450,150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 0, 0));
		panel.setBounds(138, 60, 198, 39);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Module Result");
		lblNewLabel.setBounds(29, 0, 159, 39);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		
		JLabel lblNewLabel_1 = new JLabel("Student Name:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBounds(96, 206, 106, 13);
		contentPane.add(lblNewLabel_1);
		
		txtName = new JTextField();
		txtName.setBounds(201, 203, 119, 19);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Module Name:");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2.setBounds(96, 443, 95, 13);
		contentPane.add(lblNewLabel_2);
		
		txtModule = new JTextField();
		txtModule.setBounds(201, 440, 119, 19);
		contentPane.add(txtModule);
		txtModule.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Total Percentage:");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_3.setBounds(76, 485, 119, 13);
		contentPane.add(lblNewLabel_3);
		
		txtPercentage = new JTextField();
		txtPercentage.setBounds(201, 482, 119, 19);
		contentPane.add(txtPercentage);
		txtPercentage.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Overall GPA:");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_4.setBounds(102, 528, 100, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Student ID:");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_5.setBounds(115, 159, 87, 13);
		contentPane.add(lblNewLabel_5);
		
		txtId = new JTextField();
		txtId.setBounds(201, 156, 119, 19);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JButton btnUpload = new JButton("Upload Result");
		btnUpload.setFont(new Font("Arial", Font.BOLD, 13));
		btnUpload.setBounds(169, 567, 127, 31);
		contentPane.add(btnUpload);
		
		txtGpa = new JTextField();
		txtGpa.setColumns(10);
		txtGpa.setBounds(201, 525, 119, 19);
		contentPane.add(txtGpa);
		
		txtLevel = new JTextField();
		txtLevel.setColumns(10);
		txtLevel.setBounds(201, 298, 119, 19);
		contentPane.add(txtLevel);
		
		txtSemester = new JTextField();
		txtSemester.setColumns(10);
		txtSemester.setBounds(201, 343, 119, 19);
		contentPane.add(txtSemester);
		
		JLabel lblNewLabel_4_1 = new JLabel("Level:");
		lblNewLabel_4_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_4_1.setBounds(153, 301, 100, 13);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Semester:");
		lblNewLabel_4_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_4_2.setBounds(127, 346, 100, 13);
		contentPane.add(lblNewLabel_4_2);
		
		txtCourse = new JTextField();
		txtCourse.setColumns(10);
		txtCourse.setBounds(201, 251, 119, 19);
		contentPane.add(txtCourse);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Course:");
		lblNewLabel_4_2_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_4_2_1.setBounds(138, 254, 100, 13);
		contentPane.add(lblNewLabel_4_2_1);
		
		txtSubject = new JTextField();
		txtSubject.setColumns(10);
		txtSubject.setBounds(201, 396, 119, 19);
		contentPane.add(txtSubject);
		
		JLabel lblNewLabel_2_1 = new JLabel("Subject Name:");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(96, 402, 95, 13);
		contentPane.add(lblNewLabel_2_1);
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String jdbcUrl = "jdbc:mysql://localhost:3306/student";
			    String username = "root";
			    String passkey = "";
			    
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
			            
			            if(txtId.getText().isEmpty()) {
				            
				        	 JOptionPane.showMessageDialog(btnUpload,"Please Enter the StudentId");
				    }
			            
			            else if(txtName.getText().isEmpty()) {
			            
			        	 JOptionPane.showMessageDialog(btnUpload,"Please Enter Name");
			    }
			         
			         else if(txtModule.getText().isEmpty()) {
			        	 JOptionPane.showMessageDialog(btnUpload,"Please Enter the Module Name");
			         }
			         
			         else if(txtPercentage.getText().isEmpty()) {
			        	 JOptionPane.showMessageDialog(btnUpload,"Please Enter the Percentage");
			         }
			         
			         else if(txtGpa.getText().isEmpty()) {
			        	 JOptionPane.showMessageDialog(btnUpload,"Please Enter the GPA");
			         }
			         
			         else if(txtCourse.getText().isEmpty()) {
			        	 JOptionPane.showMessageDialog(btnUpload,"Please Enter the Course");
			         }
			            
			         else if(txtSemester.getText().isEmpty()) {
			        	 JOptionPane.showMessageDialog(btnUpload,"Please Enter the Semester");
			         }
			            
			         else if(txtLevel.getText().isEmpty()) {
			        	 JOptionPane.showMessageDialog(btnUpload,"Please Enter the Level");
			         }
			            
			         else if(txtSubject.getText().isEmpty()) {
			        	 JOptionPane.showMessageDialog(btnUpload,"Please Enter the Subject");
			         }
			        
			        else {
			        	
			            String s = "INSERT INTO report (SID, Name, Module, Percentage, Gpa,Level,Sem,Course,Subject) " +
			        	           "VALUES ('"+txtId.getText()+"','" + txtName.getText().toLowerCase() + "','" + txtModule.getText() + "','" + txtPercentage.getText() +
			        	           "','" + txtGpa.getText() + "','"+txtLevel.getText()+"','"+txtSemester.getText()+"','"+txtCourse.getText().toUpperCase()+"','"+txtSubject.getText().toLowerCase()+"')";
			            
			            int rows_affected = stmt.executeUpdate(s);
			            if (rows_affected > 0) {
			            	JOptionPane.showMessageDialog(btnUpload,"Successfully Uploaded");
			            	dispose();
		            }
			        }
			        }
			    }
			        catch(ClassNotFoundException | SQLException e1) {
			        	// Handle exceptions
				        e1.printStackTrace();
				        System.out.println("Database connection failed!");
			        }
			}
		});
		
		
		
	}
}
