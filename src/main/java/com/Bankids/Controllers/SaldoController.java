package com.Bankids.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Bankids.Models.Cliente;
import com.Bankids.Models.ClienteLogado;
import com.Bankids.Models.Gasto;

@Controller
public class SaldoController {
	@RequestMapping("/saldo")
	public String index(Model model) {
		double valorGastos = 0.0;
		Cliente cliente = ClienteLogado.singleton();
		model.addAttribute("nomeCliente", cliente.getNomeCompleto());
		model.addAttribute("saldoCliente", cliente.getSaldo());
		for (Gasto gasto: cliente.getGastos()) {
			valorGastos += gasto.getValor();
		}
		model.addAttribute("gastosCliente", valorGastos);
		return "saldoView";
	}
}
