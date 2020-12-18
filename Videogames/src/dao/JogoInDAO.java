package dao;

import java.sql.SQLException;
import java.util.List;

import model.Jogo;

public interface JogoInDAO {
	public void Inserir(Jogo jogo) throws SQLException;
	public List<Jogo> listarTodos() throws SQLException;
	public Boolean Atualizar (Jogo jogo) throws SQLException;
	public Boolean Excluir(int codigo) throws SQLException;
	public Jogo buscarPorId(int _codigo) throws SQLException;
	public List<Jogo> listarTodosPorConsole(int _numero) throws SQLException;
	public List<Jogo> listarTodosPorDesenvolvedora(int _cnpj) throws SQLException;
}
