package Final_assessment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class scon {
    protected String jdbcUrl = "jdbc:mysql://localhost:3306/student";
    protected String username = "root";
    protected String passkey = "";

    // Common method to establish database connection
    protected Connection establishConnection() throws SQLException, ClassNotFoundException {
        // Load the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish a connection
        return DriverManager.getConnection(jdbcUrl, username, passkey);
    }
}

class SignupHandler extends scon {
    public boolean signup(String signup_name, String signup_email, String signup_phone, String signup_password,
                          String signup_mode, String course, String level, String optional_course) {
        try (Connection connection = establishConnection()) {
            Statement stmt = connection.createStatement();

            if ("Student".equals(signup_mode)) {
                String s = "INSERT INTO stds (SID, Name, Email, Phone, Password, Mode,Course,Level,Optional) " +
                        "VALUES (NULL, '" + signup_name.toLowerCase() + "','" + signup_email + "','" + signup_phone +
                        "','" + signup_password + "','" + signup_mode + "','" + course.toUpperCase() + "','" + level + "', '" + optional_course.toUpperCase() + "')";
                stmt.execute(s);
            } else if ("Tutor".equals(signup_mode)) {
                String s = "INSERT INTO teachers (TID, Name, Email, Phone, Password, Mode,Course) " +
                        "VALUES (NOT NULL,'" + signup_name.toLowerCase() + "','" + signup_email + "','" + signup_phone +
                        "','" + signup_password + "','" + signup_mode + "','" + course.toUpperCase() + "')";
                stmt.execute(s);
            } else if ("Manager".equals(signup_mode)) {
                String s = "INSERT INTO managers (MID,Name, Email, Phone, Password, Mode) " +
                        "VALUES (NOT NULL,'" + signup_name.toLowerCase() + "','" + signup_email + "','" + signup_phone +
                        "','" + signup_password + "','" + signup_mode + "')";
                stmt.execute(s);
            }
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Database connection failed!");
            return false;
        }
    }
}

class LoginHandler extends scon {
    public boolean login(String login_email, String login_password, String login_mode, String login_name) {
        boolean found = false;
        String level = "";
        String course = "";
        String tutor_course = "";

        try (Connection connection = establishConnection()) {
            Statement stmt = connection.createStatement();
            String query = "";
            String p = "";

            switch (login_mode) {
                case "Student":
                    query = "SELECT * FROM stds WHERE Email='" + login_email + "' AND Password='" + login_password + "'";
                    p = "INSERT INTO activity (AID,ActivityName) " +
                            "VALUES (NULL, 'Student:" + login_email + " recently logged in')";
                    break;
                case "Tutor":
                    query = "SELECT * FROM teachers WHERE Email='" + login_email + "' AND Password='" + login_password + "'";
                    p = "INSERT INTO activity (AID,ActivityName) " +
                            "VALUES (NULL, 'Tutor:" + login_email + " recently logged in')";
                    break;
                case "Manager":
                    query = "SELECT * FROM managers WHERE Email='" + login_email + "' AND Password='" + login_password + "'";
                    p = "INSERT INTO activity (AID,ActivityName) " +
                            "VALUES (NULL, 'Manager:" + login_email + " recently logged in')";
                    break;
            }

            if ("Student".equals(login_mode)) {
                String nameQuery = "SELECT Level,Course FROM stds WHERE Email='" + login_email + "' AND Password='" + login_password + "'";
                ResultSet nameResult = stmt.executeQuery(nameQuery);

                if (nameResult.next()) {
                    level = nameResult.getString("Level");
                    course = nameResult.getString("Course").toUpperCase();
                }
            }

            if ("Tutor".equals(login_mode)) {
                String nameQuery = "SELECT Course FROM teachers WHERE Email='" + login_email + "' AND Password='" + login_password + "'";
                ResultSet nameResult = stmt.executeQuery(nameQuery);

                if (nameResult.next()) {
                    tutor_course = nameResult.getString("Course").toUpperCase();
                }
            }

            stmt.execute(p);
            ResultSet rs = stmt.executeQuery(query);
            found = rs.next();

            if (found) {
                // Login successful
                switch (login_mode) {
                    case "Student":
                        StudentDashboard sd = new StudentDashboard(level, course, login_name);
                        sd.show();
                        break;
                    case "Tutor":
                        TeacherDashboard td = new TeacherDashboard(tutor_course);
                        td.show();
                        break;
                    case "Manager":
                        ManagerDashboard md = new ManagerDashboard();
                        md.show();
                        break;
                }
            } else {
                // Login failed
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "Incorrect email or password.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Database connection failed!");
        }

        return found;
    }
}
