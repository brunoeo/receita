package br.com.ws.receita.receita.controller;


import br.com.ws.receita.receita.dto.RequisicaoNovaReceita;
import br.com.ws.receita.receita.model.Receita;
import br.com.ws.receita.receita.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping("/receita")
public class ReceitaController {

    @Autowired
    ReceitaRepository receitaRepository;

    @PostMapping
    @RequestMapping("/novo")
    public String novo(@Valid RequisicaoNovaReceita request){

        Receita receita = request.toReceita();
        receitaRepository.save(receita);

        return "home";
    }

}
