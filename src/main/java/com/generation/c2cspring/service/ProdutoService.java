package com.generation.c2cspring.service;

import java.util.List;

import com.generation.c2cspring.entities.Produto;


public interface ProdutoService {
	
	Produto getById(int id);
	Produto getByName(String name);
	
	List<Produto> getAll();
	
	Produto createOrUpdate(Produto vendedor);
	
	void delete(int id);

}
