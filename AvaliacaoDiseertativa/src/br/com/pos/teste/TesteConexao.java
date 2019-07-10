package br.com.pos.teste;

import java.sql.SQLException;

import br.com.pos.conexao.Conexao;

public class TesteConexao {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Conexao con = new Conexao();
		con.getConnection();
	}

}
