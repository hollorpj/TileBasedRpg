package main;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class Main {
	private final int IMAGE_WIDTH;
	private final int IMAGE_HEIGHT;
	private final String TILE_DIRECTORY;
	private final String IMAGE_EXTENSION;
	
	private List<List<String>> imageSkeleton;
	private BufferedImage picture;	

	//	cur = tileRaw.getSubimage((widthTile * j), (heightTile * i), widthTile, heightTile);
//	// Creates scaled instance of parsed tile
//	scaled = new BufferedImage(scaledWidth, scaledHeight, BufferedImage.TYPE_INT_RGB);
//	scaled.getGraphics().drawImage(cur.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH), 0, 0, null);
	
	public Main(String pathToBitmap, String directoryOfTiles, int IMAGE_WIDTH, int IMAGE_HEIGHT) {
		this.IMAGE_HEIGHT = IMAGE_HEIGHT;
		this.IMAGE_WIDTH = IMAGE_WIDTH;
		this.imageSkeleton = new ArrayList<List<String>>();
		convertBitmapToSkeleton(pathToBitmap);
		this.TILE_DIRECTORY = directoryOfTiles;
		this.IMAGE_EXTENSION = "";
		this.picture = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_RGB);
	}
	
	public void generateImage() throws IOException {
		Image curImage;
		
		int imageHeight = imageSkeleton.size();
		int imageWidth = imageSkeleton.get(0).size();
		for (int i = 0; i < imageHeight; i++) {
			for (int j = 0; j < imageWidth; j++) {
				try {
				curImage = ImageIO.read(new File(TILE_DIRECTORY + System.getProperty("file.separator") + imageSkeleton.get(i).get(j)));
				picture.getGraphics().drawImage(curImage, (curImage.getWidth(null) * j), (curImage.getHeight(null) * i), null);
				} catch (Exception e) {
					System.out.println("hed");
				}
				
			}
		}
	}
	
	public BufferedImage getImage() {
		return picture;
	}
	
	private void convertBitmapToSkeleton(String pathToBitmap) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(pathToBitmap));
			
			String line;
			List<String> horizontalComponent = new ArrayList<String>();
			while ((line = br.readLine()) != null) {
				String[] horizontalElements = line.split(",");
				for (String elem : horizontalElements)
					horizontalComponent.add(elem);
				imageSkeleton.add(new ArrayList<String>(horizontalComponent));
				horizontalComponent.clear();
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		Main main = new Main("/home/mrshmirk/Desktop/new/Train/map/map.txt", "/home/mrshmirk/Desktop/new/Train/tiles", 480, 480);
		main.generateImage();
		BufferedImage im = main.getImage();
		
		ImageIO.write(im, "png", new File("/home/mrshmirk/Desktop/fudge"));
	}
	
}
