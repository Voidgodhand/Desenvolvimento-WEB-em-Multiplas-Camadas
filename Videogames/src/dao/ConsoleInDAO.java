package dao;

import java.sql.SQLException;
import java.util.List;

import model.Console;

public interface ConsoleInDAO {
	public void Inserir(Console console) throws SQLException;
	public List<Console> listarTodos() throws SQLException;
	public Boolean Atualizar (Console console) throws SQLException;
	public Boolean Excluir(int numero) throws SQLException;
	public Console buscarPorId(int _numero) throws SQLException;
}
