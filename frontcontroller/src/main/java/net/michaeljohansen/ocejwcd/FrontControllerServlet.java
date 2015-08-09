package net.michaeljohansen.ocejwcd;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * User: Michael Johansen
 * Date: 31.07.2015
 * Time: 11:22
 */
@WebServlet(name = "FrontControllerServlet", urlPatterns = "/")
public class FrontControllerServlet extends HttpServlet {
    private Map<String, String> externalInternalMapping = new HashMap<>();

    {
        externalInternalMapping.put("/", "/pages/main.jsp");
        externalInternalMapping.put("/ext", "/sub");
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.setAttribute("headerPath", "/fragments/header.jsp");
        httpServletRequest.setAttribute("footerPath", "/fragments/footer.jsp");
        String servletPath = httpServletRequest.getServletPath();
        if (externalInternalMapping.containsKey(servletPath)) {
            httpServletRequest.setAttribute("contentPath", externalInternalMapping.get(servletPath));
        } else {
            httpServletRequest.setAttribute("exception", new IllegalArgumentException("ServletPath: " + servletPath));
            httpServletRequest.setAttribute("contentPath", "/pages/error.jsp");
        }
        httpServletRequest.getRequestDispatcher("/WEB-INF/template.jsp").include(httpServletRequest, httpServletResponse);
    }
}
