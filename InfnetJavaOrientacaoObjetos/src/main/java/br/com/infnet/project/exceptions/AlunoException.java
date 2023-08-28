package br.com.infnet.project.exceptions;

import br.com.infnet.project.Aluno;

public class AlunoException extends Exception {
    public AlunoException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Os dados do aluno não foram preenchidos corretamente. Por favor, verificar!";
    }
}