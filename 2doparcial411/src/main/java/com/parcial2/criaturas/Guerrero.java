package com.parcial2.criaturas;

import com.parcial2.equipamiento.Arma;


public class Guerrero extends Criatura {

    
    private String arma;

    public Guerrero(String nombre, int salud, int fuerza, String arma) {
        super(nombre, salud, fuerza);
        this.arma = arma;
    }

    public String getArma() {
        return arma;
    }

    public void embestida(Criatura objetivo) {
        int danio = getFuerza() + 3;
        System.out.printf("  > %s embiste con fuerza a %s causando %d de daño.%n",
                getNombre(), objetivo.getNombre(), danio);
        objetivo.defender(danio);
    }

    @Override
    public void atacar(Criatura objetivo) {
        Arma armaEquipada = getArmaEquipada();
        if (armaEquipada != null) {
            armaEquipada.atacarConArma(this, objetivo);
            return;
        }
        int danio = getFuerza();
        System.out.printf("  > %s ataca con su %s a %s causando %d de daño.%n",
                getNombre(), arma, objetivo.getNombre(), danio);
        objetivo.defender(danio);
    }

    @Override
    public void defender(int danio) {
        int reduccion = 3;
        int danioFinal = Math.max(danio - reduccion, 0);
        System.out.printf("  > %s alza su escudo y reduce el daño a %d.%n",
                getNombre(), danioFinal);
        recibirDanio(danioFinal);
    }
}
