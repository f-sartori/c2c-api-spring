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

import com.generation.c2cspring.entities.Compra;
import com.generation.c2cspring.service.CompraService;


@RestController
@CrossOrigin("*")
public class CompraController {

	
	@Autowired
	private CompraService service;
	
	@GetMapping("/compra")
	public ResponseEntity<List<Compra>> getAll(){
		List<Compra> compra = service.getAll();
		return ResponseEntity.ok(compra);
	}
	
	@GetMapping("/compra/{id}")
	public ResponseEntity<Compra> getById(@Valid @PathVariable int id) {
		return ResponseEntity.ok(service.getById(id));
}
	
	@PostMapping("/compra")
	public ResponseEntity<Compra> post(@RequestBody Compra compra){
		try {
			Compra compraSalvo = this.service.createOrUpdate(compra);
			return ResponseEntity.ok(compraSalvo);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	@PutMapping("/compra")
	public ResponseEntity<Compra> put(@RequestBody Compra compra){
		try {
			Compra compraSalvo = this.service.createOrUpdate(compra);
			return ResponseEntity.ok(compraSalvo);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	@DeleteMapping("compra/{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
		service.delete(id);
		return ResponseEntity.ok("Deletado");
	}
	
}
