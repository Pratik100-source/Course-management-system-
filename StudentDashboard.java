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

public class StudentDashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableData;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
    private	int count1;
    private int count2;
    private int count3;
    
    
    private String level;
    private String course;
    private String login_name;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentDashboard frame = new StudentDashboard("","","");
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
	public StudentDashboard(String level, String course, String login_name) {
		this.level = level;
		this.course = course;
		this.login_name = login_name;
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
		btnCourses.setBackground(new Color(235, 235, 235));
		btnCourses.setBounds(75, 247, 137, 39);
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
		btnTutors.setBackground(new Color(235, 235, 235));
		btnTutors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StudentTeacher steacher = new StudentTeacher(level,course,login_name);
				steacher.show();
				dispose();
			}
		});
		btnTutors.setBounds(75, 309, 137, 39);
		btnTutors.setFont(new Font("Arial", Font.BOLD, 15));
		contentPane.add(btnTutors);
		
		JButton btnStudents = new JButton("Students");
		btnStudents.setBackground(new Color(235, 235, 235));
		btnStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StudentStudent sstudent = new StudentStudent(level, course, login_name);
				sstudent.show();
				dispose();
			}
		});
		btnStudents.setBounds(75, 368, 137, 39);
		btnStudents.setFont(new Font("Arial", Font.BOLD, 15));
		contentPane.add(btnStudents);
		
		JButton btnSetting = new JButton("Setting");
		btnSetting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentSetting ssetting = new StudentSetting(level,course,login_name);
				ssetting.show();
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
				lg.show();
				dispose();
			}
		});
		btnLogout.setBackground(new Color(235, 235, 235));
		btnLogout.setBounds(75, 491, 137, 39);
		btnLogout.setFont(new Font("Arial", Font.BOLD, 15));
		contentPane.add(btnLogout);
		
		JButton btnDashboard = new JButton("Dashboard");
		btnDashboard.setBounds(75, 187, 137, 39);
		btnDashboard.setBackground(new Color(255, 128, 128));
		btnDashboard.setFont(new Font("Arial", Font.BOLD, 15));
		contentPane.add(btnDashboard);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(232, 37, 709, 39);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel = new JLabel("Student");
		lblNewLabel.setBounds(259, 49, 87, 25);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Activities History");
		lblNewLabel_1.setBounds(269, 218, 142, 13);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(269, 242, 452, 289);
		contentPane.add(scrollPane);
		
		tableData = new JTable();
		tableData.setFillsViewportHeight(true);
		tableData.setBackground(new Color(235, 235, 235));
		tableData.setShowHorizontalLines(false);
		tableData.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		tableData.setEnabled(false);
		tableData.setRowSelectionAllowed(false);
		scrollPane.setViewportView(tableData);
		
		JLabel lblHome = new JLabel("");
		lblHome.setBackground(new Color(255, 255, 255));
		lblHome.setBounds(72, 37, 150, 145);
		contentPane.add(lblHome);
		Image img = new ImageIcon(this.getClass().getResource("/home (2).png")).getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);;;
		lblHome.setIcon(new ImageIcon(img));
		
		panel = new JPanel();
		panel.setBackground(new Color(235, 235, 235));
		panel.setBounds(269, 98, 139, 90);
		panel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Total Courses");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 10, 103, 13);
		panel.add(lblNewLabel_2);
	    

	    
		
	    panel_1 = new JPanel();
	    panel_1.setBackground(new Color(235, 235, 235));
	    panel_1.setBounds(431, 98, 139, 90);
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Total Teachers");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(10, 10, 103, 13);
		panel_1.add(lblNewLabel_2_1);
		
		
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(235, 235, 235));
		panel_2.setBounds(593, 98, 139, 90);
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		contentPane.add(panel_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("Total Students");
		lblNewLabel_2_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(10, 10, 104, 13);
		panel_2.add(lblNewLabel_2_2);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(232, 84, 709, 117);
		contentPane.add(separator_1_1);
		
		
		
		
		
		
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            String jdbcUrl = "jdbc:mysql://localhost:3306/student";
            String username = "root";
            String passkey = "";
            try (Connection connection = DriverManager.getConnection(jdbcUrl, username, passkey)) {

                // Create statement/Query
                try (Statement stmt = connection.createStatement()) {
                    // Check if the connection is successful
                    if (connection != null) {
                        System.out.println("Database connection is successful!");
                        loadActivityData(stmt);
                        loadCourseCount(stmt);
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            // Handle exceptions
            e.printStackTrace();
            System.out.println("Database connection failed!");
        }
    }

    private void loadActivityData(Statement stmt) throws SQLException {
        String query = "select * from activity";
        try (ResultSet rs = stmt.executeQuery(query)) {
            ResultSetMetaData rsmd = rs.getMetaData();
            DefaultTableModel model = (DefaultTableModel) tableData.getModel();

            int cols = rsmd.getColumnCount();
            String[] colName = new String[cols];
            for (int i = 0; i < cols; i++) {
                colName[i] = rsmd.getColumnName(i + 1);
                model.setColumnIdentifiers(colName);
            }

            String AID, ActivityName;
            while (rs.next()) {
                AID = rs.getString(1);
                ActivityName = rs.getString(2);
                String[] row = {AID, ActivityName};
                model.addRow(row);
                tableData.getColumnModel().getColumn(0).setMinWidth(10);
                tableData.getColumnModel().getColumn(0).setMaxWidth(30);
                
            }
        }
    }

    private void loadCourseCount(Statement stmt) throws SQLException {
    	String query1 = "select count(*) from course";
        String query2 = "select count(*) from teachers";
        String query3 = "select count(*) from stds";


      
        try (ResultSet rs1 = stmt.executeQuery(query1)) {
            rs1.next();
            count1 = rs1.getInt(1);
        }

        try (ResultSet rs2 = stmt.executeQuery(query2)) {
            rs2.next();
            count2 = rs2.getInt(1);
        }
        try (ResultSet rs3 = stmt.executeQuery(query3)) {
            rs3.next();
            count3 = rs3.getInt(1);
        }

        
//        return count1;
        JLabel lblCount1 = new JLabel(String.valueOf(count1));
	    lblCount1.setFont(new Font("Arial", Font.BOLD, 30));
		lblCount1.setBounds(20, 33, 45, 46);
		panel.add(lblCount1);
		
		JLabel lblCount2 = new JLabel(String.valueOf(count2));
		lblCount2.setFont(new Font("Arial", Font.BOLD, 30));
		lblCount2.setBounds(20, 33, 45, 46);
		panel_1.add(lblCount2);
		
		JLabel lblCount3 = new JLabel(String.valueOf(count3));
		lblCount3.setFont(new Font("Arial", Font.BOLD, 30));
		lblCount3.setBounds(20, 33, 45, 46);
		panel_2.add(lblCount3);

        
        

    }
}
