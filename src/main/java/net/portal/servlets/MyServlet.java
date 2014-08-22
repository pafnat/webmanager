package net.portal.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by p.lepeev on 22.08.14.
 */
@WebServlet("/s")
public class MyServlet extends HttpServlet {


    private static final long serialVersionUID = -2717902511925551147L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
/*
        PrintWriter out = response.getWriter();
        out.println("Hello Word");
*/

        double sqrtval = Math.sqrt(4.0);
        request.setAttribute("textA", "Hello, World, sqrt(4.0) = " + sqrtval);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);

    }
}