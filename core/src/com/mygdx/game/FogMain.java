package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FogMain extends ApplicationAdapter {
//	SpriteBatch batch, batch2;
//	Texture img;
//	Texture grass;
//	float x,y;
	
	SpriteBatch batch;
	Texture menuPic;
	
	public static final String TEST = "Dette er en test";
	
	@Override
	public void create () {
//		batch = new SpriteBatch();
//		batch2 = new SpriteBatch();
//		img = new Texture("badlogic.jpg");
//		grass = new Texture("grass.jpeg");
		Gdx.app.log(TEST, "create ()");
		Gdx.audio.newMusic(Gdx.files.internal("AOE_mp3.mp3")).play();
		menuPic = new Texture("mab_meme.png");
		batch = new SpriteBatch();
		
		
	}

	@Override
	public void render () {
//		Gdx.gl.glClearColor(1, 0, 0, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		
//		
//		if(Gdx.input.isKeyPressed(Keys.UP)){
//			y = y+ 4;
//		}
//		if(Gdx.input.isKeyPressed(Keys.DOWN)){
//			y = y- 4;
//		}
//		
//		if(Gdx.input.isKeyPressed(Keys.RIGHT)){
//			x = x+ 4;
//		}
//		if(Gdx.input.isKeyPressed(Keys.LEFT)){
//			x = x- 10;
//		}
//
//	
//		
//		batch.begin();
//		batch.draw(grass,0,0);
//		batch.draw(grass,640,480);
//		batch.draw(grass,640,0);
//		batch.draw(grass,0,480);
//		batch.draw(img, x, y);
//		batch.end();
		
		batch.begin();
		batch.draw(menuPic,0,0);
		batch.end();
		Gdx.app.log(TEST, "render ()");
		Gdx.audio.newMusic(Gdx.files.internal("AOE_mp3.mp3"));
	}
	
	@Override
	public void dispose () {
		Gdx.app.log(TEST, "dispose ()");
		Gdx.audio.newMusic(Gdx.files.internal("AOE_mp3.mp3"));
//		batch.dispose();
//		img.dispose();
	}
}
