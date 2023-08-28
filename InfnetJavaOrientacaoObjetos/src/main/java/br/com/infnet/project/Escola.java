package br.com.infnet.project;

import br.com.infnet.project.exceptions.AlunoException;
import br.com.infnet.project.exceptions.ProfessorException;
import br.com.infnet.project.exceptions.ResponsavelException;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Escola {

    private final String nomeEscola = "E.E Professora Júlia Macedo Pantoja";
    private final String endereco = "Rua Assupá, 200 - Vila Prudente, São Paulo - SP, 03137-050";
    private String diretoriaEnsino = "Centro Sul";

    public Escola() {
    }

    public String getNomeEscola() {
        return nomeEscola;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getDiretoriaEnsino() {
        return diretoriaEnsino;
    }

    public abstract void setInformacoesGerais(ArrayList<Object> informacoes) throws AlunoException, ProfessorException, ResponsavelException;

    public abstract HashMap<Object, Object> getInfomacoesGerais();

    @Override
    public String toString() {
        return "Escola{" +
            "nomeEscola='" + this.nomeEscola + '\'' +
            ", endereco='" + this.endereco + '\'' +
            ", diretoriaEnsino='" + this.diretoriaEnsino + '\'' +
            '}';
    }
}