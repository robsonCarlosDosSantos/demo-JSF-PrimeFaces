package br.com.drogaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.factory.ConexaoFactory;

public class ProdutoDAO {

	public void salvar(Produto p) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO Produto ");
		sql.append("(descricao, quantidade, preco, fabricante_codigo) VALUES (?,?,?,?) ");

		Connection conn = ConexaoFactory.conectar();
		PreparedStatement st = conn.prepareStatement(sql.toString());
		st.setString(1, p.getDescricao());
		st.setLong(2, p.getQuantidade());
		st.setDouble(3, p.getPreco());
		st.setLong(4, p.getFabricante().getCodigo());

		st.executeUpdate();

	}

	public void excluir(Produto p) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM Produto ");
		sql.append("WHERE codigo = ? ");

		Connection conn = ConexaoFactory.conectar();
		PreparedStatement st = conn.prepareStatement(sql.toString());
		st.setLong(1, p.getCodigo());

		st.executeUpdate();

	}

	public void editar(Produto p) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE Produto ");
		sql.append("SET descricao = ?, quantidade = ?, preco = ?, fabricante_codigo = ? WHERE codigo = ? ");

		Connection conn = ConexaoFactory.conectar();
		PreparedStatement st = conn.prepareStatement(sql.toString());
		st.setString(1, p.getDescricao());
		st.setLong(2, p.getQuantidade());
		st.setDouble(3, p.getPreco());
		st.setLong(4, p.getFabricante().getCodigo());
		st.setLong(5, p.getCodigo());

		st.executeUpdate();

	}

	public Produto buscarPorCodigo(Produto p) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM Produto ");
		sql.append("WHERE codigo = ? ");

		Connection conn = ConexaoFactory.conectar();
		PreparedStatement st = conn.prepareStatement(sql.toString());
		st.setLong(1, p.getCodigo());

		ResultSet rs = st.executeQuery();

		Produto item = null;
		if (rs.next()) {
			item = new Produto();
			item.setCodigo(rs.getLong("codigo"));
			item.setDescricao(rs.getString("descricao"));
			item.setQuantidade(rs.getInt("quantidade"));
			item.setPreco(rs.getDouble("preco"));

			Fabricante f = new Fabricante();
			f.setCodigo(rs.getLong("fabricante_codigo"));
			item.setFabricante(f);
		}

		return item;

	}

	public ArrayList<Produto> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM Produto ");
		sql.append("ORDER BY descricao ASC");

		Connection conn = ConexaoFactory.conectar();
		PreparedStatement st = conn.prepareStatement(sql.toString());

		ResultSet rs = st.executeQuery();

		ArrayList<Produto> lista = new ArrayList<Produto>();
		Produto item;
		while (rs.next()) {
			item = new Produto();
			item.setCodigo(rs.getLong("codigo"));
			item.setDescricao(rs.getString("descricao"));
			item.setQuantidade(rs.getInt("quantidade"));
			item.setPreco(rs.getDouble("preco"));

			Fabricante f = new Fabricante();
			f.setCodigo(rs.getLong("fabricante_codigo"));
			item.setFabricante(f);

			lista.add(item);
		}

		return lista;

	}

	public ArrayList<Produto> buscarPorDescricao(Produto p) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM Produto ");
		sql.append("WHERE descricao LIKE ? ");
		sql.append("ORDER BY descricao ASC");

		Connection conn = ConexaoFactory.conectar();
		PreparedStatement st = conn.prepareStatement(sql.toString());
		st.setString(1, "%" + p.getDescricao() + "%");

		ResultSet rs = st.executeQuery();

		ArrayList<Produto> lista = new ArrayList<Produto>();
		Produto item;
		while (rs.next()) {
			item = new Produto();
			item.setCodigo(rs.getLong("codigo"));
			item.setDescricao(rs.getString("descricao"));
			item.setQuantidade(rs.getInt("quantidade"));
			item.setPreco(rs.getDouble("preco"));

			Fabricante f = new Fabricante();
			f.setCodigo(rs.getLong("fabricante_codigo"));
			item.setFabricante(f);

			lista.add(item);
		}

		return lista;

	}

}
