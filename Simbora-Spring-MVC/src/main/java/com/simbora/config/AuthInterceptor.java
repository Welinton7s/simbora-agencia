package com.simbora.config;

import org.springframework.web.servlet.HandlerInterceptor;

import com.simbora.model.Clientes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        HttpSession session = request.getSession(false);
        Clientes clienteLogado = (session != null) ? (Clientes) session.getAttribute("clienteLogado") : null;

        if (clienteLogado == null) {
            response.sendRedirect(request.getContextPath() + "/clientes/login");
            return false;
        }

        return true;
    }
}