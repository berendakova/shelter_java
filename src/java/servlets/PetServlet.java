package servlets;

import entities.Pet;
import entities.User;
import repositories.PetRepositories;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/our_pets/*")
public class PetServlet extends HttpServlet {
    private PetRepositories petRepositories = new PetRepositories();

    public PetServlet() throws ClassNotFoundException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idPet = gePetId(req.getRequestURI());
        User user = (User) req.getSession().getAttribute("current_user");
        req.setAttribute("id_pet",idPet);
        try {
            petRepositories.updatePetStatus(idPet, 1);
            petRepositories.setPetUser(idPet, user.getIdUser());
            Pet pet = petRepositories.getPetById(idPet);
            if (pet != null) {
                req.setAttribute("pet", pet);
            } else {
                req.getRequestDispatcher("/WEB-INF/error404.jsp").forward(req, resp);
                return;
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            req.getRequestDispatcher("/WEB-INF/error404.jsp").forward(req, resp);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/petPersonal.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session!=null&&session.getAttribute("current_user")!=null){
            req.setAttribute("is_ok", true);
        }
        try {
            int id_pet = gePetId(req.getRequestURI());
            Pet pet = petRepositories.getPetById(id_pet);
            if (pet != null) {
                req.setAttribute("pet", pet);
            } else {
                req.getRequestDispatcher("/WEB-INF/error404.jsp").forward(req, resp);
                return;
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            req.getRequestDispatcher("/WEB-INF/error404.jsp").forward(req, resp);
        }
        req.getRequestDispatcher("/WEB-INF/petPersonal.jsp").forward(req, resp);
    }


    private int gePetId(String path) throws NumberFormatException {
        String[] params = path.split("/");
        int id_pet = Integer.valueOf(params[2]);
        return id_pet;
    }
}
