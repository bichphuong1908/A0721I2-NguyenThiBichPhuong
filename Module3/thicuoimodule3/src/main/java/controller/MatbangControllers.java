package controller;

import model.Matbang;
import service.MatbangServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MatbangControllers", urlPatterns = "/matbang")
public class MatbangControllers extends HttpServlet {
    private MatbangServices matbangServices= new MatbangServices();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action= request.getParameter("action");
        switch (action){
            case "save":
                String sid= request.getParameter("id");
                int id= sid.isEmpty()? 0: Integer.parseInt(sid);
                String dien_tich= request.getParameter("dien_tich");
                String trang_thai= request.getParameter("trang_thai");
                int tang= Integer.parseInt(request.getParameter("tang"));
                String loai_van_phong= request.getParameter("loai_van_phong");
                String gia_cho_thue= request.getParameter("gia_cho_thue");
                String ngay_bat_dau= request.getParameter("ngay_bat_dau");
                String ngay_ket_thuc= request.getParameter("ngay_ket_thuc");
                Matbang matbang= new Matbang(id, dien_tich, trang_thai, tang, loai_van_phong, gia_cho_thue, ngay_bat_dau, ngay_ket_thuc);
                matbangServices.save(matbang);
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
                Matbang matbang= matbangServices.get(id);
                request.setAttribute("matbang", matbang);
                request.getRequestDispatcher("/matbang/create.jsp").forward(request, response);
                break;
            case "delete":
                matbangServices.delete(Integer.parseInt(request.getParameter("id")));
            default:
                request.setAttribute("matbangs", matbangServices.getAll());
                request.getRequestDispatcher("/matbang/list.jsp").forward(request, response);
        }
    }
}
