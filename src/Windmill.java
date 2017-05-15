import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Windmill {
	
	private BufferedImage spriteSheet;
	private BufferedImage[] sprites = new BufferedImage[24];
	private int x;
	private int y;
	private BufferedImage currentImg;
	private int frameTime;
	private boolean smaller = false;
	private int width;
	private int height;
	
	public Windmill(int x, int y, boolean size){
		try { 
			spriteSheet = ImageIO.read(getClass().getResource("spritesheet2.png"));
		} catch (IOException e) { 
			System.err.println("spritesheet2.png could not be found");
		}
		
		for (int i = 0; i < sprites.length; i++){
			sprites[i] = grabImage(1, i+1, 244);
		}
		currentImg = sprites[0];
		width = currentImg.getWidth();
		height = currentImg.getHeight();
		this.x = x;
		this.y = y;
		smaller = size;
		
	}

	public BufferedImage grabImage(int col, int row, int length){
		BufferedImage img = spriteSheet.getSubimage(((col-1) * length), ((row-1) * length), length, length);
		return img;
	}
	
	public void paint (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		if (smaller){
			g.drawImage(currentImg, x, y, width/2, height/2, null);
		}
		else {
			g2d.drawImage(currentImg, x, y, null);
		}
		update();
	}
	
	public void update(){
		currentImg = sprites[(int) Math.floor(frameTime / 5)];
		
		if (frameTime < 115){
			frameTime++;
		}
		else frameTime = 0;
	}
}
