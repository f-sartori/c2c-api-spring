package com.generation.c2cspring.controller;

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

import com.generation.c2cspring.entities.Categoria;
import com.generation.c2cspring.service.CategoriaService;

@RestController
@CrossOrigin("*")
public class CategoriaController {

	@Autowired
	private CategoriaService service;
	
	@GetMapping("/categoria")
	public ResponseEntity<List<Categoria>> getAll(){
		List<Categoria> categoria = service.getAll();
		return ResponseEntity.ok(categoria);
	}
	
	@GetMapping("/categoria/{id}")
	public ResponseEntity<Categoria> getById(@Valid @PathVariable int id) {
		return ResponseEntity.ok(service.getById(id));
}
	
	@PostMapping("/categoria")
	public ResponseEntity<Categoria> post(@RequestBody Categoria categoria){
		try {
			Categoria categoriaSalvo = this.service.createOrUpdate(categoria);
			return ResponseEntity.ok(categoriaSalvo);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	@PutMapping("/categoria")
	public ResponseEntity<Categoria> put(@RequestBody Categoria categoria){
		try {
			Categoria categoriaSalvo = this.service.createOrUpdate(categoria);
			return ResponseEntity.ok(categoriaSalvo);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	@DeleteMapping("categoria/{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
		service.delete(id);
		return ResponseEntity.ok("Deletado");
	}
	
}
