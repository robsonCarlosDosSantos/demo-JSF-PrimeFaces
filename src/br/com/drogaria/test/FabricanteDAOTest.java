package br.com.drogaria.test;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;

public class FabricanteDAOTest {

	@Test
	@Ignore
	public void salvarTest() throws SQLException {

		Fabricante f = new Fabricante();
		f.setDescricao("Cifarma");

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.salvar(f);

	}
	
	@Test
	@Ignore
	public void EditarTest() throws SQLException {

		Fabricante f = new Fabricante();
		f.setCodigo(22L);
		f.setDescricao("Cifarma 2");

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.editar(f);

	}
	
	@Test
	@Ignore
	public void buscarPorCodigoTest() throws SQLException {

		Fabricante f = new Fabricante();
		f.setCodigo(21L);

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		f = fabricanteDAO.buscarPorCodigo(f);
		
		System.out.println(f);

	}
	
	@Test
	@Ignore
	public void buscarPorDescricaoTest() throws SQLException {

		Fabricante f = new Fabricante();
		f.setDescricao("2");

		ArrayList<Fabricante> lista = new ArrayList<Fabricante>();
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		lista = fabricanteDAO.buscarPorDescricao(f);
		
		for (Fabricante fabricante : lista) {
			System.out.println(fabricante);
		}	

	}
	
	@Test
	@Ignore
	public void listarTest() throws SQLException {

		ArrayList<Fabricante> lista = new ArrayList<Fabricante>();
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		lista = fabricanteDAO.listar();
		
		for (Fabricante fabricante : lista) {
			System.out.println(fabricante);
		}	

	}

	@Test
	@Ignore
	public void excluirTest() throws SQLException {

		Fabricante f = new Fabricante();
		f.setCodigo(22L);

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.excluir(f);

	}

}
