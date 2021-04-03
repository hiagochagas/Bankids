package com.Bankids.Models;

import java.util.ArrayList;
import java.util.UUID;

public class Dica {
	private static ArrayList<Dica> dicas = new ArrayList<Dica>();
	private UUID id;
	private String cabecalho;
	private String descricao;
	
	public Dica(String cabecalho,String descricao) {
		this.id = UUID.randomUUID();
		this.descricao = descricao;
		this.cabecalho = cabecalho;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
	public String getCabecalho() {
		return cabecalho;
	}

	public void setCabecalho(String cabecalho) {
		this.cabecalho = cabecalho;
	}
	
	public static ArrayList<Dica> getDicas() {
		return dicas;
	}
	
	public static void criarDicasMockadas() {
		String tit1 = "Conceito de poupar";
		String tit2 = "Balanço financeiro mensal";
		String tit3 = "c";
		String tit4 = "d";
		String descricao1 = "Poupe seu dinheiro, dinheiro deve ser tratado como algo sério, a maneira como você encara a sua realidade vai refletir na sua vida financeira. Algo que realmente é importante é você saber diferenciar o querer do precisar. Como prioridade, seu dinheiro deve ser usado para adquirir coisas que você realmente precise, caso sobre algum dinheiro, você avalia se vale a pena comprar algo do seu lazer e se irá sobrar alguma reserva.";
		String descricao2 = "Na sua vida financeira como um todo, você sempre deve ter em mente que o quanto você terá no fim de cada mês é muito importante para ter uma vida financeira tranquila. Lidar com dinheiro é algo que depende de uma visão mais madura, e você deve adquirir essa visão para encerrar o mês com um saldo positivo, portanto, você não pode gastar mais do que tem e possuir um controle de suas finanças.";
		String descricao3 = "Dinheiro dinheirin, dinheiro no cofrim";
		String descricao4 = "Tururu tururuuuuuuuuuuuuuu ruuuuuuuu";
		dicas.add(new Dica(tit1,descricao1));
		dicas.add(new Dica(tit2,descricao2));
		dicas.add(new Dica(tit3,descricao3));
		dicas.add(new Dica(tit4,descricao4));
	}

	
}
