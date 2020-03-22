package com.anafraire.mario.Objetos;

import com.badlogic.gdx.graphics.Texture;
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

    public static final int ANCHURA_TUBERIA = 52;

    public Tuberia(float x){
        topTuberia = new Texture("toptube.png");
        downTuberia = new Texture("bottomtube.png");

        random = new Random();

        posicionTopTuberia = new Vector2(x, random.nextInt(VARIACION) + TUBERIA_GAP + INICIO_BAJO);
        posicionDownTuberia = new Vector2(x, posicionTopTuberia.y - TUBERIA_GAP - downTuberia.getHeight());
    }

    public void reposicion (float x){   //Reposicionar las tuberias
        //Posicion random en y
        posicionTopTuberia.set(x, random.nextInt(VARIACION) + TUBERIA_GAP + INICIO_BAJO);
        posicionDownTuberia.set(x, posicionTopTuberia.y - TUBERIA_GAP - downTuberia.getHeight());//Alinear tuberia inferior con superior
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
