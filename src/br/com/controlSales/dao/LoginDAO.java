package br.com.controlSales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.controlSales.jdbc.ConnectionFactory;

public class LoginDAO {

	private Connection con;
	
	public LoginDAO() {
		this.con = new ConnectionFactory().getConnection();
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
	
}
