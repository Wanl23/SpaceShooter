package wanl.example.com.pool;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import wanl.example.com.base.Sprite;
import wanl.example.com.base.SpritesPool;
import wanl.example.com.sprites.game.Explosion;

public class ExplosionPool extends SpritesPool {

    TextureRegion region;
    private Sound explosionSound;

    public ExplosionPool(TextureAtlas atlas) {
        region= atlas.findRegion("explosion");
        explosionSound = Gdx.audio.newSound(Gdx.files.internal("explosion.mp3"));
    }

    @Override
    protected Sprite newObject() {
        return new Explosion(region, 9, 9, 74, explosionSound);

    }

    public void dispose() {
        explosionSound.dispose();
        super.dispose();
    }
}
