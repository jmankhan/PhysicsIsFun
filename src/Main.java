import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;


public class Main extends Canvas implements Runnable {
	public static int FPS = 10;
	
	private Thread gameThread;
	private boolean running;
	
	private JFrame parent;
	
	private Player player;
	private Level level;
	
	public Main(JFrame _parent) {
		parent = _parent;
		
		running = false;
		player = new Player( 100, 100 );
		level = new Level(player);
		
		addKeyListener(new KeyManager(player));
	}
	
	public synchronized void start() {
		if(running)
			return;
		
		running = true;
		gameThread = new Thread(this);
		gameThread.start();;
	}
	
	public synchronized void stop() {
		if(!running)
			return;
		
		running=false;
		try {
			gameThread.join();
		} catch (InterruptedException e) {e.printStackTrace();}
	}
	
	public void run(){

		requestFocusInWindow();
		
		long lastTime = System.nanoTime();
		final double amountOfTicks = FPS;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;

		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if(delta >= 1){
				tick();
				delta--;
			}
			render();
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		stop();
	}
	
	
	public void tick() {
		player.tick();
		level.tick();
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs ==  null){
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		//RENDER HERE
		g.fillRect(0, 0, 1000, 1000);
		
		player.render(g);
		//END RENDER
		g.dispose();
		bs.show();
	}
	
	public static void main(String args[]) {
		JFrame f = new JFrame();
		Main m = new Main(f);
		
		f.add(m);
		f.setSize(1000,1000);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		m.start();
	}
}
