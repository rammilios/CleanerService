package ru.innopolis.stc13.repository.connectionManager;

import java.sql.Connection;

public interface ConnectionManager {
    public Connection getConnection();
}
