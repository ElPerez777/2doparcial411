package com.parcial2;

import com.parcial2.criaturas.Dragon;
import com.parcial2.criaturas.Guerrero;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class DragonTest {

    private Dragon dragon;
    private Guerrero victima;

    @BeforeEach
    void preparar() {
        dragon = new Dragon("Drogon", 100, 10, "escamas negras");
        victima = new Guerrero("Objetivo", 100, 5, "daga");
    }

    @Test
    @DisplayName("El dragón implementa las interfaces Volador y Magico")
    void dragonImplementaInterfaces() {
        assertTrue(dragon instanceof com.parcial2.interfaces.Volador);
        assertTrue(dragon instanceof com.parcial2.interfaces.Magico);
    }

    @Test
    @DisplayName("El ataque del dragón hace daño a la víctima (fuerza*2)")
    void ataqueDragonHaceDanio() {
        int saludInicial = victima.getSalud();
        dragon.atacar(victima);
        assertTrue(victima.getSalud() < saludInicial,
                "La salud del objetivo debe disminuir tras el ataque");
    }

    @Test
    @DisplayName("El dragón no puede lanzar hechizos si no los ha aprendido")
    void dragonSinHechizoNoLanza() {
        int saludInicial = victima.getSalud();
        dragon.lanzarHechizo(victima); // Sin aprender, no hace nada
        assertEquals(saludInicial, victima.getSalud());
    }

    @Test
    @DisplayName("Después de aprender, el dragón puede lanzar hechizos")
    void dragonConHechizoLanza() {
        dragon.aprenderHechizo();
        int saludInicial = victima.getSalud();
        dragon.lanzarHechizo(victima);
        assertTrue(victima.getSalud() < saludInicial);
    }

    @Test
    @DisplayName("El atributo escamas se guarda correctamente")
    void escamasSeGuardan() {
        assertEquals("escamas negras", dragon.getEscamas());
    }
}
