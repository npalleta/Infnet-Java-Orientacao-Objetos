package br.com.infnet.project;

import br.com.infnet.project.exceptions.ResponsavelException;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.System.err;
import static java.lang.System.out;

public class Responsavel extends Escola {

    private final HashMap<Object, Object> dadosResponsavel;
    private String nomeResponsavel;
    private Aluno aluno;

    public Responsavel() {
        dadosResponsavel = new HashMap<>();
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    @Override
    public void setInformacoesGerais(ArrayList<Object> informacoes) throws ResponsavelException {
        if (informacoes == null || informacoes.size() != 4) {
            throw new ResponsavelException();
        }
        this.nomeResponsavel = String.valueOf(informacoes.get(0));
        this.dadosResponsavel.put("nome_responsavel", informacoes.get(1));
        this.dadosResponsavel.put("nome_aluno", informacoes.get(1));
    }

    @Override
    public HashMap<Object, Object> getInfomacoesGerais() {
        return this.dadosResponsavel;
    }

    public void registraProfessor(String nomeResponsavel) {

        ArrayList<Object> infoResponsavel = new ArrayList<>();

        try {
            this.setNomeResponsavel(nomeResponsavel);
            infoResponsavel.add(this.getNomeResponsavel());
            infoResponsavel.add(this.aluno.getNomeAluno());
            this.setInformacoesGerais(infoResponsavel);
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
        } catch (ResponsavelException responsavelEx) {
            err.printf(
                "Responsavel Exception: %s%n",
                responsavelEx.getMessage()
            );
        }
    }

    @Override
    public String toString() {
        return "Responsavel{" +
            "dadosResponsavel=" + this.dadosResponsavel +
            ", nomeResponsavel='" + this.nomeResponsavel + '\'' +
            ", aluno=" + this.aluno +
            '}';
    }
}
