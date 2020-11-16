package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.InitialContextFactory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.ParameterizedTest;

public class RegraImpostoComprasGrandesTeste {

    @Test
    public void calcula_itensDiferentes() {
        List<ItemVenda> itens = new ArrayList<>();
        itens.add(123, 456, 3, 10.0); // 1,5
        itens.add(234, 567, 2, 20.0); // 2,0
        itens.add(345, 678, 1, 30.0); // 3,0
        itens.add(456, 789, 3, 15.0); // 2,25
        itens.add(567, 890, 2, 25.0); // 5,0
        itens.add(678, 901, 1, 35.0); // 3,5

        RegraImposto regraImposto = new RegraImpostoComprasGrandes();
        double imposto = regraImposto.calcula(itens);

        assertEquals(imposto, 17,25);
    }

    @Test
    public void calcula_itensIguais() {
        List<ItemVenda> itens = new ArrayList<>();
        itens.add(123, 456, 3, 10.0);
        itens.add(123, 456, 2, 10.0);
        itens.add(123, 456, 1, 10.0);
        itens.add(123, 456, 3, 10.0);
        itens.add(123, 456, 2, 10.0);
        itens.add(123, 456, 1, 10.0);

        RegraImposto regraImposto = new RegraImpostoComprasGrandes();
        double imposto = regraImposto.calcula(itens);

        assertEquals(imposto, /*alguma coisa*/);
    }
}