package Final_assessment;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class TeacherStudent extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable tableData1;
	private JTextArea txtSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherStudent frame = new TeacherStudent("");
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
	public TeacherStudent(String course) {
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
				TeacherCourse tcourse = new TeacherCourse(course);
			    tcourse.show();
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
				
				TeacherTeacher tteacher = new TeacherTeacher(course);
				tteacher.show();
				dispose();
			}
		});
		btnTutors.setBounds(75, 309, 137, 39);
		btnTutors.setFont(new Font("Arial", Font.BOLD, 15));
		contentPane.add(btnTutors);
		
		JLabel lblHome = new JLabel("");
		lblHome.setBackground(new Color(255, 255, 255));
		lblHome.setBounds(72, 37, 150, 145);
		contentPane.add(lblHome);
		Image img = new ImageIcon(this.getClass().getResource("/home (2).png")).getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);;;
		lblHome.setIcon(new ImageIcon(img));
		
		JButton btnStudents = new JButton("Students");
		btnStudents.setBackground(new Color(255, 128, 128));
		btnStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnStudents.setBounds(75, 368, 137, 39);
		btnStudents.setFont(new Font("Arial", Font.BOLD, 15));
		contentPane.add(btnStudents);
		
		JButton btnSetting = new JButton("Setting");
		btnSetting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherSetting tset = new TeacherSetting(course);
				tset.show();
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
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TeacherDashboard tdash = new TeacherDashboard(course);
				tdash.show();
			}
		});
		btnDashboard.setBounds(75, 187, 137, 39);
		btnDashboard.setBackground(new Color(235, 235, 235));
		btnDashboard.setFont(new Font("Arial", Font.BOLD, 15));
		contentPane.add(btnDashboard);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(232, 37, 709, 39);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel = new JLabel("Students");
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
                updateSearchResults(course);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateSearchResults(course);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateSearchResults(course);
            }
        });
		
        JButton btnNewButton_7 = new JButton("View Progress");
        btnNewButton_7.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		JOptionPane.showMessageDialog(btnNewButton_7,"Sorry! You do not have access to this");
        	}
        });
        btnNewButton_7.setBounds(480, 117, 130, 25);
		btnNewButton_7.setFont(new Font("Arial", Font.BOLD, 13));
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_7_1 = new JButton("Edit Student");
		btnNewButton_7_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(btnNewButton_7_1,"Sorry! You do not have access to this");
				
			}
		});
		btnNewButton_7_1.setBounds(620, 117, 111, 26);
		btnNewButton_7_1.setFont(new Font("Arial", Font.BOLD, 13));
		contentPane.add(btnNewButton_7_1);
		
		JButton btnNewButton_7_2 = new JButton("Delete Student");
		btnNewButton_7_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(btnNewButton_7_2,"Sorry! You do not have access to this");
				
			}
		});
		btnNewButton_7_2.setBounds(738, 118, 126, 25);
		btnNewButton_7_2.setFont(new Font("Arial", Font.BOLD, 13));
		contentPane.add(btnNewButton_7_2);
	
		
		table = new JTable();
		table.setBounds(420, 245, 1, 1);
		contentPane.add(table);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(259, 647, 683, 0);
		contentPane.add(separator_2);
		
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
		
		
		
		loadAllStudentData(course); // Load all student data initially
		}
		
		private void loadAllStudentData(String course) {
	        String jdbcUrl = "jdbc:mysql://localhost:3306/student";
	        String username = "root";
	        String passkey = "";

	        DefaultTableModel model = (DefaultTableModel) tableData1.getModel();
	        model.setRowCount(0); // Clear previous search results
	        
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            try (Connection connection = DriverManager.getConnection(jdbcUrl, username, passkey);
	                 Statement stmt = connection.createStatement()) {
	                loadActivityData(stmt,course);
	            }
	        } catch (ClassNotFoundException | SQLException ex) {
	            ex.printStackTrace();
	            System.out.println("Database connection failed!");
	        }
	    }

	    private void updateSearchResults(String course) {
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
	                    loadSearchActivityData(stmt, searchText,course);
	                }
	            } catch (ClassNotFoundException | SQLException ex) {
	                ex.printStackTrace();
	                System.out.println("Database connection failed!");
	            }
	        } else {
	            loadAllStudentData(course); // If search text is empty, load all student data
	        }
	    }

	    private void loadActivityData(Statement stmt,String course) throws SQLException {
	        String query = "select SID ,Name , Email, Phone from stds WHERE Course = '"+course+"'";
	        try (ResultSet rs = stmt.executeQuery(query)) {
	            ResultSetMetaData rsmd = rs.getMetaData();
	            DefaultTableModel model = (DefaultTableModel) tableData1.getModel();

	            String[] colName = new String[4];
	            for (int i = 0; i < 4; i++) {
	                colName[i] = rsmd.getColumnName(i + 1);
	                model.setColumnIdentifiers(colName);
	            }

	            String SID, Name, Email, Phone;
	            while (rs.next()) {
	                SID = rs.getString(1);
	                Name = rs.getString(2);
	                Email = rs.getString(3);
	                Phone = rs.getString(4);
	                String[] row = {SID, Name, Email, Phone};
	                model.addRow(row);
	                tableData1.getColumnModel().getColumn(0).setMinWidth(10);
	                tableData1.getColumnModel().getColumn(0).setMaxWidth(30);
	                tableData1.getColumnModel().getColumn(1).setMinWidth(60);
	                tableData1.getColumnModel().getColumn(1).setMaxWidth(80);

	            }
	        }
	    }

	    private void loadSearchActivityData(Statement stmt, String searchText,String course) throws SQLException {
	        String query = "select SID ,Name , Email, Phone from stds WHERE Name = '"+searchText+"',AND Course ='"+course+"'";
	        try (ResultSet rs = stmt.executeQuery(query)) {
	            ResultSetMetaData rsmd = rs.getMetaData();
	            DefaultTableModel model = (DefaultTableModel) tableData1.getModel();

	            String[] colName = new String[4];
	            for (int i = 0; i < 4; i++) {
	                colName[i] = rsmd.getColumnName(i + 1);
	                model.setColumnIdentifiers(colName);
	            }

	            String SID, Name, Email, Phone;
	            while (rs.next()) {
	                SID = rs.getString(1);
	                Name = rs.getString(2);
	                Email = rs.getString(3);
	                Phone = rs.getString(4);
	                String[] row = {SID, Name, Email, Phone};
	                model.addRow(row);
	                tableData1.getColumnModel().getColumn(0).setMinWidth(10);
	                tableData1.getColumnModel().getColumn(0).setMaxWidth(30);
	                tableData1.getColumnModel().getColumn(1).setMinWidth(60);
	                tableData1.getColumnModel().getColumn(1).setMaxWidth(80);
	            }
	        }
	    }
	}
    
