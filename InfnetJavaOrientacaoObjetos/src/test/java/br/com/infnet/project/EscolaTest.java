package br.com.infnet.project;

import br.com.infnet.project.exceptions.AlunoException;
import br.com.infnet.project.exceptions.ProfessorException;
import br.com.infnet.project.exceptions.ResponsavelException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class EscolaTest {

    @Test
    public void testGetNomeEscola() {
        Escola escola = new Escola() {
            @Override
            public void setInformacoesGerais(ArrayList<Object> informacoes)
                    throws AlunoException, ProfessorException, ResponsavelException {
            }

            @Override
            public HashMap<Object, Object> getInfomacoesGerais() {
                return null;
            }
        };

        String expectedNomeEscola = "E.E Professora Júlia Macedo Pantoja";
        String actualNomeEscola = escola.getNomeEscola();
        Assertions.assertEquals(expectedNomeEscola, actualNomeEscola);
    }

    @Test
    public void testGetEndereco() {
        Escola escola = new Escola() {
            @Override
            public void setInformacoesGerais(ArrayList<Object> informacoes)
                    throws AlunoException, ProfessorException, ResponsavelException {
            }

            @Override
            public HashMap<Object, Object> getInfomacoesGerais() {
                return null;
            }
        };

        String expectedEndereco = "Rua Assupá, 200 - Vila Prudente, São Paulo - SP, 03137-050";
        String actualEndereco = escola.getEndereco();
        Assertions.assertEquals(expectedEndereco, actualEndereco);
    }

    @Test
    public void testGetDiretoriaEnsino() {
        Escola escola = new Escola() {
            @Override
            public void setInformacoesGerais(ArrayList<Object> informacoes)
                    throws AlunoException, ProfessorException, ResponsavelException {
            }

            @Override
            public HashMap<Object, Object> getInfomacoesGerais() {
                return null;
            }
        };

        String expectedDiretoriaEnsino = "Centro Sul";
        String actualDiretoriaEnsino = escola.getDiretoriaEnsino();
        Assertions.assertEquals(expectedDiretoriaEnsino, actualDiretoriaEnsino);
    }
}
