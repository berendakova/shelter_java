package servlets;

import entities.Pet;
import entities.User;
import repositories.PetRepositories;
import repositories.UserRepositories;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/profile")
public class PersonServlet extends HttpServlet {

    private UserRepositories userRepositories = new UserRepositories();

    public PersonServlet() throws ClassNotFoundException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/personalPage.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("current_user");
        if (user != null) {
            try {
                PetRepositories petRepositories = new PetRepositories();
                List<Pet> pets = petRepositories.getPetByUserId(user.getIdUser());
                req.setAttribute("pets", pets);
                req.setAttribute("user_name", user.getUserName());
                System.out.println("PERSON SERVLET + " + user.getIsSuperuser());
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        req.getRequestDispatcher("/WEB-INF/personalPage.jsp").forward(req, resp);

    }
}
