package ru.innopolis.stc13.repository.dao;

import ru.innopolis.stc13.repository.connectionManager.ConnectionManager;
import ru.innopolis.stc13.repository.connectionManager.ConnectionManagerJdbcImpl;
import ru.innopolis.stc13.repository.pojo.Order;
import javax.management.Query;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    private static ConnectionManager connectionManager =
            ConnectionManagerJdbcImpl.getInstance();

    @Override
    public boolean addOrder(Order order) {
        boolean result = false;
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     SQLMobile.INSERT.QUERY)) {
            preparedStatement.setInt(1, order.getOrder_id());
            preparedStatement.setString(2, order.getOrder_status());
            preparedStatement.setInt(3, order.getPrice());
            preparedStatement.setString(4, order.getPaid());
            preparedStatement.setString(5, order.getComments());
            result = preparedStatement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Order getOrderById(final Integer orderId) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     SQLMobile.GET.QUERY)) {
            preparedStatement.setInt(1, orderId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Order order = new Order(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getInt(3));
                return order;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateOrderById(final Order order) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     SQLMobile.UPDATE.QUERY)) {
            preparedStatement.setInt(1, order.getOrder_id());
            preparedStatement.setString(2, order.getOrder_status());
            preparedStatement.setString(4, order.getPaid());
            preparedStatement.setString(5, order.getComments());
            preparedStatement.setInt(3, order.getPrice());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteOrderById(final Integer orderId) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     SQLMobile.DELETE.QUERY)) {
            preparedStatement.setInt(1, orderId);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<Order> getOrderList() {
        List<Order> result = null;
        try (Connection connection = connectionManager.getConnection();
             Statement statement = connection.createStatement()) {

            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM orders")) {
                result = new ArrayList<>();
                while (resultSet.next()) {
                    result.add(new Order(
                            resultSet.getInt("order_id"),
                            resultSet.getString("order_status"),
                            resultSet.getString("paid"),
                            resultSet.getString("comments"),
                            resultSet.getInt("price")));

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    enum SQLMobile {
        GET("SELECT * FROM orders WHERE order_id = ?"),
        INSERT("INSERT INTO orders values (DEFAULT, ?, ?, ?, ?)"),
        DELETE("DELETE FROM orders WHERE order_id=?"),
        UPDATE("UPDATE orders SET order_id=?, order_status=?, price=?, paid=?, comments=?" + "WHERE id=?");

        String QUERY;

        SQLMobile(String QUERY) {
            this.QUERY = QUERY;
        }
    }
}
