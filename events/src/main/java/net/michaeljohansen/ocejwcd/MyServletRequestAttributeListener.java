package net.michaeljohansen.ocejwcd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * User: Michael Johansen
 * Date: 06.08.2015
 * Time: 14:13
 */
@WebListener
public class MyServletRequestAttributeListener implements ServletRequestAttributeListener {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        logger.info(String.format(
                "attributeAdded: Name: %s, Value: %s",
                servletRequestAttributeEvent.getName(),
                servletRequestAttributeEvent.getValue()
        ));
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        logger.info(String.format(
                "attributeRemoved: Name: %s, Value: %s",
                servletRequestAttributeEvent.getName(),
                servletRequestAttributeEvent.getValue()
        ));

    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        logger.info(String.format(
                "attributeReplaced: Name: %s, Value: %s",
                servletRequestAttributeEvent.getName(),
                servletRequestAttributeEvent.getValue()
        ));

    }
}
