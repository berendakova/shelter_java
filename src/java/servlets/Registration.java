import java.io.IOException;

import entities.User;
import exceptions.DbException;
import exceptions.DuplicateEntryException;
import repositories.UserRepositories;

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

        String content = "";

        if (
                req.getParameter("user_name") != null &&
                req.getParameter("user_email") != null &&
                req.getParameter("user_password") != null &&
                req.getParameter("user_password2") != null

        ) {
            String name = req.getParameter("user_name");
            String email = req.getParameter("user_email");
            String password = req.getParameter("user_password");
            String password2 = req.getParameter("user_password2");



            try {
                User user = new User(name,email,password);
                UserRepositories.add(user);
                resp.sendRedirect(req.getRequestURI() + "?status=1");
                return;
            } catch (DbException ex) {
                req.setAttribute("message", "Error with DB has been occured.");
            } catch (DuplicateEntryException ex) {
                req.setAttribute("message", "User with such email already exists.");
            }
        } else {
            req.setAttribute("message", "You have to fill all form fields.");
        }

        getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    }
}