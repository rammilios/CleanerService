package ru.innopolis.stc13.service;

import ru.innopolis.stc13.repository.dao.OrderDao;
import ru.innopolis.stc13.repository.dao.OrderDaoImpl;
import ru.innopolis.stc13.repository.pojo.Order;
import ru.innopolis.stc13.repository.pojo.User;
import ru.innopolis.stc13.utils.UtilMD5;

import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    OrderDao orderDao;

    public OrderServiceImpl() {
        this.orderDao = new OrderDaoImpl();
    }

    @Override
    public List<Order> getOrderList() {
        return orderDao.getOrderList();
    }

    @Override
    public int addOrder(String comments, String adress) {
        if (comments != null && adress != null) {
            Order order = new Order(comments, adress);
            return orderDao.addOrder(order);
        }
        return 0;
    }

    @Override
    public boolean checkStatus(String comments, String adress) {
        return !(comments.equals("") && adress.equals(""));
    }
}
