package wanl.example.com.sprites.game;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import wanl.example.com.base.Sprite;
import wanl.example.com.math.Rect;
import wanl.example.com.pool.BulletPool;

public class Ship extends Sprite {

    protected BulletPool bulletPool;
    protected Vector2 v = new Vector2();
    protected Rect worldBounds;
    protected TextureRegion bulletRegion;
    protected float reloadInterval;
    protected float reloadTimer;
    protected Sound sound;
    protected Vector2 bulletV;
    protected float bulletHeight;
    protected int damage;
    protected int hp;

    public Ship() {
        super();
    }

    public Ship(TextureRegion region, int rows, int cols, int frames) {
        super(region, rows, cols, frames);
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        this.worldBounds = worldBounds;
    }


    public void shoot() {
        Bullet bullet = (Bullet) bulletPool.obtain();
        bullet.set(this, bulletRegion, pos, bulletV, bulletHeight, worldBounds, damage);
        this.sound.play(0.05f);
    }

    public void dispose() {
        sound.dispose();
    }

}
