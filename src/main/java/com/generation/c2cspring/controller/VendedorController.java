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

import com.generation.c2cspring.entities.Vendedor;
import com.generation.c2cspring.service.VendedorService;

@RestController
@CrossOrigin("*")
public class VendedorController {

	@Autowired
	private VendedorService service;
	
	@GetMapping("/vendedor")
	public ResponseEntity<List<Vendedor>> getAll(){
		List<Vendedor> vendedor = service.getAll();
		return ResponseEntity.ok(vendedor);
	}
	
	@GetMapping("/vendedor/{id}")
	public ResponseEntity<Vendedor> getById(@Valid @PathVariable int id) {
		return ResponseEntity.ok(service.getById(id));
}
	
	@GetMapping("/vendedor/nome/{nome}")
	public ResponseEntity<Vendedor> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(this.service.getByNome(nome));
	}
	
	@PostMapping("/vendedor")
	public ResponseEntity<Vendedor> post(@RequestBody Vendedor vendedor){
		try {
			Vendedor vendedorSalvo = this.service.createOrUpdate(vendedor);
			return ResponseEntity.ok(vendedorSalvo);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	@PutMapping("/vendedor")
	public ResponseEntity<Vendedor> put(@RequestBody Vendedor vendedor){
		try {
			Vendedor vendedorSalvo = this.service.createOrUpdate(vendedor);
			return ResponseEntity.ok(vendedorSalvo);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	@DeleteMapping("vendedor/{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
		service.delete(id);
		return ResponseEntity.ok("Deletado");
	}
	
}
