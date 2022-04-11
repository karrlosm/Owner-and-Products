package br.edu.dac.karlos.projetojpa2.model.dto;

import java.util.ArrayList;
import java.util.List;

import br.edu.dac.karlos.projetojpa2.model.entity.Product;

public class ProductDTO {
	
	private int id;
	private String name;
	private Long quantity;
	
	public ProductDTO(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.quantity = product.getQuantity();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	public static List<ProductDTO> convert(List<Product> products){
		List<ProductDTO> dtos = new ArrayList<ProductDTO>();
		for (Product product : products) {
			dtos.add(new ProductDTO(product));
		}
		return dtos;
	}

}
