package net.michaeljohansen.ocejwcd;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: Michael Johansen
 * Date: 31.07.2015
 * Time: 12:59
 */
@WebServlet(name = "SubControllerServlet", urlPatterns = {"/sub"})
public class SubControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletResponse.getWriter().print("sub");
    }
}
