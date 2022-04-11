package br.edu.dac.karlos.projetojpa2.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.dac.karlos.projetojpa2.model.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
