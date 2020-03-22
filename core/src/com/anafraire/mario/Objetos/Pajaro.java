package com.anafraire.mario.Objetos;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

public class Pajaro {

    private static final int GRAVEDAD = -15;
    private Vector3 posicion;
    private Vector3 velocidad;
    private Texture pajaro;

    public Pajaro(int x, int y) {
        posicion = new Vector3 (x, y, 0);
        velocidad = new Vector3 (0, 0, 0);
        pajaro = new Texture("bird.png");
    }

    public void update(float deltaTime) {
        if(posicion.y > 0){ //Limitar la pantalla 1
            velocidad.add(0, GRAVEDAD, 0);
        }
        velocidad.add(0, GRAVEDAD, 0);  //El objeto caerá a la velocidad de la gravedad
        velocidad.scl(deltaTime);  //Actualiza cada segundo
        posicion.add(0, velocidad.y, 0);  //Velocidad en y

        if(posicion.y < 0){ //Limitar la pantalla 1
            posicion.y = 0;
        }

        velocidad.scl(1/deltaTime); //Actualiza cada segundo que pasa del deltaTime
    }

    public Vector3 getPosicion() {
        return posicion;
    }

    public Texture getPajaro() {
        return pajaro;
    }

    public void saltar(){
        velocidad.y = 300;
    }
}
