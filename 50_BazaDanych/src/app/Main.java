/*
 * Połączenie z bazą danych przez JDBC. Wersja MySQL, bo derby nie
 * startuje.
 */
package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author student
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Start programu!!!");

        String url = "jdbc:mysql://localhost:3306/tpi_studia";
        String username = "root";
        String password = "";

        try (Connection con = DriverManager.getConnection(url, username, password)) {
            Statement stmt = con.createStatement();
            String sql = "select * from miasto";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getString("nazwa"));
            }

            // Wyświetlenie studentów w układzie nazwisko, imię, nr albumu
            // Wyświetlenie studentów imię, spacja, nazwisko pobrane w jednej kolumnie
            // Wyświetlenei przedmiotów nazwa (typ) liczba godzin
            // Algebra (wykład) 30 godz.
            sql = "select * from student where imie like ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "%a");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.print(rs.getString("nazwisko"));
                System.out.print(" ");
                System.out.println(rs.getString("imie"));
            }

            sql = "SELECT "
                    + "nazwisko, imie, nazwa, typ "
                    + "FROM "
                    + "student s JOIN student_przedmiot sp ON s.id = sp.ids "
                    + "JOIN przedmiot p ON sp.idp = p.id "
                    + "ORDER BY nazwisko, imie";

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.print(rs.getString("nazwisko") + " ");
                System.out.print(rs.getString("imie") + " ");
                System.out.print(rs.getString("nazwa") + " ");
                System.out.println(rs.getString("typ"));
            }

            // Na ile zajęć uczęszcza każdy student
            sql = "SELECT "
                    + "s.id, nazwisko, imie "
                    + "FROM "
                    + "student s JOIN student_przedmiot sp ON s.id = sp.ids "
                    + "JOIN przedmiot p ON sp.idp = p.id "
                    + "ORDER BY nazwisko, imie";

            rs = stmt.executeQuery(sql);

            int id = -1;
            String osoba = "";
            int count = 0;
            while (rs.next()) {
//                System.out.println(rs.getString("id"));
                if (id == -1) {
                    id = rs.getInt("id");
                    osoba = rs.getString("nazwisko") + " " + rs.getString("imie");
                    count = 1;
                    continue;
                }
                if (id != rs.getInt("id")) {
                    System.out.print(osoba + " ");
                    System.out.println(count);
                    id = rs.getInt("id");
                    osoba = rs.getString("nazwisko") + " " + rs.getString("imie");
                    count = 1;
                } else {
                    count++;
                }
            }
            System.out.print(osoba + " ");
            System.out.println(count);
            
            sql = "SELECT "
                    + "s.id,s.nazwisko,s.imie, count(*) liczba "
                    + "FROM "
                    + "student s JOIN student_przedmiot sp ON s.id = sp.ids "
                    + "JOIN przedmiot p ON sp.idp = p.id "
                    + "GROUP BY s.id";
            
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.print(rs.getString("nazwisko")+" ");
                System.out.print(rs.getString("imie")+" ");
                System.out.println(rs.getString("liczba"));
            }
            
        } catch (SQLException e) {
            System.out.println("Exception creating connection: " + e);
            System.exit(0);
        }
    }
}
