package ru.innopolis.stc13.service;

import ru.innopolis.stc13.repository.dao.UserDao;
import ru.innopolis.stc13.repository.pojo.User;

public class RegisterServiceImpl implements RegisterService {
    UserDao userDao;

    public RegisterServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser(String login, String password, String name) {
        if (login != null && password != null && name != null) {
            User user = new User(login, password, name);
            userDao.addUser(user);
        }
    }

    @Override
    public boolean checkStatus(String login, String password, String name) {
        return !(login.equals("") && password.equals("") && name.equals(""));
    }
}
