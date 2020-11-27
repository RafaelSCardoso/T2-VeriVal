package com.mycompany.app;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class RegraImpostoComprasGrandesTest {

    @Test

    public void calcula_itensDiferentes() {
        List<ItemVenda> itens = new ArrayList<>();   //impostos
        itens.add(new ItemVenda(123, 456, 3, 10.0)); // 1,5
        itens.add(new ItemVenda(234, 567, 2, 20.0)); // 2,0
        itens.add(new ItemVenda(345, 678, 1, 30.0)); // 3,0
        itens.add(new ItemVenda(456, 789, 3, 15.0)); // 2,25
        itens.add(new ItemVenda(567, 890, 2, 25.0)); // 5,0
        itens.add(new ItemVenda(678, 901, 1, 35.0)); // 3,5

        RegraImpostoComprasGrandes regraImposto = new RegraImpostoComprasGrandes();
        double imposto = regraImposto.calcular(itens);

        assertEquals(imposto, 17.25, 0.01);
    }

    @Test
    public void calcula_itensIguais() {
        List<ItemVenda> itens = new ArrayList<>();   //impostos
        itens.add(new ItemVenda(123, 456, 3, 10.0)); // 3,00
        itens.add(new ItemVenda(123, 456, 2, 10.0)); // 2,00
        itens.add(new ItemVenda(123, 456, 1, 10.0)); // 0,50
        itens.add(new ItemVenda(123, 456, 3, 10.0)); // 3,00
        itens.add(new ItemVenda(123, 456, 2, 10.0)); // 1,00
        itens.add(new ItemVenda(123, 456, 1, 10.0)); // 0,50

        RegraImpostoComprasGrandes regraImposto = new RegraImpostoComprasGrandes();
        double imposto = regraImposto.calcular(itens);

        assertEquals(imposto, 10.00, 0.01);
    }
}