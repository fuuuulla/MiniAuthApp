package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() throws Exception {
        // تحميل Driver ديال MySQL
        Class.forName("com.mysql.cj.jdbc.Driver");
        // الاتصال بقاعدة البيانات
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/users_db", // اسم قاعدة البيانات
            "root", // المستخدم الافتراضي
            ""      // كلمة السر (في XAMPP عادة فارغة)
        );
    }
}

