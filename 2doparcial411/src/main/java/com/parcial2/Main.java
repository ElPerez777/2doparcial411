package com.parcial2;

import com.parcial2.batalla.Simulador;
import com.parcial2.criaturas.Dragon;
import com.parcial2.criaturas.Guerrero;
import com.parcial2.criaturas.Mago;
import com.parcial2.equipamiento.Arma;


public class Main {

    public static void main(String[] args) {

        System.out.println("*** Parcial II - Batalla de Criaturas ***\n");

        
        Dragon dragon = new Dragon("Drogon", 80, 10, "escamas rojas");
        Mago mago = new Mago("Gandalf", 50, 8, "Rayo Arcano");
        Guerrero guerrero = new Guerrero("Aragorn", 65, 9, "espada larga");

  
        Arma hachaDoble = new Arma("Hacha de Doble Filo", 5);
        Arma bastonMagico = new Arma("Bastón de Cristal", 4);

        
        System.out.println("--- Preparativos antes de la batalla ---");
        dragon.volar();
        dragon.aterrizar();
        dragon.aprenderHechizo();
        mago.aprenderHechizo();
        guerrero.equiparArma(hachaDoble);
        mago.equiparArma(bastonMagico);

        
        Simulador.simularBatalla(guerrero, mago);

     
        Dragon dragon2 = new Dragon("Smaug", 90, 12, "escamas doradas");
        dragon2.aprenderHechizo();

        Guerrero guerrero2 = new Guerrero("Boromir", 70, 10, "espada élfica");
        guerrero2.equiparArma(new Arma("Espada Flamígera", 6));

        Simulador.simularBatalla(dragon2, guerrero2);

        System.out.println("*** Fin del programa ***");
    }
}
