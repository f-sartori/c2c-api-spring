package com.generation.c2cspring.repository;

import org.springframework.data.repository.CrudRepository;

import com.generation.c2cspring.entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

	Usuario getByNome(String nome);

}
