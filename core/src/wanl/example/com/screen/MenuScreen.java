package wanl.example.com.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import wanl.example.com.base.Base2dScreen;

public class MenuScreen extends Base2dScreen {
    SpriteBatch batch;
    Texture img;
    Texture background;
    Vector2 position;
    Vector2 speed;
    Vector2 tochDownPosition;
    Vector2 buf;
    private static final float V_LEN = 10.5f;

    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        batch.getProjectionMatrix().idt();
        background = new Texture("spaceBack.jpg");
        position = new Vector2(0, 0);
        speed = new Vector2(0,0);
        tochDownPosition = new Vector2(0, 0);
        buf = new Vector2(0, 0);

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 1, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(background, 0, 0);
        batch.draw(img, -1f, -1f, 2f, 2f);
        batch.end();
        buf.set(tochDownPosition);
        if (buf.sub(position).len() > V_LEN) {
            position.add(speed);
        } else {
            position.set(tochDownPosition);
        }
//        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) position.x -= 200 * Gdx.graphics.getDeltaTime();
//        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) position.x += 200 * Gdx.graphics.getDeltaTime();
//        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) position.y -= 200 * Gdx.graphics.getDeltaTime();
//        if(Gdx.input.isKeyPressed(Input.Keys.UP)) position.y += 200 * Gdx.graphics.getDeltaTime();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        tochDownPosition.set(screenX, Gdx.graphics.getHeight() - screenY);
        speed.set(tochDownPosition.cpy().sub(position).setLength(V_LEN));
        return super.touchDown(screenX, screenY, pointer, button);
    }
}
