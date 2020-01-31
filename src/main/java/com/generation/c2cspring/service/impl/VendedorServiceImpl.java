package com.generation.c2cspring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.c2cspring.entities.Vendedor;
import com.generation.c2cspring.repository.VendedorRepository;
import com.generation.c2cspring.service.VendedorService;

@Service
public class VendedorServiceImpl implements VendedorService {
	
	@Autowired
	private VendedorRepository repository;

	@Override
	public Vendedor getById(int id) {
		
		return this.repository.findById(id).orElse(null);
	}
	
	

	@Override
	public List<Vendedor> getAll() {
		
		return (List<Vendedor>) this.repository.findAll();
	}

	@Override
	public Vendedor createOrUpdate(Vendedor vendedor) {
		Vendedor vendedorSalvo = this.repository.save(vendedor);
		return vendedorSalvo;
	}

	@Override
	public void delete(int id) {
		this.repository.deleteById(id);
		
	}



	@Override
	public Vendedor getByNome(String nome) {
		
		return this.repository.getByNome(nome);
	}

}
