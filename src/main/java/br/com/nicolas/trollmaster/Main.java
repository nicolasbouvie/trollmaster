package br.com.nicolas.trollmaster;

import java.awt.FlowLayout;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
	public static void main(String[] args) throws Exception {
		Random r = new Random(System.currentTimeMillis());
		Robot robot = new Robot();

		BufferedImage img = ImageIO.read(Main.class.getResourceAsStream("/trollface.jpg"));
		ImageIcon icon = new ImageIcon(img);
		JFrame frame = new JFrame();
		frame.setLayout(new FlowLayout());
		frame.setSize(200, 250);
		JLabel lbl = new JLabel();
		lbl.setIcon(icon);
		frame.add(lbl);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			frame.setLocation(r.nextInt(1000), r.nextInt(1000));
			frame.setVisible(true);
			robot.delay(300);
			frame.setVisible(false);
			robot.delay(2000);
		}
	}
}
