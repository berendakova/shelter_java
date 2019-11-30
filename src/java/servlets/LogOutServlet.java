package servlets;

import entities.User;
import org.apache.commons.codec.digest.DigestUtils;
import repositories.UserRepositories;
import utils.Errors;
import utils.UserReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/logOut")
public class LogOutServlet extends HttpServlet {

    private UserRepositories userRepositories = new UserRepositories();

    public LogOutServlet() throws ClassNotFoundException {
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (session.getAttribute("current_user") != null) {
            User current_user = (User) session.getAttribute("current_user");

            session.setAttribute("log",false);
            session.setAttribute("current_user", null);
            session.setAttribute("user_name",null);

            req.setAttribute("log",false);


        }
        resp.sendRedirect("/shelter");



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/shelter");

    }
}
