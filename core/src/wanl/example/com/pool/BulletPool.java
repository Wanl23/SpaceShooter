package wanl.example.com.pool;

import wanl.example.com.base.Sprite;
import wanl.example.com.base.SpritesPool;
import wanl.example.com.sprites.game.Bullet;

public class BulletPool extends SpritesPool<Bullet> {
    @Override
    protected Bullet newObject() {
        return new Bullet();
    }
}
