package br.edu.dac.karlos.projetojpa2;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.dac.karlos.projetojpa2.controller.OwnerController;
import br.edu.dac.karlos.projetojpa2.controller.ProductController;
import br.edu.dac.karlos.projetojpa2.model.entity.Owner;
import br.edu.dac.karlos.projetojpa2.model.entity.Product;

@SpringBootApplication
public class ProjetoJpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	}
}
