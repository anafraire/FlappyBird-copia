package com.anafraire.mario;

import com.anafraire.mario.Estados.AdminEstadosJuego;
import com.anafraire.mario.Estados.MenuDeEstados;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Mario extends ApplicationAdapter {

	public static final int ANCHURA = 720;
	public static final int ALTURA = 480;
	public static final String TITULO = "Mario Bros Falsete";

	private AdminEstadosJuego gsm;
	private SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm = new AdminEstadosJuego();
		Gdx.gl.glClearColor(0, 0, 1, 1);
		gsm.insertar(new MenuDeEstados(gsm));
	}

	@Override
	public void render () {

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());	//Obtenemos el tiempo real del juego
		gsm.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}

}
