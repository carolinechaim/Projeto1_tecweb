package br.edu.insper.mvc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
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
		
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Tasks;");
		ResultSet rs = stmt.executeQuery();
		
		
		while (rs.next()) {
			Tasks task = new Tasks();
			task.setId(rs.getInt("id"));
			task.setUsuario(rs.getNString("usuario"));
			task.setTag(rs.getNString("tag"));
			task.setTarefa(rs.getNString("tarefa"));
			Calendar data =Calendar.getInstance();
			data.setTime(rs.getDate("data"));
			task.setData(data);
			
			tasks.add(task);
			
		}
		rs.close();
		stmt.close();
		
		return tasks;
		
	}
	
	public List<Tasks> getListaMod(Tasks task) throws SQLException{
		List<Tasks> tasks = new ArrayList<Tasks>();
		
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Tasks WHERE tag =?;");
		stmt.setNString(1,task.getTag());
		ResultSet rs = stmt.executeQuery();
		
		
		
		while (rs.next()) {
			Tasks taskk = new Tasks();
			taskk.setId(rs.getInt("id"));
			taskk.setUsuario(rs.getNString("usuario"));
			taskk.setTag(rs.getNString("tag"));
			taskk.setTarefa(rs.getNString("tarefa"));
			Calendar data =Calendar.getInstance();
			data.setTime(rs.getDate("data"));
			taskk.setData(data);
			
			tasks.add(taskk);
			
		}
		rs.close();
		stmt.close();
		
		return tasks;
		
	}
	
	
	public void adiciona (Tasks task) throws SQLException {
		String sql = "INSERT INTO Tasks" + "(data,usuario,tag,tarefa) values(?,?,?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setDate(1,new java.sql.Date(task.getData().getTimeInMillis()));
		stmt.setNString(2,task.getUsuario());
		stmt.setNString(3,task.getTag());
		stmt.setNString(4,task.getTarefa());
		stmt.execute();
		stmt.close();
		
	}
	
	
	public void remove (Integer id) throws SQLException {
	String sql = "DELETE FROM Tasks WHERE id = ?";
	PreparedStatement stmt = connection.prepareStatement(sql);
	stmt.setInt(1, id);
	stmt.execute();
	stmt.close();
	}
	
	
	public void altera(Tasks task) throws SQLException {
	String sql = "UPDATE Tasks SET " + "data=?, usuario=?,tag=?,tarefa=? WHERE id=?";
	PreparedStatement stmt = connection.prepareStatement(sql);
	stmt.setDate(1,new java.sql.Date(task.getData().getTimeInMillis()));
	stmt.setNString(2,task.getUsuario());
	stmt.setNString(3,task.getTag());
	stmt.setNString(4,task.getTarefa());
	stmt.setInt(5, task.getId());
	stmt.execute();
	stmt.close();
		


	}
	
	
	public void close() throws SQLException {
		connection.close();
	}
	
	

}
