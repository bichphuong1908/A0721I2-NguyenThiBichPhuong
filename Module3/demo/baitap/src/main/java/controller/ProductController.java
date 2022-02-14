package controller;

import model.Product;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    @WebServlet(name = "ProductController", urlPatterns = "/product")
    public class ProductController extends HttpServlet {
        private ProductService productService= new ProductService();

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action= request.getParameter("action");
            switch (action){
                case "save":
                    String sid= request.getParameter("id");
                    int id= sid.isEmpty()? 0: Integer.parseInt(sid);
                    String name= request.getParameter("name");
                    String price= request.getParameter("price");
                    String quantity= request.getParameter("quantity");
                    String color= request.getParameter("color");
                    String description= request.getParameter("description");
                    String category= request.getParameter("category");
                    Product product= new Product(id, name, price, quantity, color, description, category);
                    productService.save(product);
                    break;
            }

            doGet(request, response);
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action= request.getParameter("action");
            if(action== null) action= "";

            switch (action){
                case "edit":
                    int id= Integer.parseInt(request.getParameter("id"));
                    Product product= productService.get(id);
                    request.setAttribute("product", product);
                    request.getRequestDispatcher("/product/create.jsp").forward(request, response);
                    break;
                case "delete":
                    productService.delete(Integer.parseInt(request.getParameter("id")));
                default:
                    request.setAttribute("products", productService.getAll());
                    request.getRequestDispatcher("/product/list.jsp").forward(request, response);
            }
        }
}
