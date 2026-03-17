package com.example;

import jakarta.servlet.*;          // ← changed from javax to jakarta
import jakarta.servlet.http.*;     // ← changed from javax to jakarta
import java.io.*;

public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.getWriter().println("<h1>Hello from Jenkins Pipeline!</h1>");
    }
}
