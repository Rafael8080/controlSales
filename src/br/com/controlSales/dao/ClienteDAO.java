package br.com.controlSales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.controlSales.jdbc.ConnectionFactory;
import br.com.controlSales.model.Cliente;

public class ClienteDAO {

	private Connection con;

	public ClienteDAO() {
		this.con = new ConnectionFactory().getConnection();
	}

	public void cadastrarCliente(Cliente obj) {
		try {

			String sql = "insert into tb_clientes (nome, rg, cpf, email, telefone, "
					+ "celular, cep, endereco, numero, complemento, bairro, cidade, estado) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, obj.getNome());
			stmt.setString(2, obj.getRg());
			stmt.setString(3, obj.getCpf());
			stmt.setString(4, obj.getEmail());
			stmt.setString(5, obj.getTelefone());
			stmt.setString(6, obj.getCelular());
			stmt.setString(7, obj.getCep());
			stmt.setString(8, obj.getEndereco());
			stmt.setInt(9, obj.getNumero());
			stmt.setString(10, obj.getComplemento());
			stmt.setString(11, obj.getBairro());
			stmt.setString(12, obj.getCidade());
			stmt.setString(13, obj.getUf());
			stmt.execute();
			stmt.close();

			System.out.println("Cadastrado com sucesso");

		} catch (SQLException e) {
			System.out.println("Erro");
		}
	}

	public void alterarCliente(String id, Cliente obj) {

		try {

			String sql = "update tb_clientes set nome=?, rg=?, cpf=?, email=?, telefone=?, "
					+ "celular=?, cep=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? where id = '"
					+ id + "'";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, obj.getNome());
			stmt.setString(2, obj.getRg());
			stmt.setString(3, obj.getCpf());
			stmt.setString(4, obj.getEmail());
			stmt.setString(5, obj.getTelefone());
			stmt.setString(6, obj.getCelular());
			stmt.setString(7, obj.getCep());
			stmt.setString(8, obj.getEndereco());
			stmt.setInt(9, obj.getNumero());
			stmt.setString(10, obj.getComplemento());
			stmt.setString(11, obj.getBairro());
			stmt.setString(12, obj.getCidade());
			stmt.setString(13, obj.getUf());
			stmt.executeUpdate();
			stmt.close();

			System.out.println("Alterado com sucesso");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro sql");
		}

	}

	public Cliente consultarClienteId(String id) {

		Cliente obj = new Cliente();

		try {

			String sql = "select * from tb_clientes where id = '" + id + "' ";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				obj.setId(rs.getInt("id"));
				obj.setNome(rs.getString("nome"));
				obj.setRg(rs.getString("rg"));
				obj.setCpf(rs.getString("cpf"));
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

	public void excluirCliente(String id) {

		try {

			String sql = "delete from tb_clientes where id = '" + id + "'";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.execute();
			stmt.close();
			System.out.println("Excluido com sucesso");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Cliente> listarClientes() {
		String sql = "select * from tb_clientes";
		return consultarUsuarios(sql);
	}
	
	public List<Cliente> buscarClienteNome(String nome) {
		String sql = "select * from tb_clientes where nome like '"+nome+"'";	
		return consultarUsuarios(sql);

	}

	private List<Cliente> consultarUsuarios(String sql) {
		try {
		List<Cliente> lista = new ArrayList<>();
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {

			Cliente obj = new Cliente();

			obj.setId(rs.getInt("id"));
			obj.setNome(rs.getString("nome"));
			obj.setRg(rs.getString("rg"));
			obj.setCpf(rs.getString("cpf"));
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
