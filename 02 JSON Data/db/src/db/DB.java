package db;
import java.sql.*;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
public class DB {
	public static void main(String[] args) throws Exception {
        // 1. Database connection
        String url = "jdbc:mysql://localhost:3306/users";
        String user = "root";
        String pass = "root";

        Connection conn = DriverManager.getConnection(url, user, pass);

        // 2. Execute query
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT id, name, age FROM users");

        // 3. Process results into a list of maps
        List<Map<String, Object>> records = new ArrayList<>();
        ResultSetMetaData meta = rs.getMetaData();
        int columnCount = meta.getColumnCount();

        while (rs.next()) {
            Map<String, Object> row = new LinkedHashMap<>();
            for (int i = 1; i <= columnCount; i++) {
                row.put(meta.getColumnLabel(i), rs.getObject(i));
            }
            records.add(row);
        }

        // 4. Convert to JSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(records);

        // 5. Print or save JSON
        System.out.println(json);
        // mapper.writeValue(new File("report.json"), records);

        conn.close();
    }
}
