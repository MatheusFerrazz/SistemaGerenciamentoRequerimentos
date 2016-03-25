/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.sgr.filtros;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author João
 */
/*@WebFilter(filterName = "FiltroLogin", urlPatterns = {"/*"})
public class FiltroLogin implements Filter {

    private FilterConfig filterConfig = null;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException { 
        
        HttpServletRequest requisicao = (HttpServletRequest) request;
        HttpServletResponse resposta = (HttpServletResponse) response;
        
        HttpSession session = requisicao.getSession(false);
        String uri = requisicao.getRequestURI();
        
        if (uri.endsWith("ControladorLogin") || uri.endsWith("sgr_index.html")){
            chain.doFilter(request, response);
        }else{
            if (session == null){
                resposta.sendRedirect(requisicao.getContextPath() + "/sgr_index.html");
            }else{
                if (session.getAttribute("aluno") == null)
                    resposta.sendRedirect(requisicao.getContextPath() + "/sgr_index.html");
                else
                    chain.doFilter(request, response);
            }
        }
    }
 

    @Override
    public void destroy() {        
    }


    @Override
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
    }

}*/
