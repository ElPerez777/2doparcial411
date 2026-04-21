package com.parcial2;

import com.parcial2.criaturas.Guerrero;
import com.parcial2.equipamiento.Arma;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmaTest {

    @Test
    @DisplayName("El arma guarda correctamente su nombre y daño adicional")
    void armaGuardaValores() {
        Arma arma = new Arma("Espada Larga", 5);
        assertEquals("Espada Larga", arma.getNombre());
        assertEquals(5, arma.getDanioAdicional());
    }

    @Test
    @DisplayName("El daño adicional del arma nunca puede ser negativo")
    void danioAdicionalNoNegativo() {
        Arma arma = new Arma("Arma rota", -5);
        assertEquals(0, arma.getDanioAdicional());
    }

    @Test
    @DisplayName("atacarConArma reduce la salud del objetivo")
    void atacarConArmaReduceSalud() {
        Guerrero atacante = new Guerrero("Atacante", 50, 10, "espada");
        Guerrero objetivo = new Guerrero("Objetivo", 50, 5, "daga");
        Arma arma = new Arma("Hacha", 4);

        int saludInicial = objetivo.getSalud();
        arma.atacarConArma(atacante, objetivo);

        assertTrue(objetivo.getSalud() < saludInicial);
    }
}
