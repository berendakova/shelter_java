package servlets;

import java.io.IOException;
import entities.User;
import exceptions.DbException;
import exceptions.DuplicateEntryException;
import repositories.UserRepositories;
import utils.Errors;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Errors errors = new Errors();


        req.setAttribute("status_email", errors.isEmail(req.getParameter("user_email")));
        req.setAttribute("status_password", errors.isCorrectPasswords("user_password", "user_password2"));

        String name = req.getParameter("user_name");
        String email = req.getParameter("user_email");
        String password = req.getParameter("user_password");
        String password2 = req.getParameter("user_password2");
        String[] roles = req.getParameterValues("listRole");
        for (int i = 0; i < roles.length; i++) {
            System.out.println(roles[i]);
        }


        User user = new User(name, email, password,roles);
        {

            try {
                UserRepositories.add(user);
                return;
            } catch (DbException | DuplicateEntryException ex) {
                ex.printStackTrace();
            }
        }


        getServletContext().getRequestDispatcher("reg.jsp").forward(req, resp);
        /*resp.sendRedirect("index.jsp");*/


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("reg.jsp").forward(req, resp);
        /*resp.sendRedirect("index.jsp");*/
    }
}