package br.edu.dac.karlos.projetojpa2.model.entity;

import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
public class Product{
	
	@Id
	private Integer id;
	private String name;
	private Long quantity;
	private String ownerCpf;
	
	public String getOwnerCpf() {
		return ownerCpf;
	}
	public void setOwnerCpf(String cpf) {
		this.ownerCpf = cpf;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	
	@Override
	public String toString() {
		return "INFORMAÇÕES DO PRODUTO => "+name+"\n"+
				"DISPONÍVEIS => " + quantity;
	}
}
