package com.mycompany.app;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalTime;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ServicoDeVendasTeste {

    @Test
    public void testeServicoDeVendas(){
        FactoryValidacao factoryValidacao = mock(FactoryValidacao.class);
        when(factoryValidacao.getRegraValidacao().valida(Produtos.class, Estoque.class, List.class)).thenReturn(LocalTime.of(8, 5));

        // Produto(int codigo, String descricao, double preco
        // ServicoDeVendas(Produtos produtos, Estoque estoque, RegraImposto regraImposto, FactoryValidacao factoryValidacao);

    }
}
