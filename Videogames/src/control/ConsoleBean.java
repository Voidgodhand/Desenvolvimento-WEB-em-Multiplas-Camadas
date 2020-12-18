package control;


import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import dao.ConsoleDAO;
import model.Console;
import util.JSFUtil;

@ManagedBean(name = "consoleBean")
@ViewScoped
public class ConsoleBean implements Serializable {

	private static final long serialVersionUID = 1L;

	//Construtores
	public ConsoleBean() {
		this.console	= new Console();
	}
	
	//Atributos
	private Console console;
	private ListDataModel<Console> listaModelConsoles;
	private List<Console> listaFiltradaModelConsoles;
	private List<Console> listaConsoles;
	
	//Métodos de acesso

	public Console getConsole() {
		return console;
	}

	public void setConsole(Console console) {
		this.console = console;
	}

	public ListDataModel<Console> getListaModelConsoles() {
		return listaModelConsoles;
	}

	public void setListaModelConsoles(ListDataModel<Console> listaModelConsoles) {
		this.listaModelConsoles = listaModelConsoles;
	}

	public List<Console> getListaFiltradaModelConsoles() {
		return listaFiltradaModelConsoles;
	}

	public void setListaFiltradaModelConsoles(List<Console> listaFiltradaModelConsoles) {
		this.listaFiltradaModelConsoles = listaFiltradaModelConsoles;
	}

	public List<Console> getListaConsoles() {
		return listaConsoles;
	}

	public void setListaConsoles(List<Console> listaConsoles) {
		this.listaConsoles = listaConsoles;
	}
	
	//Métodos de Acesso ao Banco de Dados

	public void PrepararNovo() {
		this.console = new Console();
	}
	
	public void Insert() {
		try {
			ConsoleDAO dao = new ConsoleDAO();
			
			dao.Inserir(this.console);
					
			this.console = new Console();
			
			this.listaConsoles = dao.listarTodos();
			this.listaModelConsoles = new ListDataModel<>(this.listaConsoles);
			
			JSFUtil.adicionarMensagemSucesso("Console cadastrado com sucesso!");
		}
		catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro ao tentar cadastrar um console" + e.getMessage());
		}
	}
	
	public void PrepararDelete() 
	{
		this.console = this.listaModelConsoles.getRowData();
	}
	
	public void Delete() {
		try {
			ConsoleDAO dao = new ConsoleDAO();
			
			dao.Excluir(this.console.getNumero());
					
			this.console = new Console();
			
			this.listaConsoles = dao.listarTodos();
			this.listaModelConsoles = new ListDataModel<>(this.listaConsoles);
			
			JSFUtil.adicionarMensagemSucesso("Console deletado com sucesso!");
		}
		catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro ao tentar deletar um console " + e.getMessage());

		}
	}
	
	public void PrepararUpdate() 
	{
		this.console = this.listaModelConsoles.getRowData();
	}
	
	public void Update() {
		try {
			ConsoleDAO dao = new ConsoleDAO();
			
			dao.Atualizar(this.console);
					
			this.console = new Console();
			
			this.listaConsoles = dao.listarTodos();
			this.listaModelConsoles = new ListDataModel<>(this.listaConsoles);
			
			JSFUtil.adicionarMensagemSucesso("Console atualizado com sucesso!");
		}
		catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro ao tentar atualizar um console " + e.getMessage());

		}
	}
	
	@PostConstruct
	public void init() {
		
		try {			
			ConsoleDAO dao = new ConsoleDAO();
				
			this.listaConsoles = dao.listarTodos();
			this.listaModelConsoles = new ListDataModel<>(this.listaConsoles);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
