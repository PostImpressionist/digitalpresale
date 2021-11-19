package servlet;

import model.Role;
import model.User;
import repository.inmemory.InMemoryUserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * created by E.K.
 * 2021 November 19
 **/

public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setName(req.getParameter("name"));
        user.setEmail(req.getParameter("email"));
        user.setCompany(req.getParameter("company"));
        user.setPosition(req.getParameter("position"));
        user.setPassword(req.getParameter("pass"));
        user.setRole(Role.User);

        InMemoryUserRepository userRepository = InMemoryUserRepository.getInstance();

        // TODO user fields acknowledge
        if(null == userRepository.getByEmail(user.getEmail())){
            userRepository.save(user);
        } else{
            req.setAttribute("emailAlreadyInUse", true);
            req.getRequestDispatcher("/registration.jsp").forward(req, resp);
        }

        req.getRequestDispatcher("/").forward(req, resp);

    }
}
