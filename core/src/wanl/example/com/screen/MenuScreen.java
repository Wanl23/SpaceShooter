package wanl.example.com.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import wanl.example.com.Star2dGame;
import wanl.example.com.base.Base2dScreen;
import wanl.example.com.math.Rect;
import wanl.example.com.sprites.Background;
import wanl.example.com.sprites.Star;
import wanl.example.com.sprites.menu.Exit;
import wanl.example.com.sprites.menu.Play;

public class MenuScreen extends Base2dScreen {



    private TextureAtlas atlas;
    private Texture bg;
    private Background background;
    private Star star[];
    private Play play;
    private Exit exit;


    @Override
    public void show() {
        super.show();
        bg = new Texture("spaceBack.jpg");
        background = new Background(new TextureRegion(bg));
        atlas = new TextureAtlas("menuAtlas.tpack");
        star = new Star[256];
        for (int i = 0; i < star.length; i++) {
            star[i] = new Star(atlas);
        }
        play = new Play(atlas);
        exit = new Exit(atlas);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();
    }

    public void update(float delta) {
        for (int i = 0; i < star.length; i++) {
            star[i].update(delta);
        }
        play.update(delta);
        exit.update(delta);
    }

    public void draw() {
        Gdx.gl.glClearColor(1, 1, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        for (int i = 0; i < star.length; i++) {
            star[i].draw(batch);
        }
        play.draw(batch);
        exit.draw(batch);
        batch.end();
    }

    @Override
    public void resize(Rect worldBounds) {
        background.resize(worldBounds);
        for (int i = 0; i < star.length; i++) {
            star[i].resize(worldBounds);
        }
        play.resize(worldBounds);
        exit.resize(worldBounds);
    }

    @Override
    public void dispose() {
        bg.dispose();
        atlas.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        play.touchDown(touch, pointer);
        exit.touchDown(touch, pointer);
        return super.touchDown(touch, pointer);
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer) {
        play.touchUp(touch, pointer);
        exit.touchUp(touch, pointer);
        return super.touchUp(touch, pointer);
    }
}
