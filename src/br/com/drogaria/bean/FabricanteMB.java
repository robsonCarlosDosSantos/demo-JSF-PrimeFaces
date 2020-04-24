package br.com.drogaria.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.util.JSFUtil;

@ManagedBean(name = "fabricanteMB")
@ViewScoped
public class FabricanteMB {

	private ArrayList<Fabricante> fabricantes;
	private ArrayList<Fabricante> fabricantesFilter;
	private Fabricante fabricante = new Fabricante();

	@PostConstruct
	public void preparaView() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			fabricantes = dao.listar();
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.msgError(e.getMessage());
		}
	}

	public void salvarFabricante() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.salvar(fabricante);

			fabricantes = dao.listar();

			JSFUtil.msgSuccess("Fabricante salvo com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.msgError(e.getMessage());
		}
	}

	public void excluirFabricante() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.excluir(fabricante);

			fabricantes = dao.listar();

			JSFUtil.msgSuccess("Fabricante excluido com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.msgError(e.getMessage());
		}
	}

	public void editarFabricante() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.editar(fabricante);

			fabricantes = dao.listar();

			JSFUtil.msgSuccess("Fabricante editado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.msgError(e.getMessage());
		}
	}

	public void preparaNovo() {
		fabricante = new Fabricante();
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public ArrayList<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(ArrayList<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	public ArrayList<Fabricante> getFabricantesFilter() {
		return fabricantesFilter;
	}

	public void setFabricantesFilter(ArrayList<Fabricante> fabricantesFilter) {
		this.fabricantesFilter = fabricantesFilter;
	}

}
