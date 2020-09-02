package br.com.controlSales.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.controlSales.dao.LoginDAO;
import br.com.controlSales.model.Login;


@WebServlet("/pages/ServletAutenticar")
public class ServletAutenticar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LoginDAO loginDao = new LoginDAO();
       
   
    public ServletAutenticar() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String url = request.getParameter("url");
		
		System.out.println("xghkgjhkj");
		
		if(email != null && !email.isEmpty() && senha != null && !senha.isEmpty()) {
			if(loginDao.login(email, senha)) {
				
				Login userSession = new Login();
				userSession.setEmail(email);
				userSession.setSenha(senha);
				
				HttpServletRequest req = (HttpServletRequest) request;
				HttpSession session = req.getSession();
				session.setAttribute("funcionario", userSession);
				System.out.println(url);
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/autenticar.jsp");
				dispatcher.forward(request, response);
			}
		}
		
	}

}
