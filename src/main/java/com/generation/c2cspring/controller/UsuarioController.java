package com.generation.c2cspring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generation.c2cspring.entities.Usuario;
import com.generation.c2cspring.model.security.Auth;
import com.generation.c2cspring.model.security.Token;
import com.generation.c2cspring.service.UsuarioService;





@RestController
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@GetMapping("/usuario")
			public ResponseEntity<List<Usuario>> getAll(){
				List<Usuario> usuarios = service.getAll();
				return ResponseEntity.ok(usuarios);
			}
	
	@GetMapping("/usuario/{id}")
			public ResponseEntity<Usuario> getById(@Valid @PathVariable int id) {
				return ResponseEntity.ok(service.getById(id));
	}
	
	@GetMapping("/usuario/nome/{nome}")
	public ResponseEntity<Usuario> getByName(@PathVariable String nome){
		return ResponseEntity.ok(this.service.getByName(nome));
	}
	
	
	@DeleteMapping("usuario/{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
		service.delete(id);
		return ResponseEntity.ok("Deletado");
	}
	
	@PostMapping("/usuario")
	public ResponseEntity<Usuario> post(@RequestBody Usuario usuario){
		try {
			Usuario usuarioSalvo = this.service.createOrUpdate(usuario);
			return ResponseEntity.ok(usuarioSalvo);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	@PutMapping("/usuario")
	public ResponseEntity<Usuario> put(@RequestBody Usuario usuario){
		try {
			Usuario usuarioSalvo = this.service.createOrUpdate(usuario);
			return ResponseEntity.ok(usuarioSalvo);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	@PostMapping("/usuario/login")
	public ResponseEntity<Token> autentica(@RequestBody Usuario usuario) {
		List<Usuario> lista = service.getAll();
		for (int i = 0; i < lista.size(); i++) {
			if (usuario.getEmail().equals(lista.get(i).getEmail())
					&& usuario.getSenha().equals(lista.get(i).getSenha())) {
				usuario = lista.get(i);
				String tk = Auth.generateToken(usuario);
				Token token = new Token();
				token.setToken(tk);
				token.setNome(lista.get(i).getNome());
				token.setEmail(lista.get(i).getEmail());

				return ResponseEntity.ok(token);
			}
		}
		return ResponseEntity.status(403).build();
	}
	
	
}
