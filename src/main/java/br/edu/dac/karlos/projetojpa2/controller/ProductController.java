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

import br.edu.dac.karlos.projetojpa2.model.dto.ProductDTO;
import br.edu.dac.karlos.projetojpa2.model.entity.Owner;
import br.edu.dac.karlos.projetojpa2.model.entity.Product;
import br.edu.dac.karlos.projetojpa2.model.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@PostMapping
	public ResponseEntity<Object> save(@RequestBody Product product) {
		try {
			productService.create(product);
			return new ResponseEntity<Object>(product, HttpStatus.CREATED);
		} catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Object> update(@PathVariable("id") Integer id,@RequestBody Product product) {
		try {
			product.setId(id);;
			product = productService.update(product);
			return ResponseEntity.ok(product);
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
		try {
			productService.delete(id);
			return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping
	public ResponseEntity<List<ProductDTO>> find( 
			@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "quantity", required = false) Long quantity
			){
		try {
			Product productFilter = new Product();
			productFilter.setId(id);
			productFilter.setName(name);
			productFilter.setQuantity(quantity);
			
			List<Product> products = productService.find(productFilter);

			return ResponseEntity.ok(
					ProductDTO.convert(products));
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(null);
		}

	}
}
