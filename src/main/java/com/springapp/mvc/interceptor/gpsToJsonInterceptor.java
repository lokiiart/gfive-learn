package com.springapp.mvc.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by loki on 4/3/15.
 */
public class gpsToJsonInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory
            .getLogger(gpsToJsonInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
//        logger.info("Request URL::" + request.getParameterMap()
//                + ":: Start Time=" + System.currentTimeMillis());
        System.out.println("fuck the paramete");


        // get request parameter map

        StringBuilder sb = new StringBuilder();
        BufferedReader reader = request.getReader();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } finally {
            reader.close();
        }
        System.out.println(sb.toString());
        String stringSource;
        String swapString;
        swapString = sb.toString();
        stringSource = swapString.substring(1,swapString.length()-2);
        String[] stringSourceArray = stringSource.split(",");
        Map<String, String> m = new HashMap<String, String>();

        m.put("model",stringSourceArray[0]);
        m.put("device",stringSourceArray[1]);
        m.put("imei",stringSourceArray[2]);
        m.put("longitude", stringSourceArray[3]);
        m.put("latitude", stringSourceArray[4]);
//        System.out.println(m);
//        ObjectMapper mapper = new ObjectMapper();
//        String jsonString = mapper.writeValueAsString(m);
//        System.out.println(jsonString);
//        for (int i = 0; i < stringSourceArray.length; i++) {
//            System.out.println("--"+stringSourceArray[i]);
//        }

//        request.setAttribute("mydate",jsonString);
        request.setAttribute("mydate",m);
        //if returned false, we need to make sure 'response' is sent
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("Request URL::" + request.getParameterMap()
                + " Sent to Handler :: Current Time=" + System.currentTimeMillis());
        //we can add attributes in the modelAndView and use that in the view page
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        long startTime = (Long) request.getAttribute("startTime");
        logger.info("Request URL::" + request.getRequestURL().toString()
                + ":: End Time=" + System.currentTimeMillis());
        logger.info("Request URL::" + request.getRequestURL().toString()
                + ":: Time Taken=" + (System.currentTimeMillis() - startTime));
    }


}

class stringSplit{
}
