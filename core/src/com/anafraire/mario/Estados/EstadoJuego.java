package com.anafraire.mario.Estados;

import com.anafraire.mario.Mario;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EstadoJuego extends Estado{

    private Texture pajaro;

    public EstadoJuego(AdminEstadosJuego gsm) {
        super(gsm);
        pajaro = new Texture("bird.png");
        camara.setToOrtho(false, Mario.ANCHURA/2, Mario.ALTURA/2);
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camara.combined);
        spriteBatch.begin();
        spriteBatch.draw(pajaro, 50, 50);
        spriteBatch.end();
    }

    @Override
    public void dispose() {

    }
}
