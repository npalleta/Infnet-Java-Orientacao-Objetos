package br.com.infnet.project.exceptions;

public class ResponsavelException extends Exception {
    public ResponsavelException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Os dados do responsável não foram preenchidos corretamente. Por favor, verificar!";
    }
}