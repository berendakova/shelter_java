package servlets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import entities.User;
/*
import jdk.nashorn.internal.parser.JSONParser;
*/
import org.apache.commons.codec.digest.DigestUtils;
import org.json.simple.JSONObject;
import repositories.RolesRepositories;
import repositories.UserRepositories;
import repositories.UserRolesRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/reg")
public class Registration extends HttpServlet {


    List<User> user = new LinkedList<User>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("user_name");
        String email = req.getParameter("user_email");
        String password = req.getParameter("user_password");
        String password2 = req.getParameter("user_password2");
        String[] roles = req.getParameterValues("listRole");
        password = DigestUtils.md5Hex(password);
 /*       System.out.println("TEST               TEST");
        BufferedReader br =
                new BufferedReader(new InputStreamReader(req.getInputStream()));
        String json = "";
        if(br != null){
            json = br.readLine();
            System.out.println(json);
        }
*/
        /*ObjectMapper mapper = new ObjectMapper();*/
        /*User user = mapper.readValue(json,User.class);*//*
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(json);
*/        /*System.out.println(user.getUserName());*/
        try {
            UserRolesRepository userRolesRepository = new UserRolesRepository();
            UserRepositories userRepositories = new UserRepositories();

            if (userRepositories.getUserByLogin(email) != null) {
                String answ = "this user is exist";
                req.setAttribute("existUser", answ);
                if(!password.equals(password2)){
                    req.setAttribute("password_ans","password not equals" );
                }
                getServletContext().getRequestDispatcher("/WEB-INF/reg.jsp").forward(req, resp);
                return;
            }
            if(!password.equals(password2)){
                req.setAttribute("password_ans","password not equals" );
                getServletContext().getRequestDispatcher("/WEB-INF/reg.jsp").forward(req, resp);
                return;
            }
            userRepositories.addUser(name, email, password);
            User user = userRepositories.getUserByLogin(email);

            RolesRepositories rolesRepositories = new RolesRepositories();


            for (int i = 0; i < roles.length; i++) {
                rolesRepositories.addRoles(roles[i]);
                userRolesRepository.addUserRole(user.getIdUser(), rolesRepositories.getRolesByName(roles[i]).getId());
            }

            req.setAttribute("reg", true);
        } catch (ClassNotFoundException | SQLException e) {
            req.setAttribute("reg", false);
            e.printStackTrace();
        }

        resp.sendRedirect("/shelter");


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/reg.jsp").forward(req, resp);

    }



}