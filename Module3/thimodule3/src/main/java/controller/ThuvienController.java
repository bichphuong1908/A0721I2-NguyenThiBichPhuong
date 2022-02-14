package controller;

import model.Thuvien;
import service.ThuvienService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ThuvienController", urlPatterns = "/thuvien")
public class ThuvienController extends HttpServlet {
    private ThuvienService thuvienService= new ThuvienService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action= request.getParameter("action");
        switch (action){
            case "save":
                String sid= request.getParameter("id");
                int id= sid.isEmpty()? 0: Integer.parseInt(sid);
                String ten_sach= request.getParameter("ten_sach");
                String tac_gia= request.getParameter("tac_gia");
                int so_luong= Integer.parseInt(request.getParameter("so_luong"));
                String mo_ta= request.getParameter("mo_ta");
                Thuvien thuvien= new Thuvien(id, ten_sach, tac_gia, so_luong, mo_ta);
                thuvienService.save(thuvien);
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
                Thuvien thuvien= thuvienService.get(id);
                request.setAttribute("thuvien", thuvien);
                request.getRequestDispatcher("/thuvien/create.jsp").forward(request, response);
                break;
            case "delete":
                thuvienService.delete(Integer.parseInt(request.getParameter("id")));
            default:
                request.setAttribute("thuviens", thuvienService.getAll());
                request.getRequestDispatcher("/thuvien/list.jsp").forward(request, response);
        }
    }
}
