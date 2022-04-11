package br.edu.dac.karlos.projetojpa2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.dac.karlos.projetojpa2.model.entity.Owner;
import br.edu.dac.karlos.projetojpa2.model.service.OwnerService;

@RestController
@RequestMapping("/api/owner")
public class OwnerController {
	
	@Autowired
	private OwnerService ownerService;
	
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody Owner owner) {
		try {
			ownerService.create(owner);
			return new ResponseEntity<Object>(owner, HttpStatus.CREATED);
		} catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("{cpf}")
	public ResponseEntity<Object> update(@PathVariable("cpf") String cpf,@RequestBody Owner owner) {
		try {
			owner.setCpf(cpf);
			owner = ownerService.update(owner);
			return ResponseEntity.ok(owner);
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping("{cpf}")
	public ResponseEntity<String> delete(@PathVariable("cpf") String cpf){
		try {
			ownerService.delete(cpf);
			return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping
	public ResponseEntity find( 
			@RequestParam(value = "cpf", required = false) String cpf,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "age", required = false) Long age
			){
		try {
			Owner ownerFilter = new Owner();
			ownerFilter.setCpf(cpf);
			ownerFilter.setName(name);
			ownerFilter.setAge(age);
			
			List<Owner> owners = ownerService.find(ownerFilter);
			return ResponseEntity.ok(owners);
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}
	
	/*
	public void createOwner(String cpf, String name, int age) {
		Owner owner = new Owner();
		owner.setCpf(cpf);
		owner.setName(name);
		owner.setAge(age);
		ownerService.create(owner);
	}
	
	public List<Owner >list(){
		return ownerService.readAll();
	}
	
	public void update(String cpf) {
		ownerService.update(cpf);
	}
	
	public void deletar(String cpf) {
		ownerService.delete(cpf);
	}*/
}
