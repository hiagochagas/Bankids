package com.Bankids.Controllers;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import com.Bankids.Models.Cliente;
import com.Bankids.Models.ClienteLogado;
import com.Bankids.Models.Gasto;

@Controller
public class TransferenciaController {
	
	Cliente clienteDestino;
	String valor;
	
	@RequestMapping("/transferencia")
	public String index() {
		return "transferenciaView";
	}
	
	@PostMapping("/transferencia/verificaCPF")
	public String index(WebRequest request) {
		String cpf = request.getParameter("cpf");
		valor = request.getParameter("valor");
		clienteDestino = verificarDados(cpf);
		if(clienteDestino != null && clienteDestino.getCpf() != ClienteLogado.singleton().getCpf()) {
			return "redirect:/transferencia/segundaParte";
		}
		//mostra uma mensagem de erro: usuário inválido
		return "redirect:/transferencia";
	}
	
	@RequestMapping("/transferencia/segundaParte")
	public String segundaParte(Model model) {
		model.addAttribute("cpf", clienteDestino.getCpf());
		model.addAttribute("nome", clienteDestino.getNomeCompleto());
		model.addAttribute("valor", valor);
		return "transferenciaSegundoPassoView";
	}
	
	@PostMapping("/transferencia/confirmarTransferencia") 
	public String confirmarTransferencia(WebRequest request) {
		String senha = request.getParameter("senha");
		String confirmarSenha = request.getParameter("confirmarSenha");
		if(senha.equals(confirmarSenha)) {
			transferirDeClienteLogadoPara(clienteDestino, valor);
			return "redirect:/transferencia";
		}
		return "redirect:/transferencia/segundaParte";
	}
	
	public void transferirDeClienteLogadoPara(Cliente cliente, String valor) {
		ClienteLogado clienteLogado = ClienteLogado.singleton();
		Double valorGasto = Double.parseDouble(valor);
		if(valorGasto <= clienteLogado.getSaldo()) {
			clienteLogado.removerDoSaldo(valorGasto);
			Gasto gasto = new Gasto(UUID.randomUUID(), valorGasto, "Transferencia para "+ cliente.getNomeCompleto());
			clienteLogado.adicionarGasto(gasto);
			cliente.adicionarAoSaldo(valorGasto);
		}
	}
	public Cliente verificarDados(String cpf) {
		ArrayList<Cliente> clientes = Cliente.clientesMockados; 
		for(Cliente cliente : clientes) {
			System.out.println(cliente.getCpf()); 
			if (cliente.getCpf().equals(cpf)) {
				 return cliente;	
			 }	        
		 }
		return null;
	}
}
