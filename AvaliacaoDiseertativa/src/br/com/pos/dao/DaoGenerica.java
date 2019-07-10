package br.com.pos.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.com.pos.conexao.Conexao;
import br.com.pos.entidade.ProdudoBean;

public class DaoGenerica {
	
	Conexao con = new Conexao();
	
@SuppressWarnings("null")
public List<String> listarProdutos() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		
        String sql = "select * from produto order by codigoProduto";
        List<ProdudoBean> resultado = null;
        try {
			con = (Conexao) Conexao.getConnection();
			PreparedStatement stm = ((java.sql.Connection) con).prepareStatement(sql);
			ResultSet result = stm.executeQuery();
			while (result.next()) {
				ProdudoBean produtos = new ProdudoBean();
				produtos.setNome(result.getString("nome"));
				produtos.setDescricao(result.getString("descricao"));
				produtos.setPreco(result.getDouble("preco"));
				resultado.add((produtos));
			}
            result.close();
			((Statement) con).close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
		return listarProdutos();
	}

}
