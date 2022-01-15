package controller;

import model.Customer;
import service.CustomerService;
import service.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CustomerController", urlPatterns = "/customer")
public class CustomerController extends HttpServlet {
    private CustomerService customerService= new CustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action= request.getParameter("action");
        switch (action){
            case "create":
                String name= request.getParameter("name");
                String birthday= request.getParameter("birthday");
                String address= request.getParameter("address");
                String avatar= request.getParameter("avatar");
                Customer customer= new Customer(name, birthday, address, avatar);
                customerService.create(customer);
                break;
            case "delete":
                // delete
                break;
            case "update":
                    // update
                break;
        }

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customers1",customerService.getAll());
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }
}
