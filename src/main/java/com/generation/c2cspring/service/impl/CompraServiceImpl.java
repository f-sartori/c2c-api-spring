package com.generation.c2cspring.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.generation.c2cspring.entities.Compra;
import com.generation.c2cspring.repository.CompraRepository;
import com.generation.c2cspring.service.CompraService;

@Service

public class CompraServiceImpl implements CompraService {

	@Autowired
	private CompraRepository repository;
	
	@Override
	public Compra getById(int id) {
		return this.repository.findById(id).orElse(null);
	}

	@Override
	public List<Compra> getAll() {
		return (List<Compra>) this.repository.findAll();
	}

	@Override
	public Compra createOrUpdate(Compra compra) {
		Compra compraSalvo = this.repository.save(compra);
		return compraSalvo;
	}

	@Override
	public void delete(int id) {
		this.repository.deleteById(id);
		
	}

}
