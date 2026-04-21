package com.parcial2.equipamiento;

import com.parcial2.criaturas.Criatura;

public class Arma {

    private final String nombre;
    private final int danioAdicional;

    public Arma(String nombre, int danioAdicional) {
        this.nombre = nombre;
        this.danioAdicional = Math.max(danioAdicional, 0);
    }

    public String getNombre() {
        return nombre;
    }

    public int getDanioAdicional() {
        return danioAdicional;
    }


    public void atacarConArma(Criatura atacante, Criatura objetivo) {
        int danioTotal = danioAdicional + atacante.getFuerza();
        System.out.printf("  > %s blande su %s y golpea a %s causando %d de daño.%n",
                atacante.getNombre(), nombre, objetivo.getNombre(), danioTotal);
        objetivo.defender(danioTotal);
    }
}
