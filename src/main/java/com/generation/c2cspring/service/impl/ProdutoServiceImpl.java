package com.generation.c2cspring.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.generation.c2cspring.entities.Produto;
import com.generation.c2cspring.repository.ProdutoRepository;
import com.generation.c2cspring.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;

	@Override
	public Produto getById(int id) {
		return this.repository.findById(id).orElse(null);
	}

	@Override
	public List<Produto> getAll() {
		return (List<Produto>) this.repository.findAll();
	}

	@Override
	public Produto createOrUpdate(Produto produto) {
		Produto produtoSalvo = this.repository.save(produto);
		return produtoSalvo;
	}

	@Override
	public void delete(int id) {
		this.repository.deleteById(id);
		
	}

}
