package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FogMainTestEnvironment extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	float x,y;
	Texture menuPic;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("Monk.png");

		Gdx.audio.newMusic(Gdx.files.internal("AOE_mp3.mp3")).play();
		menuPic = new Texture("mab_meme.png");
		batch = new SpriteBatch();
		
		
	}

	@Override
	public void render () {

		
		if(Gdx.input.isKeyPressed(Keys.UP)){
			if(y+5 < 760){
			y = y+ 5;} else{
				y=y;
			}
		}
		if(Gdx.input.isKeyPressed(Keys.DOWN)){
			if(y-5 > 0){
			y = y- 5;
			}else{ y=y;}
		}
		
		if(Gdx.input.isKeyPressed(Keys.RIGHT)){
			if(x+5 < 1070){
			x = x+ 5;}else{x=x;}
		}
		if(Gdx.input.isKeyPressed(Keys.LEFT)){
			if(x-5>0){
			x = x- 5;}else{x=x;}
		}
		if(Gdx.input.isKeyJustPressed(Keys.E)){
			Gdx.audio.newMusic(Gdx.files.internal("Sound1.mp3")).play();
		}

		
		batch.begin();
		batch.draw(menuPic,0,0);
		batch.draw(img, x, y, 100,100);
		batch.end();
		Gdx.audio.newMusic(Gdx.files.internal("AOE_mp3.mp3"));

	}
	
	@Override
	public void dispose () {
		Gdx.audio.newMusic(Gdx.files.internal("AOE_mp3.mp3")).dispose();
		Gdx.audio.newMusic(Gdx.files.internal("Sound1.mp3")).dispose();
		batch.dispose();
		menuPic.dispose();
		batch.dispose();
		img.dispose();
	}
}