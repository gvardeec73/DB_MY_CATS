import java.sql.*;

public class DB_Connection {
    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;

    // --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
    public static void Connect(String DB_URL) throws ClassNotFoundException, SQLException
    {
        connection = null;
        //Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection(DB_URL);
        if (connection != null) {
            DatabaseMetaData meta = connection.getMetaData();
            System.out.println("The driver name is " + meta.getDriverName());
            System.out.println("База Подключена!");
        }

    }

    // --------Создание таблицы--------
    public static void CreateDBTable() throws ClassNotFoundException, SQLException
    {
        statement = connection.createStatement();
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS types (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	type varchar(100) NOT NULL\n"
                + ");";
        statement.execute(sql);

        System.out.println("Таблица создана или уже существует.");
    }

    // --------Заполнение таблицы--------
    public static void  insert_type(String type) throws SQLException
    {
        String sql = "INSERT INTO types (type) VALUES ('" + type + "');";
        statement.execute(sql);

        System.out.println("строка заполнена");
    }
}
