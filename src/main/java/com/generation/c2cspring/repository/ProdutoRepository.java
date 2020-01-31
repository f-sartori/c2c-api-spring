package com.generation.c2cspring.repository;

import org.springframework.data.repository.CrudRepository;

import com.generation.c2cspring.entities.Produto;


public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

}
