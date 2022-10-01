package com.marc.mybike1.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

	@Entity
	@Table(name = "bicis")
	public class Bicicleta {
	    
	    @Id
	    @Column
	    //@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    @Column
	    private String name;
	    @Column 
	    private String marca;	    
	    @Column 
	    private int precio;
	    @Column 
	    private String logo;
	    
	   /* @JsonBackReference	    
	    @ElementCollection
	    @ManyToMany
	    @JoinTable(name = "pedidos", joinColumns = {
				@JoinColumn(name = "id_usuario", nullable = false, updatable = false) }, inverseJoinColumns = {
						@JoinColumn(name = "id_bicicleta", nullable = false, updatable = false) })
		private Set<Usuario> usuarioses = new HashSet<>();*/

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getMarca() {
			return marca;
		}

		public void setMarca(String marca) {
			this.marca = marca;
		}

		public int getPrecio() {
			return precio;
		}

		public void setPrecio(int precio) {
			this.precio = precio;
		}

		public String getLogo() {
			return logo;
		}

		public void setLogo(String logo) {
			this.logo = logo;
		}

	/*	public Set<Usuario> getUsuarios() {
			return usuarioses;
		}

		public void setUsuarios(Set<Usuario> usuarios) {
			this.usuarioses = usuarios;
		}

	*/

		

		
		
	    
		
}
