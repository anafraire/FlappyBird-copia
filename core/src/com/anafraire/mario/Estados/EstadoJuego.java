package com.anafraire.mario.Estados;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EstadoJuego extends Estado{

    private Texture pajaro;

    public EstadoJuego(AdminEstadosJuego gsm) {
        super(gsm);
        pajaro = new Texture("bird.png");
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();
        spriteBatch.draw(pajaro, 50, 50);
        spriteBatch.end();
    }

    @Override
    public void dispose() {

    }
}
