import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyManager implements KeyListener {
	private Player player;
	
	public KeyManager(Player p) {
		player = p;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_UP)
			player.setYDelta(-Player.speed);
		else if(key == KeyEvent.VK_DOWN)
			player.setYDelta(Player.speed);
		
		if(key == KeyEvent.VK_RIGHT)
			player.setXDelta(Player.speed);
		else if(key == KeyEvent.VK_LEFT)
			player.setXDelta(-Player.speed);
	}
	
	public void keyReleased(KeyEvent e) {
		
	}
	
	public void keyTyped(KeyEvent e) {
		
	}
}
