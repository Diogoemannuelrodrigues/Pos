package br.com.pos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.pos.conexao.Conexao;
import br.com.pos.entidade.ProdudoBean;

public class DaoProdutos extends DaoGenerica {

	@Override
	public List listarProdutos()
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		List<ProdudoBean> listaDeProdutos = new ArrayList<ProdudoBean>();

		try {
			Conexao con = null;
			con = (Conexao) new Conexao().getConnection();
			PreparedStatement stm = ((Connection) con).prepareStatement("select * from produto");
			ResultSet result = stm.executeQuery();
			while (result.next()) {
				ProdudoBean produdoBean = new ProdudoBean();
				produdoBean.setNome(result.getString("nome"));
				produdoBean.setDescricao(result.getString("descricao"));
				produdoBean.setPreco(result.getDouble("preco"));
				listaDeProdutos.add(produdoBean);
			}
			result.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return super.listarProdutos();
	}

}
