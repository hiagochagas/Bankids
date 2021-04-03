package com.Bankids.Bankids;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.Bankids.Models.Cliente;
import com.Bankids.Models.Dica;

@ComponentScan({"com.Bankids.Controllers"})
@SpringBootApplication
public class BankidsApplication {
	static boolean inicializado = false;
	public static void main(String[] args) {
		if(inicializado == false) {
			inicializado = true;
			Cliente.criarClientesMockados();
			Dica.criarDicasMockadas();
		}
		SpringApplication.run(BankidsApplication.class, args);
	}
	
}
