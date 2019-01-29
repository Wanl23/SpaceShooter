package wanl.example.com.sprites.game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import wanl.example.com.base.Sprite;
import wanl.example.com.math.Rect;

public class Bullet extends Sprite {

    private Rect worldBounds;
    private Vector2 v = new Vector2();
    private int damage;
    private Object owner;

    public Bullet() {
        regions = new TextureRegion[1];
    }

    @Override
    public void update(float deltatime) {
        pos.mulAdd(v, deltatime);
        if (isOutside(worldBounds)) {
            destroy();
        }
    }

    public void set(
            Object owner,
            TextureRegion region,
            Vector2 pos0,
            Vector2 v0,
            float height,
            Rect worldBounds,
            int damage
    ) {
        this.owner = owner;
        this.regions[0] = region;
        this.pos.set(pos0);
        this.v.set(v0);
        this.setHeightProportion(height);
        this.worldBounds = worldBounds;
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public Object getOwner() {
        return owner;
    }
}
