package com.userlogin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/login-user")
public class LoginServlet extends HttpServlet {
    private static final ArrayList<User> users = new ArrayList<>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(users);
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            response.sendRedirect("login.jsp");
            return;
        }

        users.add(new User(username, email, password));
        request.setAttribute("username", username);
        request.setAttribute("email", email);
        request.getRequestDispatcher("success.jsp").forward(request, response);
    }
}
