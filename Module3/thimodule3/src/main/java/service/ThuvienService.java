package service;


import model.Thuvien;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ThuvienService {
    private final String SELECT_ALL = "select * from thu_vien";
    private final String SELECT_BY_ID = "select * from thu_vien where id= ?";
    private final String CREATE = "insert into thu_vien (ten_sach, tac_gia, so_luong, mo_ta) value (?, ?, ?, ?)";
    private final String UPDATE = "update thu_vien set ten_sach= ?, tac_gia= ?, so_luong= ?,  mo_ta=? where id= ?";
    private final String DELETE = "delete from thu_vien where id= ?";


    private Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thuvien", "root", "Gau082001");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    public void save(Thuvien thuvien) {
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(thuvien.getId() > 0 ? UPDATE : CREATE);
            preparedStatement.setString(1, thuvien.getTen_sach());
            preparedStatement.setString(2, thuvien.getTac_gia());
            preparedStatement.setInt(3, thuvien.getSo_luong());
            preparedStatement.setString(4, thuvien.getMo_ta());

            if (thuvien.getId() > 0) preparedStatement.setInt(5, thuvien.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Thuvien> getAll() {
        List<Thuvien> thuviens = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
        ) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Thuvien thuvien = getThuvien(resultSet);
                thuviens.add(thuvien);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return thuviens;
    }

    public void delete(int id) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
        ) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Thuvien get(int id) {
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                return getThuvien(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Thuvien getThuvien(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        String ten_sach = resultSet.getString(2);
        String tac_gia = resultSet.getString(3);
        int so_luong = resultSet.getInt(4);
        String mo_ta = resultSet.getString(5);

        return new Thuvien(id, ten_sach, tac_gia, so_luong, mo_ta);
    }
}

