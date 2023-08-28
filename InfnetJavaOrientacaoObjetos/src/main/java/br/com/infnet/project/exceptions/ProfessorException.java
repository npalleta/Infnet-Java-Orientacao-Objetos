package br.com.infnet.project.exceptions;

public class ProfessorException extends Exception {
    public ProfessorException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Os dados do professor não foram preenchidos corretamente. Por favor, verificar!";
    }
}