package br.com.controlSales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
			stmt.setString(1,  obj.getNome());
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
			
		}catch(SQLException e) {
			System.out.println("Erro meu patrão");
		}
	}
	
	public void alterarCliente() {
		
	}
	
	public void excluirCliente() {
		
	}
	
}
