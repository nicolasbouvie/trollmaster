package br.com.nicolas.trollmaster.wallpaper;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public abstract class WallpaperChanger {
	public static void main(String[] args) throws Exception {
		String tmp = System.getProperty("java.io.tmpdir");
		String wallpaper = tmp + File.separator + "trollwallpaper.png";
		BufferedImage img = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(img, "png", new File(wallpaper));

		newInstance().change(wallpaper);
	}
	
	public static WallpaperChanger newInstance() {
		if ("Mac OS X".equals(System.getProperty("os.name"))) {
			return new WallpaperChangerMac();
		}
		return new WallpaperChangerMac();
	}

	public abstract void change(String path);
}
