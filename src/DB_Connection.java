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
        statement = connection.createStatement();
       // statement =  connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }

    // --------Создание таблицы--------
    public static void CreateDBTableTypes() throws ClassNotFoundException, SQLException
    {

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS types (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	type varchar(100) NOT NULL\n"
                + ");";
        statement.execute(sql);

        System.out.println("Таблица types создана или уже существует.");
    }
    public static void CreateDBTableCats() throws ClassNotFoundException, SQLException
    {
       // statement = connection.createStatement();
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS cats (\n"
                + "	id integer PRIMARY KEY UNIQUE,\n"
                + "	name varchar(20) NOT NULL,\n"
                + "	type_id integer REFERENCES types(id) NOT NULL,\n"
                + "	age integer NOT NULL,\n"
                + "	weight double\n"
                + ");";
        statement.execute(sql);

        System.out.println("Таблица cats создана или уже существует.");
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
    public static void get_type_where(String where) throws SQLException {
        String sql ="SELECT type FROM types WHERE " + where + ";";
        resultSet = statement.executeQuery(sql);
        while(resultSet.next()) {
            String type = resultSet.getString("type");
            System.out.println(type);
        }
    }

    public static void insert_cat(String name, String type, int age, Double weight) throws SQLException {
        String sql ="SELECT type FROM types WHERE type = '" + type + "';";
        resultSet = statement.executeQuery(sql);
        resultSet.next();
        String typeFromDB = resultSet.getString("type");
       // System.out.println(typeFromDB);
        if (typeFromDB == null) {
            System.out.println("Такого типа кошки нет в базе (" + type + ")");
            insert_type(type);
            System.out.println("Тип " + type + " добавлен в базу");
        }
         sql = "INSERT INTO cats (name, type_id, age, weight) VALUES \n" +
                "('" + name + "', (SELECT id FROM types WHERE type = '" + type + "')," + age + "," + weight +" );";
        statement.execute(sql);

        System.out.println("строка заполнена");
    }
    public static void get_all_types() throws SQLException {
        String sql ="SELECT * FROM types;";
        resultSet = statement.executeQuery(sql);
        while(resultSet.next()) {
            String type = resultSet.getString("type");
            System.out.println(type);
        }

    }


    // --------Закрытие--------
    public static void CloseDB() throws ClassNotFoundException, SQLException
    {
        if(resultSet != null)
            resultSet.close();
        if(statement != null)
            statement.close();
        if(connection != null)
            connection.close();
        System.out.println("Соединения закрыты");
    }
}
