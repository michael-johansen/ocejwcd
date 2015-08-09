package net.michaeljohansen.ocejwcd;

import net.michaeljohansen.ocejwcd.onattr.MyHttpSessionActivationListener;
import net.michaeljohansen.ocejwcd.onattr.MyHttpSessionBindingListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * User: Michael Johansen
 * Date: 06.08.2015
 * Time: 10:36
 */
@WebServlet(urlPatterns = "/")
public class DefaultServlet extends HttpServlet{
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public DefaultServlet(){
           logger.info("Created");
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        logger.info("doGet()");

        httpServletRequest.setAttribute("currentTime", new Date().toString());

        ServletContext servletContext = httpServletRequest.getServletContext();
        servletContext.setAttribute("last visited", new Date().toString());


        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("last visited", new Date().toString());
        session.setAttribute("my name", "Donald Duck");
        session.setAttribute("my name", "Mickey Mouse");
        session.removeAttribute("my name");

        if(session.getAttribute("activationListener") == null){
            session.setAttribute("activationListener", new MyHttpSessionActivationListener());
        }

        if(session.getAttribute("bindingListener") == null){
            session.setAttribute("bindingListener", new MyHttpSessionBindingListener());
        }
    }
}
