package com.marc.mybike1.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marc.mybike1.models.Bicicleta;
import com.marc.mybike1.models.Usuario;
import com.marc.mybike1.service.UsuarioServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class UsuarioController {
	
	@Autowired
	private UsuarioServiceImpl usuarioService;
	//---
	@GetMapping("/")
	private ResponseEntity<List<Usuario>> getAllUsuarios(){
		return ResponseEntity.ok(usuarioService.findAll());
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<?> getById(@PathVariable("id") int id){
		Usuario usuario= null;
	
		Map<String, Object> response = new HashMap<>();		
		try {
			usuario = usuarioService.findById(id);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		return ResponseEntity.ok(usuario);

	}
	/*@SuppressWarnings("unchecked")
	@GetMapping("/usuarios/{id}")
	private ResponseEntity<List<Bicicleta>> getAllUsuariosCompras(@PathVariable("id") int id){
		Usuario u= usuarioService.findById(id);
		System.out.println(u.getbicicletases());

		if(u != null) {
			return new ResponseEntity<>((List<Bicicleta>) u.getbicicletases(),HttpStatus.OK);
		}
		
		else return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);

	}*/
	//-----
	
	@PostMapping
	private Usuario saveUsuario(@RequestBody Usuario b){
		
		try {
			Usuario usuarioGuardado= usuarioService.save(b);
			return usuarioGuardado;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
				
				
	}
}
