package com.parcial2.criaturas;

import com.parcial2.equipamiento.Arma;
import com.parcial2.interfaces.Magico;


public class Mago extends Criatura implements Magico {


    private String hechizos;

 
    private boolean hechizoAprendido;

    public Mago(String nombre, int salud, int fuerza, String hechizos) {
        super(nombre, salud, fuerza);
        this.hechizos = hechizos;
        this.hechizoAprendido = false;
    }

    public String getHechizos() {
        return hechizos;
    }

    @Override
    public void aprenderHechizo() {
        this.hechizoAprendido = true;
        System.out.printf("  > %s memoriza el hechizo: %s.%n", getNombre(), hechizos);
    }

    @Override
    public void lanzarHechizo(Criatura objetivo) {
        if (!hechizoAprendido) {
            System.out.printf("  > %s intenta lanzar un hechizo pero aún no lo ha aprendido.%n",
                    getNombre());
            return;
        }
        int danioMagico = getFuerza();
        System.out.printf("  > %s lanza el hechizo '%s' sobre %s causando %d de daño.%n",
                getNombre(), hechizos, objetivo.getNombre(), danioMagico);
        objetivo.defender(danioMagico);
    }


    @Override
    public void atacar(Criatura objetivo) {
        Arma arma = getArmaEquipada();
        if (arma != null) {
            arma.atacarConArma(this, objetivo);
            return;
        }
        int danio = getFuerza();
        System.out.printf("  > %s lanza un ataque mágico contra %s causando %d de daño.%n",
                getNombre(), objetivo.getNombre(), danio);
        objetivo.defender(danio);
    }


    @Override
    public void defender(int danio) {
        int reduccion = 2;
        int danioFinal = Math.max(danio - reduccion, 0);
        System.out.printf("  > %s conjura una barrera arcana y reduce el daño a %d.%n",
                getNombre(), danioFinal);
        recibirDanio(danioFinal);
    }
}
