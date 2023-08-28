package br.com.infnet.project.exceptions;

public class NumSalaAulaException extends Exception {
    public NumSalaAulaException() {
        super();
    }

    @Override
    public String getMessage() {
        return "O número da sala não existe!";
    }
}
