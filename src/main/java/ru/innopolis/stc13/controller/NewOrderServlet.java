package ru.innopolis.stc13.controller;

import ru.innopolis.stc13.service.OrderService;
import ru.innopolis.stc13.service.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;

public class NewOrderServlet extends HttpServlet {

    OrderService orderService;

    public NewOrderServlet() {
        orderService = new OrderServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String comments = new String(req.getParameter("comments").getBytes("ISO-8859-1"), Charset.forName("UTF-8"));
        String adress = new String(req.getParameter("adress").getBytes("ISO-8859-1"), Charset.forName("UTF-8"));
        if (orderService.checkStatus(comments, adress)) {
            orderService.addOrder(comments, adress);
            resp.sendRedirect("/newOrder.jsp?status=OK");
        } else {
            resp.sendRedirect("/newOrder.jsp");
        }
    }
}
