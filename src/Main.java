import java.sql.*;
import java.sql.SQLException;
public class Main {

    static String[] types = new String[]{
            "Абиссинская кошка",
            "Австралийский мист",
            "Американская жесткошерстная",
            "Американская короткошерстная",
            "Американский бобтейл",
            "Американский кёрл",
            "Балинезийская кошка",
            "Бенгальская кошка",
            "Бирманская кошка",
            "Бомбейская кошка",
            "Бразильская короткошёрстная",
            "Британская длинношерстная",
            "Британская короткошерстная",
            "Бурманская кошка",
            "Бурмилла кошка",
            "Гавана",
            "Гималайская кошка",
            "Девон-рекс",
            "Донской сфинкс",
            "Европейская короткошерстная",
            "Египетская мау",
            "Канадский сфинкс",
            "Кимрик",
            "Корат",
            "Корниш-рекс",
            "Курильский бобтейл",
            "Лаперм",
            "Манчкин",
            "Мейн-ку́н",
            "Меконгский бобтейл",
            "Мэнкс кошка",
            "Наполеон",
            "Немецкий рекс",
            "Нибелунг",
            "Норвежская лесная кошка",
            "Ориентальная кошка",
            "Оцикет",
            "Персидская кошка",
            "Петерболд",
            "Пиксибоб",
            "Рагамаффин",
            "Русская голубая кошка",
            "Рэгдолл",
            "Саванна",
            "Селкирк-рекс",
            "Сиамская кошка",
            "Сибирская кошка",
            "Сингапурская кошка",
            "Скоттиш-фолд",
            "Сноу-шу",
            "Сомалийская кошка",
            "Тайская кошка",
            "Тойгер",
            "Тонкинская кошка",
            "Турецкая ангорская кошка",
            "Турецкий ван",
            "Украинский левкой",
            "Чаузи",
            "Шартрез",
            "Экзотическая короткошерстная",
            "Японский бобтейл"
    };

    static void add_all_types() throws SQLException {
        for (int i = 0; i < types.length; i++) {
            DB_Connection.insert_type(types[i]);
        }
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String fileName = "My_cats.db";
        String DB_URL = "jdbc:sqlite:D:" + fileName;
        DB_Connection.Connect(DB_URL);
        DB_Connection.CreateDBTableTypes();
        DB_Connection.CreateDBTableCats();
       // add_all_types();
       // DB_Connection.delete_type(40);
       // DB_Connection.get_type(19);
       // DB_Connection.get_type(10);
        //DB_Connection.update_type(41,"Неизвестная порода");
       // DB_Connection.get_type_where("id > 15 AND id < 40");
       // DB_Connection.get_type_where("type LIKE 'Б%'");
        //DB_Connection.get_all_types();
       DB_Connection.CloseDB();

    }
}