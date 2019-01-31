package wanl.example.com.sprites.game;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import wanl.example.com.math.Rect;
import wanl.example.com.pool.BulletPool;
import wanl.example.com.utils.Regions;

public class Enemy extends Ship {

    private Vector2 v0 = new Vector2();

    public Enemy(Sound sound, BulletPool bulletPool) {
        super();
        this.v.set(v0);
        this.sound = sound;
        this.bulletPool = bulletPool;
        this.bulletV = new Vector2();
        this.reloadInterval = 0.1f;
    }

    public void update(float delta) {
        super.update(delta);
        this.pos.mulAdd(v, delta);
        if (isOutside(worldBounds)) {
            destroy();
        }
        reloadTimer += delta;
        if (reloadTimer >= reloadInterval) {
            reloadTimer = 0f;
            shoot();
        }
    }

    public void set(
        TextureAtlas atlas,
        Vector2 v0,
        TextureRegion bulletRegion,
        Rect worldBounds,
        float bulletHeight,
        float bulletVY,
        int bulletDamage,
        float reloadInterval,
        float height,
        int hp
        ) {
        TextureRegion textureRegion = atlas.findRegion(EnemyTypes.values()[(int) (Math.random() * 3)].getAtalasName());
        this.regions = Regions.split(textureRegion,1,2,2);
        this.v0.set(v0);
        this.bulletRegion = bulletRegion;
        this.worldBounds = worldBounds;
        this.bulletHeight = bulletHeight;
        this.bulletV.set(0, bulletVY);
        this.damage = bulletDamage;
        this.reloadInterval = reloadInterval;
        setHeightProportion(height);
        this.hp = hp;
        reloadTimer = reloadInterval;
        v.set(v0);
    }
}
