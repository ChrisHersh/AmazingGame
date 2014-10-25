package game.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader
{
	public static int TILE_SIZE = 64;
	public static TextureRegion basicTile;
	public static TextureRegion grass;
	public static TextureRegion basicInvert;
	public static TextureRegion snorlax;
	public static TextureRegion redOverlay;
	public static TextureRegion greenOverlay;
	
	public static void load()
	{
		Texture texture = new Texture(Gdx.files.internal("BasicTile.png"));
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        
        basicTile = new TextureRegion(texture, 0, 0, 64, 64);
        
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
        redOverlay.flip(true, true);
        
        texture = new Texture(Gdx.files.internal("greenOverlay.png"));
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        
        greenOverlay = new TextureRegion(texture, 0, 0, 64, 64);
        greenOverlay.flip(true, true);
        
        texture = new Texture(Gdx.files.internal("grass.png"));
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        
        grass = new TextureRegion(texture, 0, 0, 64, 64);
        grass.flip(true, true);
	}
}
