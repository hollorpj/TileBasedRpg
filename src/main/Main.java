package main;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.GraphicsResources;

public class Main {
	public static void main(String[] args) throws IOException {
		GraphicsResources.init();
		GraphicsResources.setCurrentTileset("/home/mrshmirk/Desktop/new/Train/tiles");
		ImageIO.write(GraphicsResources.drawImage("/home/mrshmirk/Desktop/new/Train/map/map.txt"), "png", new File("/home/mrshmirk/Desktop/poodle"));
		
	}

}
