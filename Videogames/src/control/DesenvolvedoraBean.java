package control;


import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import dao.DesenvolvedoraDAO;
import model.Desenvolvedora;
import util.JSFUtil;

@ManagedBean(name = "desenvolvedoraBean")
@ViewScoped
public class DesenvolvedoraBean implements Serializable {

	private static final long serialVersionUID = 1L;

	//Construtores
	public DesenvolvedoraBean() {
		this.desenvolvedora	= new Desenvolvedora();
	}
	
	//Atributos
	private Desenvolvedora desenvolvedora;
	private ListDataModel<Desenvolvedora> listaModelDesenvolvedoras;
	private List<Desenvolvedora> listaFiltradaModelDesenvolvedoras;
	private List<Desenvolvedora> listaDesenvolvedoras;
	
	//Métodos de acesso

	public Desenvolvedora getDesenvolvedora() {
		return desenvolvedora;
	}

	public void setDesenvolvedora(Desenvolvedora desenvolvedora) {
		this.desenvolvedora = desenvolvedora;
	}

	public ListDataModel<Desenvolvedora> getListaModelDesenvolvedoras() {
		return listaModelDesenvolvedoras;
	}

	public void setListaModelDesenvolvedoras(ListDataModel<Desenvolvedora> listaModelDesenvolvedoras) {
		this.listaModelDesenvolvedoras = listaModelDesenvolvedoras;
	}

	public List<Desenvolvedora> getListaFiltradaModelDesenvolvedoras() {
		return listaFiltradaModelDesenvolvedoras;
	}

	public void setListaFiltradaModelDesenvolvedoras(List<Desenvolvedora> listaFiltradaModelDesenvolvedoras) {
		this.listaFiltradaModelDesenvolvedoras = listaFiltradaModelDesenvolvedoras;
	}

	public List<Desenvolvedora> getListaDesenvolvedoras() {
		return listaDesenvolvedoras;
	}

	public void setListaDesenvolvedoras(List<Desenvolvedora> listaDesenvolvedoras) {
		this.listaDesenvolvedoras = listaDesenvolvedoras;
	}
	
	//Métodos de Acesso ao Banco de Dados
	
	public void PrepararNovo() {
		this.desenvolvedora = new Desenvolvedora();
	}

	public void Insert() {
		try {
			DesenvolvedoraDAO dao = new DesenvolvedoraDAO();
			
			dao.Inserir(this.desenvolvedora);
					
			this.desenvolvedora = new Desenvolvedora();
			
			this.listaDesenvolvedoras = dao.listarTodos();
			this.listaModelDesenvolvedoras = new ListDataModel<>(this.listaDesenvolvedoras);
			
			JSFUtil.adicionarMensagemSucesso("Desenvolvedora cadastrada com sucesso!");
		}
		catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro ao tentar cadastrar uma desenvolvedora" + e.getMessage());
		}
	}
	
	public void PrepararDelete() 
	{
		this.desenvolvedora = this.listaModelDesenvolvedoras.getRowData();
	}
	
	public void Delete() {
		try {
			DesenvolvedoraDAO dao = new DesenvolvedoraDAO();
			
			dao.Excluir(this.desenvolvedora.getCnpj());
					
			this.desenvolvedora = new Desenvolvedora();
			
			this.listaDesenvolvedoras = dao.listarTodos();
			this.listaModelDesenvolvedoras = new ListDataModel<>(this.listaDesenvolvedoras);
			
			JSFUtil.adicionarMensagemSucesso("Desenvolvedora deletada com sucesso!");
		}
		catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro ao tentar deletar uma desenvolvedora" + e.getMessage());

		}
	}
	
	public void PrepararUpdate() 
	{
		this.desenvolvedora = this.listaModelDesenvolvedoras.getRowData();
	}
	
	public void Update() {
		try {
			DesenvolvedoraDAO dao = new DesenvolvedoraDAO();
			
			dao.Atualizar(this.desenvolvedora);
					
			this.desenvolvedora = new Desenvolvedora();
			
			this.listaDesenvolvedoras = dao.listarTodos();
			this.listaModelDesenvolvedoras = new ListDataModel<>(this.listaDesenvolvedoras);
			
			JSFUtil.adicionarMensagemSucesso("Desenvolvedora atualizada com sucesso!");
		}
		catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro ao tentar atualizar uma desenvolvedora" + e.getMessage());

		}
	}
	
	@PostConstruct
	public void init() {
		
		try {
			DesenvolvedoraDAO dao = new DesenvolvedoraDAO();
				
			this.listaDesenvolvedoras = dao.listarTodos();
			this.listaModelDesenvolvedoras = new ListDataModel<>(this.listaDesenvolvedoras);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
