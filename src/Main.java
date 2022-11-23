import java.sql.*;

public class Main {
    public static void createNewDatabase(String url) {



        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createNewTable(String url) {
        // SQLite connection string


        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS types (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	type varchar(100) NOT NULL\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        String fileName = "My_cats.db";
        String url = "jdbc:sqlite:D:" + fileName;
        createNewDatabase(url);
        createNewTable(url);
    }
}