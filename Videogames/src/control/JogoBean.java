package control;


import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import dao.JogoDAO;
import dao.ConsoleDAO;
import dao.DesenvolvedoraDAO;
import model.Jogo;
import model.Console;
import model.Desenvolvedora;

import util.JSFUtil;

@ManagedBean(name = "jogoBean")
@ViewScoped
public class JogoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	//Construtores
	public JogoBean() {
		this.jogo	= new Jogo();
	}
	
	//Atributos
	private Jogo jogo;
	private Console console;
	private Desenvolvedora desenvolvedora;
	private ListDataModel<Jogo> listaModelJogos;
	private List<Jogo> listaFiltradaModelJogos;
	private List<Jogo> listaJogos;
	private ListDataModel<Console> listaModelConsoles;
	private List<Console> listaConsoles;
	private ListDataModel<Desenvolvedora> listaModelDesenvolvedoras;
	private List<Desenvolvedora> listaDesenvolvedoras;
	
	//Métodos de acesso
	
	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public Console getConsole() {
		return console;
	}

	public void setConsole(Console console) {
		this.console = console;
	}

	public Desenvolvedora getDesenvolvedora() {
		return desenvolvedora;
	}

	public void setDesenvolvedora(Desenvolvedora desenvolvedora) {
		this.desenvolvedora = desenvolvedora;
	}

	public ListDataModel<Jogo> getListaModelJogos() {
		return listaModelJogos;
	}

	public void setListaModelJogos(ListDataModel<Jogo> listaModelJogos) {
		this.listaModelJogos = listaModelJogos;
	}

	public List<Jogo> getListaFiltradaModelJogos() {
		return listaFiltradaModelJogos;
	}

	public void setListaFiltradaModelJogos(List<Jogo> listaFiltradaModelJogos) {
		this.listaFiltradaModelJogos = listaFiltradaModelJogos;
	}

	public List<Jogo> getListaJogos() {
		return listaJogos;
	}

	public void setListaJogos(List<Jogo> listaJogos) {
		this.listaJogos = listaJogos;
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

	public ListDataModel<Desenvolvedora> getListaModelDesenvolvedoras() {
		return listaModelDesenvolvedoras;
	}

	public void setListaModelDesenvolvedoras(ListDataModel<Desenvolvedora> listaModelDesenvolvedoras) {
		this.listaModelDesenvolvedoras = listaModelDesenvolvedoras;
	}

	public List<Desenvolvedora> getListaDesenvolvedoras() {
		return listaDesenvolvedoras;
	}

	public void setListaDesenvolvedoras(List<Desenvolvedora> listaDesenvolvedoras) {
		this.listaDesenvolvedoras = listaDesenvolvedoras;
	}

	//Métodos de Acesso ao Banco de Dados
	
	public void PrepararNovo() {
		this.jogo = new Jogo();
	}
	
	public void Insert() {
		try {
			JogoDAO dao = new JogoDAO();
			
			dao.Inserir(this.jogo);
					
			this.jogo = new Jogo();
			
			this.listaJogos = dao.listarTodos();
			this.listaModelJogos = new ListDataModel<>(this.listaJogos);
			
			JSFUtil.adicionarMensagemSucesso("Jogo cadastrado com sucesso!");
		}
		catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro ao tentar cadastrar um jogo" + e.getMessage());
		}
	}
	
	public void PrepararDelete() 
	{
		this.jogo = this.listaModelJogos.getRowData();
	}
	
	public void Delete() {
		try {
			JogoDAO dao = new JogoDAO();
			
			dao.Excluir(this.jogo.getCodigo());
					
			this.jogo = new Jogo();
			
			this.listaJogos = dao.listarTodos();
			this.listaModelJogos = new ListDataModel<>(this.listaJogos);
			
			JSFUtil.adicionarMensagemSucesso("Jogo deletado com sucesso!");
		}
		catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro ao tentar deletar um jogo" + e.getMessage());
		}
	}
	
	public void PrepararUpdate() 
	{
		this.jogo = this.listaModelJogos.getRowData();
	}
	
	public void Update() {
		try {
			JogoDAO dao = new JogoDAO();
			
			dao.Atualizar(this.jogo);
					
			this.jogo = new Jogo();
			
			this.listaJogos = dao.listarTodos();
			this.listaModelJogos = new ListDataModel<>(this.listaJogos);
			
			JSFUtil.adicionarMensagemSucesso("Jogo atualizado com sucesso!");
		}
		catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro ao tentar atualizar um jogo" + e.getMessage());

		}
	}
	
	public List<Console> ListConsole(){
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
	
	public List<Desenvolvedora> ListDesenvolvedora(){
		try {
			DesenvolvedoraDAO dao = new DesenvolvedoraDAO();
			this.listaDesenvolvedoras = dao.listarTodos();
			return this.listaDesenvolvedoras;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@PostConstruct
	public void init() {
		
		try {
			JogoDAO dao = new JogoDAO();
				
			this.listaJogos = dao.listarTodos();
			this.listaModelJogos = new ListDataModel<>(this.listaJogos);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
