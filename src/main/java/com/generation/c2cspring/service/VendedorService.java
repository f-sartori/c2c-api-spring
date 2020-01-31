package com.generation.c2cspring.service;

import java.util.List;

import com.generation.c2cspring.entities.Vendedor;

public interface VendedorService {

	Vendedor getById(int id);
	Vendedor getByNome(String name);
	
	List<Vendedor> getAll();
	
	Vendedor createOrUpdate(Vendedor vendedor);
	
	void delete(int id);
}
