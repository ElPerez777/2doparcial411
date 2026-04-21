package com.parcial2;

import com.parcial2.criaturas.Guerrero;
import com.parcial2.criaturas.Mago;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MagoTest {

    private Mago mago;
    private Guerrero victima;

    @BeforeEach
    void preparar() {
        mago = new Mago("Merlin", 40, 8, "Bola de Fuego");
        victima = new Guerrero("Objetivo", 60, 5, "daga");
    }

    @Test
    @DisplayName("El mago implementa la interfaz Magico")
    void magoImplementaMagico() {
        assertTrue(mago instanceof com.parcial2.interfaces.Magico);
    }

    @Test
    @DisplayName("El mago no es Volador")
    void magoNoEsVolador() {
        assertFalse(mago instanceof com.parcial2.interfaces.Volador);
    }

    @Test
    @DisplayName("El ataque básico del mago hace daño igual a su fuerza")
    void ataqueMagoHaceDanio() {
        int saludInicial = victima.getSalud();
        mago.atacar(victima);
        assertTrue(victima.getSalud() < saludInicial);
    }

    @Test
    @DisplayName("El mago solo lanza hechizos si los aprendió")
    void magoLanzaHechizoSoloSiLoAprendio() {
        int saludInicial = victima.getSalud();

        mago.lanzarHechizo(victima);
        assertEquals(saludInicial, victima.getSalud());

        mago.aprenderHechizo();
        mago.lanzarHechizo(victima);
        assertTrue(victima.getSalud() < saludInicial);
    }

    @Test
    @DisplayName("El atributo hechizos se guarda correctamente")
    void hechizosSeGuardan() {
        assertEquals("Bola de Fuego", mago.getHechizos());
    }
}
