package org.zabalburu.dwes.ActividadSpringMVC.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.zabalburu.dwes.ActividadSpringMVC.modelo.Pelicula;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
@Transactional
public class PeliculaDAO {

	@PersistenceContext
    private EntityManager em;
	
	public Pelicula save(Pelicula nuevo) {
		em.persist(nuevo);
		return nuevo;
	}
	
	public void modify(Pelicula modificar) {
		em.merge(modificar);
	}
	
	public void remove(Pelicula eliminar) {
		em.remove(eliminar);
	}
	
	public Pelicula findById(Integer id) {
		return em.find(Pelicula.class, id);
	}
	
	public List<Pelicula> getPeliculas(){
		
		Query q = em.createQuery(
				"""
				Select p 
				From Pelicula p
				Order By p.nombre
				"""
				);
					
		return q.getResultList();
	}
}
