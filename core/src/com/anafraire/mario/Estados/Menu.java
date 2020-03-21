package com.anafraire.mario.Estados;

import com.anafraire.mario.Mario;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Menu extends Estado{

    private Texture fondo;
    private Texture boton;


    public Menu(AdminEstadosJuego adminEstadosJuego) {
        super(adminEstadosJuego);
        fondo = new Texture("mario.jpg");
        boton = new Texture("playbtn.png");

    }

    @Override
    public void handleInput() { //Cuando interactuamos con el juego, ej: clic
        if (Gdx.input.justTouched()){
            gsm.set(new EstadoJuego(gsm));
            dispose();
        }
    }

    @Override
    public void update(float deltaTime) {
        handleInput();
    }


    public void render(SpriteBatch spriteBatch) {    //Administrar los elementos del juego

    //    Gdx.gl.glClearColor(0,0,1,1);
    //    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);   //Resetea la pantalla
        spriteBatch.begin();
        spriteBatch.draw(fondo, 0, 0, Mario.ANCHURA, Mario.ALTURA);
        spriteBatch.draw(boton, (Mario.ANCHURA/2) - (boton.getWidth()/2), (Mario.ALTURA/2) - (boton.getHeight())/2);
        spriteBatch.end();

    }

    @Override
    public void dispose() { //Cuando se quite la imagen de menú, va a liberar estas dos variables y usar
        // este espacio de la memoria en otra cosa
        fondo.dispose();
        boton.dispose();
    }
}
