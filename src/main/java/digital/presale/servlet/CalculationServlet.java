package digital.presale.servlet;

import digital.presale.model.User;
import digital.presale.repository.inmemory.InMemoryCalculationRepository;
import digital.presale.repository.inmemory.InMemoryUserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.slf4j.Logger;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * created by E.K.
 * 2021 November 19
 **/

public class CalculationServlet extends HttpServlet {
    
    private static final Logger log = getLogger(CalculationServlet.class);

    private static final InMemoryUserRepository userRepository = InMemoryUserRepository.getInstance();

    private static final InMemoryCalculationRepository calcRepository = InMemoryCalculationRepository.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get");
        req.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("/calculation.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*TODO - income: userEmail & userPassword
       - security things(password & login validation)
       - pull user id from userRepo(getByEmail -> getId)
       - get all calcuations from the calcRepo for this user(getAll by userId)
       - pass calculation list to jsp via attribute
 */
        System.out.println("post");

        String incomeEmail = request.getParameter("email");

        String incomePass = request.getParameter("pass");

        // email and pass validation. If not valid -> to main page with attr invalidData = true
        User user = SecurityUtil.loginDataValidation(incomeEmail,incomePass);

        if(null == user){
            request.setAttribute("invalidData", true);
            request.getRequestDispatcher("/").forward(request, response);
        }

        request.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("/calculation.jsp").forward(request, response);
    }
}
