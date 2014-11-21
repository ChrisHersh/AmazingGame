package game.helpers;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader
{
	public static int TILE_SIZE = 64;
	
	//Test tile, not for final version
	public static TextureRegion basicTile;
	
	/**
	 * Basic tile set that the generator can pull from
	 * If any are added or removed please update the count in Constants.java
	 */
	public static TextureRegion grass;
	public static TextureRegion blurpleBuilding;
	public static TextureRegion burnedMoose;
	public static TextureRegion poopdesert;
	public static TextureRegion river;
	public static TextureRegion tree;
	public static TextureRegion wall;
	public static TextureRegion water;
	
	public static TextureRegion basicInvert;
	public static TextureRegion snorlax;
	public static TextureRegion redOverlay;
	public static TextureRegion greenOverlay;
	
	public static ArrayList<TextureRegion> tiles;
	
	public static void load()
	{
		Texture texture = new Texture(Gdx.files.internal("BasicTile.png"));
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        
        basicTile = new TextureRegion(texture, 0, 0, 64, 64);
        
        //TODO switch out for a more general version
        //Use an overlay like the others
        texture = new Texture(Gdx.files.internal("BasicTileInvert.png"));
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        
        basicInvert = new TextureRegion(texture, 0, 0, 64, 64);
        
        texture = new Texture(Gdx.files.internal("snorlax.png"));
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        snorlax = new TextureRegion(texture, 0, 0, 64, 64);
        snorlax.flip(true, true);
        
        texture = new Texture(Gdx.files.internal("redOverlay.png"));
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        redOverlay = new TextureRegion(texture, 0, 0, 64, 64);
        
        texture = new Texture(Gdx.files.internal("greenOverlay.png"));
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        greenOverlay = new TextureRegion(texture, 0, 0, 64, 64);
        
        /*
         * 
         * 
         */
        
        texture = new Texture(Gdx.files.internal("grass.png"));
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        grass = new TextureRegion(texture, 0, 0, 64, 64);
        grass.flip(true, true);
        
        texture = new Texture(Gdx.files.internal("blurpleBuilding.png"));
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        blurpleBuilding = new TextureRegion(texture, 0, 0, 64, 64);
        blurpleBuilding.flip(true, true);
        
        texture = new Texture(Gdx.files.internal("burnedMoose.png"));
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        burnedMoose = new TextureRegion(texture, 0, 0, 64, 64);
        burnedMoose.flip(true, true);
        
        texture = new Texture(Gdx.files.internal("poopdesert.png"));
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        poopdesert = new TextureRegion(texture, 0, 0, 64, 64);
        poopdesert.flip(true, true);
        
        texture = new Texture(Gdx.files.internal("river.png"));
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        river = new TextureRegion(texture, 0, 0, 64, 64);
        river.flip(true, true);
        
        texture = new Texture(Gdx.files.internal("tree.png"));
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        tree = new TextureRegion(texture, 0, 0, 64, 64);
        tree.flip(true, true);
        
        texture = new Texture(Gdx.files.internal("wall.png"));
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        wall = new TextureRegion(texture, 0, 0, 64, 64);
        wall.flip(true, true);
        
        texture = new Texture(Gdx.files.internal("water.png"));
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        water = new TextureRegion(texture, 0, 0, 64, 64);
        water.flip(true, true);
	}
}
