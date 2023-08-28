package br.com.infnet.project;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalaAulaTest {

    @Test
    public void testConstrutor() {
        Aluno aluno = new Aluno();
        aluno.setNomeAluno("Aluno José ABCD");
        aluno.setSalaAula(new SalaAula());
        aluno.getSalaAula().setNumeroSala(1);
        Professor professor = new Professor();
        professor.setNomeProfessor("Ana Maria Clara");
        professor.setSalaAula(new SalaAula());
        professor.getSalaAula().setNumeroSala(1);
        SalaAula salaAula = new SalaAula(aluno, professor);
        assertEquals("Aluno José ABCD", salaAula.getNomeAluno());
        assertEquals("Ana Maria Clara", salaAula.getNomeProfessor());
        assertEquals(Integer.valueOf(1), salaAula.getNumeroSala());
    }

    @Test
    public void testConstrutorSala() {
        Aluno aluno = new Aluno();
        aluno.setNomeAluno("Aluno José ABCD");
        aluno.setSalaAula(new SalaAula());
        aluno.getSalaAula().setNumeroSala(1);
        Professor professor = new Professor();
        professor.setNomeProfessor("Ana Maria Clara");
        professor.setSalaAula(new SalaAula());
        professor.getSalaAula().setNumeroSala(2);
        SalaAula salaAula = new SalaAula(aluno, professor);
        assertEquals(Integer.valueOf(0), salaAula.getNumeroSala());
    }

    @Test
    public void testSetNumeroSala() {
        SalaAula salaAula = new SalaAula();
        salaAula.setNumeroSala(1);
        assertEquals(Integer.valueOf(1), salaAula.getNumeroSala());
    }

    @Test
    public void testSetNomeAluno() {
        SalaAula salaAula = new SalaAula();
        salaAula.setNomeAluno("Aluno José ABCD");
        assertEquals("Aluno José ABCD", salaAula.getNomeAluno());
    }

    @Test
    public void testSetNomeProfessor() {
        SalaAula salaAula = new SalaAula();
        salaAula.setNomeProfessor("Ana Maria Clara");
        assertEquals("Ana Maria Clara", salaAula.getNomeProfessor());
    }

}
