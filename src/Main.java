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
    static String[] names = {"Гарфилд",
            "Том",
            "Гудвин",
            "Рокки",
            "Ленивец",
            "Пушок",
            "Спорти",
            "Бегемот",
            "Пират",
            "Гудини",
            "Зорро",
            "Саймон",
            "Альбус",
            "Базилио",
            "Леопольд",
            "Нарцисс",
            "Атос",
            "Каспер",
            "Валлито",
            "Оксфорд",
            "Бисквит",
            "Соня",
            "Клеопатра",
            "Цунами",
            "Забияка",
            "Матильда",
            "Кнопка",
            "Масяня",
            "Царапка",
            "Серсея",
            "Ворсинка",
            "Амели",
            "Наоми",
            "Маркиза",
            "Изольда",
            "Вальс",
            "Несквик",
            "Златан",
            "Баскет",
            "Изюм",
            "Цукат",
            "Мокко",
            "Месси",
            "Кокос",
            "Адидас",
            "Бейлиз",
            "Тайгер",
            "Зефир",
            "Мохи",
            "Валенсия",
            "Баунти",
            "Свити",
            "Текила",
            "Ириска",
            "Карамель",
            "Виски",
            "Кукуруза",
            "Гренка",
            "Фасолька",
            "Льдинка",
            "Китана",
            "Офелия",
            "Дайкири",
            "Брусника",
            "Аватар",
            "Космос",
            "Призрак",
            "Изумруд",
            "Плинтус",
            "Яндекс",
            "Крисмас",
            "Метеор",
            "Оптимус",
            "Смайлик",
            "Цельсий",
            "Краска",
            "Дейзи",
            "Пенка",
            "Веста",
            "Астра",
            "Эйприл",
            "Среда",
            "Бусинка",
            "Гайка",
            "Елка",
            "Золушка",
            "Мята",
            "Радость",
            "Сиам",
            "Оскар",
            "Феликс",
            "Гарри",
            "Байрон",
            "Чарли",
            "Симба",
            "Тао",
            "Абу",
            "Ватсон",
            "Енисей",
            "Измир",
            "Кайзер",
            "Васаби",
            "Байкал",
            "Багира",
            "Айрис",
            "Диана",
            "Мими",
            "Сакура",
            "Индия",
            "Тиффани",
            "Скарлетт",
            "Пикси",
            "Лиззи",
            "Алиса",
            "Лило",
            "Ямайка",
            "Пэрис",
            "Мальта",
            "Аляска"
    };
    static void add_all_types() throws SQLException {
        for (int i = 0; i < types.length; i++) {
            DB_Connection.insert_type(types[i]);
        }
    }

    static int randomizeInt(int fromNum, int toNum) {
        int random_number = fromNum + (int) (Math.random() * toNum); // Генерация 1-го числа
      //  System.out.println("1-ое случайное число: " + random_number);
        return random_number;
    }
    static double randomizeDouble(double fromNum, double toNum) {
        double random_number = fromNum + (Math.random() * toNum); // Генерация 1-го числа
        random_number = (Math.ceil(random_number * 100))/100;
      //  System.out.println("1-ое случайное число: " + random_number);
        return random_number;
    }

    static void add_more_cats(int n) throws SQLException {
        for (int i = 0; i < n; i++) {
            int index = randomizeInt(0, names.length - 1);
            String name = names[index];
            index = randomizeInt(0, types.length - 1);
            String type = types[index];
            int age = randomizeInt(1, 15);
            double weight = randomizeDouble(1, 10);
            System.out.println(name + " " + type + " " + age + " " + weight);
            DB_Connection.insert_cat(name,type,age,weight);
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
       // DB_Connection.get_type(2);
       // DB_Connection.get_type(10);
        //DB_Connection.update_type(41,"Неизвестная порода");
       // DB_Connection.get_type_where("id > 15 AND id < 40");
        // DB_Connection.get_type_where("type LIKE 'Б%'");
        //DB_Connection.get_all_types();
  //      DB_Connection.insert_cat("Барсик","Камышовый кот",2,3.2);
   //     DB_Connection.insert_cat("Дружок","Корат",5,6.5);
   //     DB_Connection.insert_cat("Батон","Рыжий кот",3,1.2);
       // add_more_cats(5000);
       // DB_Connection.delete_cat(5001);
       // DB_Connection.delete_cat("name LIKE 'А%'");
       // DB_Connection.update_cat("name = 'Леопард' , age = 5","id = 4997");
       // DB_Connection.get_cat(4964);
      //  DB_Connection.get_cat_where("name LIKE 'М%'");
        DB_Connection.get_all_cats();
        DB_Connection.CloseDB();


    }
}