package week4.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExemploPostgres {
    public static void main(String[] args) {
        try (Connection conn = DriverManager
                .getConnection(Credentials.url);
             Statement stmt = conn.createStatement()) {

            String query = "select * from academia";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("NOME: " + rs.getString("nome"));
            }

            rs.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
