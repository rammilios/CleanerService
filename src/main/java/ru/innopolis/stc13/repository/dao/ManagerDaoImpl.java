package ru.innopolis.stc13.repository.dao;

import ru.innopolis.stc13.repository.pojo.Manager;
import ru.innopolis.stc13.repository.connectionManager.ConnectionManager;
import ru.innopolis.stc13.repository.connectionManager.ConnectionManagerJdbcImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerDaoImpl implements ManagerDao {
    private static ConnectionManager connectionManager =
            ConnectionManagerJdbcImpl.getInstance();


    @Override
    public boolean addManager(Manager manager) {
        boolean result = false;
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     SQLMobile.INSERT.QUERY)) {
            preparedStatement.setInt(1, manager.getManager_id());
            preparedStatement.setString(2, manager.getManagerName());
            result = preparedStatement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Manager getManagerById(Integer managerId) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     SQLMobile.GET.QUERY)) {
            preparedStatement.setInt(1, managerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Manager manager = new Manager(
                        resultSet.getInt(1),
                        resultSet.getString(2));
                return manager;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateManagerById(Manager manager) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     SQLMobile.UPDATE.QUERY)) {
            preparedStatement.setString(1, manager.getManagerName());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteManagerById(Integer managerId) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     SQLMobile.DELETE.QUERY)) {
            preparedStatement.setInt(1, managerId);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    enum SQLMobile {
        GET("SELECT * FROM manager WHERE id = ?"),
        INSERT("INSERT INTO manager values (DEFAULT, ?)"),
        DELETE("DELETE FROM manager WHERE id=?"),
        UPDATE("UPDATE manager SET manager_id=?, name=?" + "WHERE id=?");

        String QUERY;

        SQLMobile(String QUERY) {
            this.QUERY = QUERY;
        }
    }
}
