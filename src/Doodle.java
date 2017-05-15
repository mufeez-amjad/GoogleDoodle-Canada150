import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Doodle extends JPanel{
	
	private BufferedImage BG;
	private BufferedImage Landscape;
	private BufferedImage logo;
	private BufferedImage cars;
	private BufferedImage train;
	private BufferedImage clouds;
	private BufferedImage turbines;
	private BufferedImage balloon;
	
	private int carX = 0;
	private int trainX = 0;
	private double cloudX = 0;
	private Windmill w1 = new Windmill(1175, 175, false);
	private Windmill w2 = new Windmill(1150, 325, true);
	private Windmill w3 = new Windmill(1325, 325, true);
	private Car car1 = new Car(1);
	private Car car2 = new Car(2);
	private Car car3 = new Car(3);
	private Car car4 = new Car(4);
	
	private int frameWidth = 1484;
	private int frameHeight = 530;
	private Balloon b1 = new Balloon(100,20);
	private Balloon b2 = new Balloon(700,40);
	
	private Balloon b3 = new Balloon(1300,40);



	public Doodle(){
		
		try { 
			BG = ImageIO.read(getClass().getResource("/BG.png"));
		} catch (IOException e) { 
			System.err.println("BG.png could not be found");
		}
		try { 
			Landscape = ImageIO.read(getClass().getResource("/Landscape.png"));
		} catch (IOException e) { 
			System.err.println("Landscape.png could not be found");
		}
		try { 
			logo = ImageIO.read(getClass().getResource("/Logo.png"));
		} catch (IOException e) { 
			System.err.println("Logo.png could not be found");
		}
		try { 
			cars = ImageIO.read(getClass().getResource("/Cars.png"));
		} catch (IOException e) { 
			System.err.println("Cars.png could not be found");
		}
		try { 
			train = ImageIO.read(getClass().getResource("/Train.png"));
		} catch (IOException e) { 
			System.err.println("Train.png could not be found");
		}
		try { 
			clouds = ImageIO.read(getClass().getResource("/Clouds.png"));
		} catch (IOException e) { 
			System.err.println("Clouds.png could not be found");
		}
		try { 
			turbines = ImageIO.read(getClass().getResource("/Turbines.png"));
		} catch (IOException e) { 
			System.err.println("Turbines.png could not be found");
		}
		
	}
	public void move(){
		carX-=2;
		if (carX <= -1500) carX = 1000;
		trainX-=5;
		if (trainX <= -1500) trainX = 700;
		
		cloudX-= 0.1;
		if (cloudX <= -1484) cloudX = 0;
		
		car1.update();
		car2.update();
		car3.update();
		car4.update();
	}
	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				 RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2d.drawImage(BG, 0, 0, null);
		car1.paint(g2d);
		car2.paint(g2d);
		car3.paint(g2d);
		car4.paint(g2d);

		//g2d.drawImage(cars, carX, 0, null);
		g2d.drawImage(train, trainX, 0, null);
		w3.paint(g2d);
		w2.paint(g2d);
		w1.paint(g2d);
		
		g2d.drawImage(Landscape, 0, 0, null);
		b1.paint(g2d);
		g2d.drawImage(clouds, (int) cloudX, 0, null);
		b2.paint(g2d);
		g2d.drawImage(clouds, (int) cloudX + 1484, 0, null);
		b3.paint(g2d);

		g2d.drawImage(logo, 0, 0, null);

	}	
	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("A Sustainable and Technologically Advanced Canada");
		Doodle panel = new Doodle();
		
		frame.add(panel); 
		panel.requestFocusInWindow();
		frame.setSize(1484, 530);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
		//frame.setResizable(false); 
		frame.setLocationRelativeTo(null); //centers the window

		while (true){
			panel.move();
			panel.repaint();
			Thread.sleep(5);
		}		
	}
}
