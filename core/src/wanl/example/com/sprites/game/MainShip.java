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

    private static final int INVALID_POINTER = -1;

    private final Vector2 v0 = new Vector2(0.5f, 0);
    private Vector2 v = new Vector2();
    private boolean isPressedLeft;
    private boolean isPressedRight;
    BulletPool bulletPool;
    private TextureRegion bulletRegion;
    private Rect worldBounds;
    Sound sound = Gdx.audio.newSound(Gdx.files.internal("sound.mp3"));
    private int leftPointer = INVALID_POINTER;
    private int rigthPointer = INVALID_POINTER;
    private float reloadInterval;
    private float reloadTimer;

    public MainShip(TextureAtlas atlas, BulletPool bulletPool) {
        super(atlas.findRegion("main_ship"), 1, 2, 2);
        this.bulletRegion = atlas.findRegion("bulletMainShip");
        setHeightProportion(0.15f);
        this.bulletPool = bulletPool;
        this.reloadInterval = 0.1f;
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
        reloadTimer += deltatime;
        if (reloadTimer >= reloadInterval) {
            reloadTimer = 0f;
            shoot();
        }
        if (getRight() > worldBounds.getRight()) {
            setRight(worldBounds.getRight());
            stop();
        }
        if (getLeft() < worldBounds.getLeft()) {
            setLeft(worldBounds.getLeft());
            stop();
        }
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
        pos.set(touch.x, pos.y);
        return true;
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        if (touch.x < worldBounds.pos.x) {
            if (leftPointer != INVALID_POINTER) return false;
            leftPointer = pointer;
            moveLeft();
        } else {
            if (rigthPointer != INVALID_POINTER) return false;
            rigthPointer = pointer;
            moveRight();
        }
        return super.touchDown(touch, pointer);
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer) {
        if (pointer == leftPointer) {
            leftPointer = INVALID_POINTER;
            if (rigthPointer != INVALID_POINTER){
                moveRight();
            } else {
                stop();
            }
        } else if (pointer == rigthPointer) {
            rigthPointer = INVALID_POINTER;
            if (leftPointer != INVALID_POINTER){
                moveLeft();
            } else {
                stop();
            }
        }
        return super.touchUp(touch, pointer);
    }

    public void dispose() {
        sound.dispose();
    }
}
