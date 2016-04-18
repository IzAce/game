package com.xda.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.xda.game.Game;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Game [In-Dev Build  0.1]";
		cfg.height = 800;
		cfg.width = 600;
		cfg.fullscreen = false;
		new LwjglApplication(new Game(), cfg);
	}
}
