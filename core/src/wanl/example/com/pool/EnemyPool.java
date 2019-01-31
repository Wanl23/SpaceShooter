package wanl.example.com.pool;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import wanl.example.com.base.SpritesPool;
import wanl.example.com.sprites.game.Enemy;

public class EnemyPool extends SpritesPool<Enemy> {

    protected Sound sound;
    private BulletPool bulletPool;

    public EnemyPool(BulletPool bulletPool) {
        this.sound = Gdx.audio.newSound(Gdx.files.internal("sound.mp3"));
        this.bulletPool = bulletPool;
    }

    @Override
    protected Enemy newObject() {
        return new Enemy(sound, bulletPool);
    }

    @Override
    public void dispose() {
        super.dispose();
        sound.dispose();
    }
}
