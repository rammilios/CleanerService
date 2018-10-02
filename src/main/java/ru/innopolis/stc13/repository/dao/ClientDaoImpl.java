package ru.innopolis.stc13.repository.dao;

import ru.innopolis.stc13.repository.pojo.Client;
import ru.innopolis.stc13.repository.connectionManager.ConnectionManager;
import ru.innopolis.stc13.repository.connectionManager.ConnectionManagerJdbcImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDaoImpl implements ClientDao {
    private static ConnectionManager connectionManager =
            ConnectionManagerJdbcImpl.getInstance();


    @Override
    public boolean addClient(Client client) {
        boolean result = false;
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     SQLMobile.INSERT.QUERY)) {
            preparedStatement.setInt(1, client.getClient_d());
            preparedStatement.setString(2, client.getName());
            preparedStatement.setString(3, client.getAdress());
            result = preparedStatement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Client getClientById(Integer client_id) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     SQLMobile.GET.QUERY)) {
            preparedStatement.setInt(1, client_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Client client = new Client(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3));
                return client;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateClientById(Client client) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     SQLMobile.UPDATE.QUERY)) {
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getAdress());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteClientById(Integer client_id) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     SQLMobile.DELETE.QUERY)) {
            preparedStatement.setInt(1, client_id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    enum SQLMobile {
        GET("SELECT * FROM clients WHERE id = ?"),
        INSERT("INSERT INTO clients values (DEFAULT, ?, ?)"),
        DELETE("DELETE FROM clients WHERE client_id=?"),
        UPDATE("UPDATE Clients SET client_id=?, name=?, adress=?" + "WHERE id=?");

        String QUERY;

        SQLMobile(String QUERY) {
            this.QUERY = QUERY;
        }
    }
}
