package com.marc.mybike1.repository;

import java.util.List;

import com.marc.mybike1.models.Usuario;

public interface IUsuarioService {
	public List<Usuario> findAll();
	public Usuario save(Usuario u);
	public Usuario findById(int id);
	public Usuario delete(int id);
}
