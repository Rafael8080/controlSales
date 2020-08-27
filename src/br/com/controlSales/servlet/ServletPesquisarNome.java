package br.com.controlSales.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.controlSales.dao.ClienteDAO;


@WebServlet("/consultarNome")
public class ServletPesquisarNome extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ClienteDAO clienteDao = new ClienteDAO();
       
 
    public ServletPesquisarNome() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeConsulta = '%' + request.getParameter("nomeConsulta") + '%';
		
		if(nomeConsulta != null && !nomeConsulta.isEmpty()) {
			System.out.println("Entrou aqui");
			RequestDispatcher view = request.getRequestDispatcher("/dadosClientes.jsp");
			request.setAttribute("clientes", clienteDao.buscarClienteNome(nomeConsulta));
			view.forward(request, response);
		} else {
			RequestDispatcher view = request.getRequestDispatcher("/dadosClientes.jsp");
			request.setAttribute("clientes", clienteDao.listarClientes());
			view.forward(request, response);
		}
		
	}

}
