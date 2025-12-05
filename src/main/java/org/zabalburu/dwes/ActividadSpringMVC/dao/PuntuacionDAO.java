package org.zabalburu.dwes.ActividadSpringMVC.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.zabalburu.dwes.ActividadSpringMVC.modelo.Puntuacion;
import org.zabalburu.dwes.ActividadSpringMVC.modelo.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PuntuacionDAO {

	   @PersistenceContext
	    private EntityManager em;
	   
	   public Puntuacion save(Puntuacion nuevo) {
		   em.persist(nuevo);
		   return nuevo;
		   
	   }
	
	   public void modify(Puntuacion modificar) {
		   em.merge(modificar);
	   }
	   
	   public boolean eliminarPuntuacion(Puntuacion puntuacion) {
		   if(puntuacion.getPuntuacion().isEmpty()){
			   em.remove(puntuacion);
			   return true;
			   }
		   return false;
	   }
	   
	   public List<Puntuacion> findByUsuario(Usuario usuario) {
	        return em.createQuery("SELECT p FROM Puntuacion p WHERE p.usuario = :usuario", Puntuacion.class)
	                .setParameter("usuario", usuario)
	                .getResultList();
	    } //Esta función busca y devuelve todos las puntuaciones que pertenecen a un usuario específico.
	   
}
