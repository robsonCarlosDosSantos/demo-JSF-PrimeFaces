package br.com.drogaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.factory.ConexaoFactory;

public class FabricanteDAO {

	public void salvar(Fabricante f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fabricante ");
		sql.append("(descricao) VALUES (?) ");

		Connection conn = ConexaoFactory.conectar();
		PreparedStatement st = conn.prepareStatement(sql.toString());
		st.setString(1, f.getDescricao());

		st.executeUpdate();

	}

	public void excluir(Fabricante f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM fabricante ");
		sql.append("WHERE codigo = ? ");

		Connection conn = ConexaoFactory.conectar();
		PreparedStatement st = conn.prepareStatement(sql.toString());
		st.setLong(1, f.getCodigo());

		st.executeUpdate();

	}

	public void editar(Fabricante f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE fabricante ");
		sql.append("SET descricao = ? WHERE codigo = ? ");

		Connection conn = ConexaoFactory.conectar();
		PreparedStatement st = conn.prepareStatement(sql.toString());
		st.setString(1, f.getDescricao());
		st.setLong(2, f.getCodigo());

		st.executeUpdate();

	}

	public Fabricante buscarPorCodigo(Fabricante f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao FROM fabricante ");
		sql.append("WHERE codigo = ? ");

		Connection conn = ConexaoFactory.conectar();
		PreparedStatement st = conn.prepareStatement(sql.toString());
		st.setLong(1, f.getCodigo());

		ResultSet rs = st.executeQuery();

		Fabricante fabricante = null;
		if (rs.next()) {
			fabricante = new Fabricante();
			fabricante.setCodigo(rs.getLong("codigo"));
			fabricante.setDescricao(rs.getString("descricao"));
		}

		return fabricante;

	}

	public ArrayList<Fabricante> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao FROM fabricante ");
		sql.append("ORDER BY descricao ASC");

		Connection conn = ConexaoFactory.conectar();
		PreparedStatement st = conn.prepareStatement(sql.toString());

		ResultSet rs = st.executeQuery();

		ArrayList<Fabricante> lista = new ArrayList<Fabricante>();
		Fabricante item;
		while (rs.next()) {
			item = new Fabricante();
			item.setCodigo(rs.getLong("codigo"));
			item.setDescricao(rs.getString("descricao"));
			lista.add(item);
		}

		return lista;

	}

	public ArrayList<Fabricante> buscarPorDescricao(Fabricante f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao FROM fabricante ");
		sql.append("WHERE descricao LIKE ? ");
		sql.append("ORDER BY descricao ASC");

		Connection conn = ConexaoFactory.conectar();
		PreparedStatement st = conn.prepareStatement(sql.toString());
		st.setString(1, "%" + f.getDescricao() + "%");

		ResultSet rs = st.executeQuery();

		ArrayList<Fabricante> lista = new ArrayList<Fabricante>();
		Fabricante item;
		while (rs.next()) {
			item = new Fabricante();
			item.setCodigo(rs.getLong("codigo"));
			item.setDescricao(rs.getString("descricao"));
			lista.add(item);
		}

		return lista;

	}

}
