package com.arief.web.controllers;

import com.arief.web.entity.Person;
import com.arief.web.jdbc.ConnectionDataSource.CreateConection;
import com.arief.web.jdbc.operation.CRUDPersonDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

public class RegistrasiPersonController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/page/person/register-person.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int kode = Integer.parseInt(req.getParameter("kode-person"));
        String nama = req.getParameter("nama-person");
        String gender = req.getParameter("gender-person");


        Person newPerson = new Person(kode,nama,gender);


        CRUDPersonDaoImpl dao = new CRUDPersonDaoImpl(CreateConection.create());
        dao.save(newPerson);

        req.setAttribute("pesan","Save data berhasil");
        RequestDispatcher rd = req.getRequestDispatcher("/page/home/home-person.jsp");
        rd.forward(req,resp);
    }



}
