package com.marc.mybike1.repository;

import java.util.List;
import java.util.Optional;

import com.marc.mybike1.models.Bicicleta;

public interface IBicicletaService {
	public List<Bicicleta> findAll();
	public Bicicleta save(Bicicleta bicicleta);
	public Bicicleta findById(int id);
	public List<Bicicleta> findByMarca(String marca);
	public Bicicleta delete(int id);
}
