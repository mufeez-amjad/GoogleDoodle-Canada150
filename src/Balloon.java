import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Balloon {

	private BufferedImage balloon;
	private double x;
	private double y;
	private int width;
	private int height;
	private double xSpeed = 0.1;
	private double ySpeed = 0.1;

	public Balloon(int x, int y){
		try { 
			balloon = ImageIO.read(getClass().getResource("/Balloon.png"));
		} catch (IOException e) { 
			System.err.println("Balloon.png could not be found");
		}

		width = balloon.getWidth();
		height = balloon.getHeight();
		this.x = x;
		this.y = y;
	}


	public void paint (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(balloon,(int) x, (int) y, null);

		update();
	}

	public void update(){
		if (x + xSpeed < 0){
			xSpeed = 0.1;
		}

		if (x + xSpeed > 1484 - width){
			xSpeed = -0.1;
		}

		if (y + ySpeed < 10){
			ySpeed = 0.1;
		}

		if (y + ySpeed > 50){
			ySpeed = -0.1;
		}

		y += ySpeed;
		x += xSpeed;

	}
	
	/*public void collision(UFO u){
		int dx = (x-u.x) + (xSpeed-u.xSpeed);
		int dy = (y-u.y) + (ySpeed-u.ySpeed);
		
		if (Math.sqrt(dx*dx+dy*dy) <= 3*width){
			int tempxa = xSpeed;
			int tempya = ySpeed;
			xSpeed = u.xSpeed;
			ySpeed = u.ySpeed;
			u.xSpeed = tempxa;
			u.ySpeed = tempya;
		}
		
		if (Math.sqrt(dx*dx+dy*dy) <= 110){
			int tempxa = xSpeed;
			int tempya = ySpeed;
			xSpeed = u.xSpeed;
			ySpeed = u.ySpeed;
			u.xSpeed = tempxa;
			u.ySpeed = tempya;
		}
		}*/
}
