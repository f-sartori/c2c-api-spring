package com.generation.c2cspring.repository;

import org.springframework.data.repository.CrudRepository;

import com.generation.c2cspring.entities.Vendedor;


public interface VendedorRepository extends CrudRepository<Vendedor, Integer> {

	Vendedor getByNome(String nome);

}
