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
	static boolean inicializado = false;
	
	@RequestMapping("/login")
	public String index() {
		if(inicializado == false) {
			inicializado = true;
			Cliente.criarClientesMockados();
		}
		return "loginView";
	}

	@PostMapping("/login/verificar")
	public String loginSubmit(WebRequest request) {
		String cpf = request.getParameter("cpf");
		String senha = request.getParameter("senha");
		Cliente cliente = verificarDados(cpf, senha);
		if(cliente != null) {
			//Instância singleton de ClienteLogado
			new ClienteLogado(cliente);
			return "redirect:/saldo";
		} //else {
		//mensagem de feedback ao usuário, cliente não encontrado.
		return "redirect:/login";
		// }
	}
	
	@PostMapping("/login/cadastro")
	public String goToCadastro() {
		return "redirect:/cadastro";
	}
	
	public Cliente verificarDados(String cpf, String senha) {
		ArrayList<Cliente> clientes = Cliente.clientesMockados; 
		for(Cliente cliente : clientes) {
			 if (cliente.getCpf().equals(cpf) && cliente.getSenha().equals(senha)) {
				 return cliente;	
			 }	        
		 }
		return null;
	}
	
}
