package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConnectionFactory;
import model.Jogo;

public class JogoDAO implements JogoInDAO {
	Connection con = ConnectionFactory.getConnection();
	
	@Override
	public void Inserir(Jogo jogo) throws SQLException
	{
		PreparedStatement stmt = null;
		String sql = "insert into jogo(nome, lancamento, numero, cnpj) values (?, ?, ?, ?)";
		stmt = con.prepareStatement(sql);
		stmt.setString(1, jogo.getNome());
		stmt.setString(2, jogo.getLancamento());
		stmt.setInt(3, jogo.getNumero());
		stmt.setInt(4, jogo.getCnpj());
		stmt.execute();
	}

	@Override
	public List<Jogo> listarTodos() throws SQLException
	{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = " select codigo, nome, lancamento, numero, cnpj from jogo";
		List<Jogo> jogos = new ArrayList<Jogo>();
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();			
		while(rs.next())
		{
			int codigo = rs.getInt(1);
			String nome = rs.getString(2);
			String lancamento = rs.getString(3);
			int numero = rs.getInt(4);
			int cnpj = rs.getInt(5);
			Jogo jogo=new Jogo(codigo, nome, lancamento, numero, cnpj);
			jogos.add(jogo);
		}   
		return jogos;
	}
	
	@Override
	public Boolean Atualizar (Jogo jogo) throws SQLException {
		PreparedStatement stmt = null;
	    String sql = "update jogo set nome=?, lancamento=?, numero=?, cnpj=? where codigo=?";
	    stmt = con.prepareStatement(sql);
	    stmt.setString(1, jogo.getNome());
	    stmt.setString(2, jogo.getLancamento());
	    stmt.setInt(3, jogo.getNumero());
	    stmt.setInt(4, jogo.getCnpj());
	    stmt.setInt(5, jogo.getCodigo());
	    return stmt.execute();
	}
	
	@Override
	public Boolean Excluir(int codigo) throws SQLException {
		PreparedStatement stmt = null;
		String sql = "delete from jogo where codigo=?";
        stmt = con.prepareStatement(sql);
        stmt.setInt(1, codigo);
        return stmt.execute();
     }
	 
	@Override
	public Jogo buscarPorId(int _codigo) throws SQLException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT codigo, nome, lancamento, numero, cnpj FROM jogo WHERE codigo = ?";
        stmt = con.prepareStatement(sql);
     	stmt.setInt(1, _codigo);
     	rs = stmt.executeQuery(); 
     	if (rs.next())
     	{
     		int codigo = rs.getInt(1);
			String nome = rs.getString(2);
			String lancamento = rs.getString(3);
			int numero = rs.getInt(4);
			int cnpj = rs.getInt(5);
			Jogo jogo=new Jogo(codigo, nome, lancamento, numero, cnpj);
			return jogo;
     	}
     	return null;
    }
	
	@Override
	public List<Jogo> listarTodosPorConsole(int _numero) throws SQLException {
		
		List<Jogo> jogos = new ArrayList<Jogo>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT codigo, nome, lancamento, numero, cnpj FROM jogo WHERE numero = ?";
		
		stmt = con.prepareStatement(sql);
		
		stmt.setInt(1, _numero);
		
		rs = stmt.executeQuery();
		
		while (rs.next()) {
			
			int codigo = rs.getInt(1);
			String nome = rs.getString(2);
			String lancamento = rs.getString(3);
			int numero = rs.getInt(4);
			int cnpj = rs.getInt(5);
			Jogo jogo=new Jogo(codigo, nome, lancamento, numero, cnpj);
			
			jogos.add(jogo);
		}
		return jogos;
	}
	
	@Override
	public List<Jogo> listarTodosPorDesenvolvedora(int _cnpj) throws SQLException {
		
		List<Jogo> jogos = new ArrayList<Jogo>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT codigo, nome, lancamento, numero, cnpj FROM jogo WHERE cnpj = ?";
		
		stmt = con.prepareStatement(sql);
		
		stmt.setInt(1, _cnpj);
		
		rs = stmt.executeQuery();
		
		while (rs.next()) {
			
			int codigo = rs.getInt(1);
			String nome = rs.getString(2);
			String lancamento = rs.getString(3);
			int numero = rs.getInt(4);
			int cnpj = rs.getInt(5);
			Jogo jogo=new Jogo(codigo, nome, lancamento, numero, cnpj);
			
			jogos.add(jogo);
		}
		return jogos;
	}
}