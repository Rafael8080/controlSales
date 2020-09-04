package br.com.controlSales.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.controlSales.dao.FornecedorDAO;
import br.com.controlSales.model.Fornecedor;

@WebServlet("/pages/salvarFornecedor")
public class ServletFornecedor extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Fornecedor fornecedor = new Fornecedor();
	private FornecedorDAO fornecedorDao = new FornecedorDAO();

	public ServletFornecedor() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");
		String idFornecedor = request.getParameter("idFornecedor");

		if (acao != null && idFornecedor != null && acao.equalsIgnoreCase("editarFornecedor")) {

			RequestDispatcher view = request.getRequestDispatcher("/pages/editarFornecedor.jsp");
			Fornecedor consultarFornecedorId = fornecedorDao.consultarFornecedorId(idFornecedor);
			request.setAttribute("fornecedor", consultarFornecedorId);
			view.forward(request, response);

		} else if (acao != null && idFornecedor != null && acao.equalsIgnoreCase("excluirFornecedor")) {
			fornecedorDao.excluirFornecedor(idFornecedor);
			RequestDispatcher view = request.getRequestDispatcher("/pages/dadosFornecedor.jsp");
			request.setAttribute("fornecedores", fornecedorDao.listarFornecedores());
			view.forward(request, response);

		} else if (acao != null && acao.equalsIgnoreCase("listarFornecedores")) {

			RequestDispatcher view = request.getRequestDispatcher("/pages/dadosFornecedor.jsp");
			request.setAttribute("fornecedores", fornecedorDao.listarFornecedores());
			view.forward(request, response);

		} else {
			RequestDispatcher view = request.getRequestDispatcher("/pages/dadosFornecedor.jsp");
			request.setAttribute("fornecedores", fornecedorDao.listarFornecedores());
			view.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String cnpj = request.getParameter("cnpj");
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

		fornecedor.setNome(nome);
		fornecedor.setCnpj(cnpj);
		fornecedor.setEmail(email);
		fornecedor.setTelefone(telefone);
		fornecedor.setCelular(celular);
		fornecedor.setCep(cep);
		fornecedor.setEndereco(endereco);
		fornecedor.setNumero(Integer.parseInt(numero));
		fornecedor.setComplemento(complemento);
		fornecedor.setBairro(bairro);
		fornecedor.setCidade(cidade);
		fornecedor.setUf(uf);

		String acao = request.getParameter("acao");
		String idCliente = request.getParameter("idFornecedor");

		if (acao != null && acao.equalsIgnoreCase("salvarFornecedor")) {

			fornecedorDao.cadastrarFornecedor(fornecedor);

			RequestDispatcher view = request.getRequestDispatcher("/pages/dadosFornecedor.jsp");
			request.setAttribute("fornecedores", fornecedorDao.listarFornecedores());
			view.forward(request, response);

		} else if (acao != null && idCliente != null && acao.equalsIgnoreCase("editarFornecedor")) {

			fornecedorDao.alterarFornecedor(idCliente, fornecedor);

			RequestDispatcher view = request.getRequestDispatcher("/pages/dadosFornecedor.jsp");
			request.setAttribute("fornecedores", fornecedorDao.listarFornecedores());
			view.forward(request, response);

		} 
		else {
			RequestDispatcher view = request.getRequestDispatcher("/pages/dadosFornecedor.jsp");
			request.setAttribute("fornecedores", fornecedorDao.listarFornecedores());
			view.forward(request, response);
		}

	}

}
