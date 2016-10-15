package com.mygdx.game.screens;

import com.badlogic.gdx.Game;
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
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.FROGGERTESTER_IKKE_PUSH;

public class MainMenu implements Screen {
	
	private SpriteBatch batch;
	private Sprite menuPic;
	private Music menuMusic;

	private Stage stage;
	private Table table;
	private TextButton buttonPlay, buttonExit, buttonOption;
	private Label heading; 
	private Skin skin;
	private BitmapFont white;
	private TextureAtlas atlas;
	
	@Override
	public void show() {

		int menu_height = 851; //Settes til dette for å passe menybildet
		int menu_width = 1161;//Settes til dette for å passe menybildet	
		Gdx.graphics.setWindowedMode(menu_width , menu_height ); //Vet ikke om fungerer helt. Setter viduet til å passe menybildet
		
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
		textButtonStyleBlack.fontColor = Color.BLACK; //Dette gjøre for å få sort skrift i stede for hvit. Kan fjernes om hvit farge ønskes
		
		//Exit-knappen
		buttonExit = new TextButton("EXIT", textButtonStyleBlack);
		buttonExit.addListener(new ClickListener(){		//Oppretter funksjonalitet til knappen
			@Override
			public void clicked(InputEvent event, float x, float y) { 
				Gdx.app.exit();
				super.clicked(event, x, y);
			}
		});
		buttonExit.pad(30); //Lager mellomromm på sidene av knappen. uten er kantene helt intill skriften
		
		
		//Play-knappen
		buttonPlay = new TextButton("PLAY", textButtonStyleBlack);
		buttonPlay.addListener(new ClickListener(){		//Oppretter funksjonalitet til knappen
			@Override
			public void clicked(InputEvent event, float x, float y) { 
				menuMusic.stop();												   //Stopper menymusikken etter man har valgt å spille
//				FROGGERTESTER_IKKE_PUSH.WIDTH = 1280;
//				FROGGERTESTER_IKKE_PUSH.HEIGHT = 720;
				Gdx.graphics.setWindowedMode(FROGGERTESTER_IKKE_PUSH.WIDTH, FROGGERTESTER_IKKE_PUSH.HEIGHT); //Setter vindustørelsen den oppringelige 1280x720.
				((Game) Gdx.app.getApplicationListener()).setScreen(new Levels()); //Sender brukeren til spillet. Levels() er kart-klassen
			}
		});
		buttonPlay.pad(30); //Lager mellomromm på sidene av knappen. uten er kantene helt intill skriften
		
		
		//Option-knappen
		buttonOption = new TextButton("OPTION", textButtonStyleBlack);
		buttonOption.addListener(new ClickListener(){		//Oppretter funksjonalitet til knappen
			@Override
			public void clicked(InputEvent event, float x, float y) { 
				menuMusic.stop();												   //Stopper menymusikken etter man har valgt å spille
				//FROGGERTESTER_IKKE_PUSH.WIDTH = 1280;
				//FROGGERTESTER_IKKE_PUSH.HEIGHT = 720;
				//Gdx.graphics.setWindowedMode(FROGGERTESTER_IKKE_PUSH.WIDTH, FROGGERTESTER_IKKE_PUSH.HEIGHT); //Setter vindustørelsen den oppringelige 1280x720.
				((Game) Gdx.app.getApplicationListener()).setScreen(new Option()); //Sender brukeren til spillet. Levels() er kart-klassen
			}
		});
		buttonOption.pad(30); //Lager mellomromm på sidene av knappen. uten er kantene helt intill skriften
		
		//Lager heading
		heading = new Label(FROGGERTESTER_IKKE_PUSH.TITLE, new LabelStyle(white, Color.WHITE));
		heading.setFontScale(1); //(1) betyr 100% av den orgenale størrelsen
		
		//Legger ting sammen
		table.add(heading);
		table.getCell(heading).spaceBottom(76); //Setter mellomrom mellom headingen og buttonPLAY
		table.row(); //Setter heading over buttonExit. uten blir heading satt ved siden av buttonPLAY.
		table.add(buttonPlay);
		table.getCell(buttonPlay).spaceBottom(10); //Setter mellomrom mellom buttonPLAY og buttonEXIT
		table.row();
		table.add(buttonOption);
		table.getCell(buttonOption).spaceBottom(10); //Setter mellomrom mellom buttonPLAY og buttonEXIT
		table.row();
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
		//Dette er utdatert i youtube-filmen jeg så. fungerer på andre måter
		stage.getViewport().update(width, height, true); //Denne måten ser ut til å funke. Bruk dette! "The last parameter "true" will center the camera in the screen"

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
		stage.dispose();
		atlas.dispose();
		skin.dispose();
		white.dispose();

	}

}
