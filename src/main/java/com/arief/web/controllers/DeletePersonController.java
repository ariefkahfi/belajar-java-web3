package com.arief.web.controllers;

import com.arief.web.jdbc.ConnectionDataSource.CreateConection;
import com.arief.web.jdbc.operation.CRUDPersonDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeletePersonController extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int kode = Integer.parseInt(req.getParameter("kode"));

        CRUDPersonDaoImpl dao  =new CRUDPersonDaoImpl(CreateConection.create());
        dao.delete(kode);
        resp.sendRedirect("/arief/person/list");
    }
}
