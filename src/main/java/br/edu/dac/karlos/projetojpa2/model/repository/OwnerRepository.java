package br.edu.dac.karlos.projetojpa2.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.dac.karlos.projetojpa2.model.entity.Owner;

public interface OwnerRepository extends JpaRepository<Owner, String> {

}
