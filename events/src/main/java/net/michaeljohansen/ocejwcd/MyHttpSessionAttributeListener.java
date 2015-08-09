package net.michaeljohansen.ocejwcd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * User: Michael Johansen
 * Date: 06.08.2015
 * Time: 10:32
 */
@WebListener
public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public MyHttpSessionAttributeListener() {
        logger.info("Created");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        logger.info(String.format(
                "attributeAdded: %s, \"%s\": \"%s\"",
                httpSessionBindingEvent.getSession().getId(),
                httpSessionBindingEvent.getName(),
                httpSessionBindingEvent.getValue()
        ));
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        logger.info(String.format(
                "attributeRemoved: %s, \"%s\": \"%s\"",
                httpSessionBindingEvent.getSession().getId(),
                httpSessionBindingEvent.getName(),
                httpSessionBindingEvent.getValue()
        ));

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.printf(
                "attributeRemoved: %s, \"%s\": \"%s\"",
                httpSessionBindingEvent.getSession().getId(),
                httpSessionBindingEvent.getName(),
                httpSessionBindingEvent.getValue()
        );

    }
}
