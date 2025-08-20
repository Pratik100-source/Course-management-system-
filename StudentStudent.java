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
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class StudentStudent extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable tableData1;
	private JTextArea txtSearch;
	
	private JTextField txtSem;
	private JTextField txtLevel;
	private JTextField txtSubject;
	private JTextField textField;
	private JTextField textField_4;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentStudent frame = new StudentStudent("","","");
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
	public StudentStudent(String level, String course, String login_name) {
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
				StudentSetting ssetting = new StudentSetting(level,course,login_name);
				ssetting.show();
				dispose();
			}
		});
		btnSetting.setBackground(new Color(235, 235, 235));
		btnSetting.setBounds(75, 430, 137, 39);
		btnSetting.setFont(new Font("Arial", Font.BOLD, 15));
		contentPane.add(btnSetting);
		
		JLabel lblHome = new JLabel("");
		lblHome.setBackground(new Color(255, 255, 255));
		lblHome.setBounds(72, 37, 150, 145);
		contentPane.add(lblHome);
		Image img = new ImageIcon(this.getClass().getResource("/home (2).png")).getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);;;
		lblHome.setIcon(new ImageIcon(img));
		
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
				StudentDashboard sdash = new StudentDashboard(level,course, login_name);
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
		
		JLabel lblNewLabel = new JLabel("Student");
		lblNewLabel.setBounds(259, 49, 87, 25);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(lblNewLabel);
		
	     txtSearch = new JTextArea();
		txtSearch.setBounds(254, 118, 212, 25);
		txtSearch.setFont(new Font("Monospaced", Font.PLAIN, 16));
		contentPane.add(txtSearch);
		
		txtSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateSearchResults(course, level);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateSearchResults(course, level);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateSearchResults(course, level);
            }
        });
		
		
        JButton btnNewButton_7 = new JButton("View Progress");
        btnNewButton_7.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		JFrame ViewProgressFrame = new JFrame();
        		ViewProgressFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		
        		ViewProgressFrame.setBounds(100, 100, 352, 324);
        		ViewProgressFrame.setLocation(500,300);
        		JPanel ViewProgressPanel  = new JPanel();
        		ViewProgressPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        		ViewProgressFrame.setContentPane(ViewProgressPanel);
        		ViewProgressPanel.setLayout(null);
        		
        		ViewProgressFrame.setVisible(true);
        		
        		txtLevel = new JTextField();
        		txtLevel.setColumns(10);
        		txtLevel.setBounds(105, 71, 119, 23);
        		ViewProgressPanel.add(txtLevel);
        		
        		txtSem = new JTextField();
        		txtSem.setColumns(10);
        		txtSem.setBounds(105, 126, 119, 23);
        		ViewProgressPanel.add(txtSem);
        		
        		JLabel lblLevel = new JLabel("Level:");
        		lblLevel.setFont(new Font("Arial", Font.BOLD, 13));
        		lblLevel.setBounds(48, 71, 62, 23);
        		ViewProgressPanel.add(lblLevel);
        		
        		JLabel lblSem = new JLabel("Sem:");
        		lblSem.setFont(new Font("Arial", Font.BOLD, 13));
        		lblSem.setBounds(63, 126, 62, 23);
        		ViewProgressPanel.add(lblSem);
        		
        		txtSubject = new JTextField();
        		txtSubject.setColumns(10);
        		txtSubject.setBounds(105, 173, 119, 23);
        		ViewProgressPanel.add(txtSubject);
        		
        		JLabel lblSubject = new JLabel("Subject:");
        		lblSubject.setFont(new Font("Arial", Font.BOLD, 13));
        		lblSubject.setBounds(48, 173, 62, 23);
        		ViewProgressPanel.add(lblSubject);
        		
        	
        		
        		JButton btnProgress = new JButton("View Progress");
        		btnProgress.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				
        		    
                         if(txtLevel.getText().isEmpty()) {
        					
        					JOptionPane.showMessageDialog(btnProgress,"Please Enter the level");
        				}
                         else if(txtSem.getText().isEmpty()) {
        					
        					JOptionPane.showMessageDialog(btnProgress,"Please Enter the semester");
        				}
                         else if(txtSubject.getText().isEmpty()) {
                        	 JOptionPane.showMessageDialog(btnProgress,"Please Enter the subject");
                         }
//        			    
                         else {
                        	 
                        	 StudentProgress stp = new StudentProgress(); 
                             stp.display(login_name,txtLevel.getText(),txtSem.getText(),txtSubject.getText().toLowerCase());
                             stp.show();
                             ViewProgressFrame.setVisible(false);
                     	}
                     	
                     		
        			}
        		});
        		btnProgress.setBounds(92, 217, 106, 21);
        		ViewProgressPanel.add(btnProgress);
        		
        		
        		
        	}
        });
        btnNewButton_7.setBounds(476, 118, 127, 26);
		btnNewButton_7.setFont(new Font("Arial", Font.BOLD, 13));
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_7_1 = new JButton("Edit Student");
		btnNewButton_7_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(btnNewButton_7_1,"Sorry! You do not have access to this");
				
			}
		});
		btnNewButton_7_1.setBounds(613, 118, 111, 25);
		btnNewButton_7_1.setFont(new Font("Arial", Font.BOLD, 13));
		contentPane.add(btnNewButton_7_1);
		
		JButton btnNewButton_7_2 = new JButton("Delete Student");
		btnNewButton_7_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(btnNewButton_7_2,"Sorry! You do not have access to this");
				
			}
		});
		btnNewButton_7_2.setBounds(734, 118, 127, 25);
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
		
		
		
		loadAllStudentData(course,level); // Load all student data initially
	}
	
	private void loadAllStudentData(String course, String level) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/student";
        String username = "root";
        String passkey = "";

        DefaultTableModel model = (DefaultTableModel) tableData1.getModel();
        model.setRowCount(0); // Clear previous search results
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(jdbcUrl, username, passkey);
                 Statement stmt = connection.createStatement()) {
                loadActivityData(stmt,course,level);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            System.out.println("Database connection failed!");
        }
    }

    private void updateSearchResults(String course, String level) {
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
                    loadSearchActivityData(stmt, searchText,course,level);
                }
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
                System.out.println("Database connection failed!");
            }
        } else {
            loadAllStudentData("",""); // If search text is empty, load all student data
        }
    }

    private void loadActivityData(Statement stmt,String course, String level) throws SQLException {
    	String query = "select SID, Name, Email, Phone from stds WHERE Course='" + course + "' AND Level='" + level + "'";
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

    private void loadSearchActivityData(Statement stmt, String searchText,String course, String level) throws SQLException {
    	String query = "select SID, Name, Email, Phone from stds WHERE Name='" + searchText + "' AND Level='" + level + "' AND Course='" + course + "'";
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
    
