package com.parcial2.criaturas;

import com.parcial2.equipamiento.Arma;

public abstract class Criatura {

    private final String nombre;
    private int salud;
    private final int fuerza;

    private Arma armaEquipada;


    public Criatura(String nombre, int salud, int fuerza) {
        this.nombre = nombre;
        this.salud = Math.max(salud, 1);
        this.fuerza = Math.max(fuerza, 1);
    }

 
    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public int getFuerza() {
        return fuerza;
    }

    public Arma getArmaEquipada() {
        return armaEquipada;
    }


    public void equiparArma(Arma arma) {
        if (arma == null) {
            return;
        }
        this.armaEquipada = arma;
        System.out.printf("  > %s equipa el arma: %s%n", nombre, arma.getNombre());
    }

    public void desequiparArma() {
        if (armaEquipada != null) {
            System.out.printf("  > %s guarda su arma: %s%n", nombre, armaEquipada.getNombre());
            this.armaEquipada = null;
        }
    }


    public boolean estaViva() {
        return salud > 0;
    }


    protected void recibirDanio(int danio) {
        this.salud = Math.max(this.salud - danio, 0);
        System.out.printf("  > %s queda con %d puntos de salud.%n", nombre, salud);
    }


    public abstract void atacar(Criatura objetivo);


    public abstract void defender(int danio);
}
