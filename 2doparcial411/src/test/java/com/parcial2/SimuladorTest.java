package com.parcial2;

import com.parcial2.batalla.Simulador;
import com.parcial2.criaturas.Criatura;
import com.parcial2.criaturas.Dragon;
import com.parcial2.criaturas.Guerrero;
import com.parcial2.criaturas.Mago;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SimuladorTest {

    @Test
    @DisplayName("Al final de la batalla una de las dos criaturas debe estar muerta")
    void alFinalHayUnMuerto() {
        Dragon dragon = new Dragon("Drago", 30, 8, "escamas rojas");
        Mago mago = new Mago("Mago", 20, 5, "Rayo");

        Simulador.simularBatalla(dragon, mago);


        assertTrue(!dragon.estaViva() || !mago.estaViva());
    }

    @Test
    @DisplayName("El ganador retornado por el simulador sigue vivo")
    void ganadorEstaVivo() {
        Guerrero fuerte = new Guerrero("Fuerte", 100, 20, "espada doble");
        Mago debil = new Mago("Debil", 10, 1, "Chispa");

        Criatura ganador = Simulador.simularBatalla(fuerte, debil);

        assertNotNull(ganador);
        assertTrue(ganador.estaViva());
    }

    @Test
    @DisplayName("En una batalla muy desigual gana la criatura más fuerte")
    void ganaLaMasFuerte() {
        Guerrero fuerte = new Guerrero("Hulk", 200, 50, "martillo");
        Mago debil = new Mago("Debilucho", 5, 1, "Chispa");

        Criatura ganador = Simulador.simularBatalla(fuerte, debil);

        assertEquals("Hulk", ganador.getNombre());
    }
}
