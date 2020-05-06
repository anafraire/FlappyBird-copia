package com.anafraire.flappy.desktop;

import com.anafraire.flappy.Juego;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Juego.ANCHURA;
		config.height = Juego.ALTURA;
		config.title = Juego.TITULO;
		new LwjglApplication(new Juego(), config);
	}
}
