package net.michaeljohansen.ocejwcd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * User: Michael Johansen
 * Date: 06.08.2015
 * Time: 14:54
 */
@WebListener
public class MyServletContextListener implements ServletContextListener{
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public MyServletContextListener() {
        logger.info("created");
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.info("contextDestroyed");
    }
}
