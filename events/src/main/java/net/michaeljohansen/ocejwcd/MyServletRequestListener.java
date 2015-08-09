package net.michaeljohansen.ocejwcd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * User: Michael Johansen
 * Date: 06.08.2015
 * Time: 14:03
 */
@WebListener
public class MyServletRequestListener implements ServletRequestListener {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public MyServletRequestListener() {
        logger.info("created");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        logger.info("requestDestroyed:" + servletRequestEvent.getServletRequest());
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        logger.info("requestInitialized:" + servletRequestEvent.getServletRequest());
    }
}
