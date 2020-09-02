package br.com.controlSales.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.controlSales.model.Login;



@WebFilter("/pages/*")
public class FilterAutenticar implements Filter {

    public FilterAutenticar() {
        
    }

	
	public void destroy() {
		
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		String autenticacaoUrl = req.getServletPath();
		
		Login userSession = (Login) session.getAttribute("funcionario");
		
		if(userSession == null && !autenticacaoUrl.equalsIgnoreCase("/pages/ServletAutenticar")) {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/autenticar.jsp?url="+autenticacaoUrl);
			dispatcher.forward(request, response);
			
			return;
			
		}
		
		chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
