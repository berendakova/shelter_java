package servlets;

import entities.Pet;
import entities.User;
import repositories.PetRepositories;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/our_pets")
public class OurPetsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/our_pets.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("current_user");

        List<Pet> listPets = new ArrayList<>();
        PetRepositories petRepositories = null;
        try {
            petRepositories = new PetRepositories();
            listPets = petRepositories.getByStatus(0);
            for (int i = 0; i < listPets.size(); i++) {
                System.out.println(listPets.get(i).getName());
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("listPet", listPets);
        req.setAttribute("user", user.getIsSuperuser());
        req.getRequestDispatcher("/WEB-INF/our_pets.jsp").forward(req, resp);
    }
}
