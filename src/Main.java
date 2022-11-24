import java.sql.*;
import java.sql.SQLException;
public class Main {

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
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String fileName = "My_cats.db";
        String DB_URL = "jdbc:sqlite:D:" + fileName;
        DB_Connection.Connect(DB_URL);
        DB_Connection.CreateDBTable();
        DB_Connection.insert_type("Абиссинская кошка");
        DB_Connection.insert_type("Австралийский мист");
        DB_Connection.insert_type("Американская жесткошерстная");
    }
}