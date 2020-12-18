package dao;

import java.sql.SQLException;
import java.util.List;

import model.Acessorio;

public interface AcessorioInDAO {
	public void Inserir(Acessorio acessorio) throws SQLException;
	public List<Acessorio> listarTodos() throws SQLException;
	public Boolean Atualizar (Acessorio acessorio) throws SQLException;
	public Boolean Excluir (int id) throws SQLException;
	public Acessorio buscarPorId(int _id) throws SQLException;
	public List<Acessorio> listarTodosPorConsole(int _numero) throws SQLException;
}
