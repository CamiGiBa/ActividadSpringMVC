package org.zabalburu.dwes.ActividadSpringMVC.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name="puntuaciones") //se tiene que llamar al igual que en el sqlManagement
@EqualsAndHashCode(onlyExplicitlyIncluded =  true)
public class Puntuacion {
	  	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @EqualsAndHashCode.Include
	    private Long id;
	  
	     @ManyToOne
	     @JoinColumn(name = "id_usuario", nullable = false)
	     private Usuario idusuario;

	     @ManyToOne
	     @JoinColumn(name = "id_pelicula", nullable = false)
	     private Pelicula idpelicula; //se pone el nombre del objeto por que se deben relacionar ellos
	     
	     @Column(nullable = false)
	     private Integer puntuacion;
	     
	     
}
