package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class MainMenu implements Screen {
	
	private SpriteBatch batch;
	private Sprite menuPic;
	private Music menuMusic;

	private Stage stage; 
	private Table table;
	private TextButton buttonPlay, buttonExit;
	private Label heading; 
	private Skin skin;
	private BitmapFont white;
	private TextureAtlas atlas;
	
	@Override
	public void show() {

		
		//Menymusikk som looper
		menuMusic = Gdx.audio.newMusic(Gdx.files.internal("AOE_mp3.mp3"));
		menuMusic.setLooping(true);
		menuMusic.play();
		
		//Det grafiske 
		atlas = new TextureAtlas("ui/button.pack");
		skin = new Skin(atlas);
		
		white = new BitmapFont(Gdx.files.internal("font/white.fnt"), false);
		
		batch = new SpriteBatch();
		Texture splashTexture = new Texture("mab_meme.png");
		menuPic = new Sprite(splashTexture);
		menuPic.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

	}

	@Override
	public void render(float delta) {
		batch.begin();
		batch.draw(menuPic,0,0);
		batch.end();

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
		//Må slette alt siden java gjør det ikke selv!!!
		Gdx.audio.newMusic(Gdx.files.internal("AOE_mp3.mp3")).dispose();
		menuMusic.dispose();
		batch.dispose();
		menuPic.getTexture().dispose();	

	}

}
