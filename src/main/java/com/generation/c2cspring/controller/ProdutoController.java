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

import com.generation.c2cspring.entities.Produto;
import com.generation.c2cspring.service.ProdutoService;

@RestController
@CrossOrigin("*")
public class ProdutoController {

	@Autowired
	private ProdutoService service;
	
	@GetMapping("/produto")
	public ResponseEntity<List<Produto>> getAll(){
		List<Produto> produto = service.getAll();
		return ResponseEntity.ok(produto);
	}
	
	@GetMapping("/produto/{id}")
	public ResponseEntity<Produto> getById(@Valid @PathVariable int id) {
		return ResponseEntity.ok(service.getById(id));
}
	
	@PostMapping("/produto")
	public ResponseEntity<Produto> post(@RequestBody Produto produto){
		try {
			Produto produtoSalvo = this.service.createOrUpdate(produto);
			return ResponseEntity.ok(produtoSalvo);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	@PutMapping("/produto")
	public ResponseEntity<Produto> put(@RequestBody Produto produto){
		try {
			Produto produtoSalvo = this.service.createOrUpdate(produto);
			return ResponseEntity.ok(produtoSalvo);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	@DeleteMapping("/produto/{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
		service.delete(id);
		return ResponseEntity.ok("Deletado");
	}
	
}
