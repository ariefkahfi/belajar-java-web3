package com.arief.web.controllers;

import com.arief.web.entity.Person;
import com.arief.web.jdbc.ConnectionDataSource.CreateConection;
import com.arief.web.jdbc.operation.CRUDPersonDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdatePersonController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int kode = Integer.parseInt(req.getParameter("kode"));

        CRUDPersonDaoImpl dao = new CRUDPersonDaoImpl(CreateConection.create());

        Person p = dao.getOne(kode);

        req.setAttribute("nama",p.getNama());
        req.setAttribute("gender",p.getGender());
        req.setAttribute("kode",p.getKode());

        req.getRequestDispatcher("/page/person/update-person.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


       int oldKode = Integer.parseInt(req.getParameter("old-kode-person"));

        System.err.println("OldKode : " + oldKode);

       Person update = new Person(req.getParameter("new-name-person"),req.getParameter("new-gender-person"));


       CRUDPersonDaoImpl dao = new CRUDPersonDaoImpl(CreateConection.create()) ;
       dao.update(oldKode,update);


       resp.sendRedirect("/arief/person/list");

    }
}
