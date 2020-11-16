package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.InitialContextFactory;

import com.bcopstein.ValidacaoForaHorarioComercial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.ParameterizedTest;

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
