package edu.cibertec.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.dom4j.rule.Mode;
import org.primefaces.component.api.UIData;



import edu.cibertec.entity.Usuario;
import edu.cibertec.modelo.ModeloUsuario;

@ManagedBean(name="usuarioController")
@ViewScoped
public class UsuarioController {
	private Usuario usuario;
	private List<Usuario>listadoUsuario;
	private UIData dtFila;
	@PostConstruct
	public void init(){
		usuario=new Usuario();
		cargarTable();
	}
	public void cargarTable(){
		listadoUsuario=new ModeloUsuario().listarUsuario();
	}
	public void seleccionar(){
		usuario=(Usuario)dtFila.getRowData();
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Usuario> getListadoUsuario() {
		return listadoUsuario;
	}
	public void setListadoUsuario(List<Usuario> listadoUsuario) {
		this.listadoUsuario = listadoUsuario;
	}
	public UIData getDtFila() {
		return dtFila;
	}
	public void setDtFila(UIData dtFila) {
		this.dtFila = dtFila;
	}
	
	public void actualizarUsuario() {
		new ModeloUsuario().actualizarUsuario(usuario);
		listadoUsuario = new ModeloUsuario().listarUsuario();
	}
	
	public void registrarUsuario() {
		new ModeloUsuario().insertarUsuario(usuario);
		listadoUsuario = new ModeloUsuario().listarUsuario();
	}
	
	public void nuevoUsuario() {
		usuario = new Usuario();
	}
	 
	
}
