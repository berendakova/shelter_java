package servlets;

import utils.Errors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Authentication extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("auth.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = "";
        String password = "";
        Errors error = new Errors();
        if((req.getParameter("user_email") != null) && (req.getParameter("user_password") != null)) {


            email = req.getParameter("user_email");
            password = req.getParameter("user_password");
        }

        String status_email_password = error.existEmailInBd(email,password);
        req.setAttribute("status_email_password",status_email_password);

        if(status_email_password.equals("true")){
            HttpSession httpSession = req.getSession(true);
            httpSession.setAttribute("user_email",email);

            req.setAttribute("log",true);

        }

        getServletContext().getRequestDispatcher("auth.jsp").forward(req, resp);
    }
}
