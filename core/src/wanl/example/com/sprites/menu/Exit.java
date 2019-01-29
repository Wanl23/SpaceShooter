package wanl.example.com.sprites.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import wanl.example.com.math.Rect;

public class Exit extends ScaledTouchUpButton {



    public Exit(TextureAtlas atlas) {
        super(atlas.findRegion("btExit"));
        setHeightProportion(0.15f);
    }
    @Override
    void action() {
        Gdx.app.exit();
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
    }


    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        return super.touchDown(touch, pointer);
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer) {
        return super.touchUp(touch, pointer);
    }

    @Override
    public void resize(Rect worldBounds) {
        setBottom(worldBounds.getBottom() + 0.05f);
        setLeft(worldBounds.getLeft() + 0.04f);
    }

}
