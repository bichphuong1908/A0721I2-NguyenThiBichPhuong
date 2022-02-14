package service;

import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private final String SELECT_ALL = "select * from customer";
    private final String SELECT_BY_ID = "select * from customer where id= ?";
    private final String CREATE = "insert into customer (name, email, country) value (?, ?, ?)";
    private final String UPDATE = "update customer set name= ?, email= ?, country= ? where id= ?";
    private final String DELETE = "delete from customer where id= ?";


    private Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demmo", "root", "Gau082001");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    public void save(Customer customer) {
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(customer.getId() > 0 ? UPDATE : CREATE);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getEmail());
            preparedStatement.setString(3, customer.getCountry());
            if (customer.getId() > 0) preparedStatement.setInt(4, customer.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


//        if(customer.getId()> 0){
//            // update
//            try ( Connection connection= getConnection();
//                  PreparedStatement preparedStatement= connection.prepareStatement(UPDATE)){
//                preparedStatement.setString(1, customer.getName());
//                preparedStatement.setString(2, customer.getEmail());
//                preparedStatement.setString(3, customer.getCountry());
//                preparedStatement.setInt(4, customer.getId());
//                preparedStatement.executeUpdate();
//
//            }catch (SQLException e){
//                e.printStackTrace();
//            }
//
//        }
//        else {
//            // create
//
//            try ( Connection connection= getConnection();
//                  PreparedStatement preparedStatement= connection.prepareStatement(CREATE)){
//                  preparedStatement.setString(1, customer.getName());
//                preparedStatement.setString(2, customer.getEmail());
//                preparedStatement.setString(3, customer.getCountry());
//                preparedStatement.executeUpdate();
//
//            }catch (SQLException e){
//                e.printStackTrace();
//            }
//        }

    }

    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
        ) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Customer customer = getCustomer(resultSet);
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
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

    public Customer get(int id) {
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                return getCustomer(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Customer getCustomer(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        String name = resultSet.getString(2);
        String email = resultSet.getString(3);
        String country = resultSet.getString(4);
        return new Customer(id, name, email, country);
    }
}
