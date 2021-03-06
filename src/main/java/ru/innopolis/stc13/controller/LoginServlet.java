package ru.innopolis.stc13.controller;

import ru.innopolis.stc13.service.LoginService;
import ru.innopolis.stc13.service.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    LoginService loginService;

    @Override
    public void init() throws ServletException {
        super.init();
        loginService = new LoginServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (loginService.checkAuth(login, password)) {
            int role = loginService.getRole(login);
            req.getSession().setAttribute("login", login);
            req.getSession().setAttribute("role", role);
            resp.sendRedirect("/inner/dashBoard");
        } else {
            resp.sendRedirect("/login?errorCode=wrongLogin");
        }
    }
}
