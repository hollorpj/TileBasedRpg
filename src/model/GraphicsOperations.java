
package model;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

import imageprocessing.ImageDrawer;

public class GraphicsOperations {
	private static GraphicsResources tileCache;
	private static ImageDrawer imageDrawer;
	
	public static void init() {
		tileCache = new GraphicsResources();
		imageDrawer = new ImageDrawer();
	}
	
	public static Map<String, BufferedImage> getCurrentTileset() {
		return tileCache.getCurrentTileset();
	}
	
	public static Map<String, BufferedImage> getCurrentSpriteset() {
		return tileCache.getCurrentSpriteset();
	}
	
	public static void setCurrentTileset(String pathToTiles) {
		tileCache.setCurrentTileset(pathToTiles);
	}
	
	public static void setCurrentSpriteset(String pathToSprites) {
		tileCache.setCurrentSpriteset(pathToSprites);
	}
	
	public static BufferedImage drawImage(String bitmapPath) {
		try {
			return imageDrawer.generateImage(bitmapPath, tileCache.getCurrentTileset());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static BufferedImage overlayImage(BufferedImage backdrop, BufferedImage toOverlay, int gridX, int gridY) {
		return imageDrawer.overlayImage(backdrop, toOverlay, gridX, gridY);
	}
	
	
	
}
