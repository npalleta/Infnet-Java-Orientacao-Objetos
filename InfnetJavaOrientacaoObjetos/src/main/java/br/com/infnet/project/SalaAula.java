package br.com.infnet.project;

public class SalaAula {

    private Integer numeroSala;
    private String nomeAluno;
    private String nomeProfessor;

    public SalaAula() {
    }

    public SalaAula(Aluno aluno, Professor professor) {
        if ((int) aluno.getSalaAula().numeroSala != professor.getSalaAula().numeroSala) {
            this.numeroSala = 0;
        } else {
            this.nomeAluno = aluno.getNomeAluno();
            this.numeroSala = aluno.getSalaAula().numeroSala;
            this.nomeProfessor = professor.getNomeProfessor();
        }
    }

    public void setNumeroSala(Integer numeroSala) {
        this.numeroSala = numeroSala;
    }

    public Integer getNumeroSala() {
        return numeroSala;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    @Override
    public String toString() {
        return "SalaAula{" +
            "numeroSala=" + this.numeroSala +
            ", nomeAluno='" + this.nomeAluno + '\'' +
            ", nomeProfessor='" + this.nomeProfessor + '\'' +
            '}';
    }
}
