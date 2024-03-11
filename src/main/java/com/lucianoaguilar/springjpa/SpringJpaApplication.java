package com.lucianoaguilar.springjpa;

import com.lucianoaguilar.springjpa.domain.Address;
import com.lucianoaguilar.springjpa.domain.Client;
import com.lucianoaguilar.springjpa.domain.Product;
import com.lucianoaguilar.springjpa.domain.User;
import com.lucianoaguilar.springjpa.repositories.AddressRepository;
import com.lucianoaguilar.springjpa.repositories.ClientRepository;
import com.lucianoaguilar.springjpa.repositories.ProductRepository;
import com.lucianoaguilar.springjpa.repositories.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(
		UserRepository userRepository,
		ClientRepository clientRepository,
		AddressRepository addressRepository,
		ProductRepository productRepository
	){
		return args -> {
			User user = userRepository.save(new User(null,"luciano_user","123123"));
			Client client = clientRepository.save(new Client(null, "luciano aguilar",user, null,null));


			// address
			Address address1 = addressRepository.save(new Address(null, "Odiard","1535",client));
			Address address2 = addressRepository.save(new Address(null, "Odiard","1530",client));
			client.setAddresses(Set.of(address1,address2));

			// product
			Product product1 = productRepository.save(new Product(null, "IPHONE", 1000.0));
			Product product2 = productRepository.save(new Product(null, "NOTEBOOK", 1400.0));
			Product product3 = productRepository.save(new Product(null, "SAMSUNG TV", 800.0));
			client.setProducts(Set.of(product1,product2,product3));


			Client luc = clientRepository.save(client);

			System.out.println("Cliente: " + luc.getName());
			System.out.println("User: " + luc.getUser().getUserName());
			luc.getAddresses().forEach(elem -> System.out.println("Address: " + elem.getStreet() +" "+ elem.getNumber()));

			luc.getProducts().forEach(elem -> System.out.println("product: "+ elem.getName() + ", prize: " + elem.getPrize()));
		};
	}
}
