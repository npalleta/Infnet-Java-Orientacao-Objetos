package br.com.infnet.project;

import br.com.infnet.project.exceptions.ProfessorException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ProfessorTest {

    private Professor professor;

    @BeforeEach
    public void setUp() {
        professor = new Professor();
    }

    @Test
    public void testSetNomeProfessor() {
        String nomeProfessor = "Jonas Tadeu";
        professor.setNomeProfessor(nomeProfessor);
        Assertions.assertEquals(nomeProfessor, professor.getNomeProfessor());
    }

    @Test
    public void testSetObservacao() {
        String observacao = "Apenas uma observação simples...";
        professor.setObservacao(observacao);
        Assertions.assertEquals(observacao, professor.getObservacao());
    }

    @Test
    public void testSetSalaAula() {
        SalaAula salaAula = new SalaAula();
        professor.setSalaAula(salaAula);
        Assertions.assertEquals(salaAula, professor.getSalaAula());
    }

    @Test
    public void testSetInformacoesGerais() {
        ArrayList<Object> informacoes = new ArrayList<>();
        informacoes.add("Jonas Tadeu");
        informacoes.add("Apenas uma observação simples...");
        informacoes.add(123);

        Assertions.assertThrows(ProfessorException.class, () -> professor.setInformacoesGerais(null));
        Assertions.assertThrows(ProfessorException.class, () -> professor.setInformacoesGerais(new ArrayList<>()));
        Assertions.assertThrows(ProfessorException.class,
                () -> professor.setInformacoesGerais(new ArrayList<>(informacoes.subList(0, 2))));
        Assertions.assertDoesNotThrow(() -> professor.setInformacoesGerais(informacoes));
    }

    @Test
    public void testRegistraProfessor() {
        String nomeProfessor = "Jonas Tadeu";
        String observacao = "Apenas uma observação simples...";
        int numeroSala = 123;

        professor.registraProfessor(nomeProfessor, observacao, numeroSala);
        Assertions.assertEquals(nomeProfessor, professor.getNomeProfessor());
        Assertions.assertEquals(observacao, professor.getObservacao());
        Assertions.assertEquals(numeroSala, professor.getSalaAula().getNumeroSala());
    }
}
