package game.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader
{
	public static int TILE_SIZE = 64;
	public static TextureRegion basicTile;
	public static TextureRegion basicInvert;
	
	public static void load()
	{
		Texture texture = new Texture(Gdx.files.internal("BasicTile.png"));
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        
        basicTile = new TextureRegion(texture, 0, 0, 64, 64);
        
        texture = new Texture(Gdx.files.internal("BasicTileInvert.png"));
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        
        basicInvert = new TextureRegion(texture, 0, 0, 64, 64);
	}
}
