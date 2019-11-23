package servlets;

import entities.User;
import utils.Errors;
import utils.UserReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class Authentication extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("auth.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name ="";
        String email = "";
        String password = "";
        String remember = "";
        Errors error = new Errors();
        if ((req.getParameter("user_email") != null) && (req.getParameter("user_password") != null)) {
            email = req.getParameter("user_email");
            password = req.getParameter("user_password");
            remember = req.getParameter("remember");
        }

        boolean status_email_password = error.existEmailInBd(email, password);

        req.setAttribute("status_email_password", status_email_password);

        System.out.println("status_email_password = "+status_email_password);
        if (status_email_password) {
            UserReader userReader = new UserReader();
            List<User> users = userReader.readUser("/home/tanya/IdeaProjects/shelter_v3/user.csv");
            for (int i = 0; i < users.size(); i++) {
                if((users.get(i).getUser_email().equals(email)) && (users.get(i).getUser_password().equals(password))){
                    name = users.get(i).getUser_name();
                }
            }


            HttpSession httpSession = req.getSession(true);
            httpSession.setAttribute("user_email", email);
            System.out.println(email);


            req.setAttribute("log", true);
            req.setAttribute("user_name", name);

//            if (req.getAttribute("log") != null) {
//
//                if (req.getAttribute("log").equals("true")) {
//                    req.getRequestDispatcher("/index.jsp").forward(req, resp);
//
//                }
//            }

     getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
//              resp.sendRedirect("/shelter");
        } else {

            req.setAttribute("log", false);
            req.setAttribute("sms", "can't find your profile, please, sign in");
        }

    }
}
