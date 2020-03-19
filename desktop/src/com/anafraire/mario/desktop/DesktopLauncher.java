package com.anafraire.mario.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.anafraire.mario.Mario;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Mario.ANCHURA;
		config.height = Mario.ALTURA;
		//config.title = Mario.TITULO;
		new LwjglApplication(new Mario(), config);
	}
}
