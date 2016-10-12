package com.mygdx.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

//Dette er det som blir vist i spillet.
public class Splash implements Screen { 
	

//	private SpriteBatch batch;
//	private Sprite menuPic;
	//private Music menuMusic;

	@Override
	public void show() {
		
//		//Menymusikk som looper
//		menuMusic = Gdx.audio.newMusic(Gdx.files.internal("AOE_mp3.mp3"));
//		menuMusic.setLooping(true);
//		menuMusic.play();
		
//		//Det grafiske 
//		batch = new SpriteBatch();
//		Texture splashTexture = new Texture("mab_meme.png");
//		menuPic = new Sprite(splashTexture);
//		menuPic.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		//Sender oss til MainMenu
		((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu());
	}

	@Override
	public void render(float delta) {
		
//		batch.begin();
//		batch.draw(menuPic,0,0);
//		batch.end();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		
//		//Må slette alt siden java gjør det ikke selv!!!
//		Gdx.audio.newMusic(Gdx.files.internal("AOE_mp3.mp3")).dispose();
//		//menuMusic.dispose();
//		batch.dispose();
//		menuPic.getTexture().dispose();	
	}

}
