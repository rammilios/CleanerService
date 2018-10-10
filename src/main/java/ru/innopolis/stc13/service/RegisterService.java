package ru.innopolis.stc13.service;

public interface RegisterService {
    void addUser(String login, String password, String name);
    boolean checkStatus(String login, String password, String name);
}
