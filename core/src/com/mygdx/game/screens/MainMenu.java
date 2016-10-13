package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

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

		stage = new Stage();
	
		Gdx.input.setInputProcessor(stage);
		
		//Menymusikk som looper
		menuMusic = Gdx.audio.newMusic(Gdx.files.internal("AOE_mp3.mp3"));
		menuMusic.setLooping(true);
		menuMusic.play();
		
		
		//Det grafiske 
		atlas = new TextureAtlas("ui//button.pack");
		skin = new Skin(atlas);
		
		table = new Table(skin);
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		white = new BitmapFont(Gdx.files.internal("font/white.fnt"), false);

		TextButtonStyle textButtonStyle = new TextButtonStyle();
		textButtonStyle.up = skin.getDrawable("button.up");		
		textButtonStyle.down = skin.getDrawable("button.donw");	//Jeg skrev down feil LEL
		textButtonStyle.pressedOffsetX = 1;
		textButtonStyle.pressedOffsetY = -1;
		textButtonStyle.font = white;
		textButtonStyle.fontColor = Color.BLACK; //Dette gjøre for å få sort skrift i stede for hvit. Kan fjernes om hvit farge ønskes
		
		buttonExit = new TextButton("EXIT", textButtonStyle);
		buttonExit.pad(20);
		
		table.add(buttonExit);
		table.debug(); //TODO fjent når ferdig med implementasjoene
		stage.addActor(table);
		
		
		
		batch = new SpriteBatch();
		Texture splashTexture = new Texture("mab_meme.png");
		menuPic = new Sprite(splashTexture);
		menuPic.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

//		batch.begin();
//		batch.draw(menuPic,0,0);
//		batch.end();
//		
	}

	@Override
	public void render(float delta) {
		
//		Gdx.gl.glClearColor(0, 0, 0, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			
		batch.begin();
		batch.draw(menuPic,0,0);
		batch.end();

		stage.act(delta);
		stage.draw(); //
		
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
