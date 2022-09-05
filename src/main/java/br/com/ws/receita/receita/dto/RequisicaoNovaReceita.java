package br.com.ws.receita.receita.dto;

import br.com.ws.receita.receita.model.Ingrediente;
import br.com.ws.receita.receita.model.Receita;
import br.com.ws.receita.receita.model.Usuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RequisicaoNovaReceita {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @NotBlank
    private String nome;
    @NotBlank
    private List<String> ingredientes;
    @NotBlank
    private String modoDePreparo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getModoDePreparo() {
        return modoDePreparo;
    }

    public void setModoDePreparo(String modoDePreparo) {
        this.modoDePreparo = modoDePreparo;
    }

    public Receita toReceita(){
        Receita receita = new Receita();
        receita.setDataPostagem(LocalDate.parse(LocalDate.now().format(formatter)));
        receita.setNome(this.nome);
        receita.setModoDePreparo(this.modoDePreparo);
        List<Ingrediente> ingredientes1 = new ArrayList<>();
        for (String ingrediente : ingredientes){
            Ingrediente ingrediente1 = new Ingrediente();
            ingrediente1.setNome(ingrediente);
            ingredientes1.add(ingrediente1);
        }
        receita.setIngredientes(ingredientes1);

        return receita;
    }

}
