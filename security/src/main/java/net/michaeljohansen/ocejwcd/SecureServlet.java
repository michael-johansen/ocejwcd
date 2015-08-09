package net.michaeljohansen.ocejwcd;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.TreeMap;

/**
 * User: Michael Johansen
 * Date: 30.07.2015
 * Time: 13:49
 *
 * All http-methods require admin except GET
 */
@WebServlet(name = "AdminServlet", urlPatterns = {"/admin"})
@ServletSecurity(
        value = @HttpConstraint(
                rolesAllowed = "admin"
        ),
        httpMethodConstraints = {
                @HttpMethodConstraint(value = "GET"),
                @HttpMethodConstraint(value = "OPTIONS")
        }
)
public class SecureServlet extends HttpServlet {
    private final TreeMap<String, String> propertyMap = new TreeMap<>();

    {
        propertyMap.put("ocejwcd.complete", "false");
        propertyMap.put("ocejwcd.difficulty", "medium");
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.setAttribute("propertyMap", propertyMap);
        httpServletRequest.getRequestDispatcher("/admin/propertyList.jsp").include(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String key = httpServletRequest.getParameter("key");
        String value = httpServletRequest.getParameter("value");

        propertyMap.put(key, value);
        httpServletResponse.sendRedirect("admin");
    }

    @Override
    protected void doDelete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        propertyMap.remove(httpServletRequest.getParameter("key"));
    }
}
