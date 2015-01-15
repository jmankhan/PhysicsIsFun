import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Player {
	public static int speed = 3;
	
	private int x, y;
	private Force playerForce;
	private BufferedImage image;
	
	public Player() {
		x=0;
		y=0;
		
		playerForce = new Force(0,0,-90.0); //start off facing up
		try {
			image = ImageIO.read(getClass().getResource("/res/player.png"));
		} catch (IOException e) {e.printStackTrace();}
	}
	
	public Player(int _x, int _y) {
		x = _x;
		y = _y;

		playerForce = new Force(0,0,-90.0); //start off facing up
	}

	public void tick() {
		x += playerForce.getVx();
		y += playerForce.getVy();
	}
	
	public void render(Graphics gr) {
		Graphics2D g = (Graphics2D) gr;
		g.setColor(Color.white);
//		g.drawImage(image, x, y, null);
		g.drawRect(x, y, 50, 50);
	}

	public void setImage(BufferedImage i) {
		image=i;
	}
	
	public void setX(int x) { 
		this.x=x;
	}
	
	public void setXDelta(int delta) {
		x+=delta;
	}
	
	public int getX() {
		return x;
	}
	
	public void setY(int y) {
		this.y=y;
	}
	
	public void setYDelta(int delta) {
		y+=delta;
	}
	
	public int getY() {
		return y;
	}
	
	public Force getForce() {
		return playerForce;
	}
	
	public void setForce(Force f) {
		playerForce = f;
	}
}
