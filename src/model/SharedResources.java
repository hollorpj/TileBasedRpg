package model;

import java.awt.image.BufferedImage;
import java.util.Map;

public class SharedResources {
	private static TileCache tileCache;
	
	public Map<String, BufferedImage> getCurrentTileset() {
		return tileCache.getCurrentTileset();
	}
	
	public void setCurrentTileset(String pathToTiles) {
		tileCache.setCurrentTileset(pathToTiles);
	}
	
}
