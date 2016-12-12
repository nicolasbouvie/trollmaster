package br.com.nicolas.trollmaster.wallpaper;

import com.sun.jna.Native;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;

public class WallpaperChangerWindows extends WallpaperChanger {

	@Override
	public void change(String path) {
		SPI.INSTANCE.SystemParametersInfo(20, 0, path, 1);
	}

	public interface SPI extends StdCallLibrary {
		SPI INSTANCE = (SPI) Native.loadLibrary("user32", SPI.class, W32APIOptions.DEFAULT_OPTIONS);
		boolean SystemParametersInfo(int uiAction, int uiParam, String pvParam, int fWinIni);
	}
}
