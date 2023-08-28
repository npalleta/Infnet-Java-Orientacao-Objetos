package br.com.infnet.project;

public class Main {

    public static void main(String[] args) {

        Aluno alunoAndre = new Aluno();
        Professor juliaPortugues = new Professor();
        Responsavel paiAnderson = new Responsavel();

        InformacaoEscolar informacaoEscolarAndre = new InformacaoEscolar(alunoAndre, juliaPortugues, paiAnderson);
        informacaoEscolarAndre.cadastraInfoEscolar(
            "André Oliveira",
            "Não se aplica.",
            "Júlia Fernandes Silvia",
            "Não se aplica.",
            "Anderson Oliveira",
            214
        );

        Aluno alunoFabio = new Aluno();
        Professor CamargoGeografia = new Professor();
        Responsavel maeIsabella = new Responsavel();

        InformacaoEscolar informacaoEscolarFabio = new InformacaoEscolar(alunoFabio, CamargoGeografia, maeIsabella);
        informacaoEscolarFabio.cadastraInfoEscolar(
            "Fábio Melo Freitas",
            "Não se aplica.",
            "Antônio Camargo",
            "Isabella Melo Freitas",
            "Isabella é professora substituta.",
            211
        );
    }
}