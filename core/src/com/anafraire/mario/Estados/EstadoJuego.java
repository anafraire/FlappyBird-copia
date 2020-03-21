package com.anafraire.mario.Estados;

import com.anafraire.mario.Mario;
import com.anafraire.mario.Objetos.Pajaro;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EstadoJuego extends Estado{

    private Pajaro pajaro;

    public EstadoJuego(AdminEstadosJuego gsm) {
        super(gsm);
        pajaro = new Pajaro(50, 200);
        camara.setToOrtho(false, Mario.ANCHURA/2, Mario.ALTURA/2);
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float deltaTime) {
        handleInput();
        pajaro.update(deltaTime);
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camara.combined);
        spriteBatch.begin();
        spriteBatch.draw(pajaro.getPajaro(), pajaro.getPosicion().x, pajaro.getPosicion().y);
        spriteBatch.end();
    }

    @Override
    public void dispose() {

    }
}
