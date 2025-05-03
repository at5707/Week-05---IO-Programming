package database;
import java.sql.*;
import java.io.*;
public class Database {
	public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company";
        String user = "root";
        String pass = "root";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, name, department, salary FROM employees");
             FileWriter fw = new FileWriter("employee_report.csv")) {

            fw.write("Employee ID,Name,Department,Salary\n");

            while (rs.next()) {
                fw.write(rs.getInt("id") + "," +
                         rs.getString("name") + "," +
                         rs.getString("department") + "," +
                         rs.getDouble("salary") + "\n");
            }

            System.out.println("CSV report generated from database.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
