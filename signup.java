package Final_assessment;

import java.awt.EventQueue;

import java.awt.Image;
import java.awt.event.*;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JTextField;
import java.sql.*;
public class signup extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPasswordField txtPassword;
    private JComboBox<String> txtMode_1;
    private JComboBox<String> courseCombobox;
    private JComboBox<String> levelCombobox;
    private JComboBox<String> optionalcourseCombobox;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    signup frame = new signup();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public signup() {
        setTitle("Signup");
        setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/signup1.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 447, 560);
        setLocation(600, 100);
        contentPane = new JPanel();
        contentPane.setBackground(UIManager.getColor("CheckBox.light"));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTextArea txtName = new JTextArea();
        txtName.setBackground(UIManager.getColor("Button.highlight"));
        txtName.setBounds(96, 189, 146, 20);
        contentPane.add(txtName);

        JTextArea txtEmail = new JTextArea();
        txtEmail.setBackground(UIManager.getColor("Button.highlight"));
        txtEmail.setBounds(96, 237, 146, 20);
        contentPane.add(txtEmail);

        JTextArea txtPhone = new JTextArea();
        txtPhone.setBackground(UIManager.getColor("Button.highlight"));
        txtPhone.setBounds(96, 294, 146, 20);
        contentPane.add(txtPhone);

        txtMode_1 = new JComboBox<>();
        txtMode_1.setToolTipText("");
        txtMode_1.setModel(new DefaultComboBoxModel<>(new String[]{"Select Mode", "Student", "Tutor", "Manager"}));
        txtMode_1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    updateUI();
                }
            }
        });
        txtMode_1.setSelectedIndex(0);
        txtMode_1.setFont(new Font("Arial", Font.BOLD, 11));
        txtMode_1.setBackground(Color.WHITE);
        txtMode_1.setBounds(96, 388, 146, 20);
        contentPane.add(txtMode_1);

        courseCombobox = new JComboBox<>();
        courseCombobox.setBounds(96, 426, 146, 20);
        contentPane.add(courseCombobox);

        levelCombobox = new JComboBox<>();
        levelCombobox.setBounds(252, 426, 77, 20);
        contentPane.add(levelCombobox);
        
        optionalcourseCombobox = new JComboBox();
        optionalcourseCombobox.setBounds(342, 426, 60, 20);
        contentPane.add(optionalcourseCombobox);

        courseCombobox.setVisible(false);
        levelCombobox.setVisible(false);
        optionalcourseCombobox.setVisible(false);

        JButton btnCreate = new JButton("Create");
        btnCreate.setFont(new Font("Arial", Font.BOLD, 11));
        btnCreate.setBounds(96, 469, 77, 21);
        contentPane.add(btnCreate);

          btnCreate.addActionListener(new ActionListener() {
			
      		public void actionPerformed(ActionEvent e) {
      			
      			
      			String signup_name = txtName.getText().toLowerCase();
      			String signup_email = txtEmail.getText();
      			String signup_phone = txtPhone.getText();
      			String signup_password = txtPassword.getText();
      			int signup_mode_index = txtMode_1.getSelectedIndex();
      			int course_index = courseCombobox.getSelectedIndex();
      			int level_index = levelCombobox.getSelectedIndex();
      			int optional_course_index = optionalcourseCombobox.getSelectedIndex();
      			
      			String selected_course = (String)courseCombobox.getSelectedItem();
      			String selected_level = (String)levelCombobox.getSelectedItem();
      			String selected_optional = (String)optionalcourseCombobox.getSelectedItem();
      			String signup_mode = "";
      			String level="";
      			String course="";
      			String optional_course ="";
      			
      			if(signup_mode_index==0) {
      				JOptionPane.showMessageDialog(btnCreate,"Please, Select a mode");
      			}
      			else if(signup_mode_index==1) {
      				
      				signup_mode = "Student";
      				
      				
      				
      				if(course_index==0) {
      					JOptionPane.showMessageDialog(btnCreate,"Please, Select a Course");
      				}
      				
      				else if(selected_course.equals("BCS")) {
      					course = "BCS";
      					
      					if(selected_level.equals("Level 4")) {
      						level = "4";
      					}
      					else if(selected_level.equals("Level 5")) {
      						level = "5";
      					}
      					else if(selected_level.equals("Level 6")) {
      						level = "6";
      						
      						if(selected_optional.equals("DSA")) {
      							optional_course = "DSA";
      						}
      						else if(selected_optional.equals("DBA")) {
      							optional_course = "DBA";
      						}
      						else {
      							JOptionPane.showMessageDialog(btnCreate,"Please, Select a optional Course");
      						}
      					}
      					else {
      						JOptionPane.showMessageDialog(btnCreate,"Please, Select a Level");
      					}
      					
      				}
      				else if(!selected_course.isEmpty()) {
                            course = selected_course;
      					
      					if(selected_level.equals("Level 4")) {
      						level = "4";
      					}
      					else if(selected_level.equals("Level 5")) {
      						level = "5";
      					}
      					else if(selected_level.equals("Level 6")) {
      						level = "6";
      						
      					}
      						else {
      							JOptionPane.showMessageDialog(btnCreate,"Please, Select the level");
      						}
      				}
      				
      			}
      				
      
                else if(signup_mode_index==2) {
      				signup_mode = "Tutor";
      				
      				if(course_index==0) {
      					JOptionPane.showMessageDialog(btnCreate,"Please, Select a Course");
      				}
      				
      				else if(!selected_course.isEmpty()) {
      					course = selected_course;
      				}
      				
      			}
                else {
                	signup_mode = "Manager";
                }
      			
      			
      			int p_length = signup_phone.length();
      			
      			if(signup_name.isEmpty()) {
      				JOptionPane.showMessageDialog(btnCreate,"Username is Empty");
      			}
      			
      			else if(signup_email.isEmpty()) {
      				
      				JOptionPane.showMessageDialog(btnCreate,"Email is Empty");
      			}
      			
      			else if(p_length!=10) {
      				
      				JOptionPane.showMessageDialog(btnCreate,"Enter the valid mobile number");
      			}
      			
      			else if(signup_password.isEmpty()) {
      				JOptionPane.showMessageDialog(btnCreate,"Please Enter the password");
				
			}
      			
 
      			else {
      				SignupHandler signupHandler = new SignupHandler();
      			    // Call SignupData once and store the result
      			    boolean signupResult = signupHandler.signup(signup_name, signup_email, signup_phone, signup_password, signup_mode,course,level,optional_course);

      			    // Check the result for success
      			    if (signupResult == true) {
      			        JOptionPane.showMessageDialog(btnCreate, "Successful signup");
      			        login mn = new login();
      			        mn.setVisible(true);
      			        dispose();
      			    }}
      		}
});

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login mn = new login();
				mn.setVisible(true);
				dispose();
			}
		});
        btnLogin.setFont(new Font("Arial", Font.BOLD, 11));
        btnLogin.setBounds(174, 469, 68, 21);
        contentPane.add(btnLogin);

        JLabel lblNewLabel = new JLabel("Enter Username:");
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 11));
        lblNewLabel.setBounds(96, 171, 99, 19);
        contentPane.add(lblNewLabel);

        JLabel lblEnterEmail = new JLabel("Enter Email");
        lblEnterEmail.setFont(new Font("Arial", Font.BOLD, 11));
        lblEnterEmail.setBounds(96, 219, 83, 18);
        contentPane.add(lblEnterEmail);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Arial", Font.BOLD, 11));
        lblPassword.setBounds(96, 331, 68, 13);
        contentPane.add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 10));
        txtPassword.setBounds(96, 345, 146, 20);
        contentPane.add(txtPassword);

        JLabel lblEnterEmail_1 = new JLabel("Enter phone number");
        lblEnterEmail_1.setFont(new Font("Arial", Font.BOLD, 11));
        lblEnterEmail_1.setBounds(93, 278, 122, 18);
        contentPane.add(lblEnterEmail_1);

        JLabel lblNewLabel_1 = new JLabel("Welcome to the SignUp Panel");
        lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
        lblNewLabel_1.setBounds(77, 29, 210, 20);
        contentPane.add(lblNewLabel_1);

        // Assuming the image is in the root directory of your classpath
        Image img = new ImageIcon(this.getClass().getResource("/signup1.png")).getImage().getScaledInstance(100, 70,
                Image.SCALE_DEFAULT);
        JLabel lblimg = new JLabel(new ImageIcon(img));
        lblimg.setBounds(119, 69, 110, 92);
        contentPane.add(lblimg);
        
        
    }

    private void updateUI() {
        String selectedMode = (String) txtMode_1.getSelectedItem();
        String selectedCourse = (String) courseCombobox.getSelectedItem();
        String selectedLevel = (String) levelCombobox.getSelectedItem();

        courseCombobox.setVisible("Student".equals(selectedMode)||"Tutor".equals(selectedMode));
        levelCombobox.setVisible("Student".equals(selectedMode) && "BCS".equals(selectedCourse));
        optionalcourseCombobox.setVisible("Student".equals(selectedMode) && "BCS".equals(selectedCourse) && "Level 6".equals(selectedLevel));

        initCourseComboBox();
        initLevelComboBox(); 
    }

    public void initCourseComboBox() {
        String selectedMode = (String) txtMode_1.getSelectedItem();
        courseCombobox.removeAllItems();
        courseCombobox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    courseCombobox.setVisible("Student".equals(selectedMode) || "Tutor".equals(selectedMode));
                    initLevelComboBox();
                }
            
            }
        });

        if ("Student".equals(selectedMode) || "Tutor".equals(selectedMode)) {
            
            String jdbcUrl = "jdbc:mysql://localhost:3306/student";
		    String username = "root";
		    String passkey = "";
            // Load courses from database
            try {
            	
		        // Establish a connection
		        Connection connection = DriverManager.getConnection(jdbcUrl, username, passkey);
		        
				// Create statement/Query
				Statement stmt = connection.createStatement();
				
                ResultSet resultSet = stmt.executeQuery("SELECT CourseName FROM course");
                courseCombobox.addItem("Select Course");
                while (resultSet.next()) {
                    String courseName = resultSet.getString("CourseName");
                    courseCombobox.addItem(courseName);
                }

                resultSet.close();
                stmt.close();
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void initLevelComboBox() {
        // Add levels based on the selected mode
        String selectedMode = (String) txtMode_1.getSelectedItem();
        levelCombobox.removeAllItems();
        levelCombobox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedCourse = (String) courseCombobox.getSelectedItem();
                    
                    levelCombobox.setVisible("Student".equals(selectedMode));
                    initOptionalCourseComboBox();
                }
             
            }
        });

        if ("Student".equals(selectedMode)) {
            // Add levels for students
            levelCombobox.removeAllItems();
            levelCombobox.addItem("Select Level");
            levelCombobox.addItem("Level 4");
            levelCombobox.addItem("Level 5");
            levelCombobox.addItem("Level 6");
        } else {
            // If mode is not student, hide or clear the level combo box
            levelCombobox.setVisible(false);
            levelCombobox.removeAllItems();
        }
    }

    public void initOptionalCourseComboBox() {
        // Add courses based on the selected level
        String selectedLevel = (String) levelCombobox.getSelectedItem();
        optionalcourseCombobox.removeAllItems();
        optionalcourseCombobox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedCourse = (String) courseCombobox.getSelectedItem();
                    String selectedLevel = (String) levelCombobox.getSelectedItem();
                    optionalcourseCombobox.setVisible("Student".equals(txtMode_1.getSelectedItem()) && "BCS".equals(selectedCourse) && "Level 6".equals(selectedLevel));
                }
            }
        });

        if ("Level 6".equals(selectedLevel)) {
            optionalcourseCombobox.addItem("Select Course");
            optionalcourseCombobox.addItem("DSA");
            optionalcourseCombobox.addItem("DBA");
        }
    }
}
