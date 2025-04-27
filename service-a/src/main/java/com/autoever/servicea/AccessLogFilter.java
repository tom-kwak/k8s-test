package com.autoever.servicea;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Iterator;


@Slf4j
public class AccessLogFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        log.info("[ACCESS_LOG] [{}] {} {}",
                req.getRemoteAddr(),
                req.getMethod(),
                req.getRequestURI()
        );
        Iterator headers = req.getHeaderNames().asIterator();
        while (headers.hasNext()) {
            String headerName = (String) headers.next();
            String headerValue = req.getHeader(headerName);
            log.info("[HEADER] {}, {}", headerName, headerValue);
        }
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("[FINAL]");
    }
}
