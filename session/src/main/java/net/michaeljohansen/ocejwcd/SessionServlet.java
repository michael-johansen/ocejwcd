package net.michaeljohansen.ocejwcd;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: Michael Johansen
 * Date: 04.08.2015
 * Time: 11:54
 */
@WebServlet(name = "SessionServlet", urlPatterns = "/", loadOnStartup = 1)
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/sessions.jsp").include(httpServletRequest, httpServletResponse);

        getServletContext().getInitParameter("test"); // context parameter
        getServletConfig().getInitParameter("test");  // servlet parameter
        getInitParameter("test");                     // servlet parameter

    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getSession().setAttribute("user", httpServletRequest.getParameter("user"));
        httpServletResponse.sendRedirect(httpServletResponse.encodeRedirectURL("updatedName"));
    }
}
