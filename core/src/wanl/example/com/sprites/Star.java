package wanl.example.com.sprites;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import wanl.example.com.base.Sprite;
import wanl.example.com.math.Rect;
import wanl.example.com.math.Rnd;

public class Star extends Sprite {

    private Vector2 v = new Vector2();
    private Rect worldBounds;
    public Star(TextureAtlas atlas) {
        super(atlas.findRegion("star"));
        setHeightProportion(0.01f);
        v.set(Rnd.nextFloat(-0.005f, 0.005f), Rnd.nextFloat(-0.5f, -0.1f));
    }

    @Override
    public void update(float deltatime) {
        pos.mulAdd(v, deltatime);
        checkAndHandleBounds();
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
        float posX = Rnd.nextFloat(worldBounds.getLeft(), worldBounds.getRight());
        float posY = Rnd.nextFloat(worldBounds.getBottom(), worldBounds.getTop());
        pos.set(posX, posY);
    }

    private void checkAndHandleBounds() {
        if(getRight() < worldBounds.getLeft()) setLeft(worldBounds.getRight());
        if(getLeft() > worldBounds.getRight()) setRight(worldBounds.getLeft());
        if(getTop() < worldBounds.getBottom()) setBottom(worldBounds.getTop());
        if(getBottom() > worldBounds.getTop()) setTop(worldBounds.getBottom());
    }
}
