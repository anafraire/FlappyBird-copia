package com.anafraire.flappy.Pantallas;

import com.anafraire.flappy.Estados.AdminEstados;
import com.anafraire.flappy.Estados.Estado;
import com.anafraire.flappy.Juego;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Menu extends Estado {

    public static Texture fondo;
    private Texture inicio;
    public Texture boton;


    public Menu(AdminEstados adminEstadosJuego) {
        super(adminEstadosJuego);
        camara.setToOrtho(false, Juego.ANCHURA/2, Juego.ALTURA/2);

        inicio = new Texture("inicio.png");
        fondo = new Texture("bg.png");
        boton = new Texture("playbtn.png");
    }

    @Override
    public void handleInput() { //Cuando interactuamos con el juego, ej: clic
        if (Gdx.input.justTouched() && Principal.gameover == false){
            gsm.set(new Principal(gsm));
        }
    }

    @Override
    public void update(float deltaTime) {
        handleInput();
    }


    public void render(SpriteBatch spriteBatch) {    //Administrar los elementos graficos del juego
        spriteBatch.begin();
        spriteBatch.draw(inicio, 0, 0, Juego.ANCHURA, Juego.ALTURA); //pantalla inicial
        spriteBatch.draw(boton, (camara.position.x + boton.getWidth()/2), camara.position.y+150);   //centro de la pantalla
        spriteBatch.end();

    }

    @Override
    public void dispose() { //Cuando se quite la imagen de menú, va a liberar estas dos variables y usar este espacio de la memoria en otra cosa
        fondo.dispose();
        boton.dispose();
        System.out.println("ESTADO DE JUEGO DISPONIBLE");

    }
}
