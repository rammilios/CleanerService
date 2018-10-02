package ru.innopolis.stc13.controller;

import ru.innopolis.stc13.repository.pojo.Order;
import ru.innopolis.stc13.service.OrderService;
import ru.innopolis.stc13.service.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderServlet extends HttpServlet {
    OrderService orderService;

    public OrderServlet() {
        orderService = new OrderServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> res = orderService.getOrderList();
        req.setAttribute("orders", res);
        req.getRequestDispatcher("/orders.jsp").forward(req, resp);
    }
}
