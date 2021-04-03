package com.Bankids.Controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Bankids.Models.ClienteLogado;
import com.Bankids.Models.Gasto;

@Controller
public class ExtratoController {
	@RequestMapping("/extrato")
	public String index(Model model) {
		ArrayList<Gasto> gastos = ClienteLogado.singleton().getGastos();
		model.addAttribute("gastos", gastos);
		return "extratoView";
	}
}
