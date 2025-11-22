package com.example.test.auth;

import jakarta.servlet.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object h) throws Exception {
        String path = req.getRequestURI();
        if (path.startsWith("/login")) return true;
        HttpSession s = req.getSession(false);
        Users u = s == null ? null : (Users) s.getAttribute("user");
        if (u == null) { res.sendRedirect("/login");return false;}
        return true;
    }
}
