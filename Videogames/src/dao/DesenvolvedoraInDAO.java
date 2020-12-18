package dao;

import java.sql.SQLException;
import java.util.List;

import model.Desenvolvedora;

public interface DesenvolvedoraInDAO {
	public void Inserir(Desenvolvedora desenvolvedora) throws SQLException;
	public List<Desenvolvedora> listarTodos() throws SQLException;
	public Boolean Atualizar (Desenvolvedora desenvolvedora) throws SQLException;
	public Boolean Excluir(int cnpj) throws SQLException;
	public Desenvolvedora buscarPorId(int _cnpj) throws SQLException;

}
