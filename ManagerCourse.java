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

public class ManagerCourse extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable tableData1;
    private JTextArea txtSearch;
    private JTextField txtCourseName;
	private JTextField txtSeats;
	private JTextField txtYears;
	
	private JTextField txtUpdateCourseName;
	private JTextField txtUpdateSeats;
	private JTextField txtUpdateYears;
	private JTextField txtId;
	
	private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ManagerCourse frame = new ManagerCourse();
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
    public ManagerCourse() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 723);
        setLocation(340, 80);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(192, 192, 192));
        contentPane.setForeground(new Color(0, 0, 0));
        contentPane.setBorder(new LineBorder(new Color(128, 128, 128)));

        setContentPane(contentPane);

        JButton btnCourses = new JButton("Courses");
        btnCourses.setBackground(new Color(255, 128, 128));
       
        btnCourses.setBounds(75, 247, 137, 39);
        btnCourses.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        contentPane.setLayout(null);
        btnCourses.setFont(new Font("Arial", Font.BOLD, 15));
        contentPane.add(btnCourses);

        JButton btnTutors = new JButton("Tutors");
        btnTutors.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ManagerTeacher mteacher = new ManagerTeacher();
        		mteacher.show();
        		dispose();
        	}
        });
        btnTutors. setBackground(new Color(235, 235, 235));
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

        JLabel lblNewLabel = new JLabel("Course");
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

        JButton btnNewButton_7 = new JButton("Add Course");
        btnNewButton_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	JFrame AddCourseFrame = new JFrame("Add Course");
            	AddCourseFrame.setVisible(true);
            	AddCourseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        		AddCourseFrame.setBounds(600, 320, 442, 422);
        		JPanel AddCoursePanel = new JPanel();
        		AddCoursePanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        		AddCourseFrame.setContentPane(AddCoursePanel);
        		AddCoursePanel.setLayout(null);
        		
        		JPanel panel = new JPanel();
        		panel.setBackground(new Color(255, 0, 0));
        		panel.setBounds(168, 60, 167, 39);
        		AddCoursePanel.add(panel);
        		panel.setLayout(null);
        		
        		JLabel lblNewLabel = new JLabel("Add Course");
        		lblNewLabel.setBounds(29, 0, 110, 39);
        		panel.add(lblNewLabel);
        		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
        		
        		JLabel lblNewLabel_1 = new JLabel("Course Name:");
        		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
        		lblNewLabel_1.setBounds(95, 145, 88, 13);
        		AddCoursePanel.add(lblNewLabel_1);
        		
        		txtCourseName = new JTextField();
        		txtCourseName.setBounds(224, 142, 96, 19);
        		AddCoursePanel.add(txtCourseName);
        		txtCourseName.setColumns(10);
        		
        		JLabel lblNewLabel_2 = new JLabel("Seats:");
        		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
        		lblNewLabel_2.setBounds(138, 202, 45, 13);
        		AddCoursePanel.add(lblNewLabel_2);
        		
        		txtSeats = new JTextField();
        		txtSeats.setBounds(224, 199, 96, 19);
        		AddCoursePanel.add(txtSeats);
        		txtSeats.setColumns(10);
        		
        		JLabel lblNewLabel_3 = new JLabel("Years:");
        		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 13));
        		lblNewLabel_3.setBounds(138, 259, 45, 13);
        		AddCoursePanel.add(lblNewLabel_3);
        		
        		txtYears = new JTextField();
        		txtYears.setBounds(224, 256, 96, 19);
        		AddCoursePanel.add(txtYears);
        		txtYears.setColumns(10);
        		
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
        			            
        			         if(txtCourseName.getText().isEmpty()) {
        			            
        			        	 JOptionPane.showMessageDialog(btnAdd,"Please Enter the name of Course");
        			    }
        			         
        			         else if(txtSeats.getText().isEmpty()) {
        			        	 JOptionPane.showMessageDialog(btnAdd,"Please Enter the no of Seats");
        			         }
        			         
        			         else if(txtYears.getText().isEmpty()) {
        			        	 JOptionPane.showMessageDialog(btnAdd,"Please Enter the duration");
        			         }
        			       
        			        
        			        else {
        			        	
        			            String s = "INSERT INTO course (CID, CourseName, Seats, Years) " +
        			        	           "VALUES (NOT NULL,'" + txtCourseName.getText().toUpperCase() + "','" + txtSeats.getText() + "','" + txtYears.getText()+"')";
        			            
        			            int rows_affected = stmt.executeUpdate(s);
        			            if (rows_affected > 0) {
        			            	JOptionPane.showMessageDialog(btnAdd,"Successfully Added");
        			            	AddCourseFrame.dispose();
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
        		btnAdd.setBounds(168, 314, 119, 21);
        		AddCoursePanel.add(btnAdd);
            }
        });
        btnNewButton_7.setBounds(480, 118, 112, 25);
        btnNewButton_7.setFont(new Font("Arial", Font.BOLD, 13));
        contentPane.add(btnNewButton_7);

        JButton btnNewButton_7_1 = new JButton("Edit Course");
        btnNewButton_7_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	JFrame EditCourseFrame = new JFrame("Edit Course");
            	EditCourseFrame.setVisible(true);
            	EditCourseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        		EditCourseFrame.setBounds(600, 320, 480, 451);
        		JPanel EditCoursePanel = new JPanel();
        		EditCoursePanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        		EditCourseFrame.setContentPane(EditCoursePanel);
        		EditCoursePanel.setLayout(null);
        		
        		JPanel panel = new JPanel();
        		panel.setBackground(new Color(255, 0, 0));
        		panel.setBounds(168, 60, 167, 39);
        		EditCoursePanel.add(panel);
        		panel.setLayout(null);
        		
        		JLabel lblNewLabel = new JLabel("Edit Course");
        		lblNewLabel.setBounds(29, 0, 110, 39);
        		panel.add(lblNewLabel);
        		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
        		
        		JLabel lblNewLabel_1 = new JLabel("New Name:");
        		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
        		lblNewLabel_1.setBounds(115, 206, 87, 13);
        		EditCoursePanel.add(lblNewLabel_1);
        		
        		txtUpdateCourseName = new JTextField();
        		txtUpdateCourseName.setBounds(201, 203, 119, 19);
        		EditCoursePanel.add(txtUpdateCourseName);
        		txtUpdateCourseName.setColumns(10);
        		
        		JLabel lblNewLabel_2 = new JLabel("New Seats:");
        		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
        		lblNewLabel_2.setBounds(115, 254, 87, 13);
        		EditCoursePanel.add(lblNewLabel_2);
        		
        		txtUpdateSeats = new JTextField();
        		txtUpdateSeats.setBounds(201, 251, 119, 19);
        		EditCoursePanel.add(txtUpdateSeats);
        		txtUpdateSeats.setColumns(10);
        		
        		JLabel lblNewLabel_3 = new JLabel("New Years:");
        		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 13));
        		lblNewLabel_3.setBounds(115, 301, 87, 13);
        		EditCoursePanel.add(lblNewLabel_3);
        		
        		txtUpdateYears = new JTextField();
        		txtUpdateYears.setBounds(201, 298, 119, 19);
        		EditCoursePanel.add(txtUpdateYears);
        		txtUpdateYears.setColumns(10);
        		
        		JLabel lblNewLabel_5 = new JLabel("CID:");
        		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 13));
        		lblNewLabel_5.setBounds(138, 159, 45, 13);
        		EditCoursePanel.add(lblNewLabel_5);
        		
        		txtId = new JTextField();
        		txtId.setBounds(201, 156, 119, 19);
        		EditCoursePanel.add(txtId);
        		txtId.setColumns(10);
        		
        		JButton btnUpdate = new JButton("Update\r\n");
        		btnUpdate.setFont(new Font("Arial", Font.BOLD, 13));
        		btnUpdate.setBounds(175, 355, 119, 21);
        		EditCoursePanel.add(btnUpdate);
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
        				            
        				        	 JOptionPane.showMessageDialog(btnUpdate,"Please Enter the CID");
        				    }
        			            
        			            else if(txtUpdateCourseName.getText().isEmpty()) {
        			            
        			        	 JOptionPane.showMessageDialog(btnUpdate,"Please Enter the Course Name");
        			    }
        			         
        			         else if(txtUpdateSeats.getText().isEmpty()) {
        			        	 JOptionPane.showMessageDialog(btnUpdate,"Please Enter the no of seats");
        			         }
        			         
        			         else if(txtUpdateYears.getText().isEmpty()) {
        			        	 JOptionPane.showMessageDialog(btnUpdate,"Please Enter the duration");
        			         }
        			            
        			        else {
        			        	
        		            	int value = Integer.parseInt(txtId.getText());			            
        			            
        		            	String s = "UPDATE `course` SET `CourseName`='" + txtUpdateCourseName.getText().toUpperCase() + "', "
        		            	        + "`Seats`='" + txtUpdateSeats.getText() + "', `Years`='" + txtUpdateYears.getText() + "' WHERE `CID`=" + value;

        			            
        			            int rows_affected = stmt.executeUpdate(s);
        			            if (rows_affected > 0) {
        			            	JOptionPane.showMessageDialog(btnUpdate,"Successfully Updated");
        			            	EditCourseFrame.dispose();
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
        });
        btnNewButton_7_1.setBounds(602, 118, 111, 25);
        btnNewButton_7_1.setFont(new Font("Arial", Font.BOLD, 13));
        contentPane.add(btnNewButton_7_1);

        JButton btnNewButton_7_2 = new JButton("Delete Course");
        btnNewButton_7_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	JFrame DeleteCourseFrame = new JFrame("Delete Course");
            	DeleteCourseFrame.setVisible(true);
            	DeleteCourseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        		DeleteCourseFrame.setBounds(600, 320, 406, 283);
        		JPanel DeleteCoursePanel = new JPanel();
        		DeleteCoursePanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        		DeleteCourseFrame.setContentPane(DeleteCoursePanel);
        		DeleteCoursePanel.setLayout(null);
        		
        		textField = new JTextField();
        		textField.setBounds(176, 126, 96, 19);
        		DeleteCoursePanel.add(textField);
        		textField.setColumns(10);
        		
        		JLabel lblNewLabel_1 = new JLabel("Enter the ID:");
        		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
        		lblNewLabel_1.setBounds(81, 128, 96, 13);
        		DeleteCoursePanel.add(lblNewLabel_1);
        		
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
        			            String s = "DELETE FROM course WHERE CID = "+value;
        			            int rows_affected = stmt.executeUpdate(s);
        			            if (rows_affected > 0) {
        			            	JOptionPane.showMessageDialog(btnDelete,"Successfully deleted");
        			            	DeleteCourseFrame.dispose();
        			            } else {
        			            	JOptionPane.showMessageDialog(btnDelete,"No record found with CID:"+value);
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
        		DeleteCoursePanel.add(btnDelete);
        		
        		JPanel panel = new JPanel();
        		panel.setBackground(new Color(255, 0, 0));
        		panel.setBounds(106, 54, 179, 19);
        		DeleteCoursePanel.add(panel);
        		panel.setLayout(null);
        		
        		JLabel lblNewLabel = new JLabel("Delete Course");
        		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
        		lblNewLabel.setBounds(20, 0, 205, 20);
        		panel.add(lblNewLabel);
            }
        });
        btnNewButton_7_2.setBounds(721, 118, 120, 25);
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
        String query = "select CID ,CourseName , Seats, Years from course";
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
        String query = "select CID ,CourseName , Seats, Years from course WHERE CourseName = '" + searchText + "'";
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
