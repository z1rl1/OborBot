package org.example;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class DatabaseHandler {
    private static final String URL = "jdbc:sqlite:C:\\Users\\kiril\\tgBot.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public String kat() throws SQLException {
        StringBuilder finish = new StringBuilder();
        Connection conn = DriverManager.getConnection(URL);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Категории");
        while (rs.next()) {
            finish.append(rs.getString("Название категории"));
            finish.append(" ");
        }
        return finish.toString();
    }

    public String sportKat() throws SQLException {
        StringBuilder finish = new StringBuilder();
        Connection conn = DriverManager.getConnection(URL);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Оборудование WHERE idKat = 1");
        while (rs.next()) {
            finish.append(rs.getString("Название"));
            finish.append("-");
            finish.append(rs.getString("Характеристика"));
            finish.append("!");
        }
        return finish.toString();
    }

    public String kompKat() throws SQLException {
        StringBuilder finish = new StringBuilder();
        Connection conn = DriverManager.getConnection(URL);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Оборудование WHERE idKat = 2");
        while (rs.next()) {
            finish.append(rs.getString("Название"));
            finish.append("-");
            finish.append(rs.getString("Характеристика"));
            finish.append("!");
        }
        return finish.toString();
    }

    public String strKat() throws SQLException {
        StringBuilder finish = new StringBuilder();
        Connection conn = DriverManager.getConnection(URL);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Оборудование WHERE idKat = 3");
        while (rs.next()) {
            finish.append(rs.getString("Название"));
            finish.append("-");
            finish.append(rs.getString("Характеристика"));
            finish.append("!");
        }
        return finish.toString();
    }

    public String srokuArend() throws SQLException {
        StringBuilder finish = new StringBuilder();
        Connection conn = DriverManager.getConnection(URL);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Аренда");
        while (rs.next()) {
            finish.append(rs.getString("Длительность"));
            finish.append("-");
            finish.append(rs.getString("Цена"));
            finish.append("!");
        }
        return finish.toString();
    }

    public String spPol() throws SQLException {
        StringBuilder finish = new StringBuilder();
        Connection conn = DriverManager.getConnection(URL);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Получение");
        while (rs.next()) {
            finish.append(rs.getString("Способ"));
            finish.append("!");
        }
        return finish.toString();
    }

    public String idOplaa(String idAr, String idpOL) throws SQLException {
        StringBuilder finish = new StringBuilder();
        Connection conn = DriverManager.getConnection(URL);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Оплата WHERE IdArenda = '" + idAr + "' AND IdPol = '" + idpOL + "'");
        while (rs.next()) {
            finish.append(rs.getString("IdOplata"));
            finish.append("!");
        }
        return finish.toString();
    }

    public String vceTovars() throws SQLException {
        StringBuilder finish = new StringBuilder();
        Connection conn = DriverManager.getConnection(URL);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Оборудование");
        while (rs.next()) {
            finish.append(rs.getString("Название"));
            finish.append("-");
            finish.append(rs.getString("Характеристика"));
            finish.append("!");
        }
        return finish.toString();
    }
    public String vceCroku() throws SQLException {
        StringBuilder finish = new StringBuilder();
        Connection conn = DriverManager.getConnection(URL);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Аренда");
        while (rs.next()) {
            finish.append(rs.getString("Длительность"));
            finish.append("-");
            finish.append(rs.getString("Цена"));
            finish.append("!");
        }
        return finish.toString();
    }

    public void uzmenCrok(String x, String y, String z){
        String sql = "UPDATE Аренда " +
                "SET Длительность = ?, Цена = ? " +
                "WHERE idArenda = ?";
        String sql1 = "UPDATE Оплата " +
                "SET Цена = ? " +
                "WHERE idOplata = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, x);  // Заменить `x` на соответствующее значение
            pstmt.setString(2, y);  // Заменить `y` на соответствующее значение
            pstmt.setString(3, z);  // Заменить `z` на соответствующее значение

            pstmt.executeUpdate();

            System.out.println("Значения успешно изменены.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql1)) {
            // Предположим, что у вас есть список idOplata и соответствующий список цен
            List<String> idOplataList = Arrays.asList(Integer.parseInt(z)*2 + "", Integer.parseInt(z)*2-1 + ""); // Список idOplata
            List<String> priceList = Arrays.asList(y, Integer.parseInt(y)+150 + ""); // Список цен
            // Выполнение обновления для каждой пары idOplata и цены
            for (int i = 0; i < idOplataList.size(); i++) {
                String idOplata = idOplataList.get(i);
                String price = priceList.get(i);
                pstmt.setString(1, price);
                pstmt.setString(2, idOplata);

                pstmt.executeUpdate();
            }
            System.out.println("Значения успешно изменены.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void uzmenObor(String x, String y, String z){
        String sql = "UPDATE Оборудование " +
                "SET Название = ?, Характеристика = ? " +
                "WHERE idObor = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, x);  // Заменить `x` на соответствующее значение
            pstmt.setString(2, y);  // Заменить `y` на соответствующее значение
            pstmt.setString(3, z);  // Заменить `z` на соответствующее значение

            pstmt.executeUpdate();

            System.out.println("Значения успешно изменены.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
