package com.anafraire.mario.Estados;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public abstract class Estado {

    protected OrthographicCamera camara;    //Lo que vemos en el momento
    protected Vector3 raton;    // Donde nosotros pinchamos para que funcione
    protected AdminEstadosJuego gsm;    //Controlar todos los estados

    protected Estado(AdminEstadosJuego estadosJuego) {
        this.gsm = estadosJuego;
        camara = new OrthographicCamera();
        raton = new Vector3();
    }

    protected abstract void handleInput();  //Entradas de estado
    public abstract void update(float deltaTime);
    public abstract void render(SpriteBatch spriteBatch);
    public abstract void dispose();

}
