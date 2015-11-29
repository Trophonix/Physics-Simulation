package main.java.com.trophonix.physics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.RenderingHints;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel {
	
	public static final int WIDTH = 400, HEIGHT = 300;
	
	public int[] pix = new int[WIDTH * HEIGHT];
	
	public static List<SandParticle> particles = new ArrayList<SandParticle>();
	
	PointerInfo pInfo = MouseInfo.getPointerInfo();
	Point p = pInfo.getLocation();
	int mouseX = (int) p.getX();
	int mouseY = (int) p.getY();
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		for (int i = 0; i < particles.size(); i++) {
			int x = particles.get(i).x;
			int y = particles.get(i).y;
			
			
			g2d.drawRect(x, y, 1, 1);
		}
	}
	
	public static void placeSand() {
		
	}
	
	public static void physics() {
		for (int i = 0; i < particles.size(); i++) {
			particles.get(i).physics();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Physics Simulation");
		Main game = new Main();
		frame.add(game);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		for (int x = 100; x < 300; x += 5) {
			for (int y = 0; y < 200; y += 5) {
				SandParticle sp = new SandParticle(x, y);
				particles.add(sp);
				
			}
		}
		
		while (true) {
			game.repaint();
			placeSand();
			physics();
			Thread.sleep(25);
		}
	}
	
}
