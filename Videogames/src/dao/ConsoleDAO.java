package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConnectionFactory;
import model.Console;
import model.Acessorio;
import model.Controle;
import model.Jogo;

public class ConsoleDAO implements ConsoleInDAO {
	
	Connection con = ConnectionFactory.getConnection();
	
    @Override
	public void Inserir(Console console) throws SQLException
	{
		PreparedStatement stmt = null;
		String sql = "insert into console(nome) values (?)";
		stmt = con.prepareStatement(sql);
		stmt.setString(1, console.getNome());
		stmt.execute();
	}

	@Override
	public List<Console> listarTodos() throws SQLException
	{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = " select numero, nome from console";
		List<Console> consoles = new ArrayList<Console>();
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();			
		while(rs.next())
		{
			int numero = rs.getInt(1);
			String nome = rs.getString(2);
			
			ControleDAO daoControle = new ControleDAO();
			List<Controle> controles = daoControle.listarTodosPorConsole(numero);
			
			JogoDAO daoJogo = new JogoDAO();
			List<Jogo> jogos = daoJogo.listarTodosPorConsole(numero);
			
			AcessorioDAO daoAcessorio = new AcessorioDAO();
			List<Acessorio> acessorios = daoAcessorio.listarTodosPorConsole(numero);
			
			Console console=new Console(numero, nome, acessorios, controles, jogos);
			consoles.add(console);
		}   
		return consoles;
	}
	
	@Override
	public Boolean Atualizar (Console console) throws SQLException {
		PreparedStatement stmt = null;
	    String sql = "update console set nome=? where numero=?";
	    stmt = con.prepareStatement(sql);
	    stmt.setString(1, console.getNome());
	    stmt.setInt(2, console.getNumero());
	    return stmt.execute();
	}
	
	@Override
	public Boolean Excluir(int numero) throws SQLException {
		PreparedStatement stmt = null;
		String sql = "delete from console where numero=?";
        stmt = con.prepareStatement(sql);
        stmt.setInt(1, numero);
        return stmt.execute();
    }
	
	@Override
	public Console buscarPorId(int _numero) throws SQLException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT numero, nome FROM console WHERE numero = ?";
        stmt = con.prepareStatement(sql);
     	stmt.setInt(1, _numero);
     	rs = stmt.executeQuery(); 
     	if (rs.next())
     	{
     		int numero = rs.getInt(1);
			String nome = rs.getString(2);
			
			ControleDAO daoControle = new ControleDAO();
			List<Controle> controles = daoControle.listarTodosPorConsole(numero);
			
			JogoDAO daoJogo = new JogoDAO();
			List<Jogo> jogos = daoJogo.listarTodosPorConsole(numero);
			
			AcessorioDAO daoAcessorio = new AcessorioDAO();
			List<Acessorio> acessorios = daoAcessorio.listarTodosPorConsole(numero);
			
			Console console = new Console(numero, nome, acessorios, controles, jogos);
			return console;
     		
     	}
     	return null;
     }
	
}