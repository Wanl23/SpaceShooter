package wanl.example.com.sprites.menu;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import wanl.example.com.Star2dGame;
import wanl.example.com.math.Rect;
import wanl.example.com.screen.GameScreen;
import wanl.example.com.screen.MenuScreen;

public class Play extends ScaledTouchUpButton {

    public Play(TextureAtlas atlas) {
        super(atlas.findRegion("btPlay"));
        setHeightProportion(0.2f);
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
    }

    @Override
    void action() {
    }

    public boolean touchDown(Vector2 touch, int pointer) {
        return super.touchDown(touch, pointer);
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer) {
        return super.touchUp(touch, pointer);
    }

    @Override
    public void resize(Rect worldBounds) {
        pos.set(-0.2f, -0.35f);
    }
}
