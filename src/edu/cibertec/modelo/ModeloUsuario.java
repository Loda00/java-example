package edu.cibertec.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import edu.cibertec.entity.Usuario;

public class ModeloUsuario {
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("PE");
	public Usuario validar(String login, String clave){
		EntityManager manager=factory.createEntityManager();
		Usuario data=null;
		TypedQuery<Usuario> resultado=null;
		
		try {
			String hql="Select u from Usuario u where u.usuario=?1 and u.clave=?2";
			resultado=manager.createQuery(hql,Usuario.class);
			resultado.setParameter(1, login);
			resultado.setParameter(2, clave);
			data=resultado.getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			manager.close();
			factory.close();
		}
		
		return data;
	}
	public List<Usuario>listarUsuario(){
		EntityManager manager=factory.createEntityManager();
		List<Usuario>listadoUsuario=new ArrayList<>();
		TypedQuery<Usuario> resultado=null;
		
		try {
			String hql="Select u from Usuario u";
			resultado=manager.createQuery(hql,Usuario.class);
			listadoUsuario=resultado.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			manager.close();
			factory.close();
		}
		
		return listadoUsuario;
	}
	public void insertarUsuario(Usuario usuario){
		EntityManager manager=factory.createEntityManager();
		
		try {
			manager.getTransaction().begin();
			manager.persist(usuario);
			manager.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			manager.getTransaction().rollback();
			System.out.println(e.getMessage());
		}finally{
			manager.close();
			factory.close();
		}
	}
	public void actualizarUsuario(Usuario usuario){
EntityManager manager=factory.createEntityManager();
		
		try {
			manager.getTransaction().begin();
			manager.merge(usuario);
			manager.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			manager.getTransaction().rollback();
			System.out.println(e.getMessage());
		}finally{
			manager.close();
			factory.close();
		}
	}
	public void eliminarUsuario(String login){
EntityManager manager=factory.createEntityManager();
		
		try {
			Usuario usuario=manager.find(Usuario.class, login);
			manager.getTransaction().begin();
			manager.remove(usuario);
			manager.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			manager.getTransaction().rollback();
			System.out.println(e.getMessage());
		}finally{
			manager.close();
			factory.close();
		}
	}
}
