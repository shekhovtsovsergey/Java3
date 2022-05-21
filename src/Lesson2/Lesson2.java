package Lesson2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.ParseException;

public class Lesson2 {

    public static void main(String args[]) throws ParseException, IOException, ClassNotFoundException {
        String name = "root";
        String pass = "11111111";
        String connectoinUrl = "jdbc:mysql://localhost:3306";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection con = DriverManager.getConnection(connectoinUrl, name, pass)) {
            try (Statement statement = con.createStatement()) {
                statement.execute("select * from ADMIN");

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }



}
