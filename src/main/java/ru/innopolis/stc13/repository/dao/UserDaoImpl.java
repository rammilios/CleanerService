package ru.innopolis.stc13.repository.dao;

import ru.innopolis.stc13.repository.pojo.User;
import ru.innopolis.stc13.repository.connectionManager.ConnectionManager;
import ru.innopolis.stc13.repository.connectionManager.ConnectionManagerJdbcImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();

    @Override
    public User getUserByLogin(String login) throws SQLException {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM \"user\" WHERE \"user\".login = ?");) {
            preparedStatement.setString(1, login);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    return new User(resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getInt(4),
                            resultSet.getString(5));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void addUser(User user) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO \"user\" VALUES (DEFAULT, ?, ?, DEFAULT, ?)");
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getName());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
