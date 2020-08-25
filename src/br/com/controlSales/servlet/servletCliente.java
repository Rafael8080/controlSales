package br.com.controlSales.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.controlSales.dao.ClienteDAO;
import br.com.controlSales.model.Cliente;

@WebServlet("/salvarCliente")
public class servletCliente extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Cliente clienteObj = new Cliente();
	private ClienteDAO clienteDao = new ClienteDAO();

	public servletCliente() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");
		String idCliente = request.getParameter("idCliente");

		if (acao.equalsIgnoreCase("editarCliente") && acao != null && idCliente != null) {
			
			RequestDispatcher view = request.getRequestDispatcher("/editarCliente.jsp");
			Cliente consultarCLienteId = clienteDao.consultarClienteId(idCliente);
			request.setAttribute("cliente", consultarCLienteId);
			view.forward(request, response);
			

		} else if (acao.equalsIgnoreCase("excluirCliente") && acao != null && idCliente != null) {
			
			

		} else if (acao.equalsIgnoreCase("listarClientes") && acao != null) {
			
			RequestDispatcher view = request.getRequestDispatcher("/dadosClientes.jsp");
			request.setAttribute("clientes", clienteDao.listarClientes());
			view.forward(request, response);
			
		} else {
			RequestDispatcher view = request.getRequestDispatcher("/dadosClientes.jsp");
			request.setAttribute("clientes", clienteDao.listarClientes());
			view.forward(request, response);
			System.out.println("Cai aqui");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String rg = request.getParameter("rg");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String celular = request.getParameter("celular");
		String cep = request.getParameter("cep");
		String endereco = request.getParameter("endereco");
		String numero = request.getParameter("numero");
		String complemento = request.getParameter("complemento");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String uf = request.getParameter("uf");

		clienteObj.setNome(nome);
		clienteObj.setRg(rg);
		clienteObj.setCpf(cpf);
		clienteObj.setEmail(email);
		clienteObj.setTelefone(telefone);
		clienteObj.setCelular(celular);
		clienteObj.setCep(cep);
		clienteObj.setEndereco(endereco);
		clienteObj.setNumero(Integer.parseInt(numero));
		clienteObj.setComplemento(complemento);
		clienteObj.setBairro(bairro);
		clienteObj.setCidade(cidade);
		clienteObj.setUf(uf);

		String acao = request.getParameter("acao");
		String idCliente = request.getParameter("idCliente");
		
		if(acao != null && acao.equalsIgnoreCase("salvarClient")) {
			
			clienteDao.cadastrarCliente(clienteObj);
			
			RequestDispatcher view = request.getRequestDispatcher("/dadosClientes.jsp");
			request.setAttribute("clientes", clienteDao.listarClientes());
			view.forward(request, response);
			
			
		} else if(idCliente != null && acao != null && acao.equalsIgnoreCase("editarClient")) {
			
			clienteDao.alterarCliente(idCliente, clienteObj);
			
			RequestDispatcher view = request.getRequestDispatcher("/dadosClientes.jsp");
			request.setAttribute("clientes", clienteDao.listarClientes());
			view.forward(request, response);
			
		} else {			
			RequestDispatcher view = request.getRequestDispatcher("/dadosClientes.jsp");
			request.setAttribute("clientes", clienteDao.listarClientes());
			view.forward(request, response);
		}
		

	}

}
