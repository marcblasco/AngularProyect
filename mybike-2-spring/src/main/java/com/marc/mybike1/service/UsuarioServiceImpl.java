package com.marc.mybike1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.marc.mybike1.DAO.IBicicletaDAO;
import com.marc.mybike1.DAO.IUsuarioDAO;
import com.marc.mybike1.models.Bicicleta;
import com.marc.mybike1.models.Usuario;
import com.marc.mybike1.repository.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioDAO usuarioDAO;
	
	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario save(Usuario u) {
		return usuarioDAO.save(u);
	}

	@Override
	public Usuario findById(int id) {
		// TODO Auto-generated method stub
		Optional<Usuario> optionalUser = usuarioDAO.findById(id);
		Usuario user = optionalUser.get();
		return user;
	}

	@Override
	public Usuario delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
