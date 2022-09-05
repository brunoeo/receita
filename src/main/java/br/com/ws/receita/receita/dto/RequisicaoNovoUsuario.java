package br.com.ws.receita.receita.dto;

import br.com.ws.receita.receita.model.Usuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.NotBlank;

public class RequisicaoNovoUsuario {

    @NotBlank
    private String nomeUsuario;
    @NotBlank
    private String senha;

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario toUsuario(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Usuario usuario = new Usuario();
        usuario.setUsername(this.nomeUsuario);
        usuario.setPassword(encoder.encode(this.senha));
        usuario.setEnabled(true);
        return usuario;
    }

}
