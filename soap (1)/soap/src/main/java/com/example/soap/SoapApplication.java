package com.example.soap;

import com.example.soap.Entities.Chambre;
import com.example.soap.Entities.Client;
import com.example.soap.repo.ChambreRepository;
import com.example.soap.repo.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SoapApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoapApplication.class, args);
		System.out.println("SOAP Service is running...");
	}

	@Bean
	public CommandLineRunner demo(ClientRepository clientRepository, ChambreRepository chambreRepository) {
		return (args) -> {
			// Exemple 1: Ajouter des clients
			Client client1 = new Client();
			client1.setNom("Dupont");
			client1.setPrenom("Jean");
			client1.setEmail("jean.dupont@example.com");
			client1.setTelephone("0123456789");
			clientRepository.save(client1);

			Client client2 = new Client();
			client2.setNom("Martin");
			client2.setPrenom("Sophie");
			client2.setEmail("sophie.martin@example.com");
			client2.setTelephone("0987654321");
			clientRepository.save(client2);

			// Exemple 2: Ajouter des chambres
			Chambre chambre1 = new Chambre();
			chambre1.setType("Simple");
			chambre1.setPrix(75.0);
			chambre1.setDisponible(true);
			chambreRepository.save(chambre1);

			Chambre chambre2 = new Chambre();
			chambre2.setType("Double");
			chambre2.setPrix(120.0);
			chambre2.setDisponible(true);
			chambreRepository.save(chambre2);

			// Exemple 3: Ajouter une autre chambre
			Chambre chambre3 = new Chambre();
			chambre3.setType("Suite");
			chambre3.setPrix(250.0);
			chambre3.setDisponible(true);
			chambreRepository.save(chambre3);

			// Afficher les clients et chambres ajoutés
			System.out.println("Clients ajoutés:");
			clientRepository.findAll().forEach(client -> System.out.println(client.getNom() + " " + client.getPrenom()));

			System.out.println("Chambres ajoutées:");
			chambreRepository.findAll().forEach(chambre -> System.out.println(chambre.getType() + " - " + chambre.getPrix() + "€"));
		};
	}
}