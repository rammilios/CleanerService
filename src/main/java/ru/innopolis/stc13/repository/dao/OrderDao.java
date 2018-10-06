package ru.innopolis.stc13.repository.dao;

import ru.innopolis.stc13.repository.pojo.Order;

import java.util.List;

public interface OrderDao {
    public int addOrder(Order order);

    public Order getOrderById(Integer orderId);

    public boolean updateOrderById(Order order);

    public boolean deleteOrderById(Integer orderId);

    List<Order> getOrderList();
}
