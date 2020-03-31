package com.anafraire.mario.Estados;

import com.anafraire.mario.FlappyBird;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Menu extends Estado{

    private Texture fondo;
    private Texture boton;


    public Menu(AdminEstadosJuego adminEstadosJuego) {
        super(adminEstadosJuego);
        camara.setToOrtho(false, FlappyBird.ANCHURA/2, FlappyBird.ALTURA/2);
        fondo = new Texture("bg.png");
        boton = new Texture("playbtn.png");

    }

    @Override
    public void handleInput() { //Cuando interactuamos con el juego, ej: clic
        if (Gdx.input.justTouched()){
            gsm.set(new EstadoJuego_Escena(gsm));
        }
    }

    @Override
    public void update(float deltaTime) {
        handleInput();
    }


    public void render(SpriteBatch spriteBatch) {    //Administrar los elementos del juego

    //    Gdx.gl.glClearColor(0,0,1,1);
    //    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);   //Resetea la pantalla
        spriteBatch.setProjectionMatrix(camara.combined);
        spriteBatch.begin();
        spriteBatch.draw(fondo, 0, 0); //pantalla inicial
        spriteBatch.draw(boton, camara.position.x - boton.getWidth()/2, camara.position.y);
        spriteBatch.end();

    }

    @Override
    public void dispose() { //Cuando se quite la imagen de menú, va a liberar estas dos variables y usar
        // este espacio de la memoria en otra cosa
        fondo.dispose();
        boton.dispose();
        System.out.println("ESTADO DE JUEGO DISPONIBLE");
    }
}
