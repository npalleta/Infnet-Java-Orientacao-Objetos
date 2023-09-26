package br.com.infnet.project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import static java.lang.System.err;
import static java.lang.System.out;

public class CalculadoraPrecoProdutos {

    private String nomeArquivoProdutos;
    private String nomeArquivoCalculado;

    public CalculadoraPrecoProdutos(String nomeArquivoProdutos, String nomeArquivoCalculado) {
        String[] diretorioPrincipal = {
            "src",
            "main",
            "resources",
            nomeArquivoProdutos,
            nomeArquivoCalculado
        };
        this.nomeArquivoProdutos = String.valueOf(
            Paths.get(System.getProperty("user.dir"),
                diretorioPrincipal[0],
                diretorioPrincipal[1],
                diretorioPrincipal[2],
                diretorioPrincipal[3]
            )
        );
        this.nomeArquivoCalculado = String.valueOf(
            Paths.get(System.getProperty("user.dir"),
                diretorioPrincipal[0],
                diretorioPrincipal[1],
                diretorioPrincipal[2],
                diretorioPrincipal[4]
            )
        );
    }

    public void calculaDescontoPorProd() {

        File arquivoProdutos = new File(this.nomeArquivoProdutos);

        try (BufferedReader arquivoEntrada = new BufferedReader(new FileReader(arquivoProdutos))) {
            Scanner scanner = new Scanner(arquivoEntrada);

            PrintWriter writer = new PrintWriter(this.nomeArquivoCalculado);

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] quebraLinhas = linha.split(",");

                if (quebraLinhas.length != 3)
                    err.printf("Linha inválida: %s%n", linha);
                else {
                    String nomeProduto = quebraLinhas[0];
                    double preco = Double.parseDouble(quebraLinhas[1]);
                    int desconto = Integer.parseInt(quebraLinhas[2]);

                    double valorFinal = preco - (preco * (desconto * 0.01));

                    writer.printf("Produto: %s%n", nomeProduto);
                    writer.printf("Preço: %s%n", preco);
                    writer.printf("desconto: %s%n", desconto);
                    writer.printf(
                        "Valor Final: %s%n%n",
                        BigDecimal.valueOf(valorFinal).setScale(2, RoundingMode.HALF_UP)
                    );
                }
            }

            scanner.close();
            writer.close();

            out.printf("Resultado gravado em: %s%n", this.nomeArquivoCalculado);

        } catch (IOException ioEx) {
            err.printf("Erro ao tentar encontrar o arquivo: %s%n", ioEx.getMessage());
        }
    }

    private static String dataAtual() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
            "dd_mm_yyyy_HHmmss", new Locale("pt", "Br")
        );
        return simpleDateFormat.format(new Date());
    }

    public static void main(String[] args) {
        CalculadoraPrecoProdutos calculadoraPrecoProd = new CalculadoraPrecoProdutos(
            "produtos.txt",
            "resultado_" + CalculadoraPrecoProdutos.dataAtual() + ".txt"
        );
        calculadoraPrecoProd.calculaDescontoPorProd();
    }
}
