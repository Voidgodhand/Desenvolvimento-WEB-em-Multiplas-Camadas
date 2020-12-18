package control;


import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import dao.AcessorioDAO;
import dao.ConsoleDAO;
import model.Acessorio;
import model.Console;

import util.JSFUtil;

@ManagedBean(name = "acessorioBean")
@ViewScoped
public class AcessorioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	//Construtores
	public AcessorioBean() {
		this.acessorio = new Acessorio();
	}
	
	//Atributos
	private Acessorio acessorio;
	private Console console;
	private ListDataModel<Acessorio> listaModelAcessorios;
	private List<Acessorio> listaFiltradaModelAcessorios;
	private List<Acessorio> listaAcessorios;
	private ListDataModel<Console> listaModelConsoles;
	private List<Console> listaConsoles;

	//Métodos de Acesso
	public Acessorio getAcessorio() {
		return acessorio;
	}

	public void setAcessorio(Acessorio acessorio) {
		this.acessorio = acessorio;
	}
	
	public ListDataModel<Acessorio> getListaModelAcessorios() {
		return listaModelAcessorios;
	}

	public void setListaModelAcessorios(ListDataModel<Acessorio> listaModelAcessorios) {
		this.listaModelAcessorios = listaModelAcessorios;
	}

	public List<Acessorio> getListaFiltradaModelAcessorios() {
		return listaFiltradaModelAcessorios;
	}

	public void setListaFiltradaModelAcessorios(List<Acessorio> listaFiltradaModelAcessorios) {
		this.listaFiltradaModelAcessorios = listaFiltradaModelAcessorios;
	}

	public List<Acessorio> getListaAcessorios() {
		return listaAcessorios;
	}

	public void setListaAcessorios(List<Acessorio> listaAcessorios) {
		this.listaAcessorios = listaAcessorios;
	}

	public ListDataModel<Console> getListaModelConsoles() {
		return listaModelConsoles;
	}

	public void setListaModelConsoles(ListDataModel<Console> listaModelConsoles) {
		this.listaModelConsoles = listaModelConsoles;
	}

	public List<Console> getListaConsoles() {
		return listaConsoles;
	}

	public void setListaConsoles(List<Console> listaConsoles) {
		this.listaConsoles = listaConsoles;
	}
	
	public Console getConsole() {
		return console;
	}

	public void setConsole(Console console) {
		this.console = console;
	}
	
	//Métodos de Acesso ao Banco de Dados

	public void PrepararNovo() {
		this.acessorio = new Acessorio();
	}

	public void Insert() {
		try {			
			AcessorioDAO dao = new AcessorioDAO();
			dao.Inserir(this.acessorio);	
			
			this.acessorio = new Acessorio();
			this.listaAcessorios = dao.listarTodos();
			this.listaModelAcessorios = new ListDataModel<>(this.listaAcessorios);
			
			JSFUtil.adicionarMensagemSucesso("Acessorio cadastrado com sucesso!");
		}
		catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro ao tentar cadastrar um acessorio " + e.getMessage());
		}
	}
	
	public void PrepararDelete() 
	{
		this.acessorio = this.listaModelAcessorios.getRowData();
	}
	
	public void Delete() {
		try {			
			AcessorioDAO dao = new AcessorioDAO();
			
			dao.Excluir(this.acessorio.getId());
					
			this.acessorio = new Acessorio();
			
			this.listaAcessorios = dao.listarTodos();
			this.listaModelAcessorios = new ListDataModel<>(this.listaAcessorios);
			
			JSFUtil.adicionarMensagemSucesso("Acessorio deletado com sucesso!");
		}
		catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro ao tentar deletar um acessorio " + e.getMessage());

		}
	}
	
	public void PrepararUpdate() 
	{
		this.acessorio = this.listaModelAcessorios.getRowData();
	}
	
	public void Update() {
		try {
			AcessorioDAO dao = new AcessorioDAO();
			
			dao.Atualizar(this.acessorio);
					
			this.acessorio = new Acessorio();
			
			this.listaAcessorios = dao.listarTodos();
			this.listaModelAcessorios = new ListDataModel<>(this.listaAcessorios);
			
			JSFUtil.adicionarMensagemSucesso("Acessorio atualizado com sucesso!");
		}
		catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro ao tentar atualizar um acessorio " + e.getMessage());

		}
	}
	
	public List<Console> List(){
		try {
			ConsoleDAO dao = new ConsoleDAO();
			this.listaConsoles = dao.listarTodos();
			return this.listaConsoles;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@PostConstruct
	public void init() {
		
		try {			
			AcessorioDAO dao = new AcessorioDAO();
				
			this.listaAcessorios = dao.listarTodos();
			this.listaModelAcessorios = new ListDataModel<>(this.listaAcessorios);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
