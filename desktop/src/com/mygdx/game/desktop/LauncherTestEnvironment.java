package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.FogMain;
import com.mygdx.game.FogMainTestEnvironment;

public class LauncherTestEnvironment {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new FogMainTestEnvironment(), config);
		config.height = 851;
		config.width = 1161;
	}
}
