package com.mygdx.game;

import com.badlogic.gdx.Game;

import com.mygdx.game.screens.Splash;

//IKKE ENDRE NOE HER INNE. DERE KAN TA HVA DERE VIL MEN IKKE ENDRE NOE PLZ
//DETTE ER MARKUS SIN LILLE PRIVATE. H�RER SAMMEN MED LAUNCHER_TESTE_IKKE_PUSH!!!!!!
public class FROGGERTESTER_IKKE_PUSH extends Game {

	public static final String TITLE = "Fog";
	public static int WIDTH = 1161; 
	public static int HEIGHT = 851; 
	
	@Override
	public void create () {
		
		//Bruker Splash.java for � lage for ordensskyld
		setScreen(new Splash());
				
	}

	@Override
	public void render () {
		super.render();
				
	}
	
	@Override
	public void dispose () {
		super.dispose();
		
	}
}
