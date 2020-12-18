package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConnectionFactory;
import model.Desenvolvedora;
import model.Jogo;

public class DesenvolvedoraDAO implements DesenvolvedoraInDAO {
	Connection con = ConnectionFactory.getConnection();
	
	@Override
	public void Inserir(Desenvolvedora desenvolvedora) throws SQLException
	{
		PreparedStatement stmt = null;
		String sql = "insert into desenvolvedora(nome) values (?)";
		stmt = con.prepareStatement(sql);
		stmt.setString(1, desenvolvedora.getNome());
		stmt.execute();
	}

	@Override
	public List<Desenvolvedora> listarTodos() throws SQLException
	{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = " select cnpj, nome from desenvolvedora";
		List<Desenvolvedora> desenvolvedoras = new ArrayList<Desenvolvedora>();
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
		while(rs.next())
		{
			int cnpj = rs.getInt(1);
			String nome = rs.getString(2);
			
			JogoDAO daoJogo = new JogoDAO();
			List<Jogo> jogos = daoJogo.listarTodosPorDesenvolvedora(cnpj);
			
			Desenvolvedora desenvolvedora=new Desenvolvedora(cnpj, nome, jogos);
			desenvolvedoras.add(desenvolvedora);
			
		}   
		return desenvolvedoras;
	}
	
	@Override
	public Boolean Atualizar (Desenvolvedora desenvolvedora) throws SQLException {
		PreparedStatement stmt = null;
	    String sql = "update desenvolvedora set nome=? where cnpj=?";
	    stmt = con.prepareStatement(sql);
	    stmt.setString(1, desenvolvedora.getNome());
	    stmt.setInt(2, desenvolvedora.getCnpj());
	    return stmt.execute();
	}
	
	@Override
	public Boolean Excluir(int cnpj) throws SQLException {
		PreparedStatement stmt = null;
		String sql = "delete from desenvolvedora where cnpj=?";
        stmt = con.prepareStatement(sql);
        stmt.setInt(1, cnpj);
        return stmt.execute();
     }
	
	@Override
	public Desenvolvedora buscarPorId(int _cnpj) throws SQLException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT cnpj, nome FROM desenvolvedora WHERE cnpj = ?";
        stmt = con.prepareStatement(sql);
     	stmt.setInt(1, _cnpj);	
     	rs = stmt.executeQuery();
     	if (rs.next())
     	{
     		int cnpj = rs.getInt(1);
			String nome = rs.getString(2);
			
			JogoDAO daoJogo = new JogoDAO();
			List<Jogo> jogos = daoJogo.listarTodosPorDesenvolvedora(cnpj);
			
			Desenvolvedora desenvolvedora = new Desenvolvedora(cnpj, nome, jogos);
            return desenvolvedora;
     	}
     	return null;
    }
}
