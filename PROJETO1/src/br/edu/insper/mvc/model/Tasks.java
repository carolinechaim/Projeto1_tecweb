package br.edu.insper.mvc.model;

import java.util.Calendar;

//JAVABEAN

public class Tasks {
	
	private Integer id;
	private Calendar data;
	private String usuario;
	private String tag;
	private String tarefa;
	
	public Integer getId() {return this.id;}
	public void setId(Integer id) {this.id = id;}
	
	public Calendar getData() {return this.data;}
	public void setData(Calendar data) {this.data=data;}
	
	public String getUsuario() {return this.usuario;}
	public void setUsuario(String usuario) {this.usuario = usuario;}
	
	public String getTag() {return this.tag;}
	public void setTag(String tag) {this.tag = tag;}
	
	public String getTarefa() {return this.tarefa;}
	public void setTarefa(String tarefa) {this.tarefa = tarefa;}

}
