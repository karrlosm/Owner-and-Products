package br.edu.dac.karlos.projetojpa2.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import br.edu.dac.karlos.projetojpa2.model.entity.Owner;
import br.edu.dac.karlos.projetojpa2.model.repository.OwnerRepository;

@Service
public class OwnerService {

	@Autowired
	private OwnerRepository repository;
	
	public void create(Owner owner) {
		repository.save(owner);
	}
	
	public List<Owner> readAll(){
		return (List<Owner>) repository.findAll();
	}

	public Owner update(Owner newOwner) {
		return repository.save(newOwner);
	}
	
	public void delete(String cpf) {
		repository.deleteById(cpf);
	}
	
	public List<Owner> find(Owner filter){
		Example example = Example.of(filter,
				ExampleMatcher.matching()
				.withIgnoreCase()
				.withStringMatcher(StringMatcher.CONTAINING));
		return repository.findAll(example);
	}
	
}
