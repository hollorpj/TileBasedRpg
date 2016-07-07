package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class TileCache {
	private Map<String, Map<String, BufferedImage>> tilesetCache;
	private Map<String, BufferedImage> currentTileset;
	
	public TileCache() {
		currentTileset = new HashMap<String, BufferedImage>();
	}
	
	public void setCurrentTileset(String pathToTiles) {
		currentTileset.clear();
		File[] tileLs = new File(pathToTiles).listFiles();
		
		try {
			for (int i = 0; i < tileLs.length; i++) 
				currentTileset.put(tileLs[i].getName(), ImageIO.read(tileLs[i]));
		} catch (IOException e) {
			System.err.println("Failure setting current tileset");
			e.printStackTrace();
		}
		
		tileLs = null;
	}
	
	public Map<String, BufferedImage> getCurrentTileset() {
		return currentTileset;
	}
	
	public void unloadCurrentTileset() {
		this.currentTileset.clear();
	}
	
	public void removeTilesetFromCache(String identifier) {
		tilesetCache.remove(identifier);
	}
	
}
