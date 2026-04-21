package com.parcial2;

import com.parcial2.criaturas.Dragon;
import com.parcial2.criaturas.Guerrero;
import com.parcial2.equipamiento.Arma;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CriaturaTest {

    private Guerrero guerrero;
    private Dragon dragon;

    @BeforeEach
    void preparar() {
        
        guerrero = new Guerrero("Prueba", 50, 10, "espada corta");
        dragon = new Dragon("Tester", 60, 12, "escamas verdes");
    }

    @Test
    @DisplayName("Una criatura recién creada debe estar viva")
    void criaturaNuevaEstaViva() {
        assertTrue(guerrero.estaViva());
        assertTrue(dragon.estaViva());
    }

    @Test
    @DisplayName("La criatura muere cuando su salud llega a 0")
    void criaturaMuereConSaludCero() {

        for (int i = 0; i < 50; i++) {
            dragon.atacar(guerrero);
            if (!guerrero.estaViva()) {
                break;
            }
        }
        assertFalse(guerrero.estaViva());
        assertEquals(0, guerrero.getSalud());
    }

    @Test
    @DisplayName("Salud y fuerza no pueden ser menores que 1")
    void saludYFuerzaMinimas() {
        Guerrero debil = new Guerrero("Debilucho", -10, 0, "palo");
        assertEquals(1, debil.getSalud());
        assertEquals(1, debil.getFuerza());
    }

    @Test
    @DisplayName("Una criatura puede equipar y desequipar un arma")
    void equiparYDesequiparArma() {
        Arma espada = new Arma("Espada de Hierro", 4);

        assertNull(guerrero.getArmaEquipada());
        guerrero.equiparArma(espada);
        assertEquals(espada, guerrero.getArmaEquipada());

        guerrero.desequiparArma();
        assertNull(guerrero.getArmaEquipada());
    }

    @Test
    @DisplayName("Equipar un arma null no cambia el arma equipada")
    void equiparArmaNull() {
        guerrero.equiparArma(null);
        assertNull(guerrero.getArmaEquipada());
    }

    @Test
    @DisplayName("Los getters retornan los valores pasados en el constructor")
    void gettersBasicos() {
        assertEquals("Prueba", guerrero.getNombre());
        assertEquals(50, guerrero.getSalud());
        assertEquals(10, guerrero.getFuerza());
    }
}
