package com.mygdx.game;

import com.badlogic.gdx.Game;

import com.mygdx.game.screens.Splash;

//IKKE ENDRE NOE HER INNE. DERE KAN TA HVA DERE VIL MEN IKKE ENDRE NOE PLZ
//DETTE ER MARKUS SIN LILLE PRIVATE. HØRER SAMMEN MED LAUNCHER_TESTE_IKKE_PUSH!!!!!!
public class FROGGERTESTER_IKKE_PUSH extends Game {

	
	@Override
	public void create () {
		
		//Bruker Splash.java for å lage for ordensskyld
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
