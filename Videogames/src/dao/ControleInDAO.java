package dao;

import java.sql.SQLException;
import java.util.List;

import model.Controle;

public interface ControleInDAO {
	public void Inserir(Controle controle) throws SQLException;
	public List<Controle> listarTodos() throws SQLException;
	public Boolean Atualizar (Controle controle) throws SQLException;
	public Boolean Excluir (int seq) throws SQLException;
	public Controle buscarPorId(int _seq) throws SQLException;
	public List<Controle> listarTodosPorConsole(int _numero) throws SQLException;
}
