package service;

import model.Chothue;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChothueService {
    private final String SELECT_ALL = "select * from chothue";
    private final String SELECT_BY_ID = "select * from chothue where id= ?";
    private final String CREATE = "insert into chothue (dien_tich, trang_thai, tang, loai_van_phong, gia_cho_thue, ngay_bat_dau, ngay_ket_thuc) value (?, ?, ?, ?, ? ,?, ?)";
    private final String UPDATE = "update chothue set dien_tich= ?, trang_thai= ?, tang= ?, loai_van_phong=?, gia_cho_thue=?, ngay_bat_dau=?, ngay_ket_thuc=? where id= ?";
    private final String DELETE = "delete from chothue where id= ?";


    private Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/module3", "root", "Gau082001");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    public void save(Chothue chothue) {
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(chothue.getId() > 0 ? UPDATE : CREATE);
            preparedStatement.setString(1, chothue.getDien_tich());
            preparedStatement.setString(2, chothue.getTrang_thai());
            preparedStatement.setInt(3, chothue.getTang());
            preparedStatement.setString(4, chothue.getLoai_van_phong());
            preparedStatement.setString(5, chothue.getGia_cho_thue());
            preparedStatement.setString(6, chothue.getNgay_bat_dau());
            preparedStatement.setString(7, chothue.getNgay_ket_thuc());

            if (chothue.getId() > 0) preparedStatement.setInt(6, chothue.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

//       if(product.getId()> 0){
//         // update
//            try ( Connection connection= getConnection();
//                 PreparedStatement preparedStatement= connection.prepareStatement(UPDATE)){
//                preparedStatement.setString(1, product.getName());
//                preparedStatement.setString(2, product.getPrice());
//                preparedStatement.setString(3, product.getQuantity());
//                preparedStatement.setString(4, product.getColor());
//                preparedStatement.setString(5, product.getDescription());
//                preparedStatement.setString(6, product.getCategory());
//                preparedStatement.setInt(7, product.getId());
//
//                preparedStatement.executeUpdate();
//
//            }catch (SQLException e){
//                e.printStackTrace();
//           }
//       }
//        else {
//           // create
//            try ( Connection connection= getConnection();
//                  PreparedStatement preparedStatement= connection.prepareStatement(CREATE)){
//                  preparedStatement.setString(1, product.getName());
//                preparedStatement.setString(2, product.getPrice());
//                preparedStatement.setString(3, product.getQuantity());
//                preparedStatement.setString(4, product.getColor());
//                preparedStatement.setString(5, product.getDescription());
//                preparedStatement.setString(6, product.getCategory());
//                preparedStatement.executeUpdate();
//
//            }catch (SQLException e){
//               e.printStackTrace();
//            }
//        }
//
    }
        public List<Chothue> getAll() {
            List<Chothue> chothues = new ArrayList<>();
            try (
                    Connection connection = getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ) {

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    Chothue chothue = getChothue(resultSet);
                    chothues.add(chothue);

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return chothues;
        }

        public void delete( int id){
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            ) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public Chothue get(int id){
            try (
                    Connection connection = getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            ) {
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    return getChothue(resultSet);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return null;
        }

        private Chothue getChothue (ResultSet resultSet) throws SQLException {
            int id = resultSet.getInt(1);
            String dien_tich = resultSet.getString(2);
            String trang_thai = resultSet.getString(3);
            int tang = resultSet.getInt(4);
            String loai_van_phong = resultSet.getString(5);
            String gia_cho_thue = resultSet.getString(6);
            String ngay_bat_dau = resultSet.getString(7);
            String ngay_ket_thuc = resultSet.getString(8);

            return new Chothue(id, dien_tich, trang_thai, tang, loai_van_phong, gia_cho_thue, ngay_bat_dau, ngay_ket_thuc);
        }
    }

