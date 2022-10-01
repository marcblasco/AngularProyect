package com.marc.mybike1.DAO;

import org.springframework.data.repository.CrudRepository;

import com.marc.mybike1.models.Usuario;

public interface IUsuarioDAO extends CrudRepository<Usuario, Integer> {

}
