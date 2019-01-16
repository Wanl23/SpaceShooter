package wanl.example.com;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SpaceShooter extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	TextureRegion textureRegion;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("spaceBackground.jpg");
		textureRegion = new TextureRegion(img, 0, 0, 150, 150);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
