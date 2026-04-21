package com.parcial2.batalla;

import com.parcial2.criaturas.Criatura;


public class Simulador {

   
    private Simulador() {
    }
 
    public static Criatura simularBatalla(Criatura criatura1, Criatura criatura2) {
        System.out.println("\n=============================================");
        System.out.printf(" INICIA LA BATALLA: %s vs %s%n",
                criatura1.getNombre(), criatura2.getNombre());
        System.out.println("=============================================");

        int numeroTurno = 1;

        while (criatura1.estaViva() && criatura2.estaViva()) {
            System.out.printf("%n--- Turno %d ---%n", numeroTurno);

         
            criatura1.atacar(criatura2);

            
            if (criatura2.estaViva()) {
                criatura2.atacar(criatura1);
            }

            numeroTurno++;
        }

        Criatura ganador = criatura1.estaViva() ? criatura1 : criatura2;
        System.out.println("\n=============================================");
        System.out.printf(" GANADOR: %s (queda con %d puntos de salud)%n",
                ganador.getNombre(), ganador.getSalud());
        System.out.println("=============================================\n");

        return ganador;
    }
}
