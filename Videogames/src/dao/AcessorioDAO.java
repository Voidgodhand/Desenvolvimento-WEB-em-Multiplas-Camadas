package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConnectionFactory;
import model.Acessorio;

public class AcessorioDAO implements AcessorioInDAO {
	Connection con = ConnectionFactory.getConnection();
	
	@Override
	public void Inserir(Acessorio acessorio) throws SQLException
	{
		PreparedStatement stmt = null;
		String sql = "insert into acessorio(nome, numero) values (?, ?)";
		stmt = con.prepareStatement(sql);
		stmt.setString(1, acessorio.getNome());
		stmt.setInt(2, acessorio.getNumero());
		stmt.execute();
	}

	@Override
	public List<Acessorio> listarTodos() throws SQLException
	{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = " select id, nome, numero from acessorio";
		List<Acessorio> acessorios = new ArrayList<Acessorio>();
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();			
		while(rs.next())
		{
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			int numero = rs.getInt(3);
			Acessorio acessorio=new Acessorio(id, nome, numero);
			acessorios.add(acessorio);
		}   
		return acessorios;
	}
	
	@Override
	public Boolean Atualizar (Acessorio acessorio) throws SQLException{
		PreparedStatement stmt = null;
	    String sql = "update acessorio set nome=?, numero=? where id=?";
	    stmt = con.prepareStatement(sql);
	    stmt.setString(1, acessorio.getNome());
	    stmt.setInt(2, acessorio.getNumero());
	    stmt.setInt(3, acessorio.getId());
	    return stmt.execute();
	}
	
	@Override
	public Boolean Excluir (int id) throws SQLException{
		PreparedStatement stmt = null;
		String sql = "delete from acessorio where id=?";
        stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        return stmt.execute();
    }
	 
	@Override
    public Acessorio buscarPorId(int _id) throws SQLException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT id, nome, numero FROM acessorio WHERE id = ?";
        stmt = con.prepareStatement(sql);
     	stmt.setInt(1, _id);
     	rs = stmt.executeQuery(); 
     	if (rs.next())
     	{
     		int id = rs.getInt(1);
			String nome = rs.getString(2);
			int numero = rs.getInt(3);
			
			Acessorio acessorio= new Acessorio(id, nome, numero);
			return acessorio;
     	}
     	return null;
    }
	
	@Override
	public List<Acessorio> listarTodosPorConsole(int _numero) throws SQLException {
		
		List<Acessorio> acessorios = new ArrayList<Acessorio>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT id, nome, numero FROM acessorio WHERE numero = ?";
		
		stmt = con.prepareStatement(sql);
		
		stmt.setInt(1, _numero);
		
		rs = stmt.executeQuery();
		
		while (rs.next()) {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			int numero = rs.getInt(3);
			
			Acessorio acessorio = new Acessorio(id, nome, numero);
			
			acessorios.add(acessorio);
		}
		return acessorios;
	}

}
