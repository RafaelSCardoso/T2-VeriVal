package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import jdk.internal.jline.internal.TestAccessible;

public class ValidacaoForaHorarioComercialTest {

    //criar testes para horario fora espediente 
    // horario comercial 08:00 - 18:00


    @Test
    public void validaTresProdutosExistentes() {

        // apenas editar campos


        // a
        Produtos produtos = mock(Produtos.class);
        when(produtos.recupera(10)).thenReturn(new Produto(10,"Prod10",1000.0));
        when(produtos.recupera(30)).thenReturn(new Produto(30,"Prod30",2000.0));
        when(produtos.recupera(50)).thenReturn(new Produto(50,"Prod15",1500.0));

        Estoque estoque = mock(Estoque.class);
        when(estoque.recupera(10)).thenReturn(new ItemEstoque(10,5));
        when(estoque.recupera(30)).thenReturn(new ItemEstoque(30,3));
        when(estoque.recupera(50)).thenReturn(new ItemEstoque(50,15));

        List<ItemVenda> itens = new ArrayList<>(3);
        itens.add(new ItemVenda(1,10,2,1000));
        itens.add(new ItemVenda(2,30,3,2000));
        itens.add(new ItemVenda(3,50,1,1500));

        RegraValidacao regra = new ValidacaoForaHorarioComercial();
        assertDoesNotThrow(()->regra.valida(produtos,estoque,itens));
    }

    @Test
    public void validaCincoItens(){

        Produtos produtos = mock(Produtos.class);
        when(produtos.recupera(10)).thenReturn(new Produto(10,"Prod10",1000.0));
        when(produtos.recupera(30)).thenReturn(new Produto(30,"Prod30",2000.0));
        when(produtos.recupera(50)).thenReturn(new Produto(50,"Prod15",1500.0));

        Estoque estoque = mock(Estoque.class);
        when(estoque.recupera(10)).thenReturn(new ItemEstoque(10,5));
        when(estoque.recupera(30)).thenReturn(new ItemEstoque(30,3));
        when(estoque.recupera(50)).thenReturn(new ItemEstoque(50,15));

        List<ItemVenda> itens = new ArrayList<>(3);
        itens.add(new ItemVenda(1,10,2,1000));
        itens.add(new ItemVenda(2,30,3,2000));
        itens.add(new ItemVenda(3,50,1,1500));
        itens.add(new ItemVenda(4,60,4,2000));
        itens.add(new ItemVenda(5,70,5,2500));
        itens.add(new ItemVenda(6,80,6,3000));

        RegraValidacao regra = new ValidacaoForaHorarioComercial();
        assertDoesNotThrow(()->regra.valida(produtos,estoque,itens));

    }
    
}
