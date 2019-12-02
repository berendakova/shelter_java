package servlets;

import entities.User;
import org.apache.commons.codec.digest.DigestUtils;
import repositories.UserRepositories;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/auth")
public class Authentication extends HttpServlet {

    private UserRepositories userRepositories = new UserRepositories();

    public Authentication() throws ClassNotFoundException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/auth.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = req.getParameter("user_email");
        String password = req.getParameter("user_password");
        String remember = req.getParameter("remember");
        String log = null;
        try {
            User userFromDB = userRepositories.getUserByLogin(email);
            if(userFromDB != null){
                System.out.println(userFromDB.getIsSuperuser());
                String md5password = DigestUtils.md5Hex(password);
                if(userFromDB.getUserPassword().equals(md5password)){

                    session.setAttribute("log",true);
                    session.setAttribute("current_user", userFromDB);
                    session.setAttribute("user_name",userFromDB.getUserName());
                }
                resp.sendRedirect("/shelter");
            }
            else{
                session.setAttribute("log",false);
                resp.sendRedirect("/reg");
            }
    } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
