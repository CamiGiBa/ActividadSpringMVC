package org.zabalburu.dwes.ActividadSpringMVC.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "usuarios") //se tiene que llamar al igual que en el sqlManagement
@EqualsAndHashCode(onlyExplicitlyIncluded =  true)	
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private long id;
	
	@Column(nullable = false, unique = true)
	private String email; 
	
	@Column(nullable = false )
	private String password; 
	
	 @Column(nullable = false)
     private String nombre;

	 @OneToMany(mappedBy="usuario")
	 private List<Puntuacion> puntuaciones;

	 @Override
	 public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", password=" + password + ", nombre=" + nombre + "]";
	 }
	 
	 
}
