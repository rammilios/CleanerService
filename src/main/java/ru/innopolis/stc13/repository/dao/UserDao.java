package ru.innopolis.stc13.repository.dao;

import ru.innopolis.stc13.repository.pojo.User;

import java.sql.SQLException;

public interface UserDao {
     User getUserByLogin(String login) throws SQLException;
     void addUser(User user);
}
