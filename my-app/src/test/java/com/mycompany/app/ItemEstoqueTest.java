package com.mycompany.app;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ItemEstoqueTest {

    

    @ParameterizedTest
    @CsvSource({
        //codigo    quantidade  valor
        "   1   ,   10      ,   +1",
        "   2   ,   10      ,   -1",
        "   3   ,   10      ,   0",
        "   4   ,   10      ,   5"
    })
    public void testeItemEstoqueEntrada(int codigo, int quantidade,int valor) {
        ItemEstoque item = new ItemEstoque(codigo, quantidade);
        item.entrada(quantidade);
        Assertions.assertEquals(item.disponivel(quantidade), quantidade + valor);
    }
    
    @ParameterizedTest
    @CsvSource({
        //codigo    quantidade
        //codigo    quantidade  valor
        "   5   ,   10      ,   +1",
        "   6   ,   10      ,   -1",
        "   7   ,   10      ,   0",
        "   8   ,   10      ,   5"
    })
    public void testeItemEstoqueSaida(int codigo, int quantidade, int valor) {
        ItemEstoque item = new ItemEstoque(codigo, quantidade);
        item.saida(quantidade);
        Assert.assertEquals(item.disponivel(quantidade), (quantidade - valor));
        
    }
    
    @ParameterizedTest
    @CsvSource({
        //codigo    quantidade
        "   9   ,   10",
        "   10   ,   5",
        "   11   ,   7",
    })
    public void testeItemEstoqueDisponivel(int codigo, int quantidade) {
        ItemEstoque item = new ItemEstoque(codigo, quantidade);
        assertEquals(item.disponivel(quantidade), quantidade);
    }
}
