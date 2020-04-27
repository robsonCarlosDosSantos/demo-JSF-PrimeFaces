package br.com.drogaria.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.util.JSFUtil;

@ManagedBean(name = "produtoMB")
@ViewScoped
public class ProdutoMB {

	private ArrayList<Produto> produtos;
	private ArrayList<Produto> produtosFilter;
	private Produto produto;
	private ArrayList<Fabricante> comboFabriante;

	public void preparaView() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			produtos = dao.listar();
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.msgError(e.getMessage());
		}
	}

	public void salvarProduto() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.salvar(produto);

			produtos = dao.listar();

			JSFUtil.msgSuccess("Produto salvo com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.msgError(e.getMessage());
		}
	}

	public void excluirProduto() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.excluir(produto);

			produtos = dao.listar();

			JSFUtil.msgSuccess("Produto excluido com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.msgError(e.getMessage());
		}
	}

	public void editarProduto() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.editar(produto);

			produtos = dao.listar();

			JSFUtil.msgSuccess("Produto editado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.msgError(e.getMessage());
		}
	}

	public void preparaNovo() {
		try {
			produto = new Produto();

			FabricanteDAO dao = new FabricanteDAO();
			comboFabriante = dao.listar();
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.msgError(e.getMessage());
		}
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public ArrayList<Produto> getProdutosFilter() {
		return produtosFilter;
	}

	public void setProdutosFilter(ArrayList<Produto> produtosFilter) {
		this.produtosFilter = produtosFilter;
	}

	public ArrayList<Fabricante> getComboFabriante() {
		return comboFabriante;
	}

	public void setComboFabriante(ArrayList<Fabricante> comboFabriante) {
		this.comboFabriante = comboFabriante;
	}

}
