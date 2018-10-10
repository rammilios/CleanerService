package ru.innopolis.stc13.controller;

import ru.innopolis.stc13.repository.dao.UserDaoImpl;
import ru.innopolis.stc13.service.RegisterService;
import ru.innopolis.stc13.service.RegisterServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.System.out;

public class RegisterServlet extends HttpServlet {
    private RegisterService registerService;

    @Override
    public void init() throws ServletException {
        super.init();
        registerService = new RegisterServiceImpl(new UserDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        if (registerService.checkStatus(login, password, name)) {
                registerService.addUser(login, password, name);
            req.getSession().setAttribute("login", login);
            req.getSession().setAttribute("password", password);
            req.getSession().setAttribute("name", name);
            out.print("You are successfully registered...");
            resp.sendRedirect("/dashBoard.jsp");
        } else {
            resp.sendRedirect("/register.jsp");
        }
    }
}
