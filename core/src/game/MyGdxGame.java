package game;


import game.helpers.*;
import game.screens.GameScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends Game {
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
//		batch = new SpriteBatch();
//		img = new Texture("badlogic.jpg");
		
		AssetLoader.load();
		setScreen(new GameScreen(2, this));
	}
	
	public void changeGameScreen(Screen nextScreen)
	{
		setScreen(nextScreen);
	}
}
