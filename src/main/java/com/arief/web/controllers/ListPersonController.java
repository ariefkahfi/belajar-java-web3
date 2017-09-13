package com.arief.web.controllers;

import com.arief.web.entity.Person;
import com.arief.web.jdbc.ConnectionDataSource.CreateConection;
import com.arief.web.jdbc.operation.CRUDPersonDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListPersonController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CRUDPersonDaoImpl dao = new CRUDPersonDaoImpl(CreateConection.create());
        List<Person> data =  dao.getAll();


        req.setAttribute("data",data);
        req.getRequestDispatcher("/page/person/list-person.jsp").forward(req,resp);

    }
}
