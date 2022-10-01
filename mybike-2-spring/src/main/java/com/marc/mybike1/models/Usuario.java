package com.marc.mybike1.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "usuarios")
public class Usuario {
    
	@Id
    @Column
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	 @Column
    private String email;
    @Column
    private String password;
    @Column 
    private String roleId;
    
   /* @JsonBackReference
    @ElementCollection
    @ManyToMany
    @JoinTable(name = "pedidos", joinColumns = {
			@JoinColumn(name = "id_bicicleta", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "id_usuario", nullable = false, updatable = false) })
	private Set<Bicicleta> bicicletases = new HashSet<>();*/
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	/*public Set<Bicicleta> getbicicletases() {
		return bicicletases;
	}

	public void setbicicletases(Set<Bicicleta> bicicletases) {
		this.bicicletases = bicicletases;
	}*/
	

    
}
