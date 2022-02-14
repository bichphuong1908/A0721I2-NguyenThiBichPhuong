package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HomeController", urlPatterns = "/login")
public class HomeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //check login
//        ... Các bạn tự tìm hiểu.
        //
        request.getSession().setAttribute("usernameSession", username);
        Cookie cookieUsername = new Cookie("username", username);
        cookieUsername.setMaxAge(24*60*60); //24h

        Cookie cookiePassword = new Cookie("password", password);
        cookiePassword.setMaxAge(24*60*60);

        response.addCookie(cookieUsername);
        response.addCookie(cookiePassword);
        response.sendRedirect("/student");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
