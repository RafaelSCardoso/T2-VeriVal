package com.mycompany.app;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;

public class ServicoDeVendasTeste {

    @Mock
    private Produtos produtos;

    @Mock
    private Estoque estoque;

    @Mock
    private RegraImposto regraImposto;

    @Mock
    private FactoryValidacao factoryValidacao;

    // não precisa testar esse método, pois ele apenas chama outro que já foi testado.
//    @Test
//    public void valida_positive() {}

    @Test
    public void calculaSubtotal_() {
        ServicoDeVendas service = new ServicoDeVendas(produtos, estoque, regraImposto, factoryValidacao);
        List<ItemVenda> itens = new ArrayList<>();

        itens.add(new ItemVenda(001, 123, 5, 10.0));
        itens.add(new ItemVenda(002, 234, 2, 40.0));
        itens.add(new ItemVenda(003, 345, 1, 140.0));

        Integer subTotal = service.calculaSubtotal(itens);

        assertEquals(subTotal, 270);
    }

    @Test
    public void calculaSubtotal_listaVazia() {
        ServicoDeVendas service = new ServicoDeVendas(produtos, estoque, regraImposto, factoryValidacao);
        List<ItemVenda> itens = new ArrayList<>();

        Integer subTotal = service.calculaSubtotal(itens);

        assertEquals(subTotal, 0);
    }

    // não precisa testar esse método, pois ele apenas chama outro que já foi testado.
//    @Test
//    public void calculaImpostos_original() {
//        RegraImposto regraImpostoOriginal = new RegraImpostoOriginal();
//        ServicoDeVendas service = new ServicoDeVendas(produtos, estoque, regraImpostoOriginal, factoryValidacao);
//        List<ItemVenda> itens = new ArrayList<>();
//
//        itens.add(new ItemVenda(001, 123, 5, 10.0));
//        itens.add(new ItemVenda(002, 234, 2, 40.0));
//        itens.add(new ItemVenda(003, 345, 1, 140.0));
//
//        Integer imposto = service.calculaImpostos(itens);
//
//        assertEquals(imposto, 27);
//    }
//
//    @Test
//    public void calculaImpostos_comprasGrandes() {
//        RegraImposto regraImpostoOriginal = new RegraImpostoComprasGrandes();
//        ServicoDeVendas service = new ServicoDeVendas(produtos, estoque, regraImpostoOriginal, factoryValidacao);
//        List<ItemVenda> itens = new ArrayList<>();
//
//        itens.add(new ItemVenda(001, 123, 5, 10.0));
//        itens.add(new ItemVenda(002, 234, 2, 40.0));
//        itens.add(new ItemVenda(003, 345, 1, 140.0));
//
//        Integer imposto = service.calculaImpostos(itens);
//
//        assertEquals(imposto, 27);
//    }

    @Test
    public void calculaPrecoFinal_() {
        ServicoDeVendas service = new ServicoDeVendas(produtos, estoque, regraImposto, factoryValidacao);
        List<ItemVenda> itens = new ArrayList<>();
        when(regraImposto.calcular).thenReturn(27);

        itens.add(new ItemVenda(001, 123, 5, 10.0));
        itens.add(new ItemVenda(002, 234, 2, 40.0));
        itens.add(new ItemVenda(003, 345, 1, 140.0));

        Integer precoFinal = service.calculaPrecoFinal(itens);

        assertEquals(precoFinal, 297);
    }

    @Test
    public void todosValores_() {
        ServicoDeVendas service = new ServicoDeVendas(produtos, estoque, regraImposto, factoryValidacao);
        List<ItemVenda> itens = new ArrayList<>();
        when(regraImposto.calcular(itens)).thenReturn((double) 27);

        itens.add(new ItemVenda(001, 123, 5, 10.0));
        itens.add(new ItemVenda(002, 234, 2, 40.0));
        itens.add(new ItemVenda(003, 345, 1, 140.0));

        Integer[] todosValores = service.todosValores(itens);

        assertEquals(todosValores[0], 270);
        assertEquals(todosValores[1], 27);
        assertEquals(todosValores[2], 297);
    }

    @Test
    public void todosValores_listaVazia() {
        ServicoDeVendas service = new ServicoDeVendas(produtos, estoque, regraImposto, factoryValidacao);
        List<ItemVenda> itens = new ArrayList<>();
        when(regraImposto.calcular).thenReturn(27);

        Integer[] todosValores = service.todosValores(itens);

        assertEquals(todosValores[0], 0);
        assertEquals(todosValores[1], 0);
        assertEquals(todosValores[2], 0);
    }
}
