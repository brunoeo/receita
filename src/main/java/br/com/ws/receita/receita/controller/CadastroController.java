package br.com.ws.receita.receita.controller;


import br.com.ws.receita.receita.dto.RequisicaoNovoUsuario;
import br.com.ws.receita.receita.model.Usuario;
import br.com.ws.receita.receita.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping("/cadastro")
public class CadastroController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping
    @RequestMapping("/formulario")
    public String login(){
        return "cadastro/formulario";
    }

    @PostMapping
    @RequestMapping("/novo")
    public String novo(@Valid RequisicaoNovoUsuario request){

        Usuario usuario = request.toUsuario();
        usuarioRepository.save(usuario);

        return "login";
    }

}
