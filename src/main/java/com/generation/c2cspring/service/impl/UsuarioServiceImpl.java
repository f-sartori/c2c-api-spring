package com.generation.c2cspring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.c2cspring.entities.Usuario;
import com.generation.c2cspring.repository.UsuarioRepository;
import com.generation.c2cspring.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;

	@Override
	public Usuario getById(int id) {
		return this.repository.findById(id).orElse(null);
	}

	@Override
	public Usuario getByName(String nome) {
		return this.repository.getByNome(nome);
	}

	@Override
	public List<Usuario> getAll() {
		
		return (List<Usuario>) this.repository.findAll();
	}

	@Override
	public Usuario createOrUpdate(Usuario usuario) {
		Usuario usuarioSalvo = this.repository.save(usuario);
		return usuarioSalvo;
	}

	@Override
	public void delete(int id) {
		this.repository.deleteById(id);
		
	}

}
