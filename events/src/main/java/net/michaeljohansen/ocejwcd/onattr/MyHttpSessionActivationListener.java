package net.michaeljohansen.ocejwcd.onattr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * User: Michael Johansen
 * Date: 06.08.2015
 * Time: 10:39
 *
 * Couldn't get GlassFish to passivate sessions. But it should happen when session is moved between jvm's (clustering),
 * or when Session max-size overflows and must be persisted to disk.
 *
 */
public class MyHttpSessionActivationListener implements HttpSessionActivationListener {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public MyHttpSessionActivationListener() {
        logger.info("Created");
    }

    @Override
    public void sessionWillPassivate(HttpSessionEvent httpSessionEvent) {
        logger.info("session will passivate: " + httpSessionEvent.getSession().getId());
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent httpSessionEvent) {
        logger.info("session did activate: " + httpSessionEvent.getSession().getId());
    }
}


