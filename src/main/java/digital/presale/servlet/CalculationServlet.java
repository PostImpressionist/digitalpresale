package digital.presale.servlet;

import digital.presale.model.Calculation;
import digital.presale.model.User;
import digital.presale.repository.inmemory.InMemoryCalculationRepository;
import digital.presale.repository.inmemory.InMemoryUserRepository;
import digital.presale.util.SecurityUtil;
import org.slf4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Objects;

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        User user = (User)request.getAttribute("user");

        switch (action == null ? "all" : action) {
            case "delete" -> {
                int id = getId(request);
                calcRepository.delete(id);
                response.sendRedirect("calculations");
            }
            case "create" -> {
                user = userRepository.get(getId(request));
                log.info("create calculation, user = " + user);
                final Calculation calc = new Calculation(
                        LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES),
                        "",
                        Collections.emptyList(),
                        user);
                request.setAttribute("user", user);
                request.setAttribute("calc", calc);
                request.getRequestDispatcher("/calculationForm.jsp").forward(request, response);

            }
            case "preview" -> {
                request.setAttribute("calculation", calcRepository.get(getId(request)));
                request.getRequestDispatcher("/calcPreview.jsp").forward(request, response);
            }
            case "filter" -> {
                /*LocalDate startDate = parseLocalDate(request.getParameter("startDate"));
                LocalDate endDate = parseLocalDate(request.getParameter("endDate"));
                LocalTime startTime = parseLocalTime(request.getParameter("startTime"));
                LocalTime endTime = parseLocalTime(request.getParameter("endTime"));
                request.setAttribute("meals", mealController.getBetween(startDate, startTime, endDate, endTime));
                request.getRequestDispatcher("/meals.jsp").forward(request, response);*/
            }
            default -> {
                request.setAttribute("calculationsList", calcRepository.getAll(user.getId()));
                request.getRequestDispatcher("/calculations.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String incomeEmail = request.getParameter("email");

        String incomePass = request.getParameter("pass");

        User user = SecurityUtil.loginDataValidation(incomeEmail, incomePass);
        request.setAttribute("user", user);

        if (null == user) {
            request.setAttribute("invalidData", true);
            log.info("user with email: " + incomeEmail + " and password: " + incomePass + " not found");
            request.getRequestDispatcher("/").forward(request, response);
        } else {
            log.info("user " + user.getName() + " logged in");
            request.setAttribute("calculationsList", calcRepository.getAll(user.getId()));
            request.getRequestDispatcher("/calculations.jsp").forward(request, response);
        }
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }
}
