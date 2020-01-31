package com.generation.c2cspring.service;

import java.util.List;

import com.generation.c2cspring.entities.Usuario;


public interface UsuarioService {
	
	Usuario getById(int id);
	Usuario getByName(String name);
	
	List<Usuario> getAll();
	
	Usuario createOrUpdate(Usuario vendedor);
	
	void delete(int id);
}
