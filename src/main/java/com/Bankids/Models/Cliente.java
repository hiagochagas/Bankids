package com.Bankids.Models;

import java.util.ArrayList;

public class Cliente {
	
	public static ArrayList<Cliente> clientesMockados = new ArrayList<Cliente>();
	
	private String nomeCompleto;
	private int idade;
	private String rg;
	private String cpfResponsavel;
	//chave única de cada Cliente
	private String cpf;
	//O ideal seria um tipo Password
	private String senha;
	private Double saldo;
	private ArrayList<Gasto> gastos;
	
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String getRg() {
		return rg;
	}
	
	public String getCpfResponsavel() {
		return cpfResponsavel;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public ArrayList<Gasto> getGastos() {
		return gastos;
	}
	
	public void setGastos(ArrayList<Gasto> gastos) {
		this.gastos = gastos;
	}

	public Cliente(String nomeCompleto, int idade, String rg, String cpfResponsavel, String cpf, String senha,
			Double saldo, ArrayList<Gasto> gastos) {
		this.nomeCompleto = nomeCompleto;
		this.idade = idade;
		this.rg = rg;
		this.cpfResponsavel = cpfResponsavel;
		this.cpf = cpf;
		this.senha = senha;
		this.saldo = saldo;
		this.gastos = gastos;
	}
	
	public void removerDoSaldo(Double valorGasto) {
		this.saldo -= valorGasto;
	}
	
	public void adicionarGasto(Gasto gasto) {
		this.gastos.add(gasto);
	}
	
	public void adicionarAoSaldo(Double valorGasto) {
		this.saldo += valorGasto;
	}
	
	public static void criarClientesMockados() {
		ArrayList<Gasto> gastos = new ArrayList<Gasto>();
		clientesMockados.add(new Cliente("Hiago", 21, "12133", "123123", "07070", "123", 123.0, gastos));
		clientesMockados.add(new Cliente("Rafael", 20, "45634", "98778", "49498", "456", 256.0, gastos));
		clientesMockados.add(new Cliente("William", 20, "23643", "23578", "34678", "789", 0.0, gastos));
		clientesMockados.add(new Cliente("Eduardo", 20, "23578", "98607", "75327", "234", 10.0, gastos));
	}

	
	
}
