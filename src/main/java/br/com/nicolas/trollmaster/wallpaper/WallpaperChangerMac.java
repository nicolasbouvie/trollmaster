package br.com.nicolas.trollmaster.wallpaper;

import java.io.IOException;

public class WallpaperChangerMac extends WallpaperChanger {

	@Override
	public void change(String path) {
		String as[] = {
	            "osascript", 
	            "-e", "tell application \"Finder\"", 
	            "-e", "set desktop picture to POSIX file \"" + path + "\"",
	            "-e", "end tell"
	    };
	    Runtime runtime = Runtime.getRuntime();
	    try {
			runtime.exec(as);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
