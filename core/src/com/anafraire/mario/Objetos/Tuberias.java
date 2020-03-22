package com.anafraire.mario.Objetos;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import java.util.Random;

public class Tuberias {

    private Texture topTuberia;
    private Texture botonTuberia;
    //private Texture downTuberia;
    private Vector2 posicionTopTuberia;    //posicion del tubo en x e y
    private Vector2 posicionBotonTuberia;
    private Random random;
    private static final int VARIACION = 130;   //Rango entre el que se mueven las tuberias
    private static final int TUBERIA_GAP = 100;   //Distancia entre un tubo y otro
    private static final int INICIO_BAJO = 0;   //No bajar demasiado la tuberia

    public Tuberias(float x){
        topTuberia = new Texture("toptube.png");
        botonTuberia = new Texture("bottomtube.png");

        random = new Random();

        posicionTopTuberia = new Vector2(x, random.nextInt(VARIACION) + TUBERIA_GAP + INICIO_BAJO);
        posicionBotonTuberia = new Vector2(x, posicionTopTuberia.y - TUBERIA_GAP - botonTuberia.getHeight());
    }

}
