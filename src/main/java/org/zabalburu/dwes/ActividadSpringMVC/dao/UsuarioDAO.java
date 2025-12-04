package org.zabalburu.dwes.ActividadSpringMVC.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.zabalburu.dwes.ActividadSpringMVC.modelo.*;


import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
public class UsuarioDAO {

	@PersistenceContext 
	private EntityManager em;
	
	public Usuario save(Usuario nuevo) {
		em.persist(nuevo);
		return nuevo;
	}

	public Usuario findById(Integer id) {
		return em.find(Usuario.class, id);
	}
	
	public void update(Usuario modificar) {
		em.merge(modificar);
	}
	
	public void delete(Usuario usuario) {
		em.remove(usuario);
	}
	
	
	public Usuario findByUsername(String username) {
		TypedQuery<Usuario> q = em.createQuery(        //em.createQuery: Crea una consulta JPQL usando el EntityManager
		"""
			Select u 
			From Usuario u 
			where lower(u.username) = lower(:username)		
		""", Usuario.class);                           // (Select u from Usuario u)Selecciona todos los usuarios ((where lower ..) Compara el username en minúsculas (para ignorar mayúsculas))
		q.setParameter("username", username);          //:username en la consulta con el valor pasado al método
		Usuario user = null;                           //Por defecto, si no encuentra nada, devuelve null
		try {
			user = q.getSingleResult();                // Ejecuta la consulta esperando UN solo resultado
		} catch (NoResultException ex) {}              //Si no encuentra nada, lanza NoResultException → se captura y user queda en null
		return user;                                   //Devuelve el usuario encontrado o null si no existe
	}
	
	
	
}
