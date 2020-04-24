package br.com.drogaria.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.util.JSFUtil;

@ManagedBean(name="fabricanteMB")
@ViewScoped
public class FabricanteMB {
	
	private ListDataModel<Fabricante> fabricantes;
	private Fabricante fabricante = new Fabricante();
	
	@PostConstruct
	public void preparaView() {
		ArrayList<Fabricante> lista = new ArrayList<Fabricante>();
		FabricanteDAO dao = new FabricanteDAO();
		
		try {
			lista = dao.listar();
			fabricantes = new ListDataModel<Fabricante>(lista);
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.msgError(e.getMessage());
		}
	}
	
	public void salvarFabricante() {
		FabricanteDAO dao = new FabricanteDAO();
		try {
			dao.salvar(fabricante);
			
			ArrayList<Fabricante> lista = dao.listar();
			fabricantes = new ListDataModel<Fabricante>(lista);
			
			JSFUtil.msgSuccess("Fabricante salvo com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.msgError(e.getMessage());
		}
	}
	
	public void preparaNovoFabricante() {
		fabricante = new Fabricante();
	}

	public ListDataModel<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(ListDataModel<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	
}
