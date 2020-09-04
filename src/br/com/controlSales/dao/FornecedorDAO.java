package br.com.controlSales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.controlSales.jdbc.ConnectionFactory;
import br.com.controlSales.model.Cliente;
import br.com.controlSales.model.Fornecedor;

public class FornecedorDAO {

	private Connection con;

	public FornecedorDAO() {
		this.con = new ConnectionFactory().getConnection();
	}

	public void cadastrarFornecedor(Fornecedor obj) {
		try {

			String sql = "insert into tb_fornecedores (nome, cnpj, email, telefone, "
					+ "celular, cep, endereco, numero, complemento, bairro, cidade, estado) values (?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, obj.getNome());
			stmt.setString(2, obj.getCnpj());
			stmt.setString(3, obj.getEmail());
			stmt.setString(4, obj.getTelefone());
			stmt.setString(5, obj.getCelular());
			stmt.setString(6, obj.getCep());
			stmt.setString(7, obj.getEndereco());
			stmt.setInt(8, obj.getNumero());
			stmt.setString(9, obj.getComplemento());
			stmt.setString(10, obj.getBairro());
			stmt.setString(11, obj.getCidade());
			stmt.setString(12, obj.getUf());
			stmt.execute();
			stmt.close();

			System.out.println("Cadastrado com sucesso");

		} catch (SQLException e) {
			System.out.println("Erro");
		}
	}

	public void alterarFornecedor(String id, Fornecedor obj) {

		try {

			String sql = "update tb_fornecedores set nome=?, cnpj=?, email=?, telefone=?, "
					+ "celular=?, cep=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? where id = '"
					+ id + "'";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, obj.getNome());
			stmt.setString(2, obj.getCnpj());
			stmt.setString(3, obj.getEmail());
			stmt.setString(4, obj.getTelefone());
			stmt.setString(5, obj.getCelular());
			stmt.setString(6, obj.getCep());
			stmt.setString(7, obj.getEndereco());
			stmt.setInt(8, obj.getNumero());
			stmt.setString(9, obj.getComplemento());
			stmt.setString(10, obj.getBairro());
			stmt.setString(11, obj.getCidade());
			stmt.setString(12, obj.getUf());
			stmt.execute();
			stmt.close();

			System.out.println("Alterado com sucesso");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro sql");
		}

	}

	public Fornecedor consultarFornecedorId(String id) {

		Fornecedor obj = new Fornecedor();

		try {

			String sql = "select * from tb_fornecedores where id = '" + id + "' ";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				obj.setId(rs.getInt("id"));
				obj.setNome(rs.getString("nome"));
				obj.setCnpj(rs.getString("cnpj"));
				obj.setEmail(rs.getString("email"));
				obj.setTelefone(rs.getString("telefone"));
				obj.setCelular(rs.getString("celular"));
				obj.setCep(rs.getString("cep"));
				obj.setEndereco(rs.getString("endereco"));
				obj.setNumero(rs.getInt("numero"));
				obj.setComplemento(rs.getString("complemento"));
				obj.setBairro(rs.getString("bairro"));
				obj.setCidade(rs.getString("cidade"));
				obj.setUf(rs.getString("estado"));

			}
			return obj;
		} catch (SQLException e) {

			e.printStackTrace();
			return null;

		}

	}

	public void excluirFornecedor(String id) {

		try {

			String sql = "delete from tb_fornecedores where id = '" + id + "'";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.execute();
			stmt.close();
			System.out.println("Excluido com sucesso");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Fornecedor> listarFornecedores() {
		String sql = "select * from tb_fornecedores";
		return consultarUsuarios(sql);
	}
	
	public List<Fornecedor> buscarFornecedorNome(String nome) {
		String sql = "select * from tb_fornecedores where nome like '"+nome+"'";	
		return consultarUsuarios(sql);

	}

	private List<Fornecedor> consultarUsuarios(String sql) {
		try {
		List<Fornecedor> lista = new ArrayList<>();
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {

			Fornecedor obj = new Fornecedor();

			obj.setId(rs.getInt("id"));
			obj.setNome(rs.getString("nome"));
			obj.setCnpj(rs.getString("cnpj"));
			obj.setEmail(rs.getString("email"));
			obj.setTelefone(rs.getString("telefone"));
			obj.setCelular(rs.getString("celular"));
			obj.setCep(rs.getString("cep"));
			obj.setEndereco(rs.getString("endereco"));
			obj.setNumero(rs.getInt("numero"));
			obj.setComplemento(rs.getString("complemento"));
			obj.setBairro(rs.getString("bairro"));
			obj.setCidade(rs.getString("cidade"));
			obj.setUf(rs.getString("estado"));

			lista.add(obj);

		}

		return lista;

	}catch(Exception e){

		e.printStackTrace();

		return null;
	}
}


}
