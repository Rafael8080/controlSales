package br.com.controlSales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.controlSales.jdbc.ConnectionFactory;
import br.com.controlSales.model.Cliente;
import br.com.controlSales.model.Funcionario;

public class FuncionarioDAO {

	private Connection con;

	public FuncionarioDAO() {
		this.con = new ConnectionFactory().getConnection();
	}

	public void cadastrarFuncionario(Funcionario obj) {
		try {

			String sql = "insert into tb_funcionarios (nome, rg, cpf, email, senha, cargo, nivel_acesso, telefone, "
					+ "celular, cep, endereco, numero, complemento, bairro, cidade, estado) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, obj.getNome());
			stmt.setString(2, obj.getRg());
			stmt.setString(3, obj.getCpf());
			stmt.setString(4, obj.getEmail());
			stmt.setString(5, obj.getSenha());
			stmt.setString(6, obj.getCargo());
			stmt.setString(7, obj.getNivelAcesso());
			stmt.setString(8, obj.getTelefone());
			stmt.setString(9, obj.getCelular());
			stmt.setString(10, obj.getCep());
			stmt.setString(11, obj.getEndereco());
			stmt.setInt(12, obj.getNumero());
			stmt.setString(13, obj.getComplemento());
			stmt.setString(14, obj.getBairro());
			stmt.setString(15, obj.getCidade());
			stmt.setString(16, obj.getUf());
			stmt.execute();
			stmt.close();

			System.out.println("Cadastrado com sucesso");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro no sql");
		}
	}
	
	public boolean login (String email, String senha) {
		try {
			
			String sql = "select * from tb_funcionarios where email = '" +email+ "'and senha = '"+senha+"'";
			PreparedStatement stmt = con.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
		if(rs.next()) {
			return true;
			
		}else {
			return false;
		}
			
		}catch(Exception e) {
			
			System.out.println("Erro no sql");
			
			e.printStackTrace();
			return false;
			
		}
	}

	public List<Funcionario> listarFuncionarios() {
		String sql = "select * from tb_funcionarios";
		return consultarFuncionarios(sql);
	}
	
	public List<Funcionario> buscaFuncionarioNome(String nome) {
		String sql = "select * from tb_funcionarios where nome like '"+nome+"'";	
		return consultarFuncionarios(sql);

	}

	private List<Funcionario> consultarFuncionarios(String sql) {
		try {
			List<Funcionario> lista = new ArrayList<>();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Funcionario obj = new Funcionario();

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
				obj.setSenha(rs.getString("senha"));
				obj.setCargo(rs.getString("cargo"));
				obj.setNivelAcesso(rs.getString("nivel_acesso"));

				lista.add(obj);

			}

			return lista;

		} catch (Exception e) {

			e.printStackTrace();

			return null;
		}
	}

	public void alterarFuncionario(String id, Funcionario obj) {

		try {

			String sql = "update tb_funcionarios set nome=?, rg=?, cpf=?, email=?, senha=?, cargo=?, nivel_acesso=?, telefone=?, "
					+ "celular=?, cep=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? where id = '"
					+ id + "'";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, obj.getNome());
			stmt.setString(2, obj.getRg());
			stmt.setString(3, obj.getCpf());
			stmt.setString(4, obj.getEmail());
			stmt.setString(5, obj.getSenha());
			stmt.setString(6, obj.getCargo());
			stmt.setString(7, obj.getNivelAcesso());
			stmt.setString(8, obj.getTelefone());
			stmt.setString(9, obj.getCelular());
			stmt.setString(10, obj.getCep());
			stmt.setString(11, obj.getEndereco());
			stmt.setInt(12, obj.getNumero());
			stmt.setString(13, obj.getComplemento());
			stmt.setString(14, obj.getBairro());
			stmt.setString(15, obj.getCidade());
			stmt.setString(16, obj.getUf());
			stmt.executeUpdate();
			stmt.close();

			System.out.println("Alterado com sucesso");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro sql");
		}

	}

	public void excluirCliente(String id) {

		try {

			String sql = "delete from tb_funcionarios where id = '" + id + "'";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.execute();
			stmt.close();
			System.out.println("Excluido com sucesso");

		} catch (Exception e) {
			System.out.println("Erro no sql");
			e.printStackTrace();
		}

	}
	
	public Funcionario consultarFuncionarioId(String id) {

		Funcionario obj = new Funcionario();

		try {

			String sql = "select * from tb_funcionarios where id = '" + id + "' ";
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
				obj.setSenha(rs.getString("senha"));
				obj.setCargo(rs.getString("cargo"));
				obj.setNivelAcesso(rs.getString("nivel_acesso"));

			}
			return obj;
		} catch (SQLException e) {

			e.printStackTrace();
			return null;

		}

	}

}
