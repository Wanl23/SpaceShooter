package wanl.example.com.sprites.menu;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import wanl.example.com.base.Sprite;
import wanl.example.com.math.Rect;

public class GameOver extends Sprite {

    public GameOver(TextureRegion region) {
        super(region);
    }

    @Override
    public void resize(Rect worldBounds) {
        pos.set(0, 0);
        setHeightProportion(0.05f);
    }
}
