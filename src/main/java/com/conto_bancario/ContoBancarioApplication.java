package com.conto_bancario;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.conto_bancario.pojo.ContoBancario;
import com.conto_bancario.service.ContoBancarioService;

@SpringBootApplication
public class ContoBancarioApplication implements CommandLineRunner{

	@Autowired
	private	ContoBancarioService contoBancarioServ;
	public static void main(String[] args) {
		SpringApplication.run(ContoBancarioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		

		try {
			ContoBancario cb1 = new ContoBancario();
			ContoBancario cb2 = new ContoBancario();
			ContoBancario cb3 = new ContoBancario();
			
			cb1.deposita(100);
			System.out.println("Saldo attuale conto 1: "+ cb1.getSaldo());
			cb1.preleva(50);
			System.out.println("Saldo attuale conto 1: "+cb1.getSaldo());
			// cb1.preleva(100);
			// System.out.println("Saldo attuale: "+cb1.getSaldo());
			cb2.deposita(900);
			System.out.println("Saldo attuale conto 2: "+cb2.getSaldo());
			cb3.deposita(800);
			System.out.println("Saldo attuale conto 2: "+cb3.getSaldo());


			contoBancarioServ.saveConto(cb1);
			contoBancarioServ.saveConto(cb2);
			contoBancarioServ.saveConto(cb3);
			

			System.out.println("-------------------------------------");

			Optional<ContoBancario> contoOptional = contoBancarioServ.findContoById(2);
			
			if(contoOptional.isEmpty()){
				System.out.println("Il conto non esiste");
				return;
			}
			
			System.out.println(contoOptional);

			ContoBancario conto = contoOptional.get();
			conto.setId(2);
			conto.deposita(500);
			contoBancarioServ.saveConto(conto);
			System.out.println(conto);

			System.out.println("-------------------------------------");

			contoBancarioServ.findAllConti().forEach(System.out::println);

			System.out.println("-------------------------------------");

			contoBancarioServ.delete(cb3);
			contoBancarioServ.findAllConti().forEach(System.out::println);

		} catch (IllegalArgumentException e) {
			System.out.println("ERRORE: "+e.getMessage());
		}

		

	}

	

}
