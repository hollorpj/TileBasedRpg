package model;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

import imageprocessing.ImageDrawer;

public class GraphicsResources {
	private static TileCache tileCache;
	private static ImageDrawer imageDrawer;
	
	public static void init() {
		tileCache = new TileCache();
		imageDrawer = new ImageDrawer();
	}
	
	public static Map<String, BufferedImage> getCurrentTileset() {
		return tileCache.getCurrentTileset();
	}
	
	public static void setCurrentTileset(String pathToTiles) {
		tileCache.setCurrentTileset(pathToTiles);
	}
	
	public static BufferedImage drawImage(String bitmapPath) {
		try {
			return imageDrawer.generateImage(bitmapPath, tileCache.getCurrentTileset());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
}
