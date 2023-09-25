package br.com.infnet.project;

import br.com.infnet.project.exceptions.ProfessorException;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.System.err;
import static java.lang.System.out;

public class Professor extends Escola {

    private final HashMap<Object, Object> dadosProfessor;
    private String nomeProfessor;
    private String observacao;
    private SalaAula salaAula;

    public Professor() {
        dadosProfessor = new HashMap<>();
        salaAula = new SalaAula();
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
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
    public void setInformacoesGerais(ArrayList<Object> informacoes) throws ProfessorException {
        if (informacoes == null || informacoes.size() != 3) {
            throw new ProfessorException();
        }
        this.nomeProfessor = String.valueOf(informacoes.get(0));
        this.observacao = String.valueOf(informacoes.get(1));
        this.dadosProfessor.put("nome_professor", this.nomeProfessor);
        this.dadosProfessor.put("observacao", this.observacao);
        this.dadosProfessor.put("numero_sala", informacoes.get(2));
    }
    
    @Override
    public HashMap<Object, Object> getInfomacoesGerais() {
        return this.dadosProfessor;
    }

    public void registraProfessor(String nomeProfessor, String observacao, int numeroSala) {

        ArrayList<Object> infoProfessor = new ArrayList<>();

        try {
            this.setNomeProfessor(nomeProfessor);
            this.setObservacao(observacao);
            this.salaAula.setNumeroSala(numeroSala);
            infoProfessor.add(this.getNomeProfessor());
            infoProfessor.add(this.getObservacao());
            infoProfessor.add(this.salaAula.getNumeroSala());
            this.setInformacoesGerais(infoProfessor);
            /* Caso necessário, é possível checar os dados usando o HashMap
                this.getInfomacoesGerais().forEach(
                    (key, value) -> out.printf("%s -> %s%n", key, value)
                );
            */

        } catch (NullPointerException nullEx) {
            err.printf(
                "Os dados do professor não existem: %s%n",
                nullEx.getMessage()
            );
        } catch (IndexOutOfBoundsException indexOutOfBoundsEx) {
            err.printf(
                "Algum dado do professor não foi preenchido corretamente: %s%n",
                indexOutOfBoundsEx.getMessage()
            );
        } catch (ProfessorException professorEx) {
            err.printf(
                "Professor Exception: %s%n",
                professorEx.getMessage()
            );
        }
    }

    @Override
    public String toString() {
        return "Professor{" +
            "dadosProfessor=" + this.dadosProfessor +
            ", nomeProfessor='" + this.nomeProfessor + '\'' +
            ", observacao='" + this.observacao + '\'' +
            ", salaAula=" + this.salaAula +
            '}';
    }
}
