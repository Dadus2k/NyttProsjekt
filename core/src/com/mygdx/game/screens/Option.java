package com.mygdx.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.FROGGERTESTER_IKKE_PUSH;

public class Option implements Screen {

	private Stage stage;
	private Table table;
	private TextButton button1080, button720;
	private Label heading; 
	private Skin skin;
	private BitmapFont white;
	private TextureAtlas atlas;
	
	@Override
	public void show() {
		
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);

		//Det grafiske 
		atlas = new TextureAtlas("ui//button.pack");
		skin = new Skin(atlas);
				
		table = new Table(skin);
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
				
				
		//Lager fonts
		white = new BitmapFont(Gdx.files.internal("font/white.fnt"), false); //"false" betyr at fonten ikke blir invertert

				
		//Lager knapper
		TextButtonStyle textButtonStyle = new TextButtonStyle();
		TextButtonStyle textButtonStyleBlack = new TextButtonStyle();
		textButtonStyle.up = skin.getDrawable("button.up");		
		textButtonStyle.down = skin.getDrawable("button.donw");	//Jeg skrev down feil LEL
		textButtonStyle.pressedOffsetX = 1;
		textButtonStyle.pressedOffsetY = -1;
		textButtonStyle.font = white; //Hvit farge
		textButtonStyleBlack = textButtonStyle;
		textButtonStyleBlack.fontColor = Color.BLACK;
		
		//720-knappen
		button720 = new TextButton("720", textButtonStyleBlack);
		button720.addListener(new ClickListener(){		//Oppretter funksjonalitet til knappen
			@Override
			public void clicked(InputEvent event, float x, float y) { 
				FROGGERTESTER_IKKE_PUSH.WIDTH = 1280;
				FROGGERTESTER_IKKE_PUSH.HEIGHT = 720;
				Gdx.graphics.setWindowedMode(FROGGERTESTER_IKKE_PUSH.WIDTH, FROGGERTESTER_IKKE_PUSH.HEIGHT);
				((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu());
				
			}
		});
		button720.pad(30); //Lager mellomromm på sidene av knappen. uten er kantene helt intill skriften
		
		//Lager heading
		heading = new Label("Options", new LabelStyle(white, Color.WHITE));
		heading.setFontScale(1); //(1) betyr 100% av den orgenale størrelsen
		
		//Legger ting sammen
		table.add(heading);
		table.getCell(heading).spaceBottom(76); //Setter mellomrom mellom headingen og buttonPLAY
		table.row(); //Setter heading over buttonExit. uten blir heading satt ved siden av buttonPLAY.
		table.add(button720);
		table.getCell(button720).spaceBottom(10); //Setter mellomrom mellom buttonPLAY og buttonEXIT
		table.row();
//		table.add(buttonExit);
//		table.getCell(buttonExit).spaceBottom(10); //Setter mellomrom mellom buttonPLAY og buttonEXIT
//		table.row();
//		table.add(buttonOption);
//		table.debug(); //TODO fjent når ferdig med implementasjoene
		stage.addActor(table);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act(delta);
		stage.draw(); //
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);

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
		stage.dispose();
		atlas.dispose();
		skin.dispose();
		white.dispose();

	}

}
