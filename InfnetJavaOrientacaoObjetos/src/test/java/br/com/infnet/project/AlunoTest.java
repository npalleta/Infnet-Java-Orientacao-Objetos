package br.com.infnet.project;

import br.com.infnet.project.exceptions.AlunoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class AlunoTest {

    private Aluno aluno;

    @BeforeEach
    public void setUp() {
        aluno = new Aluno();
    }

    @Test
    public void testSetMatricula() {
        Integer matricula = 12345;
        aluno.setMatricula(matricula);
        Assertions.assertEquals(matricula, aluno.getMatricula());
    }

    @Test
    public void testSetNomeAluno() {
        String nomeAluno = "Aluno ABC";
        aluno.setNomeAluno(nomeAluno);
        Assertions.assertEquals(nomeAluno, aluno.getNomeAluno());
    }

    @Test
    public void testSetObservacao() {
        String observacao = "Texto Teste";
        aluno.setObservacao(observacao);
        Assertions.assertEquals(observacao, aluno.getObservacao());
    }

    @Test
    public void testSetSalaAula() {
        SalaAula salaAula = new SalaAula();
        aluno.setSalaAula(salaAula);
        Assertions.assertEquals(salaAula, aluno.getSalaAula());
    }

    @Test
    public void testSetInformacoesGerais() {
        ArrayList<Object> informacoes = new ArrayList<>();
        informacoes.add("Escola ABC");
        informacoes.add("Aluno ABC");
        informacoes.add(12345);
        informacoes.add("Texto Teste");
        informacoes.add(12345);

        Assertions.assertThrows(
            AlunoException.class, () -> aluno.setInformacoesGerais(null)
        );
        Assertions.assertThrows(
            AlunoException.class, () -> aluno.setInformacoesGerais(new ArrayList<>())
        );
        Assertions.assertThrows(
            AlunoException.class,
            () -> aluno.setInformacoesGerais(new ArrayList<>(informacoes.subList(0, 4)))
        );
        Assertions.assertDoesNotThrow(() -> aluno.setInformacoesGerais(informacoes));

        try {
            aluno.setInformacoesGerais(informacoes);
        } catch (AlunoException e) {
            throw new RuntimeException(e);
        }

        HashMap<Object, Object> dadosAluno = aluno.getInfomacoesGerais();

        Assertions.assertEquals("Escola ABC", dadosAluno.get("dados_escola"));
        Assertions.assertEquals("Aluno ABC", dadosAluno.get("nome_aluno"));
        Assertions.assertEquals(12345, dadosAluno.get("matricula"));
        Assertions.assertEquals("Texto Teste", dadosAluno.get("observacao"));
        Assertions.assertEquals(12345, dadosAluno.get("numero_sala"));
    }

    @Test
    public void testRegistraAluno() {
        String escola = "Escola{nomeEscola='E.E Professora Júlia Macedo Pantoja', endereco='Rua Assupá, 200 - Vila Prudente, São Paulo - SP, 03137-050', diretoriaEnsino='Centro Sul'}";
        String nomeAluno = "Jonas Tadeu";
        Integer matricula = 12345;
        String observacao = "Qualquer coisa...";
        Integer numeroSala = 1;

        aluno.registraAluno(nomeAluno, matricula, observacao, numeroSala);
        HashMap<Object, Object> dadosAluno = aluno.getInfomacoesGerais();
        Assertions.assertEquals(escola, dadosAluno.get("dados_escola"));
        Assertions.assertEquals(nomeAluno, dadosAluno.get("nome_aluno"));
        Assertions.assertEquals(matricula, dadosAluno.get("matricula"));
        Assertions.assertEquals(observacao, dadosAluno.get("observacao"));
        Assertions.assertEquals(numeroSala, dadosAluno.get("numero_sala"));
    }
}