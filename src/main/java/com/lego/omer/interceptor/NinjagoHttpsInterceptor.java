package com.lego.omer.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class NinjagoHttpsInterceptor implements HandlerInterceptor {

    private static final Logger LOG = LoggerFactory.getLogger(NinjagoHttpsInterceptor.class);

    /**
     * Any operation can be performed at this point before sending the request to the controller
     *
     * @param request  in-coming request
     * @param response out-going response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle
    (HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        //Do something
        LOG.debug("Pre Handle operation being performed");
        return true;
    }

    /**
     * Any operation can be performed at this point before sending the response to the client
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {

        //Do something
        LOG.debug("Post Handle operation being performed");
    }

    /**
     * This is used to perform operations after completing the request and response
     *
     * @param request
     * @param response
     * @param handler
     * @param exception
     * @throws Exception
     */
    @Override
    public void afterCompletion
    (HttpServletRequest request, HttpServletResponse response, Object
            handler, Exception exception) throws Exception {

        //Do something
        LOG.debug("Request and response successfully completed");
    }
}
