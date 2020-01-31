package com.generation.c2cspring.service;

import java.util.List;

import com.generation.c2cspring.entities.Compra;


public interface CompraService {
	
	Compra getById(int id);
	
	List<Compra> getAll();
	
	Compra createOrUpdate(Compra vendedor);
	
	void delete(int id);

}
