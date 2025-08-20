package Final_assessment;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class ManagerTeacher extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable tableData1;
    private JTextArea txtSearch;
    
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JTextField txtCourse;
	private JPasswordField txtPassword;
	
	private JTextField txtUpdateName;
	private JTextField txtUpdateEmail;
	private JTextField txtUpdatePhone;
	private JPasswordField txtUpdatePassword;
	private JTextField txtId;
     
	private JTextField textField;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ManagerTeacher frame = new ManagerTeacher();
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
    public ManagerTeacher() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 723);
        setLocation(340, 80);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(192, 192, 192));
        contentPane.setForeground(new Color(0, 0, 0));
        contentPane.setBorder(new LineBorder(new Color(128, 128, 128)));

        setContentPane(contentPane);

        JButton btnCourses = new JButton("Courses");
        btnCourses.setBackground(new Color(235, 235, 235));
        btnCourses.setBounds(75, 247, 137, 39);
        btnCourses.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ManagerCourse mcourse = new ManagerCourse();
            	mcourse.show();
            	dispose();
            }
        });
        contentPane.setLayout(null);
        btnCourses.setFont(new Font("Arial", Font.BOLD, 15));
        contentPane.add(btnCourses);

        JButton btnTutors = new JButton("Tutors");
        btnTutors.setBackground(new Color(255, 128, 128));
        btnTutors.setBounds(75, 309, 137, 39);
        btnTutors.setFont(new Font("Arial", Font.BOLD, 15));
        contentPane.add(btnTutors);

        JButton btnStudents = new JButton("Students");
        btnStudents.setBackground(new Color(235, 235, 235));
        btnStudents.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ManagerStudent mstudent = new ManagerStudent();
                mstudent.setVisible(true);
                dispose();
            }
        });
        btnStudents.setBounds(75, 368, 137, 39);
        btnStudents.setFont(new Font("Arial", Font.BOLD, 15));
        contentPane.add(btnStudents);

        JButton btnSetting = new JButton("Setting");
        btnSetting.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ManagerSetting msetting = new ManagerSetting();
                msetting.setVisible(true);
                dispose();
            }
        });
        btnSetting.setBackground(new Color(235, 235, 235));
        btnSetting.setBounds(75, 430, 137, 39);
        btnSetting.setFont(new Font("Arial", Font.BOLD, 15));
        contentPane.add(btnSetting);

        JButton btnLogout = new JButton("Logout");
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login lg = new login();
                lg.setVisible(true);
                dispose();
            }
        });
        btnLogout.setBackground(new Color(235, 235, 235));
        btnLogout.setBounds(75, 491, 137, 39);
        btnLogout.setFont(new Font("Arial", Font.BOLD, 15));
        contentPane.add(btnLogout);
        
        JLabel lblHome = new JLabel("");
		lblHome.setBackground(new Color(255, 255, 255));
		lblHome.setBounds(72, 37, 150, 145);
		contentPane.add(lblHome);
		Image img = new ImageIcon(this.getClass().getResource("/home (2).png")).getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);;;
		lblHome.setIcon(new ImageIcon(img));

        JButton btnDashboard = new JButton("Dashboard");
        btnDashboard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ManagerDashboard mdash = new ManagerDashboard();
                mdash.setVisible(true);
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

        JLabel lblNewLabel = new JLabel("Tutors");
        lblNewLabel.setBounds(259, 49, 87, 25);
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
        contentPane.add(lblNewLabel);

        txtSearch = new JTextArea();
        txtSearch.setBounds(254, 118, 216, 25);
        txtSearch.setFont(new Font("Monospaced", Font.PLAIN, 16));
        contentPane.add(txtSearch);

        txtSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateSearchResults();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateSearchResults();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateSearchResults();
            }
        });

        JButton btnNewButton_7 = new JButton("Add Tutors");
        btnNewButton_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	
            	JFrame AddTutorsFrame = new JFrame("Add Tutors");
            	AddTutorsFrame.setVisible(true);
                AddTutorsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        		AddTutorsFrame.setBounds(600, 320, 442, 463);
        		JPanel AddTutorsPanel = new JPanel();
        		AddTutorsPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        		AddTutorsFrame.setContentPane(AddTutorsPanel);
        		AddTutorsPanel.setLayout(null);
        		
        		JPanel panel = new JPanel();
        		panel.setBackground(new Color(255, 0, 0));
        		panel.setBounds(168, 60, 167, 39);
        		AddTutorsPanel.add(panel);
        		panel.setLayout(null);
        		
        		JLabel lblNewLabel = new JLabel("Add Tutors");
        		lblNewLabel.setBounds(29, 0, 110, 39);
        		panel.add(lblNewLabel);
        		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
        		
        		JLabel lblNewLabel_1 = new JLabel("Name:");
        		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
        		lblNewLabel_1.setBounds(138, 145, 45, 13);
        		AddTutorsPanel.add(lblNewLabel_1);
        		
        		txtName = new JTextField();
        		txtName.setBounds(224, 142, 96, 19);
        		AddTutorsPanel.add(txtName);
        		txtName.setColumns(10);
        		
        		JLabel lblNewLabel_2 = new JLabel("Email\r\n:");
        		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
        		lblNewLabel_2.setBounds(138, 202, 45, 13);
        		AddTutorsPanel.add(lblNewLabel_2);
        		
        		txtEmail = new JTextField();
        		txtEmail.setBounds(224, 199, 96, 19);
        		AddTutorsPanel.add(txtEmail);
        		txtEmail.setColumns(10);
        		
        		JLabel lblNewLabel_3 = new JLabel("Phone:");
        		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 13));
        		lblNewLabel_3.setBounds(138, 259, 45, 13);
        		AddTutorsPanel.add(lblNewLabel_3);
        		
        		txtPhone = new JTextField();
        		txtPhone.setBounds(224, 256, 96, 19);
        		AddTutorsPanel.add(txtPhone);
        		txtPhone.setColumns(10);
        		
        		JLabel lblNewLabel_4_1 = new JLabel("Course:");
        		lblNewLabel_4_1.setFont(new Font("Arial", Font.BOLD, 13));
        		lblNewLabel_4_1.setBounds(154, 358, 77, 13);
        		AddTutorsPanel.add(lblNewLabel_4_1);
        		
        		txtCourse = new JPasswordField();
        		txtCourse.setBounds(224, 355, 96, 19);
        		AddTutorsPanel.add(txtCourse);
        		
        		JButton btnAdd = new JButton("ADD\r\n");
        		btnAdd.addActionListener(new ActionListener() {
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
        			            
        			         if(txtName.getText().isEmpty()) {
        			            
        			        	 JOptionPane.showMessageDialog(btnAdd,"Please Enter the Name");
        			    }
        			         
        			         else if(txtEmail.getText().isEmpty()) {
        			        	 JOptionPane.showMessageDialog(btnAdd,"Please Enter the Email");
        			         }
        			         
        			         else if(txtPhone.getText().isEmpty()) {
        			        	 JOptionPane.showMessageDialog(btnAdd,"Please Enter the Phone");
        			         }
        			         
        			         else if(txtPassword.getText().isEmpty()) {
        			        	 JOptionPane.showMessageDialog(btnAdd,"Please Enter the Password");
        			         }
        			         else if(txtCourse.getText().isEmpty()) {
        			        	 JOptionPane.showMessageDialog(btnAdd,"Please Enter the Course");
        			         }
        			        
        			        else {
        			        	
//        		            	int value = Integer.parseInt(txtName.getText());
        			            String s = "INSERT INTO teachers (TID, Name, Email, Phone, Password, Mode,Course) " +
        			        	           "VALUES (NOT NULL,'" + txtName.getText().toLowerCase() + "','" + txtEmail.getText() + "','" + txtPhone.getText() +
        			        	           "','" + txtPassword.getText() + "','Tutor','"+txtCourse.getText().toUpperCase()+"')";
        			            
        			            int rows_affected = stmt.executeUpdate(s);
        			            if (rows_affected > 0) {
        			            	JOptionPane.showMessageDialog(btnAdd,"Successfully Added");
        			            	AddTutorsFrame.dispose();
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
        		btnAdd.setFont(new Font("Arial", Font.BOLD, 13));
        		btnAdd.setBounds(180, 395, 119, 21);
        		AddTutorsPanel.add(btnAdd);
        		
        		txtPassword = new JPasswordField();
        		txtPassword.setBounds(224, 307, 96, 19);
        		AddTutorsPanel.add(txtPassword);
        		
        		JLabel lblNewLabel_4 = new JLabel("Password:");
        		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 13));
        		lblNewLabel_4.setBounds(138, 310, 77, 13);
        		AddTutorsPanel.add(lblNewLabel_4);
        		
        		
            }
            
        });
        btnNewButton_7.setBounds(480, 118, 101, 25);
        btnNewButton_7.setFont(new Font("Arial", Font.BOLD, 13));
        contentPane.add(btnNewButton_7);

        JButton btnNewButton_7_1 = new JButton("Edit tutors");
        btnNewButton_7_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	JFrame EditTutorsFrame = new JFrame("Edit tutors");
            	EditTutorsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        		EditTutorsFrame.setBounds(600, 320, 480, 476);
        		JPanel EditTutorsPanel  = new JPanel();
        		EditTutorsPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        		EditTutorsFrame.setContentPane(EditTutorsPanel);
        		EditTutorsPanel.setLayout(null);
        		
        		JPanel panel = new JPanel();
        		panel.setBackground(new Color(255, 0, 0));
        		panel.setBounds(168, 60, 167, 39);
        		EditTutorsPanel.add(panel);
        		panel.setLayout(null);
        		
        		JLabel lblNewLabel = new JLabel("Edit Tutors");
        		lblNewLabel.setBounds(29, 0, 110, 39);
        		panel.add(lblNewLabel);
        		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
        		
        		JLabel lblNewLabel_1 = new JLabel("New Name:");
        		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
        		lblNewLabel_1.setBounds(115, 206, 87, 13);
        		EditTutorsPanel.add(lblNewLabel_1);
        		
        		txtUpdateName = new JTextField();
        		txtUpdateName.setBounds(201, 203, 119, 19);
        		EditTutorsPanel.add(txtUpdateName);
        		txtUpdateName.setColumns(10);
        		
        		JLabel lblNewLabel_2 = new JLabel("New Email\r\n:");
        		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
        		lblNewLabel_2.setBounds(115, 254, 87, 13);
        		EditTutorsPanel.add(lblNewLabel_2);
        		
        		txtUpdateEmail = new JTextField();
        		txtUpdateEmail.setBounds(201, 251, 119, 19);
        		EditTutorsPanel.add(txtUpdateEmail);
        		txtUpdateEmail.setColumns(10);
        		
        		JLabel lblNewLabel_3 = new JLabel("New Phone:");
        		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 13));
        		lblNewLabel_3.setBounds(115, 301, 87, 13);
        		EditTutorsPanel.add(lblNewLabel_3);
        		
        		txtUpdatePhone = new JTextField();
        		txtUpdatePhone.setBounds(201, 298, 119, 19);
        		EditTutorsPanel.add(txtUpdatePhone);
        		txtUpdatePhone.setColumns(10);
        		
        		txtUpdatePassword = new JPasswordField();
        		txtUpdatePassword.setBounds(201, 345, 119, 19);
        		EditTutorsPanel.add(txtUpdatePassword);
        		
        		JLabel lblNewLabel_4 = new JLabel("New Password:");
        		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 13));
        		lblNewLabel_4.setBounds(96, 348, 100, 13);
        		EditTutorsPanel.add(lblNewLabel_4);
        		
        		JLabel lblNewLabel_5 = new JLabel("TID:");
        		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 13));
        		lblNewLabel_5.setBounds(138, 159, 45, 13);
        		EditTutorsPanel.add(lblNewLabel_5);
        		
        		txtId = new JTextField();
        		txtId.setBounds(201, 156, 119, 19);
        		EditTutorsPanel.add(txtId);
        		txtId.setColumns(10);
        		
        		JButton btnUpdate = new JButton("Update\r\n");
        		btnUpdate.setFont(new Font("Arial", Font.BOLD, 13));
        		btnUpdate.setBounds(168, 409, 119, 21);
        		EditTutorsPanel.add(btnUpdate);
        		btnUpdate.addActionListener(new ActionListener() {
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
        				            
        				        	 JOptionPane.showMessageDialog(btnUpdate,"Please Enter the Id ");
        				    }
        			            
        			            else if(txtUpdateName.getText().isEmpty()) {
        			            
        			        	 JOptionPane.showMessageDialog(btnUpdate,"Please Enter the name to update");
        			    }
        			         
        			         else if(txtUpdateEmail.getText().isEmpty()) {
        			        	 JOptionPane.showMessageDialog(btnUpdate,"Please Enter the email to update");
        			         }
        			         
        			         else if(txtUpdatePhone.getText().isEmpty()) {
        			        	 JOptionPane.showMessageDialog(btnUpdate,"Please Enter the phone to update");
        			         }
        			         
        			         else if(txtUpdatePassword.getText().isEmpty()) {
        			        	 JOptionPane.showMessageDialog(btnUpdate,"Please Enter the password to update");
        			         }
        			        
        			        else {
        			        	
        		            	int value = Integer.parseInt(txtId.getText());

        		            	String s = "UPDATE `teachers` SET `Name`='" + txtUpdateName.getText().toLowerCase() + "', "
        		            	        + "`Email`='" + txtUpdateEmail.getText() + "', `Phone`='" + txtUpdatePhone.getText() + "', "
        		            	        + "`Password`='" + txtUpdatePassword.getText() + "', `Mode`='Tutor' WHERE `TID`=" + value;

        			            
        			            int rows_affected = stmt.executeUpdate(s);
        			            if (rows_affected > 0) {
        			            	JOptionPane.showMessageDialog(btnUpdate,"Successfully Updated");
        			            	EditTutorsFrame.dispose();
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
        		
        		EditTutorsFrame.setVisible(true);
            }
        });
        btnNewButton_7_1.setBounds(591, 118, 111, 25);
        btnNewButton_7_1.setFont(new Font("Arial", Font.BOLD, 13));
        contentPane.add(btnNewButton_7_1);

        JButton btnNewButton_7_2 = new JButton("Delete Tutors");
        btnNewButton_7_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	JFrame DeleteTutorsFrame = new JFrame("Delete Tutors");
            	DeleteTutorsFrame.setVisible(true);
            	DeleteTutorsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        		DeleteTutorsFrame.setBounds(600, 320, 406, 283);
        		JPanel DeleteTutorsPanel = new JPanel();
        		DeleteTutorsPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        		DeleteTutorsFrame.setContentPane(DeleteTutorsPanel);
        		DeleteTutorsPanel.setLayout(null);
        		
        		textField = new JTextField();
        		textField.setBounds(176, 126, 96, 19);
        		DeleteTutorsPanel.add(textField);
        		textField.setColumns(10);
        		
        		JLabel lblNewLabel_1 = new JLabel("Enter the ID:");
        		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
        		lblNewLabel_1.setBounds(81, 128, 96, 13);
        		DeleteTutorsPanel.add(lblNewLabel_1);
        		
        		JButton btnDelete = new JButton("Delete");
        		btnDelete.addActionListener(new ActionListener() {
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
        			            
        			         if(textField.getText().isEmpty()) {
        			            
        			        	 JOptionPane.showMessageDialog(btnDelete,"Please Enter the ID");
        			    }
        			        
        			        else {
        			        	
        		            	int value = Integer.parseInt(textField.getText());
        			            String s = "DELETE FROM teachers WHERE TID = "+value;
        			            int rows_affected = stmt.executeUpdate(s);
        			            if (rows_affected > 0) {
        			            	JOptionPane.showMessageDialog(btnDelete,"Successfully deleted");
        			            	DeleteTutorsFrame.dispose();
        			            } else {
        			            	JOptionPane.showMessageDialog(btnDelete,"No record found with TID:"+value);
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
        		btnDelete.setBounds(144, 177, 85, 21);
        		DeleteTutorsPanel.add(btnDelete);
        		
        		JPanel panel = new JPanel();
        		panel.setBackground(new Color(255, 0, 0));
        		panel.setBounds(106, 54, 179, 19);
        		DeleteTutorsPanel.add(panel);
        		panel.setLayout(null);
        		
        		JLabel lblNewLabel = new JLabel("Delete Tutor");
        		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
        		lblNewLabel.setBounds(20, 0, 205, 20);
        		panel.add(lblNewLabel);
            }
        });
        btnNewButton_7_2.setBounds(712, 118, 120, 25);
        btnNewButton_7_2.setFont(new Font("Arial", Font.BOLD, 13));
        contentPane.add(btnNewButton_7_2);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(259, 187, 593, 424);
        contentPane.add(scrollPane);

        tableData1 = new JTable();
        tableData1.setRowSelectionAllowed(false);
        tableData1.setEnabled(false);
        scrollPane.setViewportView(tableData1);

        JSeparator separator_3 = new JSeparator();
        separator_3.setBounds(233, 95, 631, 552);
        contentPane.add(separator_3);

        loadAllStudentData();
    }

    private void loadAllStudentData() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/student";
        String username = "root";
        String passkey = "";

        DefaultTableModel model = (DefaultTableModel) tableData1.getModel();
        model.setRowCount(0); // Clear previous search results

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(jdbcUrl, username, passkey);
                 Statement stmt = connection.createStatement()) {
                loadActivityData(stmt);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            System.out.println("Database connection failed!");
        }
    }

    private void updateSearchResults() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/student";
        String username = "root";
        String passkey = "";

        DefaultTableModel model = (DefaultTableModel) tableData1.getModel();
        model.setRowCount(0); // Clear previous search results
        String searchText = txtSearch.getText().trim();
        if (!searchText.isEmpty()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                try (Connection connection = DriverManager.getConnection(jdbcUrl, username, passkey);
                     Statement stmt = connection.createStatement()) {
                    loadSearchActivityData(stmt, searchText);
                }
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
                System.out.println("Database connection failed!");
            }
        } else {
            loadAllStudentData(); // If search text is empty, load all student data
        }
    }

    private void loadActivityData(Statement stmt) throws SQLException {
        String query = "select TID ,Name , Email, Phone from teachers";
        try (ResultSet rs = stmt.executeQuery(query)) {
            ResultSetMetaData rsmd = rs.getMetaData();
            DefaultTableModel model = (DefaultTableModel) tableData1.getModel();

            String[] colName = new String[4];
            for (int i = 0; i < 4; i++) {
                colName[i] = rsmd.getColumnName(i + 1);
            }
            model.setColumnIdentifiers(colName);

            String TID, Name, Email, Phone;
            while (rs.next()) {
                TID = rs.getString(1);
                Name = rs.getString(2);
                Email = rs.getString(3);
                Phone = rs.getString(4);
                String[] row = {TID, Name, Email, Phone};
                model.addRow(row);
            }
            tableData1.getColumnModel().getColumn(0).setMinWidth(10);
            tableData1.getColumnModel().getColumn(0).setMaxWidth(30);
            tableData1.getColumnModel().getColumn(1).setMinWidth(60);
            tableData1.getColumnModel().getColumn(1).setMaxWidth(80);
        }
    }

    private void loadSearchActivityData(Statement stmt, String searchText) throws SQLException {
        String query = "select TID ,Name , Email, Phone from teachers WHERE Name = '" + searchText + "'";
        try (ResultSet rs = stmt.executeQuery(query)) {
            ResultSetMetaData rsmd = rs.getMetaData();
            DefaultTableModel model = (DefaultTableModel) tableData1.getModel();

            String[] colName = new String[4];
            for (int i = 0; i < 4; i++) {
                colName[i] = rsmd.getColumnName(i + 1);
            }
            model.setColumnIdentifiers(colName);

            String TID, Name, Email, Phone;
            while (rs.next()) {
                TID = rs.getString(1);
                Name = rs.getString(2);
                Email = rs.getString(3);
                Phone = rs.getString(4);
                String[] row = {TID, Name, Email, Phone};
                model.addRow(row);
            }
            tableData1.getColumnModel().getColumn(0).setMinWidth(10);
            tableData1.getColumnModel().getColumn(0).setMaxWidth(30);
            tableData1.getColumnModel().getColumn(1).setMinWidth(60);
            tableData1.getColumnModel().getColumn(1).setMaxWidth(80);
        }
    }
}
