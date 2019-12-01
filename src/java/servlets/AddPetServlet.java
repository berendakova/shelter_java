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

@WebServlet("/add_pet")
public class AddPetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("current_user");

        if(user.getIsSuperuser().equals("0")){
            resp.sendRedirect("/shelter");
        }else
            req.getRequestDispatcher("/WEB-INF/addPet.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("pet_img"));

        User user = (User) req.getSession().getAttribute("current_user");
        System.out.println(user.getIsSuperuser());
        if(user.getIsSuperuser().equals("1")){
            System.out.println("ADD PET");
            Pet pet = new Pet();
            String name = (String) req.getParameter("pet_name");
            System.out.println(name);
            pet.setName((String) req.getParameter("pet_name"));
            pet.setImg((String) req.getParameter("pet_img"));
            pet.setDescription((String) req.getParameter("pet_description"));
            pet.setName((String) req.getParameter("pet_name"));
            pet.setBreed((String) req.getParameter("pet_breed"));
            pet.setAge((String) req.getParameter("pet_age"));
            pet.setDisease((String) req.getParameter("pet_disease"));
            pet.setSex((String) req.getParameter("sex"));
            pet.setStatus(0);
            System.out.println(pet.getName());
            try {
                PetRepositories petRepositories = new PetRepositories();
                petRepositories.addPet(pet);
                System.out.println(pet.getName());
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            req.getRequestDispatcher("/WEB-INF/our_pets.jsp").forward(req, resp);
        }else
            resp.sendRedirect("/shelter");
    }
}
