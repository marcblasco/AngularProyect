package com.marc.mybike1.Controllers;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;

import com.marc.mybike1.models.Bicicleta;
import com.marc.mybike1.models.Usuario;
import com.marc.mybike1.service.BicicletaServiceImpl;
import com.marc.mybike1.service.UsuarioServiceImpl;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/bicicletas")
public class BicicletaController {

	
	@Autowired
	private BicicletaServiceImpl biciService;
	@Autowired
	private UsuarioServiceImpl usuarioService;
	
	@GetMapping("/")
	private ResponseEntity<List<Bicicleta>> getAllBicicletas(){
		return ResponseEntity.ok(biciService.findAll());
	}
	@GetMapping("/marca/{marca}")
	private ResponseEntity<List<Bicicleta>> getByMarca(@PathVariable("marca") String marca){
		return ResponseEntity.ok(biciService.findByMarca(marca));
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<?> getById(@PathVariable("id") int id){
		Bicicleta bici= null;
	
		Map<String, Object> response = new HashMap<>();		
		try {
			bici = biciService.findById(id);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		return ResponseEntity.ok(bici);

	}
	@PutMapping("/bicicleta/{id}")
	private Bicicleta editarBicicleta(@RequestBody Bicicleta b){
			try {
			
			return biciService.save(b);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
			}
	}	
	@DeleteMapping("/{id}")
	private Bicicleta delete(@PathVariable("id") int id) {
		return biciService.delete(id);
	}

	@PostMapping("/new")
	private Bicicleta saveBicicleta(@RequestBody Bicicleta b){
		
		try {
			Bicicleta biciGuardada= biciService.save(b);
			return biciGuardada;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
				
				
	}
	@PostMapping("/")
	private Usuario guardarUsuario(@RequestBody Usuario b){
		
		try {
			Usuario usuarioGuardado= usuarioService.save(b);
			return usuarioGuardado;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
				
				
	}

}
