package com.generation.c2cspring.service;

import java.util.List;

import com.generation.c2cspring.entities.Categoria;


public interface CategoriaService {
	
	Categoria getById(int id);
	
	List<Categoria> getAll();
	
	Categoria createOrUpdate(Categoria vendedor);
	
	void delete(int id);

}
