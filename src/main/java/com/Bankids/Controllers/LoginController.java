package com.Bankids.Controllers;


import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import com.Bankids.Models.Cliente;
import com.Bankids.Models.ClienteLogado;

@Controller
public class LoginController {
	ArrayList<Cliente> clientes = Cliente.criarClienteMockados();
	
	@RequestMapping("/login")
	public String index() {
		return "loginView";
	}

	@PostMapping("/login/verificar")
	public String index(WebRequest request) {
		String cpf = request.getParameter("cpf");
		String senha = request.getParameter("senha");
		Cliente cliente = verificarDados(cpf, senha);
		if(cliente != null) {
			//Instância singleton de ClienteLogado
			new ClienteLogado(cliente);
			System.out.println(ClienteLogado.singleton().getNomeCompleto());
			//return "redirect:/saldo"
		} //else {
		//mensagem de feedback ao usuário, cliente não encontrado.
		return "redirect:/login";
		// }
	}
	
	public Cliente verificarDados(String cpf, String senha) {
		 for(Cliente cliente : clientes) {
			 if (cliente.getCpf().equals(cpf) && cliente.getSenha().equals(senha)) {
				 return cliente;	
			 }	        
		 }
		return null;
	}
	
}
