package ru.innopolis.stc13.service;

import ru.innopolis.stc13.repository.pojo.Order;

import java.util.List;

public interface OrderService {
    List<Order> getOrderList();

    int addOrder(String comments, String adress);

    boolean checkStatus(String comments, String adress);
}
