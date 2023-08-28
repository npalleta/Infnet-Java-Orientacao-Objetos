package br.com.infnet.project.exceptions;

public class AlunoException extends Exception {
    public AlunoException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Os dados do aluno não foram preenchidos corretamente. Por favor, verificar!";
    }
}