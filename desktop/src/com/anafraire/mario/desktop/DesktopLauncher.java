package com.anafraire.mario.desktop;

import com.anafraire.mario.FlappyBird;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = FlappyBird.ANCHURA;
		config.height = FlappyBird.ALTURA;
		//config.title = FlappyBird.TITULO;
		new LwjglApplication(new FlappyBird(), config);
	}
}
