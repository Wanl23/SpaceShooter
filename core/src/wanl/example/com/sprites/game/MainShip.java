package wanl.example.com.sprites.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import wanl.example.com.base.Sprite;
import wanl.example.com.math.Rect;
import wanl.example.com.pool.BulletPool;

public class MainShip extends Sprite {

    private final Vector2 v0 = new Vector2(0.5f, 0);
    private Vector2 v = new Vector2();
    private boolean isPressedLeft;
    private boolean isPressedRight;
    BulletPool bulletPool;
    private TextureRegion bulletRegion;
    private Rect worldBounds;
    Sound sound = Gdx.audio.newSound(Gdx.files.internal("sound.mp3"));

    public MainShip(TextureAtlas atlas, BulletPool bulletPool) {
        super(atlas.findRegion("main_ship"), 1, 2, 2);
        this.bulletRegion = atlas.findRegion("bulletMainShip");
        setHeightProportion(0.15f);
        this.bulletPool = bulletPool;
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setBottom(worldBounds.getBottom() + 0.05f);
        this.worldBounds = worldBounds;
    }

    @Override
    public void update(float deltatime) {
        super.update(deltatime);
        pos.mulAdd(v, deltatime);
    }

    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.A:
            case Input.Keys.LEFT:
                isPressedLeft = true;
                moveLeft();
                break;
            case Input.Keys.D:
            case Input.Keys.RIGHT:
                isPressedRight = true;
                moveRight();
                break;
            case Input.Keys.UP:
                shoot();
                break;
        }
        return false;
    }

    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.A:
            case Input.Keys.LEFT:
                isPressedLeft = false;
                if (isPressedRight) {
                    moveRight();
                } else {
                    stop();
                }
                break;
            case Input.Keys.D:
            case Input.Keys.RIGHT:
                isPressedRight = false;
                if (isPressedLeft) {
                    moveLeft();
                } else {
                    stop();
                }
                break;
        }
        return false;
    }

    private void moveRight() {
        v.set(v0);
    }

    private void moveLeft() {
        v.set(v0).rotate(180);
    }

    private void stop() {
        v.setZero();
    }

    private void shoot() {
        Bullet bullet = (Bullet) bulletPool.obtain();
        bullet.set(this, bulletRegion, pos, new Vector2(0, 0.5f), 0.01f, worldBounds, 1);
        sound.play();
    }

    public boolean touchDragged(Vector2 touch, int pointer) {
        if (touch.x < worldBounds.getRight() && touch.x > worldBounds.getLeft()) {
            pos.set(touch.x, pos.y);
        }

        return true;
    }

}
