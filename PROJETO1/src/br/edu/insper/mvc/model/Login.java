package br.edu.insper.mvc.model;

public class Login {
	
	private Integer id;
	private String usuario;
	private Integer password;
	
	public void setId(Integer id) {this.id = id;}
	public Integer getId() {return this.id;}
	
	public void setUsername(String username) {this.usuario = username;}
	public String getUsername () {return this.usuario;}
	
	public void setPassword (Integer password) {this.password = password;}
	public Integer getPassword() {return this.password;}
	

}
