package br.com.infnet.project;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InformacaoEscolarTest {

    @Test
    public void testCadastraInfoEscolar() {
        Aluno aluno = new Aluno();
        Professor professor = new Professor();
        Responsavel responsavel = new Responsavel();
        InformacaoEscolar informacaoEscolar = new InformacaoEscolar(aluno, professor, responsavel);

        informacaoEscolar.cadastraInfoEscolar(
            "Maria Test 123",
            "Apenas uma observação simples...",
            "Júlio Test 123",
            "Apenas uma observação simples...",
            "Pai",
            214
        );

        assertEquals("Maria Test 123", aluno.getNomeAluno());
        assertEquals("Apenas uma observação simples...", aluno.getObservacao());
        assertEquals("Júlio Test 123", professor.getNomeProfessor());
        assertEquals("Apenas uma observação simples...", professor.getObservacao());
        assertEquals("Pai", responsavel.getNomeResponsavel());
        assertEquals(214, aluno.getSalaAula().getNumeroSala());
    }

    @Test
    public void testGeraMatricula() {
        InformacaoEscolar informacaoEscolar = new InformacaoEscolar(new Aluno(), new Professor(), new Responsavel());
        int matricula = informacaoEscolar.geraMatricula();
        assertTrue(matricula >= 1 && matricula <= 10000);
    }
}
