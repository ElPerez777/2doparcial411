package com.parcial2;

import com.parcial2.criaturas.Guerrero;
import com.parcial2.criaturas.Mago;
import com.parcial2.equipamiento.Arma;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuerreroTest {

    private Guerrero guerrero;
    private Mago victima;

    @BeforeEach
    void preparar() {
        guerrero = new Guerrero("Conan", 70, 10, "espada bárbara");
        victima = new Mago("Objetivo", 50, 5, "Chispa");
    }

    @Test
    @DisplayName("El ataque del guerrero hace daño con su fuerza")
    void ataqueGuerreroHaceDanio() {
        int saludInicial = victima.getSalud();
        guerrero.atacar(victima);
        assertTrue(victima.getSalud() < saludInicial);
    }

    @Test
    @DisplayName("La embestida del guerrero hace más daño que el ataque normal")
    void embestidaHaceMasDanio() {
        Mago objetivo1 = new Mago("O1", 100, 5, "Chispa");
        Mago objetivo2 = new Mago("O2", 100, 5, "Chispa");

        guerrero.atacar(objetivo1);
        guerrero.embestida(objetivo2);

        assertTrue(objetivo2.getSalud() <= objetivo1.getSalud());
    }

    @Test
    @DisplayName("Cuando el guerrero tiene arma equipada la usa al atacar")
    void guerreroUsaArmaEquipada() {
        Arma arma = new Arma("Hacha gigante", 10);
        guerrero.equiparArma(arma);

        int saludInicial = victima.getSalud();
        guerrero.atacar(victima);

        assertTrue(victima.getSalud() < saludInicial);
        assertEquals(arma, guerrero.getArmaEquipada());
    }

    @Test
    @DisplayName("El atributo arma del guerrero se guarda correctamente")
    void armaGuerreroSeGuarda() {
        assertEquals("espada bárbara", guerrero.getArma());
    }
}
