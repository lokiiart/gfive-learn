package com.springapp.mvc.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


/**
 * Created by loki on 4/3/15.
 */
@WebFilter(filterName = "stringToJsonFilter")
public class stringToJsonFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(stringToJsonFilter.class);
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
        logger.error("test"+String.valueOf(req));

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
