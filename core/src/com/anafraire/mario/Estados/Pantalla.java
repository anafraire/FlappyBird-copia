package com.anafraire.mario.Estados;

import com.anafraire.mario.Mario;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Pantalla extends Estado{

    private Texture fondo;
    private Texture boton;


    public Pantalla(AdminEstadosJuego gsm) {
        super(gsm);
        fondo = new Texture("pngocean.png");
        boton = new Texture("playbtn.png");

    }

    @Override
    protected void handleInput() {

    }

    @Override
    protected void update(float deltaTime) {

    }


    protected void render(SpriteBatch spriteBatch) {    //Administrar los elementos del juego

    //    Gdx.gl.glClearColor(0,0,1,1);
    //    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);   //Resetea la pantalla
        spriteBatch.begin();
        spriteBatch.draw(fondo, 0, 0, Mario.ANCHURA, Mario.ALTURA);
        spriteBatch.draw(boton, (Mario.ANCHURA/2) - (boton.getWidth()/2), (Mario.ALTURA/2) - (boton.getHeight())/2);
        spriteBatch.end();

    }
}
