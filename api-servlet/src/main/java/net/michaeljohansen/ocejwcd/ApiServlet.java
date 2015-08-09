package net.michaeljohansen.ocejwcd;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * User: Michael Johansen
 * Date: 05.08.2015
 * Time: 12:31
 */
@WebServlet(name = "ApiServlet", urlPatterns = "/")
public class ApiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        ApiResource resource = new ApiResource("someUrl");
        resource.getProperties().put("name", "Donald Duck");
        resource.getProperties().put("age", Calendar.getInstance().get(Calendar.YEAR) - 1934);

        httpServletRequest.setAttribute("resource", resource);
        httpServletRequest.getRequestDispatcher("/WEB-INF/resource.jsp").forward(httpServletRequest, httpServletResponse);
    }

    public static class ApiResource{
        private final String self;
        private final Map<String, Object> properties = new HashMap<>();

        public ApiResource(String self) {
            this.self = self;
        }


        public Map<String, Object> getProperties() {
            return properties;
        }

        public String getSelf() {
            return self;
        }
    }
}
