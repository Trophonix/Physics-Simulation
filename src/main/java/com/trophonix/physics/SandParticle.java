package main.java.com.trophonix.physics;

public class SandParticle {

	public int x, y;
	
	public SandParticle(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void physics() {
		if (y > Main.HEIGHT - 40) {
			return;
		}
				
		boolean colliding = false;
		
		for (int i = 0; i < Main.particles.size(); i++) {
			if (Main.particles.get(i).x == x && Main.particles.get(i).y == y + 1)
				colliding = true;
		}
	
		if (!colliding) {
			y += 1;
		}
		
	}
}
