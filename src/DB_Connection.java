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

    // --------Заполнение строки таблицы--------
    public static void  insert_type(String type) throws SQLException
    {
        String sql = "INSERT INTO types (type) VALUES ('" + type + "');";
        statement.execute(sql);

        System.out.println("строка заполнена");
    }
    // --------Удаление строки таблицы--------
    public static void delete_type(int id) throws SQLException {
        String sql ="DELETE FROM types WHERE id = " + id + ";";
        statement.execute(sql);
        System.out.println("строка удалена");
    }
    // --------Замена строки таблицы--------
    public static void update_type(int id, String new_type) throws SQLException {
        String sql ="UPDATE types SET type = '" + new_type + "' WHERE id = " + id + ";";
        statement.execute(sql);
        System.out.println("строка заменена");
    }

    public static void get_type(int id) throws SQLException {
        String sql ="SELECT type FROM types WHERE id = " + id + ";";
        resultSet = statement.executeQuery(sql);
        String type = resultSet.getString("type");
        System.out.println(type);
    }

    public static void get_all_types() throws SQLException {
        String sql ="SELECT * FROM types;";
        resultSet = statement.executeQuery(sql);
        while(resultSet.next()) {
            String type = resultSet.getString("type");
            System.out.println(type);
        }
    }

    public static void get_type_where(String where) throws SQLException {
        String sql ="SELECT type FROM types WHERE " + where + ";";
        resultSet = statement.executeQuery(sql);
        while(resultSet.next()) {
            String type = resultSet.getString("type");
            System.out.println(type);
        }
    }

    // --------Закрытие--------
    public static void CloseDB() throws ClassNotFoundException, SQLException
    {
        connection.close();
        statement.close();
        resultSet.close();

        System.out.println("Соединения закрыты");
    }
}
