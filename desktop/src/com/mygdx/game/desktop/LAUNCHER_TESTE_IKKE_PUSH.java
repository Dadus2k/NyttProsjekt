package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.FROGGERTESTER_IKKE_PUSH;
import com.mygdx.game.FogMain;

//IKKE ENDRE NOE HER INNE. DERE KAN TA HVA DERE VIL MEN IKKE ENDRE NOE PLZ
//DETTE ER MARKUS SIN LILLE PRIVATE. HØRER SAMMEN MED FROGGERTESTER_IKKE_PUSH!!!!!!
public class LAUNCHER_TESTE_IKKE_PUSH {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new FROGGERTESTER_IKKE_PUSH(), config);
		config.title = "Fog";
		config.vSyncEnabled = true;
		config.height = 851;
		config.width = 1161;
	}
}
