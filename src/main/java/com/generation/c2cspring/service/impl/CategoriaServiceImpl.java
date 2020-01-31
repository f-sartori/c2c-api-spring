package com.generation.c2cspring.service.impl;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.c2cspring.entities.Categoria;
import com.generation.c2cspring.repository.CategoriaRepository;
import com.generation.c2cspring.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	@Override
	public Categoria getById(int id) {
		return this.repository.findById(id).orElse(null);
	}

	@Override
	public List<Categoria> getAll() {
		return (List<Categoria>) this.repository.findAll();
	}

	@Override
	public Categoria createOrUpdate(Categoria categoria) {
		Categoria categoriaSalvo = this.repository.save(categoria);
		return categoriaSalvo;
	}

	@Override
	public void delete(int id) {
		this.repository.deleteById(id);
		
	}

}
