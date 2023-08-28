package br.com.infnet.project;

import br.com.infnet.project.exceptions.ResponsavelException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ResponsavelTest {

    private Responsavel responsavel;

    @BeforeEach
    public void setUp() {
        responsavel = new Responsavel();
    }

    @Test
    public void testSetNomeResponsavel() {
        String nomeResponsavel = "Maria Tadeu";
        responsavel.setNomeResponsavel(nomeResponsavel);
        Assertions.assertEquals(nomeResponsavel, responsavel.getNomeResponsavel());
    }

    @Test
    public void testSetInformacoesGerais() {
        ArrayList<Object> informacoes = new ArrayList<>();
        informacoes.add("Maria Tadeu");
        informacoes.add("Teste Teste");
        informacoes.add("Matemática");
        informacoes.add("ABC");

        Assertions.assertThrows(ResponsavelException.class, () -> {
            responsavel.setInformacoesGerais(null);
        });

        Assertions.assertThrows(ResponsavelException.class, () -> {
            responsavel.setInformacoesGerais(new ArrayList<>());
        });

        Assertions.assertThrows(ResponsavelException.class, () -> {
            responsavel.setInformacoesGerais(new ArrayList<>(informacoes.subList(0, 3)));
        });

        Assertions.assertDoesNotThrow(() -> {
            responsavel.setInformacoesGerais(informacoes);
        });
    }

    @Test
    public void testRegistraProfessor() {
        String nomeResponsavel = "Maria Tadeu";
        responsavel.registraProfessor(nomeResponsavel);
        Assertions.assertEquals(nomeResponsavel, responsavel.getNomeResponsavel());
    }
}