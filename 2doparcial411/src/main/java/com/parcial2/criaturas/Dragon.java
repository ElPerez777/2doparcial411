package com.parcial2.criaturas;

import com.parcial2.equipamiento.Arma;
import com.parcial2.interfaces.Magico;
import com.parcial2.interfaces.Volador;


public class Dragon extends Criatura implements Volador, Magico {

   
    private String escamas;

 
    private boolean sabeMagia;

    public Dragon(String nombre, int salud, int fuerza, String escamas) {
        super(nombre, salud, fuerza);
        this.escamas = escamas;
        this.sabeMagia = false;
    }

    public String getEscamas() {
        return escamas;
    }

   

    @Override
    public void volar() {
        System.out.printf("  > %s bate sus alas y se eleva por los cielos.%n", getNombre());
    }

    @Override
    public void aterrizar() {
        System.out.printf("  > %s desciende y aterriza con fuerza.%n", getNombre());
    }

 

    @Override
    public void aprenderHechizo() {
        this.sabeMagia = true;
        System.out.printf("  > %s ha aprendido un hechizo ancestral de fuego.%n", getNombre());
    }

    @Override
    public void lanzarHechizo(Criatura objetivo) {
        if (!sabeMagia) {
            System.out.printf("  > %s aún no conoce ningún hechizo.%n", getNombre());
            return;
        }
        // Como es mágico, el daño del hechizo también escala con la fuerza
        int danioHechizo = getFuerza() * 2;
        System.out.printf("  > %s lanza un aliento de fuego contra %s causando %d de daño mágico.%n",
                getNombre(), objetivo.getNombre(), danioHechizo);
        objetivo.defender(danioHechizo);
    }

    @Override
    public void atacar(Criatura objetivo) {
        Arma arma = getArmaEquipada();
        if (arma != null) {
            arma.atacarConArma(this, objetivo);
            return;
        }
        int danio = getFuerza() * 2;
        System.out.printf("  > %s ataca con sus garras causando %d de daño.%n",
                getNombre(), danio);
        objetivo.defender(danio);
    }

    @Override
    public void defender(int danio) {
        int reduccion = 4; // Sus escamas absorben parte del daño
        int danioFinal = Math.max(danio - reduccion, 0);
        System.out.printf("  > %s usa sus escamas (%s) y reduce el daño de %d a %d.%n",
                getNombre(), escamas, danio, danioFinal);
        recibirDanio(danioFinal);
    }
}
