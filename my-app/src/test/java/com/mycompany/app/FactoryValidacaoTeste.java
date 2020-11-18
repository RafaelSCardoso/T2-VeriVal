package com.mycompany.app;


import java.time.LocalTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FactoryValidacaoTeste {

    @ParameterizedTest
    @CsvSource({
        // Horas    Minutos
        "   8   ,   00",
        "   12  ,   00",
        "   18  ,   00"
    })
    public void validaFactoryHorarioComercial(int horas, int minutos) {

        FactoryValidacao factory = new FactoryValidacao(LocalTime.of(horas, minutos));

        Assertions.assertEquals(factory.getRegraValidacao(), ValidacaoHorarioComercial.class);

    }
    
    @ParameterizedTest
    @CsvSource({
        // Horas    Minutos
        "   7   ,   59",
        "   18  ,   01",
        "   21  ,   00",
        "   00  ,   00"
    })
    public void validaFactoryHorarioNaoComercial(int horas, int minutos) {

        FactoryValidacao factory = new FactoryValidacao(LocalTime.of(horas, minutos));

        Assertions.assertEquals(factory.getRegraValidacao(), ValidacaoForaHorarioComercial.class);
    }
}
