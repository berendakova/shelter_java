package servlets;

import java.io.IOException;
import entities.User;
import org.apache.commons.codec.digest.DigestUtils;
import repositories.RolesRepositories;
import repositories.UserRepositories;
import repositories.UserRolesRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@WebServlet("/reg")
public class Registration extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

/*
        Errors errors = new Errors();


        req.setAttribute("status_email", errors.isEmail(req.getParameter("user_email")));
        req.setAttribute("status_password", errors.isCorrectPasswords("user_password", "user_password2"));*/

        String name = req.getParameter("user_name");

        String email = req.getParameter("user_email");
        String password = req.getParameter("user_password");
        String password2 = req.getParameter("user_password2");
        String[] roles = req.getParameterValues("listRole");

        password = DigestUtils.md5Hex(password);


        try {
            UserRolesRepository userRolesRepository = new UserRolesRepository();
            UserRepositories userRepositories= new UserRepositories();
            if(userRepositories.getUserByLogin(email)!=null){
                getServletContext().getRequestDispatcher("/WEB-INF/reg.jsp").forward(req, resp);
                return;
            }
            userRepositories.addUser(name,email,password);
            User user = userRepositories.getUserByLogin(email);

            RolesRepositories rolesRepositories = new RolesRepositories();
           /* UserRole role = rolesRepositories.getRolesByName()*/

            for (int i = 0; i < roles.length; i++) {
                rolesRepositories.addRoles(roles[i]);
                userRolesRepository.addUserRole(user.getIdUser(), rolesRepositories.getRolesByName(roles[i]).getId() );
            }




            req.setAttribute("reg",true);
        } catch (ClassNotFoundException | SQLException e) {
            req.setAttribute("reg",false);
            e.printStackTrace();
        }



/*

        for (int i = 0; i < roles.length; i++) {
            System.out.println(roles[i]);
        }


        User user = new User(name, email, password);
        {

            try {
                UserRepositories.add(user);
                return;
            } catch (DbException | DuplicateEntryException ex) {
                ex.printStackTrace();
            }
        }
*/

        resp.sendRedirect("/shelter");


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/reg.jsp").forward(req, resp);
        /*resp.sendRedirect("index.jsp");*/
    }
}