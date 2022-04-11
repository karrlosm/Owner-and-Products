package br.edu.dac.karlos.projetojpa2.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import br.edu.dac.karlos.projetojpa2.model.entity.Owner;
import br.edu.dac.karlos.projetojpa2.model.entity.Product;
import br.edu.dac.karlos.projetojpa2.model.repository.OwnerRepository;
import br.edu.dac.karlos.projetojpa2.model.repository.ProductRepository;


@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private OwnerRepository ownerRepository;

	public void create(Product product) {
		try {
			Owner owner = ownerRepository.findById(product.getOwnerCpf()).orElse(null);
			List<Product> products = owner.getProducts();
			products.add(product);
			owner.setProducts(products);
			ownerRepository.save(owner);
			repository.save(product);
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public Product update(Product newProduct) {
		return repository.save(newProduct);
	}
	
	public void delete(Integer id) {
		Product product = repository.findById(id).orElse(null);
		if (product != null) {
			int quantity = Math.toIntExact(product.getQuantity());
			if (quantity > 1) {
				int newQuantity = quantity-1;
				product.setQuantity(Long.valueOf(newQuantity));
				repository.save(product);
			} else {
				repository.deleteById(id);
			}
		} else {
			System.out.println("PRODUTO INEXISTENTE NO SISTEMA");
		}	
	}
	
	public List<Product> find(Product filter){
		Example example = Example.of(filter,
				ExampleMatcher.matching()
				.withIgnoreCase()
				.withStringMatcher(StringMatcher.CONTAINING));
		return repository.findAll(example);
	}
}
