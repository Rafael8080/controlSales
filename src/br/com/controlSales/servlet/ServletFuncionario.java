package br.com.controlSales.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.controlSales.dao.FuncionarioDAO;
import br.com.controlSales.model.Funcionario;

@WebServlet("/pages/salvarFuncionario")
public class ServletFuncionario extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Funcionario funcionarioObj = new Funcionario();
	private FuncionarioDAO funcionarioDao = new FuncionarioDAO();

	public ServletFuncionario() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");
		String idFuncionario = request.getParameter("idFuncionario");

		if (acao != null && idFuncionario != null && acao.equalsIgnoreCase("editarFuncionario")) {
			
				RequestDispatcher view = request.getRequestDispatcher("/pages/editarFuncionario.jsp");
				Funcionario funcionario = funcionarioDao.consultarFuncionarioId(idFuncionario);
				request.setAttribute("funcionario", funcionario);
				view.forward(request, response);		

		} else if (acao != null && idFuncionario != null && acao.equalsIgnoreCase("excluirFuncionario")) {
			
			funcionarioDao.excluirCliente(idFuncionario);
			RequestDispatcher view = request.getRequestDispatcher("/pages/dadosFuncionarios.jsp");
			request.setAttribute("funcionarios", funcionarioDao.listarFuncionarios());
			view.forward(request, response);
			
			
		} else if (acao != null && acao.equalsIgnoreCase("listarFuncionarios")) {

			RequestDispatcher view = request.getRequestDispatcher("/pages/dadosFuncionarios.jsp");
			request.setAttribute("funcionarios", funcionarioDao.listarFuncionarios());
			view.forward(request, response);

		} else {
			
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
		String senha = request.getParameter("senha");
		String cargo = request.getParameter("cargo");
		String nivelAcesso = request.getParameter("nivelAcesso");

		funcionarioObj.setNome(nome);
		funcionarioObj.setRg(rg);
		funcionarioObj.setCpf(cpf);
		funcionarioObj.setEmail(email);
		funcionarioObj.setTelefone(telefone);
		funcionarioObj.setCelular(celular);
		funcionarioObj.setCep(cep);
		funcionarioObj.setEndereco(endereco);
		funcionarioObj.setNumero(Integer.parseInt(numero));
		funcionarioObj.setComplemento(complemento);
		funcionarioObj.setBairro(bairro);
		funcionarioObj.setCidade(cidade);
		funcionarioObj.setUf(uf);
		funcionarioObj.setSenha(senha);
		funcionarioObj.setCargo(cargo);
		funcionarioObj.setNivelAcesso(nivelAcesso);
		
		
		String acao = request.getParameter("acao");
		String idFuncionario= request.getParameter("idFuncionario");

		if (acao != null && acao.equalsIgnoreCase("salvarFuncionario")) {

			funcionarioDao.cadastrarFuncionario(funcionarioObj);
			RequestDispatcher view = request.getRequestDispatcher("/pages/dadosFuncionarios.jsp");
			request.setAttribute("funcionarios", funcionarioDao.listarFuncionarios());
			view.forward(request, response);
			
		} else if (acao != null && idFuncionario != null && acao.equalsIgnoreCase("editarFuncionario")) {
			
			System.out.println(nivelAcesso);
			
			funcionarioDao.alterarFuncionario(idFuncionario, funcionarioObj);
			RequestDispatcher view = request.getRequestDispatcher("/pages/dadosFuncionarios.jsp");
			request.setAttribute("funcionarios", funcionarioDao.listarFuncionarios());
			view.forward(request, response);
		

		} 
		else {
			
		}

	}

}
