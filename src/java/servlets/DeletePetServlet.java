package servlets;

import entities.User;
import repositories.PetRepositories;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/delete_pet/*")
public class DeletePetServlet extends HttpServlet {

    PetRepositories petRepositories = new PetRepositories();

    public DeletePetServlet() throws ClassNotFoundException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        int idPet = gePetId(req.getRequestURI());

        try {
            petRepositories.deletePet(idPet);
            resp.sendRedirect("/our_pets");
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        int idPet = gePetId(req.getRequestURI());
        if (user.getIsSuperuser().equals("0")) {
            resp.sendRedirect("/shelter");
        } else {
            try {
                petRepositories.deletePet(idPet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private int gePetId(String path) throws NumberFormatException {
        String[] params = path.split("/");
        int id_pet = Integer.valueOf(params[2]);
        return id_pet;
    }
}
