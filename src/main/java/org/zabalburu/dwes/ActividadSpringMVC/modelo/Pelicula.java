package org.zabalburu.dwes.ActividadSpringMVC.modelo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "peliculas") //se tiene que llamar al igual que en el sqlManagement
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pelicula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private long id;
	
	@OneToMany
	private List <Puntuacion> puntuaciones = new ArrayList<>();
	@JoinColumn(name = "usuario_id",nullable = false)
	private Usuario usuario;
	
	 @Column(nullable = false)
	  private String titulo;
	 
	 @Column(nullable = false)
	  private String director;
	 
	 @Column(nullable = false)
	  private String genero;
	 
	 @Column(nullable = false)
	 private Date añoEstreno;
	 
	 public void addPelicula(Puntuacion punt) {
		 puntuaciones.add(punt); //puntuaciones es del array
		 punt.setIdpelicula(this);
	 }
	 
	 public void removePelicula(Puntuacion punt) {
	        puntuaciones.remove(punt);
	        punt.setIdpelicula(null);
	    }

	 @Override
	 public String toString() {
		return "Pelicula [id=" + id + ", puntuaciones=" + puntuaciones + ", usuario=" + usuario + ", titulo=" + titulo
				+ ", director=" + director + ", genero=" + genero + ", añoEstreno=" + añoEstreno + "]";
	 }
	 
	 
}
