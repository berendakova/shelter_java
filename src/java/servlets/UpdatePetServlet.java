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

@WebServlet("/update_pet/*")
public class UpdatePetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("current_user");
        if(user.getIsSuperuser().equals("1")) {
            int idPet = gePetId(req.getRequestURI());
            try {
                PetRepositories petRepositories = new PetRepositories();
                Pet pet = petRepositories.getPetById(idPet);
                System.out.println("UPDATE " + pet.getName());
                req.setAttribute("pet_img", pet.getImg());
                req.setAttribute("pet_description", pet.getDescription());
                req.setAttribute("pet_name", pet.getName());
                req.setAttribute("pet_breed", pet.getBreed());
                req.setAttribute("pet_age", pet.getAge());
                req.setAttribute("pet_disease", pet.getDisease());
                req.setAttribute("sex", pet.getSex());
                pet.setStatus(0);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            req.getRequestDispatcher("/WEB-INF/updatePet.jsp").forward(req, resp);
        }else
            resp.sendRedirect("/shelter");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if(user.getIsSuperuser().equals("1")){
            int idPet = gePetId(req.getRequestURI());
            try {
                PetRepositories petRepositories = new PetRepositories();
                Pet pet = petRepositories.getPetById(idPet);
                pet.setImg((String) req.getParameter("pet_img"));
                pet.setDescription((String) req.getParameter("pet_description"));
                pet.setName((String) req.getParameter("pet_name"));
                pet.setBreed((String) req.getParameter("pet_breed"));
                pet.setAge((String) req.getParameter("pet_age"));
                pet.setDisease((String) req.getParameter("pet_disease"));
                pet.setSex((String) req.getParameter("sex"));
                pet.setStatus(0);
                petRepositories.updatePet(pet);
                resp.sendRedirect("/our_pets");
            } catch (ClassNotFoundException | SQLException e) {
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
