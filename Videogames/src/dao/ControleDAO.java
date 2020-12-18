package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConnectionFactory;
import model.Controle;

public class ControleDAO implements ControleInDAO{
	Connection con = ConnectionFactory.getConnection();
	
	@Override
	public void Inserir(Controle controle) throws SQLException
	{		
		PreparedStatement stmt = null;
		String sql = "insert into controle(cor, numero_botoes, numero) values (?, ?, ?)";
		stmt = con.prepareStatement(sql);
		stmt.setString(1, controle.getCor());
		stmt.setInt(2, controle.getNumero_botoes());
		stmt.setInt(3, controle.getNumero());
		stmt.execute();
	}

	@Override
	public List<Controle> listarTodos() throws SQLException
	{		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = " select seq, cor, numero_botoes, numero from controle";
		List<Controle> controles = new ArrayList<Controle>();
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();			
		while(rs.next())
		{
			int seq = rs.getInt(1);
			String cor = rs.getString(2);
			int numero_botoes = rs.getInt(3);
			int numero = rs.getInt(4);
			
			Controle controle=new Controle(seq, cor, numero_botoes, numero);
			controles.add(controle);
		}   
		return controles;
	}
	
	@Override
	public Boolean Atualizar (Controle controle) throws SQLException{
		PreparedStatement stmt = null;
	    String sql = "update controle set cor=?, numero_botoes = ?, numero=? where seq=?";
	    stmt = con.prepareStatement(sql);
	    stmt.setString(1, controle.getCor());
	    stmt.setInt(2, controle.getNumero_botoes());
	    stmt.setInt(3, controle.getNumero());
	    stmt.setInt(4, controle.getSeq());
	    return stmt.execute();
	}
	
	@Override
	public Boolean Excluir (int seq) throws SQLException{
		PreparedStatement stmt = null;
		String sql = "delete from controle where seq=?";
        stmt = con.prepareStatement(sql);
        stmt.setInt(1, seq);
        return stmt.execute();
    }
	 
	@Override
	public Controle buscarPorId(int _seq) throws SQLException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT seq, cor, numero_botoes, numero FROM controle WHERE seq = ?";
        stmt = con.prepareStatement(sql);
     	stmt.setInt(1, _seq);
     	rs = stmt.executeQuery(); 
     	if (rs.next())
     	{
     		int seq = rs.getInt(1);
			String cor = rs.getString(2);
			int numero_botoes = rs.getInt(3);
			int numero = rs.getInt(4);
			
			Controle controle=new Controle(seq, cor, numero_botoes, numero);
			return controle;
     	}
     	return null;
	}
	
	@Override
	public List<Controle> listarTodosPorConsole(int _numero) throws SQLException {
		
		List<Controle> controles = new ArrayList<Controle>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT seq, cor, numero_botoes, numero FROM controle WHERE numero = ?";
		
		stmt = con.prepareStatement(sql);
		
		stmt.setInt(1, _numero);
		
		rs = stmt.executeQuery();
		
		while (rs.next()) {
			
			int seq = rs.getInt(1);
			String cor = rs.getString(2);
			int numero_botoes = rs.getInt(3);
			int numero = rs.getInt(4);
			
			Controle controle=new Controle(seq, cor, numero_botoes, numero);
			
			controles.add(controle);
		}
		return controles;
	}
}