package net.michaeljohansen.ocejwcd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * User: Michael Johansen
 * Date: 06.08.2015
 * Time: 10:24
 */
@WebListener
public class MyHttpSessionListener implements HttpSessionListener {
    private final Logger logger = LoggerFactory.getLogger(getClass());


    public MyHttpSessionListener() {
        logger.info("Created");
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        session.setMaxInactiveInterval(30);
        logger.info("session created: " + session.getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        logger.info("session destroyed: " + httpSessionEvent.getSession().getId());
    }
}
