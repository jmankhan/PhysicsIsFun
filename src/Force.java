
public class Force {
	private double vx, vy, ax, ay;
		
	public Force(double vx, double vy, double ax, double ay) {
		this.vx = vx;
		this.vy = vy;
		this.ax = ax;
		this.ay = ay;
	}

	public Force(double vx, double vy, double ax) {
		this.vx = vx;
		this.vy = vy;
		this.ax = ax;
		this.ay = 0;
	}
	
	public Force(double vx, double vy) {
		this.vx = vx;
		this.vy = vy;
		this.ax = 0;
		this.ay = 0;
	}
	
	public Force(double vx) {
		this.vx = vx;
		this.vy = 0;
		this.ax = 0;
		this.ay = 0;
	}
	
	public Force() {
		this.vx = 0;
		this.vy = 0;
		this.ax = 0;
		this.ay = 0;
	}

	public double getVx() {
		return vx;
	}

	public void setVx(double vx) {
		this.vx = vx;
	}

	public void setVxDelta(double d) {
		vx += d;
	}
	
	public double getVy() {
		return vy;
	}

	public void setVy(double vy) {
		this.vy = vy;
	}

	public void setVyDelta(double d) {
		vy += d;
	}
	
	public double getAx() {
		return ax;
	}

	public void setAx(double ax) {
		this.ax = ax;
	}

	public void setAxDelta(double d) {
		ax += d;
	}
	
	public double getAy() {
		return ay;
	}

	public void setAy(double ay) {
		this.ay = ay;
	}
	
	public void setAyDelta(double d) {
		ay+=d;
	}
}
