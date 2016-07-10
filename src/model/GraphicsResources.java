package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import imageprocessing.ImageSubroutines;

public class GraphicsResources {
	private Map<String, Map<String, BufferedImage>> tilesetCache;
	private Map<String, BufferedImage> currentTileset;
	private Map<String, BufferedImage> currentSpriteset;
	
	public GraphicsResources() {
		currentTileset = new HashMap<String, BufferedImage>();
		currentSpriteset = new HashMap<String, BufferedImage>();
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
	
	// pass image subs reference
	public void setCurrentSpriteset(String pathToSprites) {
		currentSpriteset.clear();
		File[] spriteLs = new File(pathToSprites).listFiles();
		
		try {
			final int tileWidth = Constants.getTileWidth();
			final int tileHeight = Constants.getTileHeight();
			
			for (int i = 0; i < spriteLs.length; i++) {
				currentSpriteset.put(spriteLs[i].getName(), 
						new ImageSubroutines().scaleBufferedImage(ImageIO.read(spriteLs[i]), tileWidth, tileHeight));
			}
		} catch (IOException e) {
			System.err.println("Failure setting current spriteset");
			e.printStackTrace();
		}
		
		spriteLs = null;
	}
	
	public Map<String, BufferedImage> getCurrentTileset() {
		return currentTileset;
	}
	
	public Map<String, BufferedImage> getCurrentSpriteset() {
		return currentSpriteset;
	}
	
	public void unloadCurrentTileset() {
		this.currentTileset.clear();
	}
	
	public void unloadCurrentSpriteset() {
		this.currentSpriteset.clear();
	}
	
	public void removeTilesetFromCache(String identifier) {
		tilesetCache.remove(identifier);
	}
	
}
