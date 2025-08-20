package Final_assessment;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;

public class StudentProgress extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_4;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentProgress frame = new StudentProgress();
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
	public StudentProgress() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 567, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGpa = new JLabel("GPA");
		lblGpa.setFont(new Font("Arial", Font.BOLD, 13));
		lblGpa.setBounds(100, 148, 45, 13);
		contentPane.add(lblGpa);
		
		JLabel lblNewLabel_3_1 = new JLabel("Percentage");
		lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_3_1.setBounds(311, 148, 80, 13);
		contentPane.add(lblNewLabel_3_1);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(148, 145, 96, 19);
		contentPane.add(textField_4);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(395, 145, 96, 19);
		contentPane.add(textField);
		
		txtSubject = new JTextField();
		txtSubject.setForeground(new Color(255, 0, 0));
		txtSubject.setFont(new Font("Arial", Font.BOLD, 18));
		txtSubject.setEditable(false);
		txtSubject.setColumns(10);
		txtSubject.setBounds(179, 59, 258, 19);
		contentPane.add(txtSubject);
		
	}
	
		String jdbcUrl = "jdbc:mysql://localhost:3306/student";
	    String username = "root";
	    String passkey = "";
	    private JTextField txtSubject;
	    
	    public boolean display(String name, String level, String sem, String subject) {
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
	                
	            
	                // Construct the query to retrieve data from reports table based on level, sem, subject, and name
	                String reportQuery = "SELECT * FROM report WHERE Level='" + level + "' AND Sem='" + sem + "' AND Subject='" + subject + "' AND Name='" + name + "'";
	                ResultSet reportResult = stmt.executeQuery(reportQuery);
	                if (reportResult.next()) {
	                    // Retrieve percentage and GPA from the result set
	                    double percentage = reportResult.getDouble("Percentage");
	                    double gpa = reportResult.getDouble("GPA");

	                    // Display the retrieved values in their respective fields
	                    textField.setText(Double.toString(percentage));
	                    textField_4.setText(Double.toString(gpa));
	                    txtSubject.setText(subject);

	                    // Close the connection
	                    connection.close();
	                    return true;
	                } else {
	                    // If no matching record found in reports table, return false or handle accordingly
	                    return false;
	                }
	            }
	        } catch (ClassNotFoundException | SQLException e1) {
	            // Handle exceptions
	            e1.printStackTrace();
	            System.out.println("Database connection failed!");
	        }
	        return false;
	    }

		
	}

