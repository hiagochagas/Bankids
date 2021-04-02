package com.Bankids.Models;

public class ClienteLogado extends Cliente {
	
	private static ClienteLogado clienteLogado;
	
	public ClienteLogado(Cliente cliente) {
		super(cliente.getNomeCompleto(), cliente.getIdade(), cliente.getRg(), cliente.getCpfResponsavel(), cliente.getCpf(), cliente.getSenha(), cliente.getSaldo(), cliente.getGastos());
		clienteLogado = this;
	}
	//Instância singleton dessa classe, podendo ser chamada da seguinte forma:
	// ClienteLogado.singleton()
	public static ClienteLogado singleton() {
		return clienteLogado;
	}
	
	
}
