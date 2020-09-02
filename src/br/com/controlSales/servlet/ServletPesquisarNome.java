package br.com.controlSales.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.controlSales.dao.ClienteDAO;
import br.com.controlSales.dao.FuncionarioDAO;


@WebServlet("/pages/consultarNome")
public class ServletPesquisarNome extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ClienteDAO clienteDao = new ClienteDAO();
    private FuncionarioDAO funcionarioDao = new FuncionarioDAO();
 
    public ServletPesquisarNome() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		String nomeConsulta = '%' + request.getParameter("nomeConsulta") + '%';
		
		if(nomeConsulta != null && !nomeConsulta.isEmpty() && acao != null && acao.equalsIgnoreCase("pesquisarCliente")) {
			System.out.println("Entrou aqui pesquisarCliente");
			RequestDispatcher view = request.getRequestDispatcher("/pages/dadosClientes.jsp");
			request.setAttribute("clientes", clienteDao.buscarClienteNome(nomeConsulta));
			view.forward(request, response);
		}else if(nomeConsulta != null && !nomeConsulta.isEmpty() && acao != null && acao.equalsIgnoreCase("pesquisarFuncionario")) {
			System.out.println("Entrou aqui pesquisarFuncionario");
			RequestDispatcher view = request.getRequestDispatcher("/pages/dadosFuncionarios.jsp");
			request.setAttribute("funcionarios",funcionarioDao.buscaFuncionarioNome(nomeConsulta));
			view.forward(request, response);
		} 
		else {
			RequestDispatcher view = request.getRequestDispatcher("/pages/dadosClientes.jsp");
			request.setAttribute("clientes", clienteDao.listarClientes());
			view.forward(request, response);
		}
		
	}

}
