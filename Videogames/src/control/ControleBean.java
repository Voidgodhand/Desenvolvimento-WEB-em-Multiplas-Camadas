package control;


import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import dao.ControleDAO;
import dao.ConsoleDAO;
import model.Controle;
import model.Console;

import util.JSFUtil;

@ManagedBean(name = "controleBean")
@ViewScoped
public class ControleBean implements Serializable {

	private static final long serialVersionUID = 1L;

	//Construtores
	public ControleBean() {
		this.controle	= new Controle();
	}
	
	//Atributos
	private Controle controle;
	private Console console;
	private ListDataModel<Controle> listaModelControles;
	private List<Controle> listaFiltradaModelControles;
	private List<Controle> listaControles;
	private ListDataModel<Console> listaModelConsoles;
	private List<Console> listaConsoles;
	
	//Métodos de acesso
	
	public Controle getControle() {
		return controle;
	}

	public void setControle(Controle controle) {
		this.controle = controle;
	}

	public ListDataModel<Controle> getListaModelControles() {
		return listaModelControles;
	}

	public void setListaModelControles(ListDataModel<Controle> listaModelControles) {
		this.listaModelControles = listaModelControles;
	}

	public List<Controle> getListaFiltradaModelControles() {
		return listaFiltradaModelControles;
	}

	public void setListaFiltradaModelControles(List<Controle> listaFiltradaModelControles) {
		this.listaFiltradaModelControles = listaFiltradaModelControles;
	}

	public List<Controle> getListaControles() {
		return listaControles;
	}

	public void setListaControles(List<Controle> listaControles) {
		this.listaControles = listaControles;
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
		this.controle = new Controle();
	}
	
	public void Insert() {
		try {
			ControleDAO dao = new ControleDAO();
			
			dao.Inserir(this.controle);
					
			this.controle = new Controle();
			
			this.listaControles = dao.listarTodos();
			this.listaModelControles = new ListDataModel<>(this.listaControles);
			
			JSFUtil.adicionarMensagemSucesso("Controle cadastrado com sucesso!");
		}
		catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro ao tentar cadastrar um controle" + e.getMessage());
		}
	}
	
	public void PrepararDelete() 
	{
		this.controle = this.listaModelControles.getRowData();
	}
	
	public void Delete() {
		try {
			
			ControleDAO dao = new ControleDAO();
			
			dao.Excluir(this.controle.getSeq());
					
			this.controle = new Controle();
			
			this.listaControles = dao.listarTodos();
			this.listaModelControles = new ListDataModel<>(this.listaControles);
			
			JSFUtil.adicionarMensagemSucesso("Controle deletado com sucesso!");
		}
		catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro ao tentar deletar um controle" + e.getMessage());

		}
	}
	
	public void PrepararUpdate() 
	{
		this.controle = this.listaModelControles.getRowData();
	}
	
	public void Update() {
		try {			
			ControleDAO dao = new ControleDAO();
			
			dao.Atualizar(this.controle);
					
			this.controle = new Controle();
			
			this.listaControles = dao.listarTodos();
			this.listaModelControles = new ListDataModel<>(this.listaControles);
			
			JSFUtil.adicionarMensagemSucesso("Controle atualizado com sucesso!");
		}
		catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro ao tentar atualizar um controle" + e.getMessage());

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
			ControleDAO dao = new ControleDAO();
				
			this.listaControles = dao.listarTodos();
			this.listaModelControles = new ListDataModel<>(this.listaControles);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
