package br.edu.insper.mvc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




public class DAO {
	
	
	private Connection connection = null;
	
	public DAO() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/meus_dados?serverTimezone=UTC",
                "root", "9vpnvn00");
	}
	

	
	public List<Tasks> getLista() throws SQLException{
		List<Tasks> tasks = new ArrayList<Tasks>();
		
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM tasks;");
		ResultSet rs = stmt.executeQuery();
		
		
		while (rs.next()) {
			Tasks task = new Tasks();
			task.setId(rs.getInt("id"));
			task.setUsuario(rs.getNString("usuario"));
			task.setTag(rs.getNString("tag"));
			task.setTarefa(rs.getNString("tarefa"));
			
			tasks.add(task);
			
		}
		rs.close();
		stmt.close();
		
		return tasks;
		
	}
	
	public List<Tasks> getListaMod(Tasks task) throws SQLException{
		List<Tasks> tasks = new ArrayList<Tasks>();
		
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM tasks WHERE tag =?;");
		stmt.setNString(1,task.getTag());
		ResultSet rs = stmt.executeQuery();
		
		
		
		while (rs.next()) {
			Tasks taskk = new Tasks();
			taskk.setId(rs.getInt("id"));
			taskk.setUsuario(rs.getNString("usuario"));
			taskk.setTag(rs.getNString("tag"));
			taskk.setTarefa(rs.getNString("tarefa"));
			
			tasks.add(taskk);
			
		}
		rs.close();
		stmt.close();
		
		return tasks;
		
	}
	
	
	public void adiciona (Tasks task) throws SQLException {
		String sql = "INSERT INTO tasks" + "(usuario,tag,tarefa) values(?,?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setNString(1,task.getUsuario());
		stmt.setNString(2,task.getTag());
		stmt.setNString(3,task.getTarefa());
		stmt.execute();
		stmt.close();
		
	}
	
	
	public void remove (Integer id) throws SQLException {
	String sql = "DELETE FROM tasks WHERE id = ?";
	PreparedStatement stmt = connection.prepareStatement(sql);
	stmt.setInt(1, id);
	stmt.execute();
	stmt.close();
	}
	
	
	public void altera(Tasks task) throws SQLException {
	String sql = "UPDATE tasks SET " + "usuario=?,tag=?,tarefa=? WHERE id=?";
	PreparedStatement stmt = connection.prepareStatement(sql);
	stmt.setNString(1,task.getUsuario());
	stmt.setNString(2,task.getTag());
	stmt.setNString(3,task.getTarefa());
	stmt.setInt(4, task.getId());
	stmt.execute();
	stmt.close();
		


	}
	
	public void alteraLog(Login login) throws SQLException {
	String sql = "UPDATE login SET " + "usuario=?,password = ? WHERE id=?";
	PreparedStatement stmt = connection.prepareStatement(sql);
	stmt.setNString(1,login.getUsername());
	stmt.setInt(2,login.getPassword());
	stmt.setInt(3, login.getId());
	stmt.execute();
	stmt.close(); 
		
	}
	
	
	public String getUser() throws SQLException {
		String variavel = new String ();
		
		String sql = "SELECT usuario FROM login";		
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			variavel= rs.getNString("usuario");
			
		}
		
		rs.close();
		stmt.close();
		
		return variavel;
		
		
		
	}
	
	
	public void close() throws SQLException {
		connection.close();
	}
	
	

}
