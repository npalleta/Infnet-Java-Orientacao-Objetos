package br.com.infnet.project.enums;

public enum NumSalaAula {
    CIENCIAS(210), GEOGRAFIA(211), HISTORIA(212), MATEMATICA(213), PORTUGUES(214);

    public int numeroSala;

    NumSalaAula(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    public int getNumSalaAula() {
        return this.numeroSala;
    }
}
