package com.anafraire.mario.Estados;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public abstract class Estado {

    private OrthographicCamera camara;    //Lo que vemos en el momento
    private Vector3 raton;    // Donde nosotros pinchamos para que funcione
    private AdminEstadosJuego estadosJuego;    //Controlar todos los estados

    public Estado(AdminEstadosJuego estadosJuego) {
        this.estadosJuego = estadosJuego;
        camara = new OrthographicCamera();
        raton = new Vector3();
    }

    protected abstract void handleInput();  //Entradas de estado
    protected abstract void update(float deltaTime);
    protected abstract void render(SpriteBatch spriteBatch);
}
