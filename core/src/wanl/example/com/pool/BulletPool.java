package wanl.example.com.pool;

import wanl.example.com.base.Sprite;
import wanl.example.com.base.SpritesPool;
import wanl.example.com.sprites.game.Bullet;

public class BulletPool extends SpritesPool {
    @Override
    protected Sprite newObject() {
        return new Bullet();
    }
}
