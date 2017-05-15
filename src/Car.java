import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Car {
	private int x = 0;
	private int y = 0;
	private BufferedImage car;
	private int speed;


	public Car(int carNumber){
		if (carNumber == 1){
			try { 
				car = ImageIO.read(getClass().getResource("car1.png"));
			} catch (IOException e) { 
				System.err.println("car1.png could not be found");
			}
		}
		
		if (carNumber == 2){
			try { 
				car = ImageIO.read(getClass().getResource("car2.png"));
			} catch (IOException e) { 
				System.err.println("car2.png could not be found");
			}
		}
		
		if (carNumber == 3){
			try { 
				car = ImageIO.read(getClass().getResource("car3.png"));
			} catch (IOException e) { 
				System.err.println("car3.png could not be found");
			}
		}
		
		if (carNumber == 4){
			try { 
				car = ImageIO.read(getClass().getResource("car4.png"));
			} catch (IOException e) { 
				System.err.println("car4.png could not be found");
			}
		}
		
		speed = (int) (Math.random() * 4) + 1;
	}


	public void paint(Graphics2D g2d) {
		g2d.drawImage(car, x, y, null);
	}
	
	public void update(){
		x -= speed;
		if (x <= -1500) x = 1000;
	}
}
