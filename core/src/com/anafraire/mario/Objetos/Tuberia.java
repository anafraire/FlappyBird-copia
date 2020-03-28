package com.anafraire.mario.Objetos;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import java.util.Random;

public class Tuberia {

    private Texture topTuberia;
    //private Texture botonTuberia;
    private Texture downTuberia;
    private Vector2 posicionTopTuberia;    //posicion del tubo en x e y
    private Vector2 posicionDownTuberia;
    private Random random;
    private static final int VARIACION = 130;   //Rango entre el que se mueven las tuberias
    private static final int TUBERIA_GAP = 100;   //Distancia entre un tubo y otro
    private static final int INICIO_BAJO = 0;   //No bajar demasiado la tuberia
    private Rectangle limiteSuperior;
    private Rectangle limiteInferior;

    public static final int ANCHURA_TUBERIA = 52;

    public Tuberia(float x){
        topTuberia = new Texture("toptube.png");
        downTuberia = new Texture("bottomtube.png");

        random = new Random();

        posicionTopTuberia = new Vector2(x, random.nextInt(VARIACION) + TUBERIA_GAP + INICIO_BAJO);
        posicionDownTuberia = new Vector2(x, posicionTopTuberia.y - TUBERIA_GAP - downTuberia.getHeight());

        limiteSuperior = new Rectangle(posicionTopTuberia.x, posicionTopTuberia.y,
                topTuberia.getWidth(), topTuberia.getHeight());  //contorno tubo superior
        limiteInferior  = new Rectangle(posicionDownTuberia.x, posicionDownTuberia.y,
                downTuberia.getWidth(), downTuberia.getHeight());   //contorno tubo inferior
    }

    public void reposicion (float x){   //Reposicionar las tuberias
        //Posicion random en y
        posicionTopTuberia.set(x, random.nextInt(VARIACION) + TUBERIA_GAP + INICIO_BAJO);
        posicionDownTuberia.set(x, posicionTopTuberia.y - TUBERIA_GAP - downTuberia.getHeight());//Alinear tuberia inferior con superior

        limiteSuperior.setPosition(posicionTopTuberia.x, posicionTopTuberia.y); //contorno de los tubos a la derecha top
        limiteInferior.setPosition(posicionDownTuberia.x, posicionDownTuberia.y); //contorno de los tubos a la derecha down
    }

    public boolean colision (Rectangle jugador) {
        boolean res = false;
        if(jugador.overlaps(limiteSuperior) || jugador.overlaps(limiteInferior)){
            res = true;
        }
        return res;
        //return jugador.overlaps(limiteSuperior) || jugador.overlaps(limiteInferior);  //tocar una tuberia
    }

    public Texture getTopTuberia() {
        return topTuberia;
    }

    public void setTopTuberia(Texture topTuberia) {
        this.topTuberia = topTuberia;
    }

    public Texture getDownTuberia() {
        return downTuberia;
    }

    public void setDownTuberia(Texture botonTuberia) {
        this.downTuberia = botonTuberia;
    }

    public Vector2 getPosicionTopTuberia() {
        return posicionTopTuberia;
    }

    public void setPosicionTopTuberia(Vector2 posicionTopTuberia) {
        this.posicionTopTuberia = posicionTopTuberia;
    }

    public Vector2 getPosicionDownTuberia() {
        return posicionDownTuberia;
    }

    public void setPosicionDownTuberia(Vector2 posicionBotonTuberia) {
        this.posicionDownTuberia = posicionBotonTuberia;
    }
}
