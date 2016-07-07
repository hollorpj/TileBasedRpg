package imageprocessing;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.Constants;

public class ImageDrawer {
	public ImageDrawer(){}
	
	public BufferedImage generateImage(String pathToBitmap, Map<String, BufferedImage> tileset) throws IOException {
		List<List<String>> imageSkeleton = convertBitmapToSkeleton(pathToBitmap);
		BufferedImage picture = new BufferedImage((Constants.getTileWidth() * imageSkeleton.get(0).size()), (Constants.getTileHeight() * imageSkeleton.size()) , BufferedImage.TYPE_INT_RGB);
		
		Image curImage;
		int numTilesTall = imageSkeleton.size();
		int numTilesWide = imageSkeleton.get(0).size();
		for (int i = 0; i < numTilesTall; i++) {
			for (int j = 0; j < numTilesWide; j++) {
				curImage = tileset.get(imageSkeleton.get(i).get(j));
				picture.getGraphics().drawImage(curImage, (curImage.getWidth(null) * j), (curImage.getHeight(null) * i), null);
			}
		}
		
		return picture;
	}
	
	private List<List<String>> convertBitmapToSkeleton(String pathToBitmap) {
		List<List<String>> imageSkeleton = new ArrayList<List<String>>();
		
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
			
			return imageSkeleton;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
