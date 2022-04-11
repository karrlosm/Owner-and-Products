package br.edu.dac.karlos.projetojpa2.model.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Owner{

	@Id
	private String cpf;
	private String name;
	private Long age;
	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL})
	@JoinColumn(name = "ProductFK")
	private List<Product> products;
	

	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String newCpf) {
		this.cpf = newCpf;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}
	
	public String toString() {
		return "INFORMAÇÕES DO DONO \n"+"CPF => "+cpf+"\n"+"NOME => "+name+"\n"+"IDADE => "+age;
	}
	
}
