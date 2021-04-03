package com.Bankids.Models;

public class ClienteLogado extends Cliente {
	
	private static Cliente clienteLogado;
	
	public ClienteLogado(Cliente cliente) {
		super();
		clienteLogado = cliente;
	}
	//Instância singleton dessa classe, podendo ser chamada da seguinte forma:
	// ClienteLogado.singleton()
	public static Cliente singleton() {
		return clienteLogado;
	}
	
	
}
