package com.marc.mybike1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.marc.mybike1.DAO.IBicicletaDAO;
import com.marc.mybike1.models.Bicicleta;
import com.marc.mybike1.repository.IBicicletaService;


@Service
public class BicicletaServiceImpl implements IBicicletaService {

	@Autowired
	private IBicicletaDAO bicicletaDAO;

	@Override
	public List<Bicicleta> findAll() {
		
		return (List<Bicicleta>) bicicletaDAO.findAll();
	}

	@Override
	public Bicicleta save(Bicicleta b) {
		// TODO Auto-generated method stub
		return bicicletaDAO.save(b);
	}

	@Override
	public Bicicleta findById(int id) {
		
		Optional<Bicicleta> optionalBici = bicicletaDAO.findById(id);
		Bicicleta bicicleta = optionalBici.get();
		return bicicleta;
				
	}
	
	@Override
	public Bicicleta delete(int id) {
		Optional<Bicicleta> optionalBici = bicicletaDAO.findById(id);
		Bicicleta bicicleta = optionalBici.get();
		if(bicicleta!= null)
		bicicletaDAO.delete(bicicleta);
		return bicicleta;
		
		
	}
	public List <Bicicleta> findByMarca(String marca) {
		List<Bicicleta> bicisRespuesta = new ArrayList<Bicicleta>();
		List<Bicicleta> bicis = (List<Bicicleta>) bicicletaDAO.findAll();
		for(int i=0; i<bicis.size(); i++) {
			if(bicis.get(i).getMarca().equals(marca)) {
				bicisRespuesta.add(bicis.get(i));
			}
		}		
		return bicisRespuesta;
	}

	

	

		
}
