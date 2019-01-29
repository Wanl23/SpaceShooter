package wanl.example.com.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import wanl.example.com.SpaceShooter;
import wanl.example.com.Star2dGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		float aspect = 3f/4f;
		config.width = 400;
		config.height = (int) (config.width/aspect);
		config.resizable = false;
		new LwjglApplication(new Star2dGame(), config);
	}
}
