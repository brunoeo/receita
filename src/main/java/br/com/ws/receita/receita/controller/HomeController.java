package br.com.ws.receita.receita.controller;


import br.com.ws.receita.receita.model.Receita;
import br.com.ws.receita.receita.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/home")
public class HomeController {


	@Autowired
	ReceitaRepository receitaRepository;

	@GetMapping
	public String home(Model model){

		List<Receita> pedidos = receitaRepository.findAll();

		model.addAttribute("receitas", pedidos);

		return "home";
	}

}
