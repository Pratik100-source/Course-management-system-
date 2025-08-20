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
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTabbedPane;
import javax.swing.JSlider;
import javax.swing.JPasswordField;
import java.awt.Label;

interface Setting {
    void changePassword();
}

public class ManagerSetting extends JFrame implements Setting {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPasswordField passwordField;
    private JPasswordField passwordField_1;

    private JTextField txtName;
    private JTextField txtCourse;
    private JTextField txtLevel;
    private JTextField txtSem;
    private JButton btnView;
    private JButton btnPrint;
    private JFrame resultFrame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ManagerSetting frame = new ManagerSetting();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    // panel = new JPanel();
    /**
     * Create the frame.
     */
    public ManagerSetting() {
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
                ManagerCourse mcourse = new ManagerCourse();
                mcourse.show();
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

                ManagerTeacher mteacher = new ManagerTeacher();
                mteacher.show();
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

                ManagerStudent mstudent = new ManagerStudent();
                mstudent.show();
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
                ManagerDashboard mdash = new ManagerDashboard();
                mdash.show();
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
        Image img = new ImageIcon(this.getClass().getResource("/home (2).png")).getImage().getScaledInstance(150, 150,
                Image.SCALE_DEFAULT);
        ;
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

                changePassword();
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

        JButton btnPrintStudentResult = new JButton("Print Student Result");
        btnPrintStudentResult.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JFrame PrintStudentFrame = new JFrame("Print Student Result");

                PrintStudentFrame.setVisible(true);
                PrintStudentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                PrintStudentFrame.setBounds(100, 100, 450, 300);
                JPanel PrintStudentPanel = new JPanel();
                PrintStudentPanel.setBorder(null);
                PrintStudentFrame.setContentPane(PrintStudentPanel);
                PrintStudentPanel.setLayout(null);
                PrintStudentFrame.setLocation(550, 300);

                JLabel lblNewLabel = new JLabel("Name:");
                lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
                lblNewLabel.setBounds(99, 41, 45, 13);
                PrintStudentPanel.add(lblNewLabel);

                txtName = new JTextField();
                txtName.setBounds(154, 38, 96, 19);
                PrintStudentPanel.add(txtName);
                txtName.setColumns(10);

                JLabel lblLevel = new JLabel("Course:");
                lblLevel.setFont(new Font("Arial", Font.BOLD, 13));
                lblLevel.setBounds(88, 86, 56, 13);
                PrintStudentPanel.add(lblLevel);

                txtCourse = new JTextField();
                txtCourse.setColumns(10);
                txtCourse.setBounds(154, 83, 96, 19);
                PrintStudentPanel.add(txtCourse);

                JLabel lblNewLabel_2 = new JLabel("Level:");
                lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
                lblNewLabel_2.setBounds(99, 133, 45, 13);
                PrintStudentPanel.add(lblNewLabel_2);

                txtLevel = new JTextField();
                txtLevel.setColumns(10);
                txtLevel.setBounds(154, 130, 96, 19);
                PrintStudentPanel.add(txtLevel);

                JLabel lblNewLabel_1 = new JLabel("Sem:");
                lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
                lblNewLabel_1.setBounds(99, 181, 45, 13);
                PrintStudentPanel.add(lblNewLabel_1);

                txtSem = new JTextField();
                txtSem.setColumns(10);
                txtSem.setBounds(154, 178, 96, 19);
                PrintStudentPanel.add(txtSem);

                btnView = new JButton("View");
                btnView.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        String name = txtName.getText().toLowerCase();
                        String course = txtCourse.getText().toUpperCase();
                        String level = txtLevel.getText();
                        String sem = txtSem.getText();

                        // Create and show the result window
                        showResultWindow(name, course, level, sem);
                        PrintStudentFrame.dispose();
                    }
                });
                btnView.setBounds(138, 219, 85, 21);
                PrintStudentPanel.add(btnView);
            }

            private void showResultWindow(String name, String course, String level, String sem) {
                JFrame resultFrame = new JFrame("Result");
                resultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                resultFrame.setBounds(100, 100, 600, 400);
                resultFrame.setLocation(550, 250);

                try {
                    String jdbcUrl = "jdbc:mysql://localhost:3306/student";
                    String username = "root";
                    String passkey = "";
                    Connection connection = DriverManager.getConnection(jdbcUrl, username, passkey);

                    String query = "SELECT * FROM report WHERE Name = ? AND Course = ? AND Level = ? AND Sem = ?";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, name);
                    statement.setString(2, course);
                    statement.setString(3, level);
                    statement.setString(4, sem);
                    ResultSet resultSet = statement.executeQuery();

                    if (!resultSet.next()) {
                        JOptionPane.showMessageDialog(null, "No records found for the specified criteria.", "No Records",
                                JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }

                    // Get column names
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    int columnCount = metaData.getColumnCount();
                    String[] columns = new String[columnCount];
                    for (int i = 1; i <= columnCount; i++) {
                        columns[i - 1] = metaData.getColumnName(i);
                    }

                    // Create table model and add data
                    DefaultTableModel tableModel = new DefaultTableModel(columns, 0);

                    // Fetch data in the while loop
                    do {
                        Object[] row = new Object[columnCount];
                        for (int i = 0; i < columnCount; i++) {
                            row[i] = resultSet.getString(i + 1);
                        }
                        tableModel.addRow(row);
                    } while (resultSet.next());

                    // Create JTable and add to JScrollPane
                    JTable table = new JTable(tableModel);
                    JScrollPane scrollPane = new JScrollPane(table);

                    // Add JScrollPane to resultFrame
                    resultFrame.getContentPane().add(scrollPane, BorderLayout.CENTER);

                    // Create print button
                    JButton btnPrint = new JButton("Print");
                    btnPrint.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                // Print the table
                                table.print();
                            } catch (PrinterException ex) {
                                ex.printStackTrace();
                                JOptionPane.showMessageDialog(null,
                                        "Error printing the table: " + ex.getMessage(), "Error",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    });

                    // Add print button to the bottom of the frame
                    JPanel bottomPanel = new JPanel();
                    bottomPanel.add(btnPrint);
                    resultFrame.getContentPane().add(bottomPanel, BorderLayout.SOUTH);

                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                resultFrame.setVisible(true);
            }
        });
        btnPrintStudentResult.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnPrintStudentResult.setBounds(426, 271, 184, 25);
        contentPane.add(btnPrintStudentResult);

    }

    @Override
    public void changePassword() {
        String Oldpassword = passwordField.getText();
        String Newpassword = passwordField_1.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/student";
        String username = "root";
        String passkey = "";

        if (Oldpassword.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Enter the old password");
        } else if (Newpassword.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Enter the new password");
        } else {
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

                    String s = "UPDATE managers SET Password = '" + Newpassword + "'WHERE Password='" + Oldpassword + "'";
                    int rows_affected = stmt.executeUpdate(s);
                    if (rows_affected > 0) {
                        JOptionPane.showMessageDialog(null, "Successfully Changed the password");
                    } else {
                        JOptionPane.showMessageDialog(null, "Old password doesn't match");
                    }
                }
            } catch (ClassNotFoundException | SQLException e1) {
                // Handle exceptions
                e1.printStackTrace();
                System.out.println("Database connection failed!");
            }
        }
    }
}
