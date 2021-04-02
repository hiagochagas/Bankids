package com.Bankids.Controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import com.Bankids.Models.Cliente;
import com.Bankids.Models.Gasto;

@Controller
public class CadastroController {

	@RequestMapping("/cadastro")
	public String index() {
		return "cadastroView";
	}
	
	@PostMapping("/cadastro/login")
	public String returnToLogin() {
		return "redirect:/login";
	}
	
	@PostMapping("/cadastro/cadastrar")
	public String registrarCliente(WebRequest request) {
		String nomeCompleto = request.getParameter("nomeCompleto");
		String idade = request.getParameter("idade");
		String rg = request.getParameter("rg");
		String cpfResponsavel = request.getParameter("cpfResponsavel");
		String cpfCrianca = request.getParameter("cpfCrianca");
		String senha = request.getParameter("senha");
		String confirmarSenha = request.getParameter("confirmarSenha");
		Double saldo = 0.0;
		ArrayList<Gasto> gastos = new ArrayList<Gasto>();
		if(senha.equals(confirmarSenha)) {
			int idadeTransformada = Integer.parseInt(idade);
			Cliente cliente = new Cliente(nomeCompleto,idadeTransformada,rg,cpfResponsavel,cpfCrianca,senha,saldo,gastos);
			Cliente.clientesMockados.add(cliente);
		}
		return "redirect:/login";
	}
}
