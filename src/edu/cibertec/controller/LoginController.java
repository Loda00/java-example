package edu.cibertec.controller;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import edu.cibertec.entity.Usuario;
import edu.cibertec.modelo.ModeloUsuario;
import edu.cibertec.utils.Constantes;

@ManagedBean(name="sesion")
@SessionScoped
public class LoginController {
	private String login;
	private String clave;
	private Usuario usuario;
	
	public void iniciaSesion() throws IOException{
		usuario=new ModeloUsuario().validar(login, clave);
		if(usuario==null){
			Constantes.mensaje("Sistema", "Usuario y/o clave incorrect", 
					FacesMessage.SEVERITY_INFO);
		}else{
			Constantes.url("usuario.jsf");
		}
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
