package com.arief.web.controllers;

import com.arief.web.entity.Person;
import com.arief.web.jdbc.ConnectionDataSource.CreateConection;
import com.arief.web.jdbc.operation.CRUDPersonDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginPersonController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/page/person/login-person.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int kode = Integer.parseInt(req.getParameter("kode-person"));


        CRUDPersonDaoImpl dao = new CRUDPersonDaoImpl(CreateConection.create());

        Person p = dao.getOne(kode);

        if(p!=null){
          req.setAttribute("pesan","Anda berhasil login");

          req.getSession().setAttribute("kode-person",p.getKode());
          req.getSession().setAttribute("nama-person",p.getNama());

          req.getRequestDispatcher("/page/home/home-person.jsp").forward(req,resp);
        }else{
          req.setAttribute("pesan","Akun tersebut belum terdaftar");
          req.getRequestDispatcher("/page/home/home-person.jsp").forward(req,resp);
        }

    }
}
