package net.michaeljohansen.ocejwcd;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * User: Michael Johansen
 * Date: 04.08.2015
 * Time: 13:20
 */
@WebListener
public class ActiveSessionsListener implements HttpSessionListener {
    private Map<String, HttpSession> sessionMap = new HashMap<>();

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        session.setMaxInactiveInterval(10 /* seconds */);
        System.out.println("Session created: " + session.getId());

        sessionMap.put(session.getId(), session);
        session.getServletContext().setAttribute("sessionMap", sessionMap);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        System.out.println("Session destroyed: " + session.getId());
        sessionMap.remove(session.getId());
    }
}
