package lk.ijse.stumanagement.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Demo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // types to send data to the backend

        // Query String
        String queryString = req.getQueryString();
        System.out.println(queryString);

        // Headers
        String header = req.getHeader("X-myHeader");
        System.out.println(header);

    }
}
