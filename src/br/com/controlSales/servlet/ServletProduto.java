package br.com.controlSales.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.controlSales.dao.ProdutoDAO;
import br.com.controlSales.model.Produto;


@WebServlet("/pages/salvarProduto")
public class ServletProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Produto produto = new Produto();
	private ProdutoDAO produtoDao = new ProdutoDAO();
       
    public ServletProduto() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String acao = request.getParameter("acao");
		String idProduto = request.getParameter("idProduto");
		
		if(acao != null && acao.equalsIgnoreCase("listarProduto")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/dadosProduto.jsp");
			request.setAttribute("produtos", produtoDao.listarProdutos());
			dispatcher.forward(request, response);
		} else if(acao != null && idProduto != null && acao.equalsIgnoreCase("editarProduto") ) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/editarProduto.jsp");
			request.setAttribute("produto", produtoDao.consultarProdutoId(idProduto));
			dispatcher.forward(request, response);
		}else if(acao != null && idProduto != null && acao.equalsIgnoreCase("excluirProduto")) {
			produtoDao.excluirProduto(idProduto);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/dadosProduto.jsp");
			request.setAttribute("produtos", produtoDao.listarProdutos());
			dispatcher.forward(request, response);
			
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String descricao = request.getParameter("descricao");
		String preco = request.getParameter("preco");
		String qtd_estoque = request.getParameter("qtd_estoque");
		String fornecedor = request.getParameter("fornecedor");
		
		produto.setDescricao(descricao);
		produto.setPreco(Double.parseDouble(preco));
		produto.setQtd_estoque(Integer.parseInt(qtd_estoque));
		produto.setFornecedorId(Integer.parseInt(fornecedor));
		
		String acao = request.getParameter("acao");
		String idProduto = request.getParameter("idProduto");
		
		
		if(acao != null && acao.equalsIgnoreCase("salvarProduto")) {
			produtoDao.cadastrar(produto);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/dadosProduto.jsp");
			request.setAttribute("produtos", produtoDao.listarProdutos());
			dispatcher.forward(request, response);
			
		}else if(acao != null && idProduto != null && acao.equalsIgnoreCase("editarProduto")) {
			produtoDao.alterarProduto(idProduto, produto);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/dadosProduto.jsp");
			request.setAttribute("produtos", produtoDao.listarProdutos());
			dispatcher.forward(request, response);
		} else {
			produtoDao.alterarProduto(idProduto, produto);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/dadosProduto.jsp");
			request.setAttribute("produtos", produtoDao.listarProdutos());
			dispatcher.forward(request, response);
		}
		
	
	}

}
