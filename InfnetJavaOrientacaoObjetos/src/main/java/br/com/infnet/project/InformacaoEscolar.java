package br.com.infnet.project;

import br.com.infnet.project.enums.NumSalaAula;
import br.com.infnet.project.exceptions.NumSalaAulaException;

import java.util.Random;

import static java.lang.System.out;

public class InformacaoEscolar {

    private Aluno aluno;
    private Professor professor;
    private Responsavel responsavel;
    private SalaAula salaAula;

    public InformacaoEscolar(Aluno aluno, Professor professor, Responsavel responsavel) {
        this.aluno = aluno;
        this.professor = professor;
        this.responsavel = responsavel;
    }

    public void cadastraInfoEscolar(String nomeAluno, String obsAluno, String nomeProfessor, String obsProfessor, String nomeResponsavel, int numeroSala) {

        out.printf("Incluindo informações no sistema da escola: Aluno(a): %s%n", nomeAluno);

        this.aluno.registraAluno(nomeAluno, geraMatricula(), obsAluno, numeroSala);

        boolean numSalaEncontrada = false;

        for (NumSalaAula numSalaAula : NumSalaAula.values()) {
            if (numSalaAula.numeroSala == numeroSala) {
                numeroSala = numSalaAula.numeroSala;
                numSalaEncontrada = true;
                break;
            }
        }

        if (!numSalaEncontrada) {
            try {
                throw new NumSalaAulaException();
            } catch (NumSalaAulaException numSalaAulaEx) {
                throw new RuntimeException(numSalaAulaEx.getMessage());
            }
        }

        this.professor.registraProfessor(nomeProfessor, obsProfessor, numeroSala);
        this.responsavel.setNomeResponsavel(nomeResponsavel);
        this.salaAula = new SalaAula(aluno, professor);
        out.printf(
            "%s%nAluno: %s%nMatrícula: %s%nProfessor: %s%nResponsável: %s%nSala de Aula Número: %s%n",
            aluno.getEscola(),
            salaAula.getNomeAluno(),
            aluno.getMatricula(),
            salaAula.getNomeProfessor(),
            this.responsavel.getNomeResponsavel(),
            salaAula.getNumeroSala()
        );
    }

    public int geraMatricula() {
        return new Random().nextInt(10000) + 1;
    }

    @Override
    public String toString() {
        return "InformacaoEscolar{" +
            "aluno=" + this.aluno +
            ", professor=" + this.professor +
            ", responsavel=" + this.responsavel +
            ", salaAula=" + this.salaAula +
            '}';
    }
}
