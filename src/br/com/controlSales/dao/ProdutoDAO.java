package br.com.controlSales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.controlSales.jdbc.ConnectionFactory;
import br.com.controlSales.model.Fornecedor;
import br.com.controlSales.model.Produto;

public class ProdutoDAO {

	private Connection con;
	
	public ProdutoDAO() {
		this.con = new ConnectionFactory().getConnection();
	}
	
	public void cadastrar(Produto obj) {
		try {
			String sql = "insert into tb_produtos (descricao, preco, qtd_estoque, for_id) values (?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, obj.getDescricao());
			stmt.setDouble(2, obj.getPreco());
			stmt.setInt(3, obj.getQtd_estoque());
			stmt.setInt(4, obj.getFornecedorId());
			stmt.execute();
			stmt.close();
			System.out.println("cadastrado com sucesso");
			
			
		}catch(Exception e) {
			
			System.out.println("Erro no sql");
			e.printStackTrace();
		}
	}
	
	public List<Produto> listarProdutos(){
		
		try {
			
			List<Produto> lista = new ArrayList<>();
			String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome from tb_produtos as p "
					+ "inner join tb_fornecedores as f on (p.for_id = f.id)";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Produto obj = new Produto();
				Fornecedor f = new Fornecedor();
				
				obj.setId(rs.getInt("p.id"));
				obj.setDescricao(rs.getString("p.descricao"));
				obj.setPreco(rs.getDouble("p.preco"));
				obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));
				
				f.setNome(rs.getString("f.nome"));
				obj.setFornecedor(f);
				
				lista.add(obj);
				
			}
			return lista;
		}catch(Exception e) {
			System.out.println("Erro no sql");
			e.printStackTrace();
			return null;
		}
		
		
	}
		
	public void alterarProduto(String id, Produto obj) {

		try {

			String sql = "update tb_produtos set descricao=?, preco=?, qtd_estoque=?, for_id=? where id = '"
					+ id + "'";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, obj.getDescricao());
			stmt.setDouble(2, obj.getPreco());
			stmt.setInt(3, obj.getQtd_estoque());
			stmt.setInt(4, obj.getFornecedorId());
			stmt.executeUpdate();
			stmt.close();

			System.out.println("Alterado com sucesso");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro sql");
		}

	}
	
	public Produto consultarProdutoId(String id) {

		Produto obj = new Produto();
		Fornecedor f = new Fornecedor();

		try {

			String sql = "select * from tb_produtos where id = '"+id+"' ";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				obj.setId(rs.getInt("id"));
				obj.setDescricao(rs.getString("descricao"));
				obj.setPreco(rs.getDouble("preco"));
				obj.setQtd_estoque(rs.getInt("qtd_estoque"));
				
			}
			return obj;
		} catch (SQLException e) {

			e.printStackTrace();
			return null;

		}

	}
	
	public void excluirProduto(String id) {

		try {

			String sql = "delete from tb_produtos where id = '" + id + "'";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.execute();
			stmt.close();
			System.out.println("Excluido com sucesso");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

	
} //Fecha classe ProdutoDAO
