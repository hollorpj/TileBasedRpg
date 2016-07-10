package main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.GraphicsOperations;

public class Main {
	
	public static void main(String[] args) throws IOException {
		GraphicsOperations.init();
		
		GraphicsOperations.setCurrentTileset("/home/mrshmirk/Desktop/game/tiles");
		GraphicsOperations.setCurrentSpriteset("/home/mrshmirk/Desktop/game/sprites");
		
		long start = System.currentTimeMillis();
		BufferedImage backdrop = GraphicsOperations.drawImage("/home/mrshmirk/Desktop/game/map.txt");
		System.out.println(System.currentTimeMillis() - start);
		BufferedImage sprite = GraphicsOperations.getCurrentSpriteset().get("Ball_Back.png");
		System.out.println(System.currentTimeMillis() - start);
		BufferedImage overlayed = GraphicsOperations.overlayImage(backdrop, sprite, 1, 0);
		System.out.println(System.currentTimeMillis() - start);
		
		ImageIO.write(overlayed, "png", new File("/home/mrshmirk/Desktop/hellohello"));
	}

}