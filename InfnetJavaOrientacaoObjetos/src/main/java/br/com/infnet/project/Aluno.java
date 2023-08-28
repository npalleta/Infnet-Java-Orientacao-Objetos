package br.com.infnet.project;

import br.com.infnet.project.exceptions.AlunoException;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.System.*;

public class Aluno extends Escola {

    private final HashMap<Object, Object> dadosAluno;
    private Integer matricula;
    private String nomeAluno;
    private String observacao;
    private SalaAula salaAula;

    public Aluno() {
        super();
        dadosAluno = new HashMap<>();
        salaAula = new SalaAula();
    }

    public String getEscola() {
        return super.toString();
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setSalaAula(SalaAula salaAula) {
        this.salaAula = salaAula;
    }

    public SalaAula getSalaAula() {
        return salaAula;
    }

    @Override
    public void setInformacoesGerais(ArrayList<Object> informacoes) throws AlunoException {
        if (informacoes == null || informacoes.size() != 5) {
            throw new AlunoException();
        }

        this.nomeAluno = String.valueOf(informacoes.get(1));
        this.matricula = (Integer) informacoes.get(2);
        this.observacao = String.valueOf(informacoes.get(3));
        this.dadosAluno.put("dados_escola", informacoes.get(0));
        this.dadosAluno.put("nome_aluno", this.nomeAluno);
        this.dadosAluno.put("matricula", this.matricula);
        this.dadosAluno.put("observacao", this.observacao);
        this.dadosAluno.put("numero_sala", informacoes.get(4));
    }

    @Override
    public HashMap<Object, Object> getInfomacoesGerais() {
        return this.dadosAluno;
    }

    public void registraAluno(String nomeAluno, int matricula, String observacao, int numeroSala) {

        ArrayList<Object> infoAluno = new ArrayList<>();

        try {
            this.setNomeAluno(nomeAluno);
            this.setMatricula(matricula);
            this.setObservacao(observacao);
            this.salaAula.setNumeroSala(numeroSala);
            infoAluno.add(this.getEscola());
            infoAluno.add(this.getNomeAluno());
            infoAluno.add(this.getMatricula());
            infoAluno.add(this.getObservacao());
            infoAluno.add(this.salaAula.getNumeroSala());
            this.setInformacoesGerais(infoAluno);
            /* Caso necessário, é possível checar os dados usando o HashMap
                this.getInfomacoesGerais().forEach(
                    (key, value) -> out.printf("%s -> %s%n", key, value)
                );
             */

        } catch (NullPointerException nullEx) {
            err.printf(
                "Os dados de aluno não existem: %s%n",
                nullEx.getMessage()
            );
        } catch (IndexOutOfBoundsException indexOutOfBoundsEx) {
            err.printf(
                "Algum dado de aluno não foi preenchido corretamente: %s%n",
                indexOutOfBoundsEx.getMessage()
            );
        } catch (AlunoException alunoEx) {
            err.printf(
                "Aluno Exception: %s%n",
                alunoEx.getMessage()
            );
        }
    }

    @Override
    public String toString() {
        return "Aluno{" +
            "dadosAluno=" + this.dadosAluno +
            ", matricula=" + this.matricula +
            ", nomeAluno='" + this.nomeAluno + '\'' +
            ", observacao='" + this.observacao + '\'' +
            ", salaAula=" + this.salaAula +
            '}';
    }
}
