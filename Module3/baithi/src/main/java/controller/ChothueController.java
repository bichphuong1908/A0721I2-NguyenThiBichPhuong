package controller;


import model.Chothue;
import service.ChothueService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChothueController extends HttpServlet {
    private ChothueService chothueService= new ChothueService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action= request.getParameter("action");
        switch (action){
            case "save":
                String sid= request.getParameter("id");
                int id= sid.isEmpty()? 0: Integer.parseInt(sid);
                String dien_tich= request.getParameter("dien_tich");
                String trang_thai= request.getParameter("trang_thai");
                int tang= request.getIntHeader("tang");
                String loai_van_phong = request.getParameter("loai_van_phong");
                String gia_cho_thue = request.getParameter("gia_cho_thue");
                String ngay_bat_dau = request.getParameter("ngay_bat_dau");
                String ngay_ket_thuc = request.getParameter("ngay_ket+thuc");
                Chothue chothue= new Chothue(id, dien_tich, trang_thai, tang, loai_van_phong, gia_cho_thue, ngay_bat_dau, ngay_ket_thuc);
                chothueService.save(chothue);
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
                Chothue chothue= chothueService.get(id);
                request.setAttribute("chothue", chothue);
                request.getRequestDispatcher("/chothue/add.jsp").forward(request, response);
                break;
            case "delete":
                chothueService.delete(Integer.parseInt(request.getParameter("id")));
            default:
                request.setAttribute("chothues", chothueService.getAll());
                request.getRequestDispatcher("/chothue/list.jsp").forward(request, response);
        }
    }
}
