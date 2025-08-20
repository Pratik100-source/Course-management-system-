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

public class StudentSetting extends JFrame {

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
					StudentSetting frame = new StudentSetting("","","");
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
	public StudentSetting(String level, String course, String login_name) {
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
				StudentCourse scourse = new StudentCourse(level,course,login_name);
				scourse.show();
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
				
				StudentTeacher steacher = new StudentTeacher(level,course,login_name);
				steacher.show();
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
				
				StudentStudent sstudent = new StudentStudent(level,course,login_name);
				sstudent.show();
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
		btnSetting.setBackground(new Color(255, 128, 128));
		btnSetting.setBounds(75, 430, 137, 39);
		
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
				StudentDashboard sdash = new StudentDashboard(level,course,login_name);
				sdash.show();
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
			            
			            String s = "UPDATE stds SET Password = '"+Newpassword+"'WHERE Password='"+Oldpassword+"'";
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
		
		JButton btnCheckResultStatus = new JButton("Check Result Status");
        btnCheckResultStatus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	  boolean passedAllSubjects = checkSubjectsPassed(login_name, course, level);

            	    if (passedAllSubjects) {
            	        // Update the student's level if they have passed all subjects
            	        updateStudentLevel(login_name, level);
            	        JOptionPane.showMessageDialog(null, "Congratulations! You have cleared this semester");
            	    } else if (passedAllSubjects == false) {
            	        // Display a message indicating that the student has not passed all subjects
            	        JOptionPane.showMessageDialog(null, "Sorry, you have not passed this semester");
            	    } 
            	}
        });
        btnCheckResultStatus.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnCheckResultStatus.setBounds(435, 271, 165, 25);
        contentPane.add(btnCheckResultStatus);
    }

    private boolean checkSubjectsPassed(String studentName, String course, String level) {
        // Database connection details
        String jdbcUrl = "jdbc:mysql://localhost:3306/student";
        String username = "root";
        String passkey = "";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, passkey)) {
            // Prepare the SQL statement
            String sql = "SELECT * FROM report WHERE Name = ? AND Course = ? AND Level = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, studentName);
            statement.setString(2, course);
            statement.setString(3, level);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "Sorry, the result for level " + level + " is not available.");
                return false;
            }

            // Check if the student has marks greater than 40 in all subjects
            while (resultSet.next()) {
                String subjectMarksString = resultSet.getString("Percentage");
                int subjectMarks = Integer.parseInt(subjectMarksString); // Convert subject marks to integer

                if (subjectMarks < 40) {
                    return false; // Student has not passed all subjects
                }
           
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void updateStudentLevel(String studentName, String level) {
        // Database connection details
        String jdbcUrl = "jdbc:mysql://localhost:3306/student";
        String username = "root";
        String passkey = "";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, passkey)) {
            // Check if the student's sem in reports table is 2 and level is less than 6
            String semQuery = "SELECT Sem FROM report WHERE Name = ? AND Sem = 2";
            PreparedStatement semStatement = connection.prepareStatement(semQuery);
            semStatement.setString(1, studentName);
            ResultSet semResultSet = semStatement.executeQuery();
            if (semResultSet.next()) {
                // If sem is 2 and level is less than 6, increment level
                int currentLevel = Integer.parseInt(level);
                if (currentLevel < 6) {
                    // Prepare the SQL statement
                    String sql = "UPDATE stds SET Level = ? WHERE Name = ?";
                    PreparedStatement statement = connection.prepareStatement(sql);

                    // Convert level from string to integer and increment by 1
                    int newLevel = currentLevel + 1;
                    String newLevelString = String.valueOf(newLevel);

                    // Set parameters in the prepared statement
                    statement.setString(1, newLevelString);
                    statement.setString(2, studentName);

                    // Execute the update
                    statement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    }
