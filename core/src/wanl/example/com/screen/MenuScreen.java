package wanl.example.com.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import wanl.example.com.base.Base2dScreen;

public class MenuScreen extends Base2dScreen {

    private static final float CONST_LENGTH = 0.01f;
    Texture img;
    Texture background;

    protected Vector2 buf;

    Vector2 position;
    Vector2 v;
    Vector2 touch;

    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        background = new Texture("spaceBack.jpg");
        buf = new Vector2();
        position = new Vector2(-0.5f, -0.5f);
        v = new Vector2(0, 0);
        touch = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 1, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(background, -0.5f, -0.5f, 1f, 1f);
        batch.draw(img, position.x, position.y, 0.5f, 0.5f);
        batch.end();

        buf.set(touch);
        if (buf.sub(position).len() > 0.1f) {
            position.add(v);
        } else {
            position.set(touch);
        }

    }

    @Override
    public void dispose() {
        img.dispose();
        super.dispose();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        this.touch = touch;
        v.set(touch.cpy().sub(position)).setLength(0.1f);
        return super.touchDown(touch, pointer);
    }


}
