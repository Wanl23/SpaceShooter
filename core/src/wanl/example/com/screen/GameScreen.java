package wanl.example.com.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import wanl.example.com.base.Base2dScreen;
import wanl.example.com.math.Rect;
import wanl.example.com.pool.BulletPool;
import wanl.example.com.pool.EnemyPool;
import wanl.example.com.pool.ExplosionPool;
import wanl.example.com.sprites.Background;
import wanl.example.com.sprites.Star;
import wanl.example.com.sprites.game.Bullet;
import wanl.example.com.sprites.game.Explosion;
import wanl.example.com.sprites.game.MainShip;
import wanl.example.com.utils.EnemyEmitter;

public class GameScreen extends Base2dScreen {
    private TextureAtlas atlas;
    private Texture bg;
    private Background background;
    private Star star[];
    private MainShip mainShip;
    private Music music;
    private BulletPool bulletPool;
    private ExplosionPool explosionPool;
    private EnemyPool enemyPool;
    private EnemyEmitter enemyEmitter;


    @Override
    public void show() {
        super.show();
        bg = new Texture("spaceBack.jpg");
        background = new Background(new TextureRegion(bg));
        music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        music.setLooping(true);
        music.setVolume(0.05f);
        music.play();
        atlas = new TextureAtlas("mainAtlas.tpack");
        star = new Star[64];
        for (int i = 0; i < star.length; i++) {
            star[i] = new Star(atlas);
        }
        bulletPool = new BulletPool();
        explosionPool = new ExplosionPool(atlas);
        enemyPool = new EnemyPool(bulletPool);
        mainShip = new MainShip(atlas, bulletPool);
        enemyEmitter = new EnemyEmitter(atlas, enemyPool, worldBounds);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        deleteAllDestroyed();
        draw();
    }

    public void update(float delta) {
        for (int i = 0; i < star.length; i++) {
            star[i].update(delta);
        }
        mainShip.update(delta);
        bulletPool.updateActiveSprites(delta);
        explosionPool.updateActiveSprites(delta);
        enemyPool.updateActiveSprites(delta);
        enemyEmitter.generate(delta);
    }

    public void deleteAllDestroyed() {
        bulletPool.freeDestroyesActiveSprites();
        explosionPool.freeDestroyesActiveSprites();
        enemyPool.freeDestroyesActiveSprites();
    }

    public void draw() {
        Gdx.gl.glClearColor(1, 1, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        for (int i = 0; i < star.length; i++) {
            star[i].draw(batch);
        }
        mainShip.draw(batch);
        bulletPool.drawActiveSprites(batch);
        explosionPool.drawActiveSprites(batch);
        enemyPool.drawActiveSprites(batch);
        batch.end();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        for (int i = 0; i < star.length; i++) {
            star[i].resize(worldBounds);
        }
        mainShip.resize(worldBounds);
    }

    @Override
    public void dispose() {
        bg.dispose();
        atlas.dispose();
        music.dispose();
        bulletPool.dispose();
        explosionPool.dispose();
        enemyPool.dispose();
        mainShip.dispose();
        super.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        mainShip.keyDown(keycode);
        return super.keyDown(keycode);
    }

    @Override
    public boolean keyUp(int keycode) {
        mainShip.keyUp(keycode);
        return super.keyUp(keycode);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        Explosion explosion = (Explosion) explosionPool.obtain();
        explosion.set(0.15f, touch);
        mainShip.touchDown(touch, pointer);
        return super.touchDown(touch, pointer);
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer) {
        mainShip.touchUp(touch, pointer);
        return super.touchUp(touch, pointer);
    }

    @Override
    public boolean touchDragged(Vector2 touch, int pointer) {
        //mainShip.touchDragged(touch, pointer);
        return super.touchDragged(touch, pointer);
    }
}