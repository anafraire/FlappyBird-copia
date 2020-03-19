package com.anafraire.mario;

import com.anafraire.mario.Estados.AdminEstadosJuego;
import com.anafraire.mario.Estados.Pantalla;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;

public class Mario extends ApplicationAdapter {

	public static final int ANCHURA = 800;
	public static final int ALTURA = 400;
	//public static final String TITULO = "Mario Bros Falsete";

	private AdminEstadosJuego gsm;
	private SpriteBatch batch;
	private TiledMap mapa;
	private AssetManager manager;


	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm = new AdminEstadosJuego();
		Gdx.gl.glClearColor(0, 0, 1, 1);
		gsm.insertar(new Pantalla(gsm));
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
