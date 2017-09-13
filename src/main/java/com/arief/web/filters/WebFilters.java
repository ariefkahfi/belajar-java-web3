package com.arief.web.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class WebFilters implements Filter {


    private ServletContext context;

    public void init(FilterConfig filterConfig) throws ServletException {
        context  = filterConfig.getServletContext();
        context.log("Init-Filter");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;

        HttpSession sesi = req.getSession();

        context.log("Client ip address :: " + req.getRemoteAddr());
        context.log("RequestURI :: " + req.getRequestURI());


        if(sesi.getAttribute("kode-person")==null){
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }

    }

    public void destroy() {
        context.log("Destroying-filter");
    }
}
