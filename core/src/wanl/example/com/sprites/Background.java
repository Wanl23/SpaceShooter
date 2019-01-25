package wanl.example.com.sprites;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import wanl.example.com.base.Sprite;
import wanl.example.com.math.Rect;

public class Background extends Sprite {

    public Background(TextureRegion region) {
        super(region);
    }

    @Override
    public void resize(Rect worldBounds) {
        pos.set(worldBounds.pos);
        setHeightProportion(worldBounds.getHeight());
    }
}
