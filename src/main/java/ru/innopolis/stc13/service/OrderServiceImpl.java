package ru.innopolis.stc13.service;

import ru.innopolis.stc13.repository.dao.OrderDao;
import ru.innopolis.stc13.repository.dao.OrderDaoImpl;
import ru.innopolis.stc13.repository.pojo.Order;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    OrderDao orderDao;

    public OrderServiceImpl() {this.orderDao = new OrderDaoImpl();}

    @Override
    public List<Order> getOrderList() {return orderDao.getOrderList(); }
}
