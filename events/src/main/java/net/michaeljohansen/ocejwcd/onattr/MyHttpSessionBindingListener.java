package net.michaeljohansen.ocejwcd.onattr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * User: Michael Johansen
 * Date: 06.08.2015
 * Time: 10:24
 */
public class MyHttpSessionBindingListener implements HttpSessionBindingListener {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public MyHttpSessionBindingListener() {
        logger.info("Created");
    }

    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        logger.info(String.format(
                "valueBound: Session: %s, Name: %s, Value: %s",
                httpSessionBindingEvent.getSession().getId(),
                httpSessionBindingEvent.getName(),
                httpSessionBindingEvent.getValue()
        ));
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        logger.info(String.format(
                "valueUnbound: Session: %s, Name: %s, Value: %s",
                httpSessionBindingEvent.getSession().getId(),
                httpSessionBindingEvent.getName(),
                httpSessionBindingEvent.getValue()
        ));
    }
}
