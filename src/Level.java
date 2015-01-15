import java.awt.Graphics;


public class Level {
	public Force force;
	
	private Player player;
	
	public Level(Player p) {
		player = p;
		force = new Force(1, 1, 0, 0);
	}
	
	public void tick() {
		Force playerForce = player.getForce();
		playerForce.setVxDelta(force.getVx());
		playerForce.setVyDelta(force.getVy());
		player.setForce(playerForce);
	}
	
	public void render(Graphics g) {
		
	}
}
