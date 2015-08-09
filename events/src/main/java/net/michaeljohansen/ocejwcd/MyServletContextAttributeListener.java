package net.michaeljohansen.ocejwcd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * User: Michael Johansen
 * Date: 06.08.2015
 * Time: 14:54
 */
@WebListener
public class MyServletContextAttributeListener implements ServletContextAttributeListener{
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public MyServletContextAttributeListener() {
        logger.info("created");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        logger.info(String.format("attributeAdded: \"%s\": \"%s\"", servletContextAttributeEvent.getName(), servletContextAttributeEvent.getValue()));
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        logger.info(String.format("attributeRemoved: \"%s\": \"%s\"", servletContextAttributeEvent.getName(), servletContextAttributeEvent.getValue()));
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        logger.info(String.format("attributeReplaced: \"%s\": \"%s\"", servletContextAttributeEvent.getName(), servletContextAttributeEvent.getValue()));
    }
}
