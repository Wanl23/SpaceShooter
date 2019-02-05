package wanl.example.com.sprites.menu;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import wanl.example.com.math.Rect;
import wanl.example.com.screen.GameScreen;

public class NewGame extends ScaledTouchUpButton {

    private Game game;

    public NewGame(TextureRegion region, Game game) {
        super(region);
        this.game = game;
    }

    @Override
    void action() {
        game.setScreen(new GameScreen(game));
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
        pos.set(0, 0);
        setHeightProportion(0.05f);
    }
}
