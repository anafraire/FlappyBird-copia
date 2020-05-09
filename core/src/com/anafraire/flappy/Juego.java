package com.anafraire.flappy;

import com.anafraire.flappy.Estados.AdminEstados;
import com.anafraire.flappy.Pantallas.Menu;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Juego extends ApplicationAdapter {

	public static final int ANCHURA = 480;
	public static final int ALTURA = 800;
	public static final String TITULO = "TFG FlappyBird";	//Titulo de la ventana de la ejecución
	public static Sound musica;
	public AdminEstados gsm;
	public SpriteBatch batch;


	@Override
	public void create () {
		//estado = EstadoJuego_Escena.EstadosJuego.MENU;
		batch = new SpriteBatch();
		gsm = new AdminEstados();
		Gdx.gl.glClearColor(0, 0, 1, 1);
		gsm.insertar(new Menu(gsm));
		startMusica();    //Inicia la musica

	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());	//Obtenemos el tiempo real del juego y lo actualizamos
		gsm.render(batch);	//Optimizar el juego

	}
	
	@Override
	public void dispose () {
		//menu.dispose();
	    batch.dispose();
	}

	public static void startMusica(){
		musica = Gdx.audio.newSound(Gdx.files.internal("music.mp3"));
		musica.play(0.10f);
	}
}
