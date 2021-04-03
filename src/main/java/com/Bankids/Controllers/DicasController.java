package com.Bankids.Controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Bankids.Models.Dica;

@Controller
public class DicasController {
	@RequestMapping("/dicas")
	public String index(Model model) {
		ArrayList<Dica> dicas = Dica.getDicas();
		model.addAttribute("dicas", dicas);
		return "dicasView";
	}
}
